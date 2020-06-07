package credits.controller;

import credits.MockLoanApplications;
import credits.SQL.ConnectionManager;
import credits.SQL.Statements;
import credits.model.DbLoanApplication;
import credits.model.LoanApplicationViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Labeled;

import java.sql.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LoanController {

    public EventHandler<ActionEvent> sendLoanApplication(LoanApplicationViewModel loanApplication) {
        // TODO: wysłać wniosek do db

        return e -> System.out.println("Wniosek kredytowy złożony: " + loanApplication);
    }

    public Collection<DbLoanApplication> getAllLoanApplications() {
        // TODO: pobierz wszystkie loan applications do przetworzenia (nie zaakceptowane i nie odrzucone) z bazy
        Collection<DbLoanApplication> loanApplications = new LinkedList<DbLoanApplication>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllLoanApplications)) {

            while (resultSet.next())
            {
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

                DbLoanApplication loanApplication = new DbLoanApplication(loanApplicationId, userId, monthlyIncome,formOfEmployment,
                martialStatus,costsOfLiving,otherDebts,employerName,employerContact,loanAmmount,ownContribution,creditPurpose
                        ,interestRate,loanCollateral,commission, creditTypeId,currency);
                loanApplications.add(loanApplication);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loanApplications;
    }

    private boolean acceptLoanApplication(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.acceptLoanApplication);) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EventHandler acceptLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> acceptedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            for (Integer id : acceptedApplicationsIds) {
                if(acceptLoanApplication(id)) {
                    System.out.println("Wniosek " + id + " zaakceptowany");
                } else {
                    System.out.println("Wystąpił błąd przy akceptacji wniosku " + id);
                }
            }
            ((Node)(e.getSource())).getScene().getWindow().hide();
        };
    }

    private boolean rejectLoanApplication(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.rejectLoanApplication);) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EventHandler rejectLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> rejectedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            for (Integer id : rejectedApplicationsIds) {
                if(rejectLoanApplication(id)) {
                    System.out.println("Wniosek " + id + " odrzucony");
                } else {
                    System.out.println("Wystąpił błąd przy odrzuceniu wniosku " + id);
                }
            }
            ((Node)(e.getSource())).getScene().getWindow().hide();
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
}
