package credits.controller;

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
        return e -> System.out.println("Wniosek kredytowy zaakceptowany");
    }
}
