package hrynkevych.serhii;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello3")
public class HelloArrayParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            String[] parameters = req.getParameterValues("p");
            if (parameters != null) {
                writer.print("<h1>Hello world! Parameters: ");
                for (String parameter : parameters) {
                    writer.print(parameter + " ");
                }
                writer.println(".</h1>");
            } else {
                writer.println("<h1>Hello world!</h1>");
            }
        }
    }
}
