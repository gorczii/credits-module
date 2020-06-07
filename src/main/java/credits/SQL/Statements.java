package credits.SQL;

public class Statements {
    public static final String makeLoanApplication = "{? = call dbo.makeLoanApplication(?)}";
    public static String rejectLoanApplication = "{call dbo.rejectLoanApplication(?)}";
    public static String acceptLoanApplication = "{call dbo.acceptLoanApplication(?)}";
    public static String getAllLoanApplications = "SELECT [loan_application].[loan_application_id]\n" +
            "      ,[user_id]\n" +
            "      ,[monthly_income]\n" +
            "      ,[form_of_employment]\n" +
            "      ,[marital_status]\n" +
            "      ,[monthly_costs_of_living]\n" +
            "      ,[other_debts_monthly_payments]\n" +
            "      ,[employer_name]\n" +
            "      ,[employer_contact_data]\n" +
            "      ,[loan_amount]\n" +
            "      ,[own_contribution]\n" +
            "      ,[credit_purpose]\n" +
            "      ,[interest_rate]\n" +
            "      ,[loan_collateral]\n" +
            "      ,[commission]\n" +
            "      ,[credit_type_id]\n" +
            "      ,[currency].short_name\n" +
            "  FROM [credits].[dbo].[loan_application]\n" +
            "  JOIN [credits].[dbo].[credit]\n" +
            "  ON [credit].[loan_application_id] = [loan_application].[loan_application_id]\n" +
            "  JOIN [credits].[dbo].[credit_terms]\n" +
            "  ON [credit].[credit_terms_id] = [credits].[dbo].[credit_terms].[credit_terms_id]\n" +
            "  JOIN [account]\n" +
            "  ON [credit].[account_id] = [account].[account_id]\n" +
            "  JOIN [currency]\n" +
            "  ON [account].[currency_id] = [currency].[currency_id]\n  " +
            "  WHERE [credits].[dbo].[loan_application].[acceptance_timestamp] IS NULL";
}
