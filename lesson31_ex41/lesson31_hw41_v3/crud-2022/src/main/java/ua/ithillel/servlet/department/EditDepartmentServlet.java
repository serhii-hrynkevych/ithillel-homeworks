package ua.ithillel.servlet.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/edit-department")
public class EditDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentManageService dms = new DepartmentManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            Department department = dms.get(id);
            if (Objects.nonNull(department)) {
                req.setAttribute("department", department);
                getServletContext().getRequestDispatcher("/view/department/editdepartment.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/view/notfound.jsp").forward(req, resp);
            }
        } catch (BusinessException | NumberFormatException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentManageService dms = new DepartmentManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            Department department = new Department(id, name);
            dms.update(department);
            resp.sendRedirect(req.getContextPath() + "/find-all-departments");
        } catch (BusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
