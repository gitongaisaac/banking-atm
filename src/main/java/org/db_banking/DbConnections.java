package org.db_banking;

import java.sql.*;

/* Connect with database. Each method has a different return type or different number of parameters or parameters have
* different data types. This helps in fetching different values e.g. amount which is a double, account number
* which is an integer... etc. Also at the bottom, the methods are for updating certain values in the database.
* The methods have no return types because they do not return any values.
*
* These class is abstract and cannot be inherited by classes outside this package. This is to increase data privacy. */
abstract class DbConnections {
    /* JDBC MySQL Driver*/
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    /* Connection Requirements */
    /* Database connection URL */
    private final String url = "jdbc:mysql://127.0.0.1:3306/atm_banking";

    /* Database connection username */
    private final String username = "isaac";

    /* Database connection password */
    private final String password = "D3F 15@@c 53rv3r";

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    /* In this method the condition is an integer and returns a data type of integer. This method will fetch queries
    * where the value being returned is an integer e.g. account number and the condition is an integer e.g. fetching an
    * account number when the pin number is known: In this case the account number is an integer(return type) and the
    * pin number is an integer(condition). Also accepts a query and a label, the query is an sql query and the label is
    * the column name */
    protected int dbIntConnection(String query, int condition, String label) {
    int result = 0;

    try {
        Class.forName(this.jdbcDriver);

        connection = DriverManager.getConnection(this.url, this.username, this.password);

        statement = connection.prepareStatement(query);
        statement.setInt(1, condition);

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            result = resultSet.getInt(label);
        }

        connection.close();
        statement.close();
        resultSet.close();

    } catch (Exception e) {
//        throw new RuntimeException(e);
        System.out.println(e);
    }

        return result;
    }

    /* Same as the first method, but in this case the return type is a double and the condition is a double. */
    protected double dbDoubleConnection(String query, double condition, String label) {
        double result = 0;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setDouble(1, condition);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getDouble(label);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    /* Return type: String.  Condition: String. e.g. getting the ssn given the state */
    protected String dbStringConnection(String query, String condition, String label) {
        String result = null;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, condition);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getString(label);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e ) {
            System.out.println(e);
        }

        return result;
    }

    /* Return type: String. Condition: integer.  */
    protected String dbStringConnection(String query, int condition, String label) {
        String result = null;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setInt(1, condition);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = String.valueOf(resultSet.getString(label));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e ) {
            System.out.println(e);
        }

        return result;
    }

    protected String dbDateTimeConnection(String query, String condition, String label) {
        String result = null;

        try {
            Class.forName(this.jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, condition);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = String.valueOf(resultSet.getString(label));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e ) {
            System.out.println(e);
        }

        return result;
    }

/*
 * UPDATE CONNECTIONS
 * This are methods that update the database. They do not need a return type, just conditions. One condition sets a new
 * value for a specific account number
*/

    /* This method will update the database where one condition is an integer and the other is a double. e.g. setting
    * a new account balance for a certain account number */
    public void postDbDoubleConnection(String query, int condition1, double condition2) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setDouble(1, condition2);
            statement.setInt(2, condition1);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* Condition one: integer, Condition two: String. e.g. setting a new pin for a specific ssn*/
    public void postDbStringConnection(String query, int condition1, String condition2) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, condition2);
            statement.setInt(2, condition1);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* This method is for adding a new transaction on the transaction table. It takes parameters for all the columns */
    protected void postTransactionInfo(String query, String ref, String trans_name, double trans_amt, double trans_bal,
                                       Date date, Time time, int trans_party, int account_no, String ssn) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, ref);
            statement.setString(2, trans_name);
            statement.setDouble(3, trans_amt);
            statement.setDouble(4, trans_bal);
            statement.setDate(5, date);
            statement.setTime(6, time);
            statement.setInt(7, trans_party);
            statement.setInt(8, account_no);
            statement.setString(9, ssn);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
