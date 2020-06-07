package credits;

import credits.SQL.ConnectionManager;
import credits.controller.MainWindowController;
import credits.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        ResultSet resultSet = null;


        MainWindowController mainWindowController = new MainWindowController();
        MainWindow mainWindow = new MainWindow(mainWindowController);
        mainWindow.show();
    }
}