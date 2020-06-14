package credits.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;


/**
 * Dodaje kolejne nody jeden pod drugim, w zależności od tego w jakiej kolejności były wywołane meotdy -with...
 */

public class WindowBuilder {

    private Stage primaryStage;
    private GridPane grid;
    private int rowCounter = 0;


    public WindowBuilder(String title, int width, int height) {
        this.primaryStage = new Stage();
        primaryStage.setTitle(title);
        initGrid(width, height);
    }

    public WindowBuilder withButton(String text, EventHandler onClick) {
        Button button = new Button(text);
        button.setOnAction(onClick);
        grid.add(button, 0, rowCounter++);
        return this;
    }

    public WindowBuilder withTextField(String label, TextField textField) {
        Label l = new Label(label);
        grid.add(l, 0, rowCounter);
        grid.add(textField, 1, rowCounter++);
        return this;
    }

    public WindowBuilder withComboBox(String label, ComboBox comboBox) {
        Label l = new Label(label);
        grid.add(l, 0, rowCounter);
        grid.add(comboBox, 1, rowCounter++);
        return this;
    }

    public WindowBuilder withFormattedTextField(String label, TextField textField, TextFormatter formatter) {
        Label l = new Label(label);
        if (formatter != null) {
            textField.setTextFormatter(formatter);
        }
        grid.add(l, 0, rowCounter);
        grid.add(textField, 1, rowCounter++);
        return this;
    }

    public WindowBuilder withText(String text) {
        Text t = new Text(text);
        grid.add(t, 0, rowCounter++);
        return this;
    }

    public WindowBuilder withCheckBox(CheckBox checkBox) {
        grid.add(checkBox, 0, rowCounter++);
        return this;
    }

    public WindowBuilder withText(String text, Font font) {
        Text t = new Text(text);
        t.setFont(font);
        grid.add(t, 0, rowCounter++);
        return this;
    }

    public WindowBuilder withText(Text text) {
        grid.add(text, 0, rowCounter++);
        return this;
    }

    public Stage build() {
        return primaryStage;
    }

    private void initGrid(int width, int height) {
        this.grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, width, height);
        primaryStage.setScene(scene);
    }

}
