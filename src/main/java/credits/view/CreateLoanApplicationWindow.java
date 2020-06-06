package credits.view;

import credits.controller.CreateLoanApplicationWindowController;
import credits.model.LoanApplication;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreateLoanApplicationWindow extends Stage {

    private CreateLoanApplicationWindowController controller;

    public CreateLoanApplicationWindow(CreateLoanApplicationWindowController controller) {
        super();
        this.controller = controller;
        init();
    }

    private void init() {
        LoanApplication la = new LoanApplication();

        Stage stage = new WindowBuilder("Nowy wniosek kredytowy")
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
                .withTextField("Waluta (id)", la.currencyId)
                .withButton("Złóż wniosek", controller.sendLoanApplication(la))
                .build();
        stage.show();
    }
}
