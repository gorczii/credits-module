package credits.view;

import credits.controller.RepaymentScheduleController;
import credits.SQL.Model.LoanApplication;
import javafx.stage.Stage;

import java.util.Collection;

public class ShowRepaymentScheduleWindow {

    private final RepaymentScheduleController controller;
    private Stage stage;

    public ShowRepaymentScheduleWindow(RepaymentScheduleController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        Collection<LoanApplication> loanApplications = controller.getAcceptedLoanApplications();
        WindowBuilder builder = new WindowBuilder("Harmonogramy spłat", 600, 275);
        for (LoanApplication loanApplication : loanApplications) {
            builder.withButton(loanApplication.getInfo(), controller.openCreateRepaymentScheduleWindow(loanApplication));
        }
        this.stage = builder.build();
    }

    public void show() {
        this.stage.show();
    }

}
