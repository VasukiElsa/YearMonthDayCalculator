
import java.sql.*;
public class StoringUsersAgeResultInDb {

			public void storeInDatabase(String email,String BirthDate, String CurrentDate, String result){
		        String url = "jdbc:mysql://localhost:3306/YearMonthDateCalculator";
		        String uname = "vasu";
		        String password = "23";
		        String query = "UPDATE User SET DOB=?,currentDate=?,calculatedAge=? WHERE email=?";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(url, uname, password);
		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, BirthDate);
		            ps.setString(2, CurrentDate);
		            ps.setString(3, result);
		            ps.setString(4, email);
		            System.out.println(email);

		            ps.executeUpdate();
		            System.out.println("Rows Executed Successfully");
		            ps.close();
		            con.close();
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		          
		        }
		    
			
		
	

}
}

