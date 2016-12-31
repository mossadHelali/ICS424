/**
 * Created by alsayed on 12/31/16.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String USERNAME = "alsayed";
    private static final String PASSWORD = "alsayed";
    private static final String JDBC = "jdbc:mysql://localhost:3306/ICS424";

    public static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(JDBC,USERNAME, PASSWORD);
        return conn;
    }

}