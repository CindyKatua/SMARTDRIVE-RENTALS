import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/smartdrive_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "smartdrive";
    private static final String PASSWORD = "SmartDrive123!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
