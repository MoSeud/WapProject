import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class techsupport extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>TechSupport</title></head><body>");
        out.print("<form method='post'>" );
        out.print(" NAME: <input type='text' name='name'/><br/>");
        out.print(" EMAIL: <input type='email' name='mail'/><br/>");
        out.print(" PROBLEM: <input type='text' name='prob'/></br>");
        out.print("PROBLEM DESCRIPTION: <textarea type='text' name='name' rows='10' cols='30'></textarea><br/>");
//        out.print("<p>Please click the button</p>");
        out.print("<input type='submit' value='HELP'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc= this.getServletContext();
        String techSupEmail=sc.getInitParameter("support-email");
        String name=req.getParameter("name");
        String email= req.getParameter("mail");

        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Tech Support</title></head><body>");
        out.print("<p>Thank you!" +name + " for contacting us. We should reply from " +
                "us withing 24 hrs in your email address "+email + ". Let us know in our support email "+ techSupEmail+" if" +
                "you don't receive reply within 24 hrs. Please be sure to attach your reference support ticket id in your email.</p>");
        out.print("</body></html>");
    }
}
