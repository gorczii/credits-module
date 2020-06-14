package credits.controller;

import credits.view.*;
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
            new OldRepaymentScheduleWindow(controller).show();
            System.out.println("Otwarto panel tworzenia harmongramów spłat kredytów");
        };
    }

    public EventHandler openShowRepaymentsWindows() {
        return e -> {
            ShowRepaymentsController controller = new ShowRepaymentsController();
            new ShowRepaymentsWindow(controller).show();
            System.out.println("Otwarto panel tworzenia nowego użytkownika");
        };
    }

    public EventHandler openNewUserWindow() {
        return e -> {
            NewUserController controller = new NewUserController();
            new ShowNewUserWindow(controller).show();
            System.out.println("Otwarto panel tworzenia nowego użytkownika");
        };
    }
}
