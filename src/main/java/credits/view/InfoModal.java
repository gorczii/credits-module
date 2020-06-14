package credits.view;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class InfoModal {

    private Stage stage;

    public InfoModal(String title, String message) {
        super();
        this.stage = new WindowBuilder(title, 600, 275)
                .withText(message, Font.font("Tahoma", FontWeight.NORMAL, 18))
                .withButton("OK", e -> this.stage.close())
                .build();
    }

    public void show() {
        this.stage.show();
    }
}
