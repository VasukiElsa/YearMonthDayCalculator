import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/YearMonthDateCalculator","vasu","23");
			PreparedStatement ps = con.prepareStatement("INSERT INTO User(name,email,password) VALUES(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			
			int i = ps.executeUpdate();
			if(i > 0) {
				response.sendRedirect("LoginForm.html");
				ps.close();
				con.close();
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
