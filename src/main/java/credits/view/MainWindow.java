package credits.view;

import credits.controller.MainWindowController;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MainWindow extends Stage {

    private MainWindowController controller;

    public MainWindow(MainWindowController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        TextField textField = new TextField();
        Stage stage = new WindowBuilder("Strona główna - moduł kredytów")
                .withText("Strona główna", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withButton("Złóż wniosek kredytowy", controller.createLoanApplication())
                .withButton("Akceptuj wniosek", controller.acceptLoanApplication())
                .withTextField("Imie: ", textField)
                .build();
        stage.show();
    }


}
