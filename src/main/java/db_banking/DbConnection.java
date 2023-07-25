package db_banking;

// JDBC Packages import
import  java.sql.*;

public class DbConnection {

    public void dbConnection(String query) {
        try {
            final String jdbcDriver = "com.mysql.cj.jdbc.Driver";

            /* Connection Requirements */
            final String url = "jdbc:mysql://127.0.0.1:3306/atm_banking";
            final String username = "isaac";
            final String password = "D3F 15@@c 53rv3r";

            /* Java Database Connection Driver Registration */
            Class.forName(jdbcDriver);

            /* Connection to Database */
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String result = resultSet.getString(1);

                System.out.println(result);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String query = "SELECT last_name FROM Person_info WHERE SSN = '096-43-2509' OR SSN = '105-27-2358'";

        DbConnection dbConnection = new DbConnection();
       dbConnection.dbConnection(query);
    }
}
