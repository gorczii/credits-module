package credits.view;

import credits.controller.RepaymentScheduleController;
import credits.model.DbLoanApplication;
import credits.model.RepaymentScheduleViewModel;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CreateRepaymentScheduleWindow {

    private RepaymentScheduleController controller;
    private DbLoanApplication dbLoanApplication;
    private Stage stage;

    public CreateRepaymentScheduleWindow(RepaymentScheduleController controller, DbLoanApplication dbLoanApplication) {
        super();
        this.controller = controller;
        this.dbLoanApplication = dbLoanApplication;
        init();
    }

    private void init() {
        RepaymentScheduleViewModel rs = new RepaymentScheduleViewModel(dbLoanApplication);
        Text singleInst = new Text("\n");

        WindowBuilder builder = new WindowBuilder("Nowy harmonogram spłat", 800, 400)
                .withText("Nowy harmonogram spłat", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withText(dbLoanApplication.getInfo(), Font.font("Tahoma", FontWeight.NORMAL, 12))
                .withTextField("Kwota kredytu", rs.loanAmount)
                .withTextField("Liczba rat", rs.numberOfRepayments)
                .withButton("Oblicz wysokość raty", showSingleInstallmentAmount(singleInst, rs))
                .withButton("Zapisz harmonogram spłat", controller.saveRepaymentSchedule(rs))
                .withText(singleInst);

        this.stage = builder.build();
    }

    public void show() {
        this.stage.show();
    }

    private EventHandler showSingleInstallmentAmount(Text text, RepaymentScheduleViewModel rs) {
        return e -> {
            double amount = Double.valueOf(rs.loanAmount.getText()) / Integer.valueOf(rs.numberOfRepayments.getText());
            rs.singleInstallmentAmount = new TextField("" + amount);
            text.setText("\nWysokość pojedynczej raty: " + amount);
        };
    }
}
