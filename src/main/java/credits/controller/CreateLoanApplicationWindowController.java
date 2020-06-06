package credits.controller;

import credits.model.LoanApplicationViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreateLoanApplicationWindowController {

    // TODO
    public EventHandler<ActionEvent> sendLoanApplication(LoanApplicationViewModel loanApplication) {
        return e -> System.out.println("Wniosek kredytowy złożony: " + loanApplication);

    }
}
