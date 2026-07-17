import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    // MySQL Username
    private static final String USER = "root";

    // MySQL Password
    // Change this according to your MySQL installation
    private static final String PASSWORD = "root";

    // Method to establish connection
    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

            return conn;

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            System.out.println(e.getMessage());

            return null;
        }
    }
}
