package credits.controller;

import credits.model.LoanApplication;
import javafx.event.EventHandler;

public class CreateLoanApplicationWindowController {

    // TODO
    public EventHandler sendLoanApplication(LoanApplication loanApplication) {
        return e -> System.out.println("Wniosek kredytowy złożony: " + loanApplication);

    }
}
