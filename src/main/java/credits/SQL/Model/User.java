package credits.SQL.Model;

import java.util.Date;

public class User {
    private final int id;
    private final int identificationDocumentId;
    private final String firstNames;
    private final String lastNames;
    private final String pesel;
    private final Date dateOfBirth;
    private final int registredAddressId;
    private final int contactAddressId;
    private final String email;
    private final  String phoneNumber;

    public User(int id, int identificationDocumentId, String firstNames, String lastNames, String pesel, Date dateOfBirth, int registredAddressId, int contactAddressId, String email, String phoneNumber) {
        this.id = id;
        this.identificationDocumentId = identificationDocumentId;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.registredAddressId = registredAddressId;
        this.contactAddressId = contactAddressId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getIdentificationDocumentId() {
        return identificationDocumentId;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getPesel() {
        return pesel;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getRegistredAddressId() {
        return registredAddressId;
    }

    public int getContactAddressId() {
        return contactAddressId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return firstNames + " " + lastNames + " " + pesel;
    }
}
