/**
 * Created by alsayed on 12/31/16.
 */
import java.sql.*;

public class FriendDriver {

    public static boolean truncateTable() throws SQLException{
        String sql = "TRUNCATE FRIENDS";
        // Execute deletion

        // creating connection: this form of try is used to close resources after execution
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){

            int affected = statement.executeUpdate();
            if(affected == 0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static boolean createFriends(int id1, int id2){

    }

    public static boolean populate1000rows(){

        for

        return false;
    }

}
