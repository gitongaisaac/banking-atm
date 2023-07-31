package org.db_banking;

// JDBC Packages import
import  java.sql.*;

/* MySQL Database connection abstract class. Has method dbConnection() */
abstract class DbNonParamConnections {

    /* JDBC MySQL Driver*/
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    /* Connection Requirements */
    /* Database connection URL */
    private final String url = "jdbc:mysql://127.0.0.1:3306/atm_banking";

    /* Database connection username */
    private final String username = "isaac";

    /* Database connection password */
    private final String password = "D3F 15@@c 53rv3r";

    /* *********************************************************************************************************** */
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    /* *********************************************************************************************************** */

    /* This method takes in an SQL query parameter and returns the STRING queried as result. Only returns Strings
     * Produces one row and one column. */
    protected String dbStringConnection(String query) {
        /* Connection query result initialization */
        String result = null;

        try {
            /* Java Database Connection Driver Registration */
            Class.forName(this.jdbcDriver);

            /* Connection to Database */
            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getString(1);
            }

            /* Close database connection */
            connection.close();
            statement.close();
            resultSet.close();

            /* Catch any errors during the connection */
        } catch (Exception e) {
            System.out.println("Sorry! An error occurred");
        }

        /* Returns the queried result */
        return result;

    }

    /* *********************************************************************************************************** */
    /* Integer return type connection */
    protected int dbIntegerConnection(String query) {
        int result = 0;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Sorry! An error occurred");
        }

        return result;
    }

    /* *********************************************************************************************************** */
    /* Double return type connection */
    protected double dbDoubleConnection(String query) {
        double result = 0;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getDouble(1);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Sorry! An error occurred");
        }

        return result;
    }

    /* *********************************************************************************************************** */
    /* Date String return type connection */
    protected String dbDateConnection(String query) {
        String result = null;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = String.valueOf(resultSet.getDate(1));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Sorry! An error occurred");
        }

        return result;

    }

    /* *********************************************************************************************************** */
    /* Time String return type connection */
    protected String dbTimeConnection(String query) {
        String result = null;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = String.valueOf(resultSet.getTime(1));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Sorry! An error occurred");
        }

        return result;
    }

}