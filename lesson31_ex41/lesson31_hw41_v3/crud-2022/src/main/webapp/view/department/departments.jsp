<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departments</title>
</head>
<body>
<h2>Список Департаментов</h2>
<ul>
    <li><a href='<c:url value="/" />'>На главную</a></li>
    <li><a href='<c:url value="/add-department" />'>Добавление нового</a></li>
</ul>
<table>
    <tr>
        <th>ID подразделения</th>
        <th>Название подразделения</th>
        <th>Начальник подразделения</th>
        <th></th>
    </tr>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.nameChief}</td>
            </td>
            <td>
                <a href='<c:url value="/edit-department?id=${department.id}" />'>Изменить</a> |
                <form method="post" action='<c:url value="/delete-department" />' style="display:inline;">
                    <input type="hidden" name="id" value="${department.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
