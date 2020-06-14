package credits.model;

import credits.SQL.Model.CreditType;
import credits.SQL.Model.Currency;
import credits.SQL.Model.DocumentType;
import credits.SQL.Model.User;
import javafx.scene.control.CheckBox;
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

    public TextField registredTown;
    public TextField registredStreet;
    public TextField registredStreetNumber;
    public TextField registredFlatNumber;
    public TextField registredPostalCode;

    public TextField contactTown;
    public TextField contactStreet;
    public TextField contactStreetNumber;
    public TextField contactFlatNumber;
    public TextField contactPostalCode;

    public CheckBox sameAdress;

    public NewUserApplicationNewModel() {
        documentType = new ComboBox<>();
        documentNumber= new TextField();
        documentValidityDate= new DatePicker();
        firstName= new TextField();
        lastName= new TextField();
        pesel= new TextField();
        dateOfBirth= new DatePicker();
        email = new TextField();
        phoneNumber = new TextField();

        registredTown = new TextField();
        registredStreet = new TextField();
        registredStreetNumber = new TextField();
        registredFlatNumber = new TextField();
        registredPostalCode = new TextField();

        contactTown = new TextField();
        contactStreet = new TextField();
        contactStreetNumber = new TextField();
        contactFlatNumber = new TextField();
        contactPostalCode = new TextField();

        sameAdress = new CheckBox();
    }
}
