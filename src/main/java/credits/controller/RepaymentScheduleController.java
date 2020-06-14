package credits.controller;

import credits.SQL.SqlDataProvider;
import credits.SQL.Model.LoanApplication;
import credits.model.RepaymentScheduleViewModel;
import credits.view.CreateRepaymentScheduleWindow;
import javafx.event.EventHandler;

import java.util.Collection;

public class RepaymentScheduleController {


    public Collection<LoanApplication> getAcceptedLoanApplications() {
        // TODO: pobierz zaakceptowane loan applications z bazy
        return new SqlDataProvider().getAcceptedLoans();
    }

    public EventHandler saveRepaymentSchedule(RepaymentScheduleViewModel rs) {
        return e -> {

            // TODO: zapisz w bazce repayment schedule
            System.out.println("Zapisano harmonogram spłat");
        };
    }

    public EventHandler openCreateRepaymentScheduleWindow(LoanApplication loanApplication) {
        return e -> {
            new CreateRepaymentScheduleWindow(this, loanApplication).show();
            System.out.println("Utworzono nowy harmonogram spłat");
        };
    }
}
