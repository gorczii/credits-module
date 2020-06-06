package credits.view;

import credits.controller.LoanController;
import credits.model.LoanApplicationViewModel;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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

        this.stage = new WindowBuilder("Nowy wniosek kredytowy", 600, 700)
                .withText("Nowy wniosek kredytowy", Font.font("Tahoma", FontWeight.NORMAL, 20))
                .withTextField("Identyfikator użytkownika", la.userId)
                .withTextField("Miesięczny dochód", la.monthlyIncome)
                .withTextField("Forma zatrudnienia", la.formOfEmployment)
                .withTextField("Stan cywilny", la.maritalStatue)
                .withTextField("Miesięczne wydatki", la.monthlyCostsOfLiving)
                .withTextField("Inne miesięczne wydatki", la.otherDebtsMonthlyPayments)
                .withTextField("Nazwa pracodawcy", la.employerName)
                .withTextField("Kontakt do pracodawcy", la.employerContactData)
                .withTextField("Wysokość kredytu", la.loanAmount)
                .withTextField("Wkład własny", la.ownContribution)
                .withTextField("Cel kredytu", la.creditPurpose)
                .withTextField("Stopa oprocentowania", la.interestRate)
                .withTextField("Forma zabezpieczenia kredytu", la.loanCollateral)
                .withTextField("Prowizja", la.commission)
                .withTextField("Identyfikator typu kredytu", la.creditTypeId)
                .withTextField("Waluta", la.currencyId)
                .withButton("Złóż wniosek", controller.sendLoanApplication(la))
                .build();
    }

    public void show() {
        this.stage.show();
    }
}
