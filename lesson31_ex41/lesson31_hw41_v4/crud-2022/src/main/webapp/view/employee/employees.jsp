<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employees</title>
</head>
<body>
<h2>Список работников</h2>
<ul>
    <li><a href='<c:url value="/" />'>На главную</a></li>
</ul>
<ol>
    <c:forEach items="${employees}" var="employee">
        <li>${employee}
            &nbsp; &nbsp;
            <a href='<c:url value="/edit-employee?id=${employee.id}" />'>Редактировать</a>
            &nbsp; &nbsp;
            <form method="post" action='<c:url value="/delete-employee" />' style="display:inline;">
                <input type="hidden" name="id" value="${employee.id}">
                <input type="submit" value="Удалить">
            </form>
        </li>
    </c:forEach>
</ol>
<h4>Добавить нового работника</h4>
<form action='<c:url value="/add-employee" />' method="post">
    <input type="hidden" value="${employee.id}" name="id" />
    <label>ФИО</label><br>
    <input name="name" value="${employee.name}" /><br><br>
    <label>Зарплата</label><br>
    <input name="salary" value="${employee.salary}" type="number" /><br><br>
    <label>Подразделение (ID)</label><br>
    <input name="departmentId" value="${employee.departmentId}" type="number" /><br><br>
    <label>Начальник (ID)</label><br>
    <input name="chiefId" value="${employee.chiefId}" type="number" /><br><br>
    <input type="submit" value="Добавить" />
</form>

</body>
</html>
