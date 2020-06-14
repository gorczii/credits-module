package credits.view;

import credits.controller.MainWindowController;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MainWindow {

    private MainWindowController controller;
    private Stage stage;

    public MainWindow(MainWindowController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        this.stage = new WindowBuilder("Moduł kredytów", 500, 275)
                .withText("KREDYTY", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withText("Strona główna", Font.font("Tahoma", FontWeight.NORMAL, 14))
                .withButton("Nowy wniosek kredytowy", controller.openNewLoanApplicationWindow())
                .withButton("Akceptuj/odrzuć wnioski", controller.openAcceptLoanApplicationWindow())
                .withButton("Pokaż harmonogram spłat", controller.openShowRepaymentsWindows())
                .withButton("Dodaj nowego użytkownika", controller.openNewUserWindow())
                .build();
    }

    public void show() {
        this.stage.show();
    }


}
