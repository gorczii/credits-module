package credits.SQL.Model;

public class LoanApplicationForm {
    int userId;
    double monthlyIncome;
    String formOfEmployment;
    String martialStatus;
    double monthlyCostOfLiving;
    double otherDebtsMonthly;
    String employerName;
    String employerContactData;
    double loanAmmount;
    double ownContribution;
    String creditPurpose;
    String interestRate;
    String loanCollateral;
    double commision;
    int creditTypeId;
    int currencyId;
    int numberOfRepayments;

    public LoanApplicationForm(int userId, double monthlyIncome, String formOfEmployment, String martialStatus, double monthlyCostOfLiving, double otherDebtsMonthly, String employerName, String employerContactData, double loanAmmount, double ownContribution, String creditPurpose, String interestRate, String loanCollateral, double commision, int creditTypeId, int currencyId, int numberOfRepayments) {
        this.userId = userId;
        this.monthlyIncome = monthlyIncome;
        this.formOfEmployment = formOfEmployment;
        this.martialStatus = martialStatus;
        this.monthlyCostOfLiving = monthlyCostOfLiving;
        this.otherDebtsMonthly = otherDebtsMonthly;
        this.employerName = employerName;
        this.employerContactData = employerContactData;
        this.loanAmmount = loanAmmount;
        this.ownContribution = ownContribution;
        this.creditPurpose = creditPurpose;
        this.interestRate = interestRate;
        this.loanCollateral = loanCollateral;
        this.commision = commision;
        this.creditTypeId = creditTypeId;
        this.currencyId = currencyId;
        this.numberOfRepayments = numberOfRepayments;
    }

    public int getUserId() {
        return userId;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public double getMonthlyCostOfLiving() {
        return monthlyCostOfLiving;
    }

    public double getOtherDebtsMonthly() {
        return otherDebtsMonthly;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerContactData() {
        return employerContactData;
    }

    public double getLoanAmmount() {
        return loanAmmount;
    }

    public double getOwnContribution() {
        return ownContribution;
    }

    public String getCreditPurpose() {
        return creditPurpose;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public String getLoanCollateral() {
        return loanCollateral;
    }

    public double getCommision() {
        return commision;
    }

    public int getCreditTypeId() {
        return creditTypeId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public int getNumberOfRepayments() {
        return numberOfRepayments;
    }
}
