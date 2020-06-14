package credits.SQL;


import credits.SQL.Model.*;
import sun.awt.image.ImageWatched;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class SqlDataProvider {
    static public Collection<Currency> getAllCurrencies() {
        Collection<Currency> currencies = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllCurrencies)) {
            while (resultSet.next()) {
                int currencyId = resultSet.getInt(1);
                String currencyShortName = resultSet.getString(2);
                String currencyName = resultSet.getString(3);
                Currency currency = new Currency(currencyId, currencyShortName, currencyName);
                currencies.add(currency);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return currencies;
    }

    static public Collection<CreditType> getAllCreditTypes() {
        Collection<CreditType> creditTypes = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllCreditTypes)) {
            while (resultSet.next()) {
                int creditTypeID = resultSet.getInt(1);
                String creditTypeName = resultSet.getString(2);
                String creditTypeDescription = resultSet.getString(3);
                CreditType creditType = new CreditType(creditTypeID, creditTypeName, creditTypeDescription);
                creditTypes.add(creditType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return creditTypes;
    }

    static public Collection<User> getAllUsers() {
        Collection<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllUsers)) {
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int idId = resultSet.getInt(2);
                String firstNames = resultSet.getString(3);
                String lastNames = resultSet.getString(4);
                String pesel = resultSet.getString(5);
                Date dateOfBirth = resultSet.getDate(6);
                int registredAddresId = resultSet.getInt(7);
                int contactAddresId = resultSet.getInt(8);
                String email = resultSet.getString(9);
                String phoneNumber = resultSet.getString(10);

                User user = new User(userId, idId, firstNames, lastNames, pesel, dateOfBirth, registredAddresId, contactAddresId, email, phoneNumber);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    static public boolean makeLoanApplication(LoanApplicationForm form) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.makeLoanApplication);) {
            statement.setInt(1, form.getUserId());
            statement.setDouble(2, form.getMonthlyIncome());
            statement.setString(3, form.getFormOfEmployment());
            statement.setString(4, form.getMartialStatus());
            statement.setDouble(5, form.getMonthlyCostOfLiving());
            statement.setDouble(6, form.getOtherDebtsMonthly());
            statement.setString(7, form.getEmployerName());
            statement.setString(8, form.getEmployerContactData());
            statement.setDouble(9, form.getLoanAmmount());
            statement.setDouble(10, form.getOwnContribution());
            statement.setString(11, form.getCreditPurpose());
            statement.setString(12, form.getInterestRate());
            statement.setString(13, form.getLoanCollateral());
            statement.setDouble(14, form.getCommision());
            statement.setInt(15, form.getCreditTypeId());
            statement.setInt(16, form.getCurrencyId());
            statement.setInt(17, form.getNumberOfRepayments());

            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public Collection<LoanApplication> getAcceptedLoans() {

        Collection<LoanApplication> loanApplications = new LinkedList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAcceptedLoanApplications)) {
            while (resultSet.next()) {
                int loanApplicationId = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                double monthlyIncome = resultSet.getDouble(3);
                String formOfEmployment = resultSet.getString(4);
                String martialStatus = resultSet.getString(5);
                double costsOfLiving = resultSet.getInt(6);
                double otherDebts = resultSet.getInt(7);
                String employerName = resultSet.getString(8);
                String employerContact = resultSet.getString(9);
                double loanAmmount = resultSet.getDouble(10);
                double ownContribution = resultSet.getDouble(11);
                String creditPurpose = resultSet.getString(12);
                double interestRate = resultSet.getDouble(13);
                String loanCollateral = resultSet.getString(14);
                double commission = resultSet.getDouble(15);
                int creditTypeId = resultSet.getInt(16);
                String currency = resultSet.getString(17);

                LoanApplication loanApplication = new LoanApplication(loanApplicationId, userId, monthlyIncome, formOfEmployment,
                        martialStatus, costsOfLiving, otherDebts, employerName, employerContact, loanAmmount, ownContribution, creditPurpose
                        , interestRate, loanCollateral, commission, creditTypeId, currency);
                loanApplications.add(loanApplication);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loanApplications;
    }

    static public boolean acceptLoanApplication(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.acceptLoanApplication);) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public boolean rejectLoanApplication(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.rejectLoanApplication);) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public boolean createRepaymentSchedule(Integer creditId) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.createRepaymentSchedule);) {
            statement.setInt(1, creditId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public boolean payRepayment(Integer creditId, double amount) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.payRepayment);) {
            statement.setInt(1, creditId);
            statement.setDouble(2, amount);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public double getCreditAmountLeft(Integer creditId) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.getCreditLeft);) {
            statement.registerOutParameter(1, Types.DECIMAL);
            statement.setInt(2, creditId);
            statement.execute();
            return statement.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1.0;
        }
    }

    static public Collection<Credit> getAllCredits() {
        Collection<Credit> credits = new LinkedList<Credit>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllCredits)) {
            while (resultSet.next()) {
                int creditId = resultSet.getInt(1);
                int accountId = resultSet.getInt(2);
                int creditTypeId = resultSet.getInt(3);
                int creditTermsId = resultSet.getInt(4);
                int loanApplicationId = resultSet.getInt(5);

                Credit credit = new Credit(creditId, accountId, creditTypeId, creditTermsId, loanApplicationId);

                credits.add(credit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return credits;
    }

    static public Collection<DocumentType> getAllDocumentTypes() {
        Collection<DocumentType> documentTypes = new LinkedList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Statements.getAllDocumentTypes)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                DocumentType documentType = new DocumentType(id, name);
                documentTypes.add(documentType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documentTypes;
    }

    public static Collection<Credit> getUserCredits(Integer id) {
        Collection<Credit> credits = new LinkedList<Credit>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(Statements.getUserCredits)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                int creditId = resultSet.getInt(1);
                int accountId = resultSet.getInt(2);
                int creditTypeId = resultSet.getInt(3);
                int creditTermsId = resultSet.getInt(4);
                int loanApplicationId = resultSet.getInt(5);

                Credit credit = new Credit(creditId, accountId, creditTypeId, creditTermsId, loanApplicationId);

                credits.add(credit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return credits;
    }

    public static Collection<Repayment> getRepayments(Integer creditId) {
        Collection<Repayment> repayments = new LinkedList<Repayment>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(Statements.getCreditRepayments)) {

            statement.setInt(1, creditId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                int repaymentId = resultSet.getInt(1);
                double amount = resultSet.getInt(3);
                Date date = resultSet.getDate(4);

                Repayment repayment = new Repayment(repaymentId, creditId, amount, date);
                repayments.add(repayment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return repayments;
    }

    public static Collection<RepaymentScheduleElement> getRepaymentSchedule(Integer creditId) {
        Collection<RepaymentScheduleElement> repayments = new LinkedList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(Statements.getCreditScheduledRepayment)) {

            statement.setInt(1, creditId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                int repaymentId = resultSet.getInt(1);
                double amount = resultSet.getInt(3);
                Date date = resultSet.getDate(4);

                RepaymentScheduleElement repayment = new RepaymentScheduleElement(repaymentId, creditId, amount, date);
                repayments.add(repayment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return repayments;
    }

    public static int addAddress(NewAddress newAddress) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.insertAdress)) {

            statement.setString(1, newAddress.getTown());
            statement.setString(2, newAddress.getStreet());
            statement.setString(3, newAddress.getStreetNumber());

            if (newAddress.getFlatNumber() != null) {
                statement.setString(4, newAddress.getFlatNumber());
            } else {
                statement.setNull(4, Types.VARCHAR);
            }

            statement.setString(5, newAddress.getPostalCode());

            statement.registerOutParameter(6, Types.INTEGER);

            statement.execute();
            return statement.getInt(6);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }


    public static int addDocument(NewDocument newDocument) {
        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.insertDocument)) {

            statement.setInt(1, newDocument.getDocumentTypeId());
            statement.setString(2, newDocument.getNumber());
            statement.setDate(3, new java.sql.Date(newDocument.getValidityDate().getTime()));

            statement.registerOutParameter(4, Types.INTEGER);

            statement.execute();
            return statement.getInt(4);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static boolean addUser(NewUser newUser, NewAddress registredAddress, NewAddress conctactAddress, NewDocument document) {
        int registeredAddressId = addAddress(registredAddress);
        System.out.println("address dodany");
        int contactAddressId = -1;
        if (registeredAddressId == contactAddressId) {
            contactAddressId = registeredAddressId;
        } else {
            contactAddressId = addAddress(conctactAddress);
        }
        int documentId = addDocument(document);
        System.out.println("dokument dodany");


        try (Connection connection = ConnectionManager.getConnection();
             CallableStatement statement = connection.prepareCall(Statements.addUser)) {

            statement.setInt(1, documentId);
            statement.setString(2, newUser.getFirstName());
            statement.setString(3, newUser.getLastName());
            statement.setString(4, newUser.getPesel());
            statement.setDate(5, new java.sql.Date(newUser.getDateOfBirth().getTime()));
            statement.setInt(6, registeredAddressId);
            statement.setInt(7, contactAddressId);
            statement.setString(8, newUser.getEmail());
            statement.setLong(9, newUser.getPhoneNumber());

            statement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
