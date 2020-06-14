package credits.model;

import credits.SQL.Model.CreditType;
import credits.SQL.Model.Currency;
import credits.SQL.Model.DocumentType;
import credits.SQL.Model.User;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewUserApplicationNewModel {

    public ComboBox<DocumentType> documentType;
    public TextField documentNumber;
    public DatePicker documentValidityDate;
    public TextField firstName;
    public TextField lastName;
    public TextField pesel;
    public DatePicker dateOfBirth;
    public TextField email;
    public TextField phoneNumber;

    public NewUserApplicationNewModel() {
        documentType = new ComboBox<>();
        documentNumber= new TextField();
        documentValidityDate= new DatePicker();
        firstName= new TextField();
        lastName= new TextField();
        pesel= new TextField();
        dateOfBirth= new DatePicker();
        email = new TextField();
        phoneNumber= new TextField();
    }
}
