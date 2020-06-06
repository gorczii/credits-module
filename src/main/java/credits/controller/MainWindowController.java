package credits.controller;

import credits.view.AcceptLoanApplicationWindow;
import credits.view.CreateLoanApplicationWindow;
import javafx.event.EventHandler;

public class MainWindowController {

    // TODO
    public EventHandler createLoanApplication() {
        openCreateLoanApplicationView();
        return e -> System.out.println("Otwarto nowy wniosek kredytowy");
    }

    private void openCreateLoanApplicationView() {
        CreateLoanApplicationWindowController controller = new CreateLoanApplicationWindowController();
        new CreateLoanApplicationWindow(controller).show();
    }

    // TODO
    public EventHandler acceptLoanApplication() {
        openAcceptLoanApplicationView();
        return e -> System.out.println("Wniosek kredytowy zaakceptowany");
    }

    private void openAcceptLoanApplicationView() {
        AcceptLoanApplicationWindowController controller = new AcceptLoanApplicationWindowController();
        new AcceptLoanApplicationWindow(controller).show();
    }
}
