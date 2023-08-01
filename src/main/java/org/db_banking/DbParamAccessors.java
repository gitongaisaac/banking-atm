package org.db_banking;

public class DbParamAccessors extends DbParamConnections {

    public int dbIntAccessor(String query, int condition, String label) {
        DbParamAccessors accessor = new DbParamAccessors();
        return accessor.dbIntConnection(query, condition, label);
    }

    public double dbDoubleAccessor(String query, double condition, String label) {
        DbParamAccessors accessor = new DbParamAccessors();
        return accessor.dbDoubleConnection(query, condition, label);
    }

    public String dbStringAccessor(String query, String condition, String label) {
        DbParamAccessors accessor = new DbParamAccessors();
        return accessor.dbStringConnection(query, condition, label);
    }

    public String dbDateAccessor(String query, String condition, String label) {
        DbParamAccessors accessor = new DbParamAccessors();
        return accessor.dbDateConnection(query, condition, label);
    }

    public String dbTimeAccessor(String query, String condition, String label) {
        DbParamAccessors accessor = new DbParamAccessors();
        return accessor.dbTimeConnection(query, condition, label);
    }

//    public static void main(String[] args) {
//        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
//        String label = "account_pin";
//        int condition = 12345678;
//
//        DbParamAccessors accessor = new DbParamAccessors();
//        int result = accessor.dbIntAccessor(query, condition, label);
//
//        System.out.println(result);
//    }

}
