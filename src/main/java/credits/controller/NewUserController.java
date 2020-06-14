package credits.controller;

import credits.SQL.Model.NewAddress;
import credits.SQL.Model.NewDocument;
import credits.SQL.Model.NewUser;
import credits.SQL.SqlDataProvider;
import credits.model.NewUserApplicationNewModel;
import credits.view.InfoModal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class NewUserController {
    public EventHandler addNewUser(NewUserApplicationNewModel nm) {
        return event -> {

            int documentType = nm.documentType.getValue().getId();
            String documentNumber = nm.documentNumber.getText();
            LocalDate localDate = nm.dateOfBirth.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date documentValidity  = Date.from(instant);

            NewDocument newDocument = new NewDocument(documentType, documentNumber, documentValidity);


            String firstName = nm.firstName.getText();
            String lastName = nm.lastName.getText();
            String pesel = nm.pesel.getText();
            LocalDate localDate2 = nm.dateOfBirth.getValue();
            Instant instant2 = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateOfBirth  = Date.from(instant);
            String email = nm.email.getText();
            long phoneNumber = Long.parseLong(nm.phoneNumber.getText());

            NewUser newUser = new NewUser(firstName, lastName, pesel, dateOfBirth, email, phoneNumber);

            String registredTown = nm.registredTown.getText();
            String registredStreet = nm.registredStreet.getText();
            String registredStreetNumber = nm.registredStreetNumber.getText();
            String registredFlatNumber = nm.registredFlatNumber.getText().equals("") ? null :  nm.registredFlatNumber.getText();
            String registredPostalCode = nm.registredPostalCode.getText();

            NewAddress registredAddress = new NewAddress(registredTown, registredStreet, registredStreetNumber, registredFlatNumber, registredPostalCode);
            NewAddress contactAddress;
            if (nm.sameAdress.isSelected()) {
                contactAddress = registredAddress;
            } else {
                String contactTown = nm.contactTown.getText();
                String contactStreet = nm.contactStreet.getText();
                String contactStreetNumber = nm.contactStreetNumber.getText();
                String contactFlatNumber = nm.contactFlatNumber.getText().equals("") ? null :  nm.contactFlatNumber.getText();
                String contactPostalCode = nm.contactPostalCode.getText();
                contactAddress = new NewAddress(contactTown, contactStreet, contactStreetNumber, contactFlatNumber, contactPostalCode);
            }

            if (SqlDataProvider.addUser(newUser, registredAddress, contactAddress, newDocument)) {
                InfoModal infoModal = new InfoModal("Sukces", "Pomyślnie dodano użytkownika!");
                infoModal.show();
            } else {
                InfoModal infoModal = new InfoModal("Błąd", "Wystąpił błąd podczas dodawania użytkownika");
                infoModal.show();
            }

        };
    }

    public EventHandler<ActionEvent> onSameAdressChecked(NewUserApplicationNewModel nm) {
        return event -> {
           if (!nm.sameAdress.isSelected()) {
               nm.contactTown.setDisable(false);
               nm.contactStreet.setDisable(false);
               nm.contactStreetNumber.setDisable(false);
               nm.contactFlatNumber.setDisable(false);
               nm.contactPostalCode.setDisable(false);
           } else {
               nm.contactTown.setDisable(true);
               nm.contactStreet.setDisable(true);
               nm.contactStreetNumber.setDisable(true);
               nm.contactFlatNumber.setDisable(true);
               nm.contactPostalCode.setDisable(true);
           }
        };
    }
}
