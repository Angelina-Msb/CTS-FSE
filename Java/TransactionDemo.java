import java.sql.*;

public class TransactionDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void transfer(int fromAccount, int toAccount, double amount) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            PreparedStatement debit = con.prepareStatement(debitQuery);
            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            PreparedStatement credit = con.prepareStatement(creditQuery);
            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);

            int debitRows = debit.executeUpdate();
            int creditRows = credit.executeUpdate();

            if (debitRows > 0 && creditRows > 0) {
                con.commit();
                System.out.println("Transaction Successful");
            } else {
                con.rollback();
                System.out.println("Transaction Failed");
            }

            debit.close();
            credit.close();
            con.close();

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        transfer(1, 2, 1000);
    }
}