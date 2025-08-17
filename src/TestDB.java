import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                System.out.println("✅ Connected to Railway MySQL!");
            } else {
                System.out.println("❌ Connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}