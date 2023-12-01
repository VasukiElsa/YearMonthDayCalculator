import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

				
		

		
		String query = "SELECT * FROM User WHERE email=? AND password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/YearMonthDateCalculator","vasu","23");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("GettingInputsForYearMonthDayCalculation.html");
				
				
			}
			else {
				response.sendRedirect("RegistrationForm.html");
			}
			rs.close();
			ps.close();
			con.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
}
		
		
		
		
		
	}


