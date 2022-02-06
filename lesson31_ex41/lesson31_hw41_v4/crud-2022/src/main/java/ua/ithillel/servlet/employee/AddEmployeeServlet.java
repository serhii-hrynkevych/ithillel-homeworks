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

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/employee/employees.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        try {
            String name = req.getParameter("name");
            int salary = Integer.parseInt(req.getParameter("salary"));
            long departmentId = Long.parseLong(req.getParameter("departmentId"));
            String chiefIdParam = req.getParameter("chiefId");
            Long chiefId = null;
            if (Objects.nonNull(chiefIdParam) && chiefIdParam.length() > 0) {
                chiefId = Long.parseLong(chiefIdParam);
            }
            Employee employee = new Employee(departmentId, chiefId, name, salary);
            ems.add(employee);
            resp.sendRedirect(req.getContextPath() + "/find-all-employees");
        } catch (BusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
