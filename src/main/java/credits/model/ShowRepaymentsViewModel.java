package credits.model;

import credits.SQL.Model.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ShowRepaymentsViewModel {

    public ComboBox<User> userId;
    public ComboBox<Credit> credits;
    public ListView<Repayment> repayments;
    public ListView<RepaymentScheduleElement> repaymentScheduleElements;
    public TextField repaymentValue;
    public Button addRepayment;
    public TextField creditLeft;


    public ShowRepaymentsViewModel() {
        userId = new ComboBox<>();
        credits = new ComboBox<>();
        repayments = new ListView<>();
        repaymentScheduleElements = new ListView<>();
        repaymentValue = new TextField();
        addRepayment = new Button();
        creditLeft = new TextField();
    }
}
