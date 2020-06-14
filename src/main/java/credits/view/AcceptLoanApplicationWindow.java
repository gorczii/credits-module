package credits.view;

import credits.controller.LoanController;
import credits.SQL.Model.LoanApplication;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AcceptLoanApplicationWindow {

    private final LoanController controller;
    private Stage stage;

    public AcceptLoanApplicationWindow(LoanController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        Collection<LoanApplication> loanApplications = controller.getAllLoanApplications();

        WindowBuilder builder = new WindowBuilder("Wnioski kredytowe", 600, 275);
        List<CheckBox> checkBoxes = loanApplications.stream()
                .map(la -> new CheckBox(la.getInfo()))
                .collect(Collectors.toList());

        checkBoxes.forEach(builder::withCheckBox);

        builder.withButton("Zaakceptuj wybrane wnioski", controller.acceptLoanApplications(checkBoxes));
        builder.withButton("Odrzuć wybrane wnioski", controller.rejectLoanApplications(checkBoxes));
        this.stage = builder.build();
    }

    public void show() {
        this.stage.show();
    }
}
