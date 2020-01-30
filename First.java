import java.sql.*;

public class First {
	static Statement query() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Travel","root","8101996@Yogesh");
			Statement stmt = con.createStatement();
			return stmt;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
