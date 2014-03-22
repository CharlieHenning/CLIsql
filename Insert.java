import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Insert {
	ResultSet results;
	java.sql.Connection conn;
	public Insert(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("nowI'm here");
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}

		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CHH7","root", "");
		} catch (SQLException e) {
			System.out.println("i'm here!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertNewRecord(String title, String creatorName, String creatorEmail, String creatorHomepage, String copyright, String mimetype, String location,
			int width, int height, String keyword){
				
		String qry = "INSERT INTO GALLERYCHH7(idphoto, title, creatorname, creatoremail, creatorhomepage, copyright, mimetype, location, width, height, keywords) "
				+ "VALUES (null, \"" + title + "\", \"" + creatorName + "\", \"" + creatorEmail + "\", \"" + creatorHomepage + "\", \"" + copyright + "\", \"" + 
				mimetype + "\", \"" + location + "\", " + width + ", "  + height + ",\"" + keyword + "\");";
		System.out.println(qry);
		java.sql.Statement newRecord;
		try {
			newRecord = conn.createStatement();
			newRecord.executeUpdate(qry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet getResults(){
		return results;
	}
	public void setResults(ResultSet rs){
		results = rs;
	}
}
