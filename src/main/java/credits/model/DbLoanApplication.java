package credits.model;

public class DbLoanApplication {

    public int loanApplicationId;
    public int userId;
    public double monthlyIncome;
    public String formOfEmployment;
    public String maritalStatue;
    public double monthlyCostsOfLiving;
    public double otherDebtsMonthlyPayments;
    public String employerName;
    public String employerContactData;
    public double loanAmount;
    public double ownContribution;
    public String creditPurpose;
    public double interestRate;
    public String loanCollateral; // forma zabezpieczenia kredytu
    public double commission; // prowizja
    public int creditTypeId;
    public String currency;

    public DbLoanApplication(int loanApplicationId, int userId, double monthlyIncome, String formOfEmployment,
                             String maritalStatue, double monthlyCostsOfLiving, double otherDebtsMonthlyPayments,
                             String employerName, String employerContactData, double loanAmount,
                             double ownContribution, String creditPurpose, double interestRate, String loanCollateral,
                             double commission, int creditTypeId, String currency) {
        this.loanApplicationId = loanApplicationId;
        this.userId = userId;
        this.monthlyIncome = monthlyIncome;
        this.formOfEmployment = formOfEmployment;
        this.maritalStatue = maritalStatue;
        this.monthlyCostsOfLiving = monthlyCostsOfLiving;
        this.otherDebtsMonthlyPayments = otherDebtsMonthlyPayments;
        this.employerName = employerName;
        this.employerContactData = employerContactData;
        this.loanAmount = loanAmount;
        this.ownContribution = ownContribution;
        this.creditPurpose = creditPurpose;
        this.interestRate = interestRate;
        this.loanCollateral = loanCollateral;
        this.commission = commission;
        this.creditTypeId = creditTypeId;
        this.currency = currency;
    }

    /**
     * Tu w zamyśle miał być "tytuł", jakieś najważniejsze info czy coś takiego, do wyświetlenia na liście wniosków
     * <p>
     * !!!!!! MUSI BYĆ NA POCZĄTKU ID I SPACJA XD
     */
    public String getInfo() {
        return loanApplicationId + " | Użytkownik: " + userId + " | Wysokość kredytu: " + loanAmount + " | Cel " +
                "kredytu: "
                + creditPurpose;
    }

    @Override
    public String toString() {
        return "DbLoanApplication{" +
                "loanApplicationId=" + loanApplicationId +
                ", userId=" + userId +
                ", monthlyIncome=" + monthlyIncome +
                ", formOfEmployment='" + formOfEmployment + '\'' +
                ", maritalStatue='" + maritalStatue + '\'' +
                ", monthlyCostsOfLiving=" + monthlyCostsOfLiving +
                ", otherDebtsMonthlyPayments=" + otherDebtsMonthlyPayments +
                ", employerName='" + employerName + '\'' +
                ", employerContactData='" + employerContactData + '\'' +
                ", loanAmount=" + loanAmount +
                ", ownContribution=" + ownContribution +
                ", creditPurpose='" + creditPurpose + '\'' +
                ", interestRate=" + interestRate +
                ", loanCollateral='" + loanCollateral + '\'' +
                ", commission=" + commission +
                ", creditTypeId=" + creditTypeId +
                ", currency='" + currency + '\'' +
                '}';
    }
}
