package ua.ithillel.servlet.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.service.DepartmentManageService;

import java.io.IOException;

@WebServlet("/delete-department")
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        DepartmentManageService dms = new DepartmentManageService();
        try {
            dms.delete(id);
            resp.sendRedirect(req.getContextPath() + "/find-all-departments");
        } catch (BusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
