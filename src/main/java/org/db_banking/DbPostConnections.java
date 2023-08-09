package org.db_banking;

import java.sql.*;

abstract class DbPostConnections {
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

    public void dbIntegerConnection(String query, int condition, String label) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setInt(1, condition);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dbDoubleConnection(String query, double condition, String label) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setDouble(1, condition);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dbStringConnection(String query, String condition, String label) {
        try {
            Class.forName(jdbcDriver);

            connection = DriverManager.getConnection(this.url, this.username, this.password);

            statement = connection.prepareStatement(query);
            statement.setString(1, condition);

            statement.executeUpdate();

            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
