package db_banking;

// JDBC Packages import
import  java.sql.*;

public class DbConnection {

    public static void dbConnection() {
        /* Java Database Connection Driver Registration */
        final String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        /* Connection Instances */
        final String url = "jdbc:mysql://127.0.0.1:3306/atm_banking";
        final String username = "isaac";
        final String password = "D3F 15@@c 53rv3r";

        try {
            Class.forName(jdbcDriver);

            /* Connection to Database */
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT SSN, last_name, first_name, email_address, state FROM Person_info");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "    **********    " + resultSet.getString(2) +
                        "    *********     " + resultSet.getString(3) + "    *********    " + resultSet.getString(4) +
                        "    *********     " + resultSet.getString(5));
            }

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void login() {}

    public static void main(String[] args) {
        dbConnection();
    }
}
