package ua.ithillel.servlet.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.DepartmentWithChief;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@WebServlet("/find-all-departments")
public class FindAllDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        DepartmentManageService dms = new DepartmentManageService();
        List<DepartmentWithChief> departmentWithChiefList = new ArrayList<>();
        try {
            List<Employee> employeeList = ems.findAll();
            List<Department> departmentList = dms.findAll();
            for (Department d : departmentList) {
                String nameChief = "^^нет начальника отдела^^";
                for (Employee e : employeeList) {
                    if (Objects.equals(e.getDepartmentId(), d.getId()) && e.getChiefId() == null) {
                        nameChief = e.getName();
                    }
                }
                departmentWithChiefList.add(new DepartmentWithChief(d.getId(), d.getName(), nameChief));
            }

            departmentWithChiefList.sort((Comparator<Department>) (o1, o2) -> {
                String x1 = o1.getName();
                String x2 = o2.getName();
                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }
                x1 = o1.getName();
                x2 = o2.getName();
                return x1.compareTo(x2);
            });

            req.setAttribute("departments", departmentWithChiefList);
            getServletContext().getRequestDispatcher("/view/department/departments.jsp").forward(req, resp);
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
