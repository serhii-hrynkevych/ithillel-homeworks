package hrynkevych.serhii;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello2")
public class HelloTwoParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            String name = req.getParameter("name");
            String age = req.getParameter("age");
            if (name != null && age != null) {
                writer.println("<h1>Hello world!. I am " + name + ". I am " + age + " years old.</h1>");
            } else if (name != null) {
                writer.println("<h1>Hello world!. I am " + name + ".</h1>");
            } else {
                writer.println("<h1>Hello world!</h1>");
            }
        }
    }
}
