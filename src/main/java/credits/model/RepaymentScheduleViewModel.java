package credits.model;

import credits.SQL.Model.LoanApplication;
import javafx.scene.control.TextField;

public class RepaymentScheduleViewModel {

    public LoanApplication loanApplication;
    public TextField numberOfRepayments;
    public TextField loanAmount;
    public TextField singleInstallmentAmount;

    public RepaymentScheduleViewModel(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
        numberOfRepayments = new TextField();
        loanAmount = new TextField("" + loanApplication.loanAmount);
        singleInstallmentAmount = new TextField();
    }
}
