package credits.view;

import credits.SQL.Model.LoanApplication;
import credits.SQL.Model.User;
import credits.SQL.SqlDataProvider;
import credits.controller.RepaymentScheduleController;
import credits.controller.ShowRepaymentsController;
import credits.model.ShowRepaymentsViewModel;
import javafx.event.Event;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class ShowRepaymentsWindow {
    private final ShowRepaymentsController controller;
    private Stage stage;

    public ShowRepaymentsWindow(ShowRepaymentsController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        ShowRepaymentsViewModel viewModel = new ShowRepaymentsViewModel();

        List<User> users = new ArrayList<>(SqlDataProvider.getAllUsers());
        users.sort((o1, o2) -> o1.getLastNames().compareToIgnoreCase(o2.getLastNames()));
        viewModel.userId.getItems().addAll(users);
        viewModel.userId.setValue(viewModel.userId.getItems().get(0));
        viewModel.userId.setOnAction(controller.onUserChanged(viewModel));

        //TODO te kredyty się wyswieltaja zjebanie (mozna w toString powyciagac ladne informacje)
        viewModel.credits.getItems().addAll(SqlDataProvider.getUserCredits(viewModel.userId.getItems().get(0).getId()));
        viewModel.credits.setOnAction(controller.onCreditChanged(viewModel));

        viewModel.addRepayment.setDisable(true);
        viewModel.repaymentValue.setDisable(true);
        viewModel.creditLeft.setDisable(true);

        UnaryOperator<TextFormatter.Change> doubleFilter = c -> {
            Pattern validEditingState = Pattern.compile("(([1-9][0-9]*)|0)?(\\.[0-9]{0,2})?");
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                if (Double.parseDouble(text) != 0.0) {
                    viewModel.addRepayment.setDisable(false);
                }
                return c ;
            } else {
                return null ;
            }
        };

        WindowBuilder builder = new WindowBuilder("Harmonogramy spłat", 600, 275);
        builder.withComboBox("Wybierz użytkownika", viewModel.userId);
        builder.withComboBox("Wybierz kredyt", viewModel.credits);
        builder.withListView("Wpłaty", viewModel.repayments);
        builder.withListView("Plan wpłat", viewModel.repaymentScheduleElements);
        builder.withTextField("Pozostała kwota do zapłaty", viewModel.creditLeft);
        builder.withFormattedTextField("Kwota wpłaty", viewModel.repaymentValue, new TextFormatter<Double>(new DoubleStringConverter(), 0.0, doubleFilter));
        builder.withButton("Dodaj wpłate", viewModel.addRepayment, controller.onAddRepaymentClicked(viewModel));
        this.stage = builder.build();
    }

    public void show() {
        this.stage.show();
    }

}
