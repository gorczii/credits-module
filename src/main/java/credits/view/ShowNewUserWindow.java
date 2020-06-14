package credits.view;

import credits.SQL.Model.LoanApplication;
import credits.SQL.SqlDataProvider;
import credits.controller.NewUserController;
import credits.controller.RepaymentScheduleController;
import credits.model.LoanApplicationViewModel;
import credits.model.NewUserApplicationNewModel;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.util.Collection;

public class ShowNewUserWindow {

    private final NewUserController controller;
    private Stage stage;

    public ShowNewUserWindow(NewUserController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {

        NewUserApplicationNewModel nm = new NewUserApplicationNewModel();

        nm.documentType.getItems().addAll(SqlDataProvider.getAllDocumentTypes());
        nm.documentType.setValue(nm.documentType.getItems().get(0));

        this.stage = new WindowBuilder("Nowy użytkownik", 600, 700)
                .withText("Nowy wniosek kredytowy", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withComboBox("Typ dokumentu", nm.documentType)
                .withTextField("Numer dokumentu", nm.documentNumber)
                .withDatePicker("Data dokumentu", nm.documentValidityDate)
                .withTextField("Imię", nm.firstName)
                .withTextField("Nazwisko", nm.lastName)
                .withTextField("Pesel", nm.pesel)
                .withDatePicker("Data urodzenia", nm.dateOfBirth)
                .withTextField("email", nm.email)
                .withTextField("Numer telefonu", nm.phoneNumber)
                .withButton("Dodaj użytkownika", controller.addNewUser(nm))
                .build();
    }

    public void show() {
        this.stage.show();
    }

}
