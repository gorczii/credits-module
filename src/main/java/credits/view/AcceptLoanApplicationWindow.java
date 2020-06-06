package credits.view;

import credits.controller.AcceptLoanApplicationWindowController;
import credits.model.DbLoanApplication;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.Collection;

public class AcceptLoanApplicationWindow extends Stage {

    private final AcceptLoanApplicationWindowController controller;

    public AcceptLoanApplicationWindow(AcceptLoanApplicationWindowController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        Collection<DbLoanApplication> loanApplications = controller.getAllLoanApplications();

        WindowBuilder builder = new WindowBuilder("Wnioski kredytowe");
        for (DbLoanApplication application : loanApplications) {
            CheckBox checkBox = new CheckBox(application.getInfo());
            builder.withCheckBox(checkBox);
        }
        builder.build().show();
    }
}
