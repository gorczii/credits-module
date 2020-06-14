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

        nm.sameAdress.setOnAction(controller.onSameAdressChecked(nm));

        this.stage = new WindowBuilder("Nowy użytkownik", 600, 700)
                .withText("Dodaj nowego użytkownika", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withComboBox("Typ dokumentu", nm.documentType)
                .withTextField("Numer dokumentu", nm.documentNumber)
                .withDatePicker("Data dokumentu", nm.documentValidityDate)
                .withTextField("Imię", nm.firstName)
                .withTextField("Nazwisko", nm.lastName)
                .withTextField("Pesel", nm.pesel)
                .withDatePicker("Data urodzenia", nm.dateOfBirth)
                .withTextField("email", nm.email)
                .withTextField("Numer telefonu", nm.phoneNumber)
                .withText("Adres zamieszkania", Font.font("Tahoma", FontWeight.NORMAL, 16))
                .withTextField("Miasto", nm.registredTown)
                .withTextField("Ulica", nm.registredStreet)
                .withTextField("Numer domu", nm.registredStreetNumber)
                .withTextField("Numer mieszkania", nm.registredFlatNumber)
                .withTextField("Kod Pocztowy", nm.registredPostalCode)
                .withText("Adres kontaktowy", Font.font("Tahoma", FontWeight.NORMAL, 16))
                .withText("Taki sam jak zamieszkania", Font.font("Tahoma", FontWeight.NORMAL, 14))
                .withCheckBox(nm.sameAdress)
                .withTextField("Miasto", nm.contactTown)
                .withTextField("Ulica", nm.contactStreet)
                .withTextField("Numer domu", nm.contactStreetNumber)
                .withTextField("Numer mieszkania", nm.contactFlatNumber)
                .withTextField("Kod Pocztowy", nm.contactPostalCode)
                .withButton("Dodaj użytkownika", controller.addNewUser(nm))
                .build();
    }

    public void show() {
        this.stage.show();
    }

}
