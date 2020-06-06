package credits.view;

import credits.controller.AcceptLoanApplicationWindowController;
import credits.model.DbLoanApplication;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AcceptLoanApplicationWindow {

    private final AcceptLoanApplicationWindowController controller;
    private Stage stage;

    public AcceptLoanApplicationWindow(AcceptLoanApplicationWindowController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        Collection<DbLoanApplication> loanApplications = controller.getAllLoanApplications();

        WindowBuilder builder = new WindowBuilder("Wnioski kredytowe");
        List<CheckBox> checkBoxes = loanApplications.stream()
                .map(la -> new CheckBox(la.getInfo()))
                .collect(Collectors.toList());

        checkBoxes.forEach(builder::withCheckBox);

        builder.withButton("Zaakceptuj wybrane wnioski", controller.acceptLoanApplications(checkBoxes));
        this.stage = builder.build();
    }

    public void show() {
        this.stage.show();
    }
}
