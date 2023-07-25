package org.db_banking;

/* Public class DbAccessor. To access the DbConnection abstract class. This helps by making this class public rather
 * than making the DbConnection class public */
public class DbAccessor extends DbConnection {

    public String dbAccessor(String query) {
        DbAccessor dbAccessor = new DbAccessor();

        return dbAccessor.dbStringConnection(query);
    }

//    public static void main(String[] args) {
//        String query = "SELECT last_name FROM Person_info WHERE SSN = '096-43-2509'";
//
//        DbAccessor dbAccessor = new DbAccessor();
//        String result = dbAccessor.dbAccessor(query);
//
//        System.out.println(result);
//    }
}
