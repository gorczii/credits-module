package credits;

import credits.model.DbLoanApplication;

import java.util.Arrays;
import java.util.Collection;

public class MockLoanApplications {

    public static Collection<DbLoanApplication> get() {
        DbLoanApplication la1 = new DbLoanApplication(1, 1, 5000.0, "UoP", "wolny", 1800.0, 650.50,
                "TomTom", "Żeromskiego 94C", 250000.00, 65000.0, "Zakup mieszkania", 5.51, "Hipoteka", 0.0, 1, "PLN");
        DbLoanApplication la2 = new DbLoanApplication(2, 2, 13500.0, "UoP", "zamężny", 2000.0, 1000.0,
                "BinarApps", "j.kalucki@binarapps.com", 500000.00, 150000.0, "Założenie działalności", 6.03,
                "Hipoteka", 150.0, 2, "EUR");
        DbLoanApplication la3 = new DbLoanApplication(3, 3, 5500.0, "Umowa zlecenie", "zamężny", 2000.0, 0.0,
                "Microsoft", "Bill Gates", 80000.00, 35000.0, "Zakup samochodu", 5.55,
                "Umowa Leasingowa", 320.0, 3, "PLN");
        return Arrays.asList(la1, la2, la3);
    }
}