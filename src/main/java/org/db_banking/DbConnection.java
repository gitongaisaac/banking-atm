package org.db_banking;

// JDBC Packages import
import  java.sql.*;

/* MySQL Database connection class. Has method dbConnection() */
public class DbConnection {

    /* This method takes in an SQL query parameter and returns the queried as result.
     * Produces one row and one column. */
    public String dbConnection(String query) {

        /* Connection query result initialization */
        String result = null;

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
                result = resultSet.getString(1);

//                System.out.println(result);
            }


            /* Close database connection */
            connection.close();
            statement.close();
            resultSet.close();

            /* Catch any errors during the connection */
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Returns the queried result */
        return result;

    }

//    public static void main(String[] args) {
//        String query = "SELECT last_name FROM Person_info WHERE SSN = '096-43-2509'";
//
//        /* Class object */
//        DbConnection dbConnection = new DbConnection();
//        String result = dbConnection.dbConnection(query);
//
//
//        System.out.println(result);
//    }
}
