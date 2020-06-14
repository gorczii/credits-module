package credits.controller;

import credits.SQL.Model.*;
import credits.SQL.SqlDataProvider;
import credits.model.LoanApplicationViewModel;
import credits.model.ShowRepaymentsViewModel;
import credits.view.InfoModal;
import credits.view.ShowNewUserWindow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.Collection;

public class ShowRepaymentsController {

    public EventHandler<ActionEvent> onUserChanged(ShowRepaymentsViewModel viewModel) {
        return e -> {
            viewModel.credits.getItems().clear();
            viewModel.repaymentScheduleElements.getItems().clear();
            viewModel.repayments.getItems().clear();

            viewModel.credits.getItems().addAll(SqlDataProvider.getUserCredits(viewModel.userId.getValue().getId()));
        };
    }

    public EventHandler<ActionEvent> onCreditChanged(ShowRepaymentsViewModel viewModel) {
        return e -> {
            ComboBox<Credit> source = viewModel.credits;
            if (source.getValue() == null) {
                return;
            }

            Collection<Repayment> repayments = SqlDataProvider.getRepayments(source.getValue().getCreditId());
            System.out.println(repayments);
            Collection<RepaymentScheduleElement> repaymentSchedule = SqlDataProvider.getRepaymentSchedule(source.getValue().getCreditId());
            System.out.println(repaymentSchedule);
            viewModel.repaymentScheduleElements.setItems(FXCollections.observableArrayList(repaymentSchedule));
            viewModel.repayments.setItems(FXCollections.observableArrayList(repayments));

            viewModel.repaymentValue.setDisable(false);
            viewModel.creditLeft.setText(String.valueOf(SqlDataProvider.getCreditAmountLeft(source.getValue().getCreditId())));
        };
    }

    public EventHandler onAddRepaymentClicked(ShowRepaymentsViewModel viewModel) {
        return e -> {
            if (Double.parseDouble(viewModel.repaymentValue.getText()) > Double.parseDouble(viewModel.creditLeft.getText())) {
                InfoModal infoModal = new InfoModal("Błąd", "Wpłata nie może być większa niż pozostała kwota.");
                infoModal.show();
                System.out.println("test");
                return;
            }

            SqlDataProvider.payRepayment(viewModel.credits.getValue().getCreditId(), Double.parseDouble(viewModel.repaymentValue.getText()));
            Collection<Repayment> repayments = SqlDataProvider.getRepayments(viewModel.credits.getValue().getCreditId());
            viewModel.repayments.setItems(FXCollections.observableArrayList(repayments));
            viewModel.creditLeft.setText(String.valueOf(SqlDataProvider.getCreditAmountLeft(viewModel.credits.getValue().getCreditId())));

            viewModel.repaymentValue.setText("0.0");
            viewModel.addRepayment.setDisable(true);
        };
    }
}
