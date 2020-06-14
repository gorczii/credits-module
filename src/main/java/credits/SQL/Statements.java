package credits.SQL;

public class Statements {
    public static final String makeLoanApplication = "{call dbo.makeLoanApplication(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String rejectLoanApplication = "{call dbo.rejectLoanApplication(?)}";
    public static final String acceptLoanApplication = "{call dbo.acceptLoanApplication(?)}";
    public static final String createRepaymentSchedule = "{call dbo.createRepaymentSchedule(?)}";
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
    public static String getAcceptedLoanApplications = "SELECT [loan_application].[loan_application_id]\n" +
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
            "  WHERE [credits].[dbo].[loan_application].[acceptance_timestamp] IS NOT NULL";

    public static String getAllCurrencies = "SELECT currency_id, name, short_name FROM [credits].[dbo].[currency]";
    public static String getAllCreditTypes = "SELECT credit_type_id, credit_type_name, credit_type_description FROM [credits].[dbo].[credit_type]";
    public static String getAllUsers = "SELECT [user_id]\n" +
            "      ,[identification_document_id]\n" +
            "      ,[first_names]\n" +
            "      ,[last_name]\n" +
            "      ,[pesel]\n" +
            "      ,[date_of_birth]\n" +
            "      ,[registered_address_id]\n" +
            "      ,[contact_address_id]\n" +
            "      ,[email]\n" +
            "      ,[phone_number]\n" +
            "  FROM [credits].[dbo].[user]";

    public static String payRepayment = "{call dbo.payRepayment(?, ?)}";
    public static String getCreditLeft = "{? = call dbo.getCreditAmountLeft(?)}";
    public static String getAllCredits = "SELECT [credit_id]\n" +
            "      ,[account_id]\n" +
            "      ,[credit_type_id]\n" +
            "      ,[credit_terms_id]\n" +
            "      ,[loan_application_id]\n" +
            "  FROM [credits].[dbo].[credit]";
    public static String getAllDocumentTypes = "SELECT [document_type_id]\n" +
            "      ,[type_name]\n" +
            "  FROM [credits].[dbo].[document_type]";

    public static String getUserCredits = "SELECT [credit_id]\n" +
            "      ,[credit].[account_id]\n" +
            "      ,[credit_type_id]\n" +
            "      ,[credit_terms_id]\n" +
            "      ,[loan_application_id]\n" +
            "  FROM [credits].[dbo].[credit]\n" +
            "  JOIN [credits].[dbo].[user_account] ON [credits].[dbo].[credit].[account_id] = [credits].[dbo].[user_account].[account_id] \n" +
            "  WHERE [credits].[dbo].[user_account].[user_id] = ?";
    public static String getCreditRepayments = "SELECT [repayment_id]\n" +
            "      ,[credit_id]\n" +
            "      ,[amount]\n" +
            "      ,[timestamp]\n" +
            "  FROM [credits].[dbo].[repayment]\n" +
            "  WHERE  [credits].[dbo].[repayment].[credit_id] = ?";

    public static String getCreditScheduledRepayment = "SELECT [repayment_schedule_id]\n" +
            "      ,[credit_id]\n" +
            "      ,[installment_amount]\n" +
            "      ,[repayment_date]\n" +
            "  FROM [credits].[dbo].[repayment_schedule]\n" +
            "  WHERE [credits].[dbo].[repayment_schedule].[credit_id] = ?";

    public static String insertDocument = "{call dbo.insertDocument(?, ?, ?, ?)}";

    public static String insertAdress = "{call dbo.insertAdress(?, ?, ?, ?, ?, ?)}";

    public static String addUser = "{call dbo.insertUser(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
}