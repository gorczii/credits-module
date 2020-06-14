package credits.model;

import credits.SQL.Model.CreditType;
import credits.SQL.Model.Currency;
import credits.SQL.Model.MaritalStatus;
import credits.SQL.Model.User;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LoanApplicationViewModel {

    public ComboBox<User> userId;
    public TextField monthlyIncome;
    public ComboBox<String> formOfEmployment;
    public ComboBox<String> maritalStatue;
    public TextField monthlyCostsOfLiving;
    public TextField otherDebtsMonthlyPayments;
    public TextField employerName;
    public TextField employerContactData;
    public TextField loanAmount;
    public TextField ownContribution;
    public TextField creditPurpose;
    public TextField interestRate;
    public TextField loanCollateral;
    public TextField commission;
    public ComboBox<CreditType> creditType;
    public ComboBox<Currency> currency;
    public TextField numberOfRepayments;

    public LoanApplicationViewModel() {
        userId = new ComboBox<>();
        monthlyIncome = new TextField();
        formOfEmployment = new ComboBox<>();
        maritalStatue = new ComboBox<>();
        monthlyCostsOfLiving = new TextField();
        otherDebtsMonthlyPayments = new TextField();
        employerName = new TextField();
        employerContactData = new TextField();
        loanAmount = new TextField();
        ownContribution = new TextField();
        creditPurpose = new TextField();
        interestRate = new TextField();
        loanCollateral = new TextField();
        commission = new TextField();
        creditType = new ComboBox<>();
        currency = new ComboBox<>();
        numberOfRepayments = new TextField();
    }

//    public LoanApplicationViewModel(String userId, String monthlyIncome, String formOfEmployment, String maritalStatu,
//                                    String monthlyCostsOfLiving, String otherDebtsMonthlyPayments, String employerName,
//                                    String employerContactData, String loanAmount, String ownContribution,
//                                    String creditPurpose, String interestRate, String loanCollateral, String commission,
//                                    String creditTypeId, String currencyId) {
//
//
//    }

    @Override
    public String toString() {
        return "LoanApplicationViewModel{" +
                "userId=" + userId.toString() +
                ", monthlyIncome=" + monthlyIncome.getCharacters() +
                ", formOfEmployment=" + formOfEmployment +
                ", maritalStatue=" + maritalStatue.toString() +
                ", monthlyCostsOfLiving=" + monthlyCostsOfLiving.getCharacters() +
                ", otherDebtsMonthlyPayments=" + otherDebtsMonthlyPayments.getCharacters() +
                ", employerName=" + employerName.getCharacters() +
                ", employerContactData=" + employerContactData.getCharacters() +
                ", loanAmount=" + loanAmount.getCharacters() +
                ", ownContribution=" + ownContribution.getCharacters() +
                ", creditPurpose=" + creditPurpose.getCharacters() +
                ", interestRate=" + interestRate.getCharacters() +
                ", loanCollateral=" + loanCollateral.getCharacters() +
                ", commission=" + commission.getCharacters() +
                ", creditTypeId=" + creditType.toString() +
                ", currencyId=" + currency.toString() +
                ", numberOfRepayments=" + numberOfRepayments.toString() +
                '}';
    }
}
