package credits.controller;

import credits.MockLoanApplications;
import credits.model.DbLoanApplication;
import credits.model.RepaymentScheduleViewModel;
import credits.view.CreateRepaymentScheduleWindow;
import javafx.event.EventHandler;

import java.util.Collection;

public class RepaymentScheduleController {


    public Collection<DbLoanApplication> getAcceptedLoanApplications() {
        // TODO: pobierz zaakceptowane loan applications z bazy
        return MockLoanApplications.get();
    }

    public EventHandler saveRepaymentSchedule(RepaymentScheduleViewModel rs) {
        return e -> {

            // TODO: zapisz w bazce repayment schedule
            System.out.println("Zapisano harmonogram spłat");
        };
    }

    public EventHandler openCreateRepaymentScheduleWindow(DbLoanApplication loanApplication) {
        return e -> {
            new CreateRepaymentScheduleWindow(this, loanApplication).show();
            System.out.println("Utworzono nowy harmonogram spłat");
        };
    }
}
