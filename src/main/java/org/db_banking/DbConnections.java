package org.db_banking;

import java.sql.*;

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

    /* *********************************************************************************************************** */
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

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
*/

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

    protected void trans(String query, String ref, String trans_name, double trans_amt, double trans_bal, String date,
                      String time, String trans_party, int account_no, String ssn) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, ref);
            statement.setString(2, trans_name);
            statement.setDouble(3, trans_amt);
            statement.setDouble(4, trans_bal);
            statement.setString(5, date);
            statement.setString(6, time);
            statement.setString(7, trans_party);
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
