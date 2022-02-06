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
    <li><a href='<c:url value="/add-employee" />'>Добавление нового</a></li>
</ul>
<table>
    <tr>
        <th>Подразделение</th>
        <th>ФИО</th>
        <th>Зарплата</th>
        <th>Начальник</th>
        <th></th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.department}</td>
            <td>${employee.name}</td>
            <td>${employee.salary}</td>
            <td>${employee.nameChief}</td>
            <td>
                <a href='<c:url value="/edit-employee?id=${employee.id}" />'>Изменить</a> |
                <form method="post" action='<c:url value="/delete-employee" />' style="display:inline;">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
