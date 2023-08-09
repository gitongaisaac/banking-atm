package org.db_banking;

import java.sql.*;

abstract class DbFetchConnections {
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
}
