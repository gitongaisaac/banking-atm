package org.db_banking;

/* Public class DbAccessor. To access the DbConnection abstract class. Since the DbConnection class is not accessible
 * out of this package, this class inherits from the DbConnection class and makes the functionalities of the class
 * public to other packages */
public class DbAccessor extends DbConnection {

    /* *********************************************************************************************************** */
    /* dbIntegerConnection Accessor */
    public int dbIntegerAccessor(String query) {
        /* Class object */
        DbAccessor dbAccessor = new DbAccessor();
        return  dbAccessor.dbIntegerConnection(query);
    }

    /* *********************************************************************************************************** */
    /* dbDoubleConnection Accessor */
    public double dbDoubleAccessor(String query) {
        DbAccessor dbAccessor = new DbAccessor();
        return dbAccessor.dbDoubleConnection(query);
    }

    /* *********************************************************************************************************** */
    /* dbStringConnection Accessor */
    public String dbStringAccessor(String query) {
        DbAccessor dbAccessor = new DbAccessor();
        return dbAccessor.dbStringConnection(query);
    }

    /* *********************************************************************************************************** */
    /* dbDateConnection Accessor */
    public String dbDateAccessor(String query) {
        DbAccessor dbAccessor = new DbAccessor();
        return dbAccessor.dbDateConnection(query);
    }

    /* *********************************************************************************************************** */
    /* dbTimeConnection Accessor */
    public String dbTimeAccessor(String query) {
        DbAccessor dbAccessor = new DbAccessor();
        return dbAccessor.dbTimeConnection(query);
    }

    /* *********************************************************************************************************** */
//    public static void main(String[] args) {
//        String query1 = "SELECT account_no FROM Account_info WHERE account_pin = 1234";
//        String query2 = "SELECT total_balance FROM Account_info WHERE account_pin = 1234";
//        String query3 = "SELECT last_name FROM Person_info WHERE SSN = '096-43-2509'";
//        String query4 = "SELECT date_of_birth FROM Person_info WHERE SSN = '096-43-2509'";
//        String query5 = "SELECT trans_time FROM Trans_info WHERE REF = '08OPQ7R7'";
//
//        DbAccessor dbAccessor = new DbAccessor();
//
//        int result1 = dbAccessor.dbIntegerAccessor(query1);
//        double result2 = dbAccessor.dbDoubleAccessor(query2);
//        String result3 = dbAccessor.dbStringAccessor(query3);
//        String result4 = dbAccessor.dbDateAccessor(query4);
//        String result5 = dbAccessor.dbTimeAccessor(query5);
//
//        System.out.println(result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5);
//    }
}
