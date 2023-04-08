import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String arg[]) throws SQLException {
       Connection connection = DatabaseConnection.getConnection();

//found on the web and used as reference


        connection.close();

            // MySQL is database
            // mydatabase is name of database
            // my-secret-pw is password of database

            Statement statement;
            statement = connection.createStatement();

//            ResultSet resultSet;
//            resultSet = statement.executeQuery("select * from designation");
//            int code;
//            String title;
//            while (resultSet.next()) {
//                code = resultSet.getInt("Val3");
//                title = resultSet.getString("Val1").trim();
//                System.out.println("Val1 : " + code
//                        + " Val2 : " + title);
//            }
//            resultSet.close();
//            statement.close();


    } // function ends
} // class ends
