
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class DataBaseAccess {
	public static void main(String[] args){
		Search search;
		//InputStream ioStream = new InputStream;
		String test = "";
		boolean invalidChoice = true;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Data Base Image search!");
		System.out.println("Would you like to search or insert an image?(type 'insert' or 'search')");
		boolean wrongInput = true;
		String strCommand = "";
		while(wrongInput){
			String temp = s.nextLine();
			if(temp.equalsIgnoreCase("search")){
				strCommand = "search";
				wrongInput = false;
			}
			else if(temp.equalsIgnoreCase("insert")){
				System.out.println("youmadeit");
				strCommand = "insert";
				wrongInput = false;
			}
			else
				System.out.println("Please enter either 'search' or 'insert'");
		}
		if(strCommand.equals("search")){
		System.out.println("Please select the manner in which you would like to search:");
		System.out.println("ex: Creator, Keyword, or Photo title");
		
		while(invalidChoice){
			test = s.nextLine();

			if(test.equalsIgnoreCase("creator")){
				System.out.println("you chose creator");
				System.out.println("Enter the creator name to search for:");

				//connect to database to verify that's working.
				String searchVariable = s.nextLine();

					search = new Search("creator", searchVariable);
					search.creatorSearch();
					
					ResultSet rs = search.getResults();
					ResultSetMetaData rsMetaData;
					try {
						rsMetaData = rs.getMetaData();
						
						System.out.println("Here is the data contained in the " + searchVariable + " record:");

						while(rs.next()){
						for(int i = 1; i <= rsMetaData.getColumnCount(); i++)	
						System.out.println(rs.getString(i));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				invalidChoice = false;
			}
			else if(test.equalsIgnoreCase("keyword")){
				System.out.println("you chose keywords!");
				System.out.println("Enter the keyword to search for:");
				String searchVariable = s.nextLine();

				search = new Search("keyword", searchVariable);
				System.out.println("Enter the keyword to search for:");
				search.keywordSearch();
				
				ResultSet rs = search.getResults();
				ResultSetMetaData rsMetaData;
				try {
					rsMetaData = rs.getMetaData();
					while(rs.next()){
						System.out.println("Here is the data contained in the " + searchVariable + " record:");
					for(int i = 1; i <= rsMetaData.getColumnCount(); i++)	
					System.out.println(rs.getString(i));
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				invalidChoice = false;
			}
			else if(test.equalsIgnoreCase("photo title")){
				System.out.println("you chose photo title!");
				System.out.println("Enter the photo title to search for:");
				String searchVariable = s.nextLine();
				search = new Search("keyword",searchVariable);
				System.out.println("Enter the keyword to search for:");
				search.photoTitleSearch();
				
				ResultSet rs = search.getResults();
				ResultSetMetaData rsMetaData;
				try {
					rsMetaData = rs.getMetaData();
					while(rs.next()){
						System.out.println("Here is the data contained in the " + searchVariable + " record:");
					for(int i = 1; i <= rsMetaData.getColumnCount(); i++)	
						System.out.println(rs.getString(i));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				invalidChoice = false;
			}
			else{
				System.out.println("Please make a valid selection of 'creator', 'keyword', or 'photo title'");
			}
		}
	}
		else if(strCommand.equals("insert")){
			String title, creatorName, creatorHomepage, creatorEmail, copyright, mimetype, location,
			 keyword;
			int width, height;
			System.out.println("Please enter the data as prompted.");
			
			System.out.print("Title:");
			title = s.nextLine();
			System.out.print("\n");
			System.out.println("Creator Name:");
			creatorName = s.nextLine();
			
			System.out.println("Creator Email:");
			creatorEmail = s.nextLine();
			
			System.out.println("Creator Homepage:");
			creatorHomepage = s.nextLine();

			System.out.println("Copyright:");
			copyright = s.nextLine();

			System.out.println("Mimetype:");
			mimetype = s.nextLine();

			System.out.println("Location:");
			location = s.nextLine();

			System.out.println("Width:");
			width = Integer.parseInt(s.nextLine());

			System.out.println("Height:");
			height = Integer.parseInt(s.nextLine());

			System.out.println("Keyword:");
			keyword = s.nextLine();

			Insert insert = new Insert();
			insert.insertNewRecord(title, creatorName, creatorEmail, creatorHomepage, copyright, mimetype, location,
					width, height, keyword);
	}
	
		
	}
}
