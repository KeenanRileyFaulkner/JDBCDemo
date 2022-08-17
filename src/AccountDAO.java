import java.sql.*;

public class AccountDAO {
    public static final String url = "jdbc:postgresql://localhost/JDBCDemo";
    public static final String username = "postgres";
    public static final String pwd = "somedatabasepwd";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(url, username, pwd)) {
            Statement st = con.createStatement();
            int rowCount = st.executeUpdate("insert into account values(1, 'Faulkner','Keenan', 10000)");
            System.out.println(rowCount + " rows inserted");
//        int rowCount = st.executeUpdate("update account set balance=50000 where last_name='Faulkner'");
//        System.out.println(rowCount + " rows updated");
//        int rowCount = st.executeUpdate("delete from account where last_name='Faulkner'");
//        System.out.println(rowCount + " rows deleted");
            ResultSet rs = st.executeQuery("select * from account where last_name = 'Faulkner'");
            while(rs.next()) {
                System.out.println(rs.getString(3) + " " + rs.getString(2) + " has $"
                        + rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //connection automatically closed through try with resources block; finally block with close() not necessary.
    }
}
