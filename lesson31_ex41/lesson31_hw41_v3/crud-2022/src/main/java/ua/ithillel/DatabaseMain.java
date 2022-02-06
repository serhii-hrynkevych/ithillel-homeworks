package ua.ithillel;

import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

public class DatabaseMain {
    public static void main(String[] args) {
        AppConfig.init();
        try {
            System.out.println("-------Department-------\n");
            DepartmentManageService dms = new DepartmentManageService();
            EmployeeManageService ems = new EmployeeManageService();

            ems.clear();
            dms.clear();

            Department admins = new Department("Административный отдел");
            Long adminsId = dms.add(admins);
            Department legal = new Department("Юридический отдел");
            Long legalId = dms.add(legal);
            Department credit = new Department("Кредитный отдел");
            Long creditId = dms.add(credit);
            Department accounting = new Department("Отдел бухгалтерского учета и отчетности");
            Long accountingId = dms.add(accounting);
            Department it = new Department("Отдел информационных технологий");
            Long itId = dms.add(it);
            Department hr = new Department("Отдел кадров");
            Long hrId = dms.add(hr);

            System.out.println(dms.findAll());
            System.out.println(dms.size() + " записей в department\n");

            Department newDepartment = new Department("новый департамент");
            System.out.println(dms.add(newDepartment));
            System.out.println(dms.findAll());
            System.out.println(dms.size() + " записей в department\n");

            Department updateDepartment = new Department(creditId, "Кредитный отдел - обновленный");
            dms.update(updateDepartment);

            System.out.println(dms.get(creditId));

            dms.delete(itId);

            System.out.println(dms.findAll());
            System.out.println(dms.size() + " записей в department\n");

            System.out.println("\n-------Employee-------\n");

            Employee nazarov = new Employee(adminsId, null, "Назаров Максим Давидович", 35000);
            Long nazarovId = ems.add(nazarov);
            Employee alexandrova = new Employee(adminsId, nazarovId, "Александрова Аиша Игоревна", 35000);
            ems.add(alexandrova);
            Employee kyzmin = new Employee(adminsId, nazarovId, "Кузьмин Артём Богданович", 5500);
            ems.add(kyzmin);
            Employee gromova = new Employee(adminsId, nazarovId, "Громова Сафия Владимировна", 6000);
            ems.add(gromova);
            Employee eremin = new Employee(adminsId, nazarovId, "Еремин Ярослав Тимурович", 6000);
            ems.add(eremin);
            Employee baranov = new Employee(adminsId, nazarovId, "Баранов Дмитрий Русланович", 5200);
            ems.add(baranov);
            Employee eremina = new Employee(adminsId, nazarovId, "Еремина София Макаровна", 6500);
            ems.add(eremina);
            Employee volkov = new Employee(legalId, null, "Волков Станислав Юрьевич", 45000);
            Long volkovId = ems.add(volkov);
            Employee mihaylov = new Employee(legalId, volkovId, "Михайлов Филипп Фёдорович", 15500);
            ems.add(mihaylov);
            Employee makarov = new Employee(legalId, volkovId, "Макаров Алексей Родионович", 15000);
            ems.add(makarov);
            Employee lebedeva = new Employee(creditId, null, "Лебедева Анна Михайловна", 20000);
            Long lebedevaId = ems.add(lebedeva);
            Employee tarasova = new Employee(creditId, lebedevaId, "Тарасова Юлия Глебовна", 22000);
            ems.add(tarasova);
            Employee kolosova = new Employee(creditId, lebedevaId, "Колосова Алиса Константиновна", 18000);
            ems.add(kolosova);
            Employee safonov = new Employee(creditId, lebedevaId, "Сафонов Арсений Егорович", 15000);
            ems.add(safonov);
            Employee larina = new Employee(creditId, lebedevaId, "Ларина Ирина Львовна", 15000);
            ems.add(larina);
            Employee ponomareva = new Employee(creditId, lebedevaId, "Пономарева Евгения Данильевна", 15000);
            ems.add(ponomareva);
            Employee zhuravleva = new Employee(creditId, lebedevaId, "Журавлева Милана Фёдоровна", 14000);
            ems.add(zhuravleva);
            Employee nikiforov = new Employee(creditId, lebedevaId, "Никифоров Максим Максимович", 14500);
            ems.add(nikiforov);
            Employee makarovAlex = new Employee(creditId, lebedevaId, "Макаров Алексей Родионович", 15000);
            ems.add(makarovAlex);
            Employee kolesnikova = new Employee(accountingId, null, "Колесникова Милана Родионовна", 35000);
            Long kolesnikovaId = ems.add(kolesnikova);
            Employee kupriyanova = new Employee(accountingId, kolesnikovaId, "Куприянова Евгения Даниловна", 12000);
            ems.add(kupriyanova);
            Employee chistyakov = new Employee(accountingId, kolesnikovaId, "Чистяков Владимир Артёмович", 13000);
            ems.add(chistyakov);
            Employee savitskaya = new Employee(accountingId, kolesnikovaId, "Савицкая София Андреевна", 15000);
            ems.add(savitskaya);
            Employee borisova = new Employee(accountingId, kolesnikovaId, "Борисова Анна Саввична", 37000);
            Long borisovaId = ems.add(borisova);
            Employee grekov = new Employee(accountingId, kolesnikovaId, "Греков Артём Маркович", 17000);
            Long grekovId = ems.add(grekov);

            System.out.println(ems.findAll());
            System.out.println(ems.size() + " записей в employee\n");

            Employee newEmployee = new Employee(hrId, null, "Новый employee", 105000);
            System.out.println(ems.add(newEmployee));
            System.out.println(ems.findAll());
            System.out.println(ems.size() + " записей в employee\n");

            Employee updateEmployee = new Employee(grekovId, accountingId, kolesnikovaId, "Т. Греков Артём Маркович", 17250);
            ems.update(updateEmployee);

            System.out.println(ems.get(grekovId));

            ems.delete(borisovaId);

            System.out.println(ems.findAll());
            System.out.println(ems.size() + " записей в employee\n");
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}
