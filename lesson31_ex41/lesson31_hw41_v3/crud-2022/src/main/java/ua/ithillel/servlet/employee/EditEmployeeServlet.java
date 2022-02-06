package ua.ithillel.servlet.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            Employee employee = ems.get(id);
            if (Objects.nonNull(employee)) {
                req.setAttribute("employee", employee);
                getServletContext().getRequestDispatcher("/view/employee/editemployee.jsp").forward(req, resp);
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
        EmployeeManageService ems = new EmployeeManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            int salary = Integer.parseInt(req.getParameter("salary"));
            long departmentId = Long.parseLong(req.getParameter("departmentId"));
            String chiefIdParam = req.getParameter("chiefId");
            Long chiefId = null;
            if (Objects.nonNull(chiefIdParam) && chiefIdParam.length() > 0) {
                chiefId = Long.parseLong(chiefIdParam);
            }
            Employee employee = new Employee(id, departmentId, chiefId, name, salary);
            ems.update(employee);
            resp.sendRedirect(req.getContextPath() + "/find-all-employees");
        } catch (BusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
