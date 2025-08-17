
import java.sql.*;

public class DBConnection {
	static Connection con = null;
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://caboose.proxy.rlwy.net:47939/railway?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "root";
		String password = "dlqclmZELWUKHgqDAIPdTFyMBsdcKxkI";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException | SQLException ae) {
                }
		return con;
	}
}