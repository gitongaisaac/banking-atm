package org.db_banking;

public class DbAccessor {

    public String dbAccessor(String query) {
        DbConnection dbConnection = new DbConnection();
        String result = dbConnection.dbConnection(query);

        return result;
    }

    public static void main(String[] args) {
        String query = "SELECT last_name FROM Person_info WHERE SSN = '096-43-2509'";

        DbAccessor dbAccessor = new DbAccessor();
        String result = dbAccessor.dbAccessor(query);

        System.out.println(result);
    }
}
