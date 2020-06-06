package credits.controller;

import credits.model.LoanApplicationViewModel;
import javafx.event.EventHandler;

public class CreateLoanApplicationWindowController {

    // TODO
    public EventHandler sendLoanApplication(LoanApplicationViewModel loanApplication) {
        return e -> System.out.println("Wniosek kredytowy złożony: " + loanApplication);

    }
}
