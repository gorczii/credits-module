package credits.controller;

import credits.MockLoanApplications;
import credits.model.DbLoanApplication;
import credits.model.LoanApplicationViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Labeled;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LoanController {

    public EventHandler<ActionEvent> sendLoanApplication(LoanApplicationViewModel loanApplication) {
        // TODO: wysłać wniosek do db
        return e -> System.out.println("Wniosek kredytowy złożony: " + loanApplication);
    }

    public Collection<DbLoanApplication> getAllLoanApplications() {
        // TODO: pobierz wszystkie loan applications do przetworzenia (nie zaakceptowane i nie odrzucone) z bazy
        return MockLoanApplications.get();
    }

    public EventHandler acceptLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> acceptedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            // TODO: wysłać akceptacje do db
            System.out.println("Wnioski " + acceptedApplicationsIds + " zaakceptowane.");
        };
    }

    public EventHandler rejectLoanApplications(List<CheckBox> checkBoxes) {
        return e -> {
            List<Integer> acceptedApplicationsIds = getChosenApplicationsIds(checkBoxes);
            // TODO: wysłać odrzucenie wniosków do db
            System.out.println("Wnioski " + acceptedApplicationsIds + " odrzucone.");
        };
    }

    private List<Integer> getChosenApplicationsIds(List<CheckBox> checkBoxes) {
        return checkBoxes.stream()
                .filter(CheckBox::isSelected)
                .map(Labeled::getText)
                .map(this::extractLoanApplicationId)
                .collect(Collectors.toList());
    }

    private int extractLoanApplicationId(String loanApplicationInfo) {
        return new Integer(loanApplicationInfo.substring(0, loanApplicationInfo.indexOf(" ")));
    }
}
