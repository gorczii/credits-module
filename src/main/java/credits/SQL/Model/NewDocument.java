package credits.SQL.Model;

import java.sql.Time;
import java.util.Date;

public class NewDocument {
    int documentTypeId;
    String number;
    Date validityDate;

    public NewDocument(int documentTypeId, String number, Date validityDate) {
        this.documentTypeId = documentTypeId;
        this.number = number;
        this.validityDate = validityDate;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Time validityDate) {
        this.validityDate = validityDate;
    }
}
