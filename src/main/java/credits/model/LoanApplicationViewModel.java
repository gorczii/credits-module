package credits.model;

import javafx.scene.control.TextField;

public class LoanApplicationViewModel {

    public TextField userId;
    public TextField monthlyIncome;
    public TextField formOfEmployment;
    public TextField maritalStatue;
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
    public TextField creditTypeId;
    public TextField currencyId;

    public LoanApplicationViewModel() {
        userId = new TextField();
        monthlyIncome = new TextField();
        formOfEmployment = new TextField();
        maritalStatue = new TextField();
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
        creditTypeId = new TextField();
        currencyId = new TextField();
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
                "userId=" + userId.getCharacters() +
                ", monthlyIncome=" + monthlyIncome.getCharacters() +
                ", formOfEmployment=" + formOfEmployment +
                ", maritalStatue=" + maritalStatue.getCharacters() +
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
                ", creditTypeId=" + creditTypeId.getCharacters() +
                ", currencyId=" + currencyId.getCharacters() +
                '}';
    }
}