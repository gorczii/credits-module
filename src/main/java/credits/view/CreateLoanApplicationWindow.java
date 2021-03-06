package credits.view;

import credits.SQL.Model.FormOfEmployment;
import credits.SQL.Model.MaritalStatus;
import credits.SQL.Model.User;
import credits.SQL.SqlDataProvider;
import credits.controller.LoanController;
import credits.model.LoanApplicationViewModel;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class CreateLoanApplicationWindow {

    private LoanController controller;
    private Stage stage;

    public CreateLoanApplicationWindow(LoanController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

        UnaryOperator<TextFormatter.Change> doubleFilter = c -> {
            Pattern validEditingState = Pattern.compile("(([1-9][0-9]*)|0)?(\\.[0-9]{0,2})?");
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        LoanApplicationViewModel la = new LoanApplicationViewModel();
        la.creditType.getItems().addAll(SqlDataProvider.getAllCreditTypes());
        la.creditType.setValue(la.creditType.getItems().get(0));

        la.currency.getItems().addAll(SqlDataProvider.getAllCurrencies());
        la.currency.setValue(la.currency.getItems().get(0));

        List<User> users = new ArrayList<>(SqlDataProvider.getAllUsers());
        users.sort((o1, o2) -> o1.getLastNames().compareToIgnoreCase(o2.getLastNames()));


        la.userId.getItems().addAll(users);
        la.userId.setValue(la.userId.getItems().get(0));

        la.maritalStatue.getItems().addAll(MaritalStatus.getStatues());
        la.maritalStatue.setValue(MaritalStatus.getStatues()[0]);

        la.formOfEmployment.getItems().addAll(FormOfEmployment.getForms());
        la.formOfEmployment.setValue(FormOfEmployment.getForms()[0]);

        Text repaymentAmount = new Text();

        this.stage = new WindowBuilder("Nowy wniosek kredytowy", 600, 750)
                .withText("Nowy wniosek kredytowy", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withComboBox("Identyfikator użytkownika", la.userId)
                .withComboBox("Waluta", la.currency)
                .withFormattedTextField("Miesięczny dochód", la.monthlyIncome, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withComboBox("Forma zatrudnienia", la.formOfEmployment)
                .withComboBox("Stan cywilny", la.maritalStatue)
                .withFormattedTextField("Miesięczne wydatki", la.monthlyCostsOfLiving, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withFormattedTextField("Inne miesięczne wydatki", la.otherDebtsMonthlyPayments, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withTextField("Nazwa pracodawcy", la.employerName)
                .withTextField("Kontakt do pracodawcy", la.employerContactData)
                .withComboBox("Typ kredytu", la.creditType)
                .withFormattedTextField("Wysokość kredytu", la.loanAmount, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withFormattedTextField("Wkład własny", la.ownContribution, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withTextField("Cel kredytu", la.creditPurpose)
                .withFormattedTextField("Stopa oprocentowania", la.interestRate, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withTextField("Forma zabezpieczenia kredytu", la.loanCollateral)
                .withFormattedTextField("Prowizja", la.commission, new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter))
                .withFormattedTextField("Liczba rat", la.numberOfRepayments, new TextFormatter<>(new IntegerStringConverter(), 12, integerFilter))
                .withButton("Oblicz wysokość raty", controller.calculateRepaymentAmount(la, repaymentAmount))
                .withText(repaymentAmount)
                .withButton("Złóż wniosek", controller.sendLoanApplication(la))
                .build();
    }

    public void show() {
        this.stage.show();
    }
}
