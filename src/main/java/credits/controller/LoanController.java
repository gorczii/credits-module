package credits.controller;

import com.sun.javafx.binding.StringFormatter;
import credits.SQL.ConnectionManager;
import credits.SQL.Model.LoanApplicationForm;
import credits.SQL.SqlDataProvider;
import credits.SQL.Statements;
import credits.SQL.Model.LoanApplication;
import credits.model.LoanApplicationViewModel;
import credits.view.InfoModal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Labeled;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static credits.SQL.SqlDataProvider.acceptLoanApplication;
import static credits.SQL.SqlDataProvider.rejectLoanApplication;

public class LoanController {

    public class InputException extends java.lang.Exception {
        public InputException(String message) {
            super(message);
        }
    }


    public EventHandler<ActionEvent> sendLoanApplication(LoanApplicationViewModel loanApplication) {
        return e -> {
            try {
                LoanApplicationForm form = toApplicationForm(loanApplication);
                if (SqlDataProvider.makeLoanApplication(form)) {
                    InfoModal infoModal = new InfoModal("Sukces", "Pomyślnie złożono wniosek!");
                    infoModal.show();
                }
            } catch (Exception ex) {
                InfoModal infoModal = new InfoModal("Wystąpił błąd", ex.getMessage());
                infoModal.show();
            }
            System.out.println("Wniosek kredytowy złożony: " + loanApplication);
        };
    }


    private boolean isEmpty(LoanApplicationViewModel loanApplication) {
        return loanApplication.monthlyIncome.getText().isEmpty()
                || loanApplication.monthlyCostsOfLiving.getText().isEmpty()
                || loanApplication.otherDebtsMonthlyPayments.getText().isEmpty()
                || loanApplication.employerName.getText().isEmpty()
                || loanApplication.employerContactData.getText().isEmpty()
                || loanApplication.loanAmount.getText().isEmpty()
                || loanApplication.ownContribution.getText().isEmpty()
                || loanApplication.creditPurpose.getText().isEmpty()
                || loanApplication.interestRate.getText().isEmpty()
                || loanApplication.loanCollateral.getText().isEmpty()
                || loanApplication.commission.getText().isEmpty()
                || loanApplication.numberOfRepayments.getText().isEmpty();
    }

    private LoanApplicationForm toApplicationForm(LoanApplicationViewModel viewModel) throws Exception {
        if (isEmpty(viewModel)) {
            throw new InputException("Nie można wysłać wniosku z pustymi polami");
        }

        int userId = viewModel.userId.getValue().getId();
        double monthlyIncome = Double.parseDouble(viewModel.monthlyIncome.getText());
        String formOfEmployment = viewModel.formOfEmployment.getValue();
        String martialStatue = viewModel.maritalStatue.getValue();
        double monthlyCostOfLiving = Double.parseDouble(viewModel.monthlyCostsOfLiving.getText());
        double otherDebtsMonthlyPayments = Double.parseDouble(viewModel.otherDebtsMonthlyPayments.getText());
        String employerName = viewModel.monthlyIncome.getText();
        String employerContactData = viewModel.employerContactData.getText();
        double loanAmount = Double.parseDouble(viewModel.loanAmount.getText());
        double ownContribution = Double.parseDouble(viewModel.ownContribution.getText());
        String creditPurpose = viewModel.creditPurpose.getText();
        String interestRate = viewModel.interestRate.getText();
        String loanCollateral = viewModel.loanCollateral.getText();
        double commission = Double.parseDouble(viewModel.commission.getText());
        int creditTypeId = viewModel.creditType.getValue().getId();
        int currencyId = viewModel.currency.getValue().getId();
        int numberOfRepayments = Integer.parseInt(viewModel.numberOfRepayments.getText());

        if (loanAmount <= 0.0) {
            throw new InputException("Wysokość kredytu musi być większa od 0.0");
        }

        if (ownContribution > loanAmount) {
            throw new InputException("Wkład własny nie może być większy od wysokości kredytu");
        }

        if (commission > loanAmount) {
            throw new InputException("Porowizja kredytu nie może być większa od wysokości kredytu");

        }

        return new LoanApplicationForm(userId, monthlyIncome, formOfEmployment, martialStatue, monthlyCostOfLiving, otherDebtsMonthlyPayments,
                employerName, employerContactData, loanAmount, ownContribution, creditPurpose, interestRate, loanCollateral, commission,
                creditTypeId, currencyId, numberOfRepayments);

    }

