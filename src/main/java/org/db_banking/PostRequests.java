package org.db_banking;

public class PostRequests extends DbPostConnections {
    public void postAccountBalance(int account_no, double amt) {
        String query = """
                UPDATE Account_info
                SET total_balance = total_balance + ?
                WHERE account_no = ?
                """;

        PostRequests postRequests = new PostRequests();
        postRequests.dbIntegerConnection(query, account_no, amt);
    }
}
