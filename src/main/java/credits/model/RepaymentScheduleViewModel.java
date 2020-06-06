package credits.model;

import javafx.scene.control.TextField;

public class RepaymentScheduleViewModel {

    public DbLoanApplication loanApplication;
    public TextField numberOfRepayments;
    public TextField loanAmount;
    public TextField singleInstallmentAmount;

    public RepaymentScheduleViewModel(DbLoanApplication loanApplication) {
        this.loanApplication = loanApplication;
        numberOfRepayments = new TextField();
        loanAmount = new TextField("" + loanApplication.loanAmount);
        singleInstallmentAmount = new TextField();
    }
}