    public Collection<LoanApplication> getAllLoanApplications() {
        // TODO: pobierz wszystkie loan applications do przetworzenia (nie zaakceptowane i nie odrzucone) z bazy+

        Collection<LoanApplication> loanApplications = new LinkedList<LoanApplication>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllLoanApplications)) {
            while (resultSet.next()) {
                int loanApplicationId = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                double monthlyIncome = resultSet.getDouble(3);
                String formOfEmployment = resultSet.getString(4);
                String martialStatus = resultSet.getString(5);
                double costsOfLiving = resultSet.getInt(6);
                double otherDebts = resultSet.getInt(7);
                String employerName = resultSet.getString(8);
                String employerContact = resultSet.getString(9);
                double loanAmmount = resultSet.getDouble(10);
                double ownContribution = resultSet.getDouble(11);
                String creditPurpose = resultSet.getString(12);
                double interestRate = resultSet.getDouble(13);
                String loanCollateral = resultSet.getString(14);
                double commission = resultSet.getDouble(15);
                int creditTypeId = resultSet.getInt(16);
                String currency = resultSet.getString(17);

                LoanApplication loanApplication = new LoanApplication(loanApplicationId, userId, monthlyIncome, formOfEmployment,
                        martialStatus, costsOfLiving, otherDebts, employerName, employerContact, loanAmmount, ownContribution, creditPurpose
                        , interestRate, loanCollateral, commission, creditTypeId, currency);
                loanApplications.add(loanApplication);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loanApplications;
    }

    public EventHandler calculateRepaymentAmount(LoanApplicationViewModel la, Text repaymentAmount) {
        return e -> {
            try {
                double amount = Double.parseDouble(la.loanAmount.getText());
                int numberOfRepayments = Integer.parseInt(la.numberOfRepayments.getText());
                double repayment = amount / numberOfRepayments;
                repaymentAmount.setText("Wysokość raty kredytu: " + String.format("%.2f", repayment));
            } catch (Exception ex) {
                InfoModal infoModal = new InfoModal("Błąd", "Wystąpił błąd w obliczaniu raty kredytu");
                infoModal.show();
            }
        };
    }

    public EventHandler acceptLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> acceptedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            for (Integer id : acceptedApplicationsIds) {
                if (acceptLoanApplication(id)) {
                    System.out.println("Wniosek " + id + " zaakceptowany");
                } else {
                    System.out.println("Wystąpił błąd przy akceptacji wniosku " + id);
                }
            }
            ((Node) (e.getSource())).getScene().getWindow().hide();
        };
    }

    public EventHandler rejectLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> rejectedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            for (Integer id : rejectedApplicationsIds) {
                if (rejectLoanApplication(id)) {
                    System.out.println("Wniosek " + id + " odrzucony");
                } else {
                    System.out.println("Wystąpił błąd przy odrzuceniu wniosku " + id);
                }
            }
            ((Node) (e.getSource())).getScene().getWindow().hide();
        };
    }

    private List<Integer> getChosenApplicationsIds(List<CheckBox> checkBoxes) {
        return checkBoxes.stream()
                .filter(CheckBox::isSelected)
                .map(Labeled::getText)
                .map(this::extractLoanApplicationId)
                .collect(Collectors.toList());
    }

    private int extractLoanApplicationId(String loanApplicationInfo) {
        return new Integer(loanApplicationInfo.substring(0, loanApplicationInfo.indexOf(" ")));
    }

    // TODO
    public List<String> getCreditTypes() {
        return Arrays.asList("Kredyt hipoteczny", "Kredyt walutowy", "Jeszczejakiś kredyt");
    }

    // TODO
    public List<String> getCurrencies() {
        return Arrays.asList("PLN", "EUR", "USD", "XDD");
    }
}
