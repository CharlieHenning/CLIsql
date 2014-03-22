import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
	Connection conn;
	ResultSet results;
	String searchVariable;
	
	public Search(String searchType, String searchVariable){
		this.searchVariable = searchVariable;
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
	
	public void creatorSearch(){

		String qry = "SELECT * from GALLERYCHH7 where creatorname like '%" + searchVariable + "%'";
	try {
		Statement searchCreator = conn.createStatement();
		ResultSet rs = searchCreator.executeQuery(qry);
		setResults(rs);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("statement executed");
		e.printStackTrace();
	}
}
	
public void keywordSearch(){
		String qry = "SELECT * from GALLERYCHH7 where keywords like '%" + searchVariable + "%'";
	try {
		Statement searchKeyword = conn.createStatement();
		ResultSet rs = searchKeyword.executeQuery(qry);
		setResults(rs);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("statement executed");
		e.printStackTrace();
	}
	}
public void photoTitleSearch(){
		String qry = "SELECT * from GALLERYCHH7 where title like '%" + searchVariable + "%'";
	try {
		Statement searchTitle = conn.createStatement();
		ResultSet rs = searchTitle.executeQuery(qry);
		setResults(rs);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public ResultSet getResults(){
		return results;
	}
	public void setResults(ResultSet theResults){
		results = theResults;
	}
}
