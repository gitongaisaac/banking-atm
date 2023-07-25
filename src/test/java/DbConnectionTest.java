import com.sun.tools.jconsole.JConsoleContext;

import java.sql.*;

public class DbConnectionTest {

    public static void dbConnection() {
        String url = "jdbc:mysql://localhost:3306/atm_banking";
        String username = "isaac";
        String password = "D3F 15@@c 53rv3r";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String executeQuery =
                    "SELECT " +
                            "last_name, " +
                            "first_name, " +
                            "state " +
                    "FROM Person_info " +
                    "WHERE state != 'California'";

            ResultSet resultSet = statement.executeQuery(executeQuery);

            String last_name, first_name, state;
            int x = 0;

            while (resultSet.next()) {
                last_name = resultSet.getString(1);
                first_name = resultSet.getString(2);
                state = resultSet.getString(3);

                x = 5;

                System.out.println(last_name + "   " + first_name + "   " + state + "\n");
            }

            System.out.println(x);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }



    }

    public static void main(String[] args) {
        dbConnection();
    }

}
