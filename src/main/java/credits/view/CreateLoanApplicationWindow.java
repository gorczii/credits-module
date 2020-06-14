package credits.view;

import credits.controller.LoanController;
import credits.model.LoanApplicationViewModel;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class CreateLoanApplicationWindow {

    private LoanController controller;
    private Stage stage;

    public CreateLoanApplicationWindow(LoanController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        LoanApplicationViewModel la = new LoanApplicationViewModel();
        ComboBox creditTypeComboBox = new ComboBox();
        List<String> creditTypes = controller.getCreditTypes();
        creditTypeComboBox.getItems().addAll(creditTypes);
        creditTypeComboBox.setValue(creditTypes.get(0));

        ComboBox currencyComboBox = new ComboBox();
        List<String> currencies = controller.getCurrencies();
        currencyComboBox.getItems().addAll(currencies);
        currencyComboBox.setValue(currencies.get(0));

        this.stage = new WindowBuilder("Nowy wniosek kredytowy", 600, 700)
                .withText("Nowy wniosek kredytowy", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withTextField("Identyfikator użytkownika", la.userId)
                .withComboBox("Waluta", currencyComboBox)
                .withTextField("Miesięczny dochód", la.monthlyIncome)
                .withTextField("Forma zatrudnienia", la.formOfEmployment)
                .withTextField("Stan cywilny", la.maritalStatue)
                .withTextField("Miesięczne wydatki", la.monthlyCostsOfLiving)
                .withTextField("Inne miesięczne wydatki", la.otherDebtsMonthlyPayments)
                .withTextField("Nazwa pracodawcy", la.employerName)
                .withTextField("Kontakt do pracodawcy", la.employerContactData)
                .withComboBox("Typ kredytu", creditTypeComboBox)
                .withTextField("Wysokość kredytu", la.loanAmount)
                .withTextField("Wkład własny", la.ownContribution)
                .withTextField("Cel kredytu", la.creditPurpose)
                .withTextField("Stopa oprocentowania", la.interestRate)
                .withTextField("Forma zabezpieczenia kredytu", la.loanCollateral)
                .withTextField("Prowizja", la.commission)
                .withButton("Złóż wniosek", controller.sendLoanApplication(la, creditTypeComboBox, currencyComboBox))
                .build();
    }

    public void show() {
        this.stage.show();
    }
}
