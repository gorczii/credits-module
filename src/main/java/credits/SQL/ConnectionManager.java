package credits.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

//    private static final String connectionUrl = "jdbc:sqlserver://MACIEK-KOMPUTER;databaseName=credits;integratedSecurity=true";
    private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=credits;integratedSecurity=true;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }
}
