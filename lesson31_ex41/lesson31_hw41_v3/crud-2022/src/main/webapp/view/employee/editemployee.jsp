<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Обновление данных работника</h2>
<form method="post">
    <input type="hidden" value="${employee.id}" name="id" />
    <label>ФИО</label><br>
    <input name="name" value="${employee.name}" /><br><br>
    <label>Зарплата</label><br>
    <input name="salary" value="${employee.salary}" type="number" /><br><br>
    <label>Подразделение (ID)</label><br>
    <input name="departmentId" value="${employee.departmentId}" type="number" /><br><br>
    <label>Начальник (ID)</label><br>
    <input name="chiefId" value="${employee.chiefId}" type="number" /><br><br>
    <input type="submit" value="Изменить" />
</form>

</body>
</html>
