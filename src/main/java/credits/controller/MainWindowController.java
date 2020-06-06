package credits.controller;

import credits.view.AcceptLoanApplicationWindow;
import credits.view.CreateLoanApplicationWindow;
import credits.view.ShowRepaymentScheduleWindow;
import javafx.event.EventHandler;

public class MainWindowController {

    public EventHandler openNewLoanApplicationWindow() {
        return e -> {
            LoanController controller = new LoanController();
            new CreateLoanApplicationWindow(controller).show();
            System.out.println("Otwarto nowy wniosek kredytowy");
        };
    }

    public EventHandler openAcceptLoanApplicationWindow() {
        return e -> {
            LoanController controller = new LoanController();
            new AcceptLoanApplicationWindow(controller).show();
            System.out.println("Otwarto panel akceptowania/odrzucania wniosków");
        };
    }

    public EventHandler openRepaymentScheduleWindow() {
        return e -> {
            RepaymentScheduleController controller = new RepaymentScheduleController();
            new ShowRepaymentScheduleWindow(controller).show();
            System.out.println("Otwarto panel tworzenia harmongramów spłat kredytów");
        };
    }
}
