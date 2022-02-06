package ua.ithillel.servlet.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        EmployeeManageService ems = new EmployeeManageService();
        try {
            ems.delete(id);
            resp.sendRedirect(req.getContextPath() + "/find-all-employees");
        } catch (BusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
