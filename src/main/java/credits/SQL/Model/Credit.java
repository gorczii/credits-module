package credits.SQL.Model;

public class Credit {
    private int creditId;
    private int accountId;
    private int creditTypeId;
    private int creditTermsId;
    private int loanApplicationId;

    public int getCreditId() {
        return creditId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCreditTypeId() {
        return creditTypeId;
    }

    public int getCreditTermsId() {
        return creditTermsId;
    }

    public int getLoanApplicationId() {
        return loanApplicationId;
    }

    public Credit(int creditId, int accountId, int creditTypeId, int creditTermsId, int loanApplicationId) {
        this.creditId = creditId;
        this.accountId = accountId;
        this.creditTypeId = creditTypeId;
        this.creditTermsId = creditTermsId;
        this.loanApplicationId = loanApplicationId;
    }
}
