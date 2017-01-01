package MySQL; /**
 * Created by alsayed on 12/31/16.
 */
import java.sql.*;
public class PersonManager {

    public static boolean createPerson(String name) throws SQLException{
        String sql = "INSERT INTO PERSONS VALUES (?, ?)";

        // creating connection: this form of try is used to close resources after execution
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){

            statement.setString(1, null);
            statement.setString(2, name);

            int affected = statement.executeUpdate();

            if(affected == 1){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static Person getPersonById(int id) throws SQLException{

        // sql query
        String sql = "SELECT * FROM PERSONS WHERE PERSON_ID = ?" ;


        // creating connection: this form of try is used to close resources after execution
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,  id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                // we already have the id
                String name = rs.getString(2);

                Person person = new Person(id, name);

                return person;

            }
            else {
                return null;
            }
        }
    }

}
