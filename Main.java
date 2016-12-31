import java.sql.Connection;
import java.sql.SQLException;
import java.util.Timer;

/**
 * Created by alsayed on 12/31/16.
 */
public class Main {
    public static void main(String []a) throws SQLException{

        long startTime = System.nanoTime();
        System.out.println(FriendDriver.truncateTable());
        long estimatedTime = System.nanoTime() - startTime;
        System.out.print(estimatedTime/1000000000.0);
    }
}
