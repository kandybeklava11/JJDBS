package Config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String url = "jdbc:postgresql://localhost:5432/DATABASEFOREXEMS";
    private static final String username = "postgres";
    private static final String password = "1234";

    public static java.sql.Connection getConnection() {
        try {
            java.sql.Connection connection =
                    DriverManager.getConnection(url, username, password);
            System.out.println("Connected Succeed");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
