package credits.SQL.Model;

import java.util.Date;

public class Repayment {
    private int id;
    private int creditId;
    private double ammount;
    private Date date;

    public Repayment(int id, int creditId, double ammount, Date date) {
        this.id = id;
        this.creditId = creditId;
        this.ammount = ammount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getCreditId() {
        return creditId;
    }

    public double getAmmount() {
        return ammount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Kwota: " + ammount + "   Data: " + date;
    }
}
