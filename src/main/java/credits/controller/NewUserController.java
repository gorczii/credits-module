package credits.controller;

import credits.model.NewUserApplicationNewModel;
import javafx.event.EventHandler;

public class NewUserController {
    public EventHandler addNewUser(NewUserApplicationNewModel nm) {
        return event -> {
            System.out.println("Test");
        };
    }
}
