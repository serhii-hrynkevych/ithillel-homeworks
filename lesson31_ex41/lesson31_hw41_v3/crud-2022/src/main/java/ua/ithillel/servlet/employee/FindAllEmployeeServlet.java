package ua.ithillel.servlet.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.model.EmployeeWithDepartment;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/find-all-employees")
public class FindAllEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        DepartmentManageService dms = new DepartmentManageService();
        List<EmployeeWithDepartment> employeeWithDepartmentList = new ArrayList<>();
        try {
            List<Employee> employeeList = ems.findAll();
            List<Department> departmentList = dms.findAll();
            for (Employee e : employeeList) {
                String departmentName = departmentList.stream()
                        .filter(d -> d.getId().equals(e.getDepartmentId()))
                        .map(Department::getName)
                        .findAny()
                        .orElse(null);

                String nameChief = "^^являеться руководителем отдела^^";
                if (e.getChiefId() != null) {
                    nameChief = ems.get(e.getChiefId()).getName();
                }

                employeeWithDepartmentList.add(new EmployeeWithDepartment(
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getDepartmentId(),
                        e.getChiefId(),
                        departmentName,
                        nameChief
                ));
            }
            employeeWithDepartmentList.sort((Comparator<EmployeeWithDepartment>) (o1, o2) -> {
                String x1 = o1.getDepartment();
                String x2 = o2.getDepartment();
                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }
                x1 = o1.getName();
                x2 = o2.getName();
                return x1.compareTo(x2);
            });

            req.setAttribute("employees", employeeWithDepartmentList);
            getServletContext().getRequestDispatcher("/view/employee/employees.jsp").forward(req, resp);
        } catch (BusinessException e) {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println(e.getMessage());
            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.close();
        }
    }
}
