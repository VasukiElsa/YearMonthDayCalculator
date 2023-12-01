import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calculate")
public class PerformingYearMonthDayCalculations extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String BirthDate = req.getParameter("DOB");
        String CurrentDate = req.getParameter("CDATE");
        


        
        FunctionsForYearMonthDayCalculations obj = new FunctionsForYearMonthDayCalculations();
        String result = obj.calculateAge(BirthDate, CurrentDate);
        
        HttpSession session = req.getSession();
        String email = (String)session.getAttribute("email");
        
        
        
        
        StoringUsersAgeResultInDb db = new StoringUsersAgeResultInDb();
        db.storeInDatabase(email,BirthDate, CurrentDate, result);
        
 
        
		
        res.getWriter().println(result); // response to the user
    }


}

