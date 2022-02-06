<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>
<h2>Обновление данных Департамента</h2>
<ul>
    <li><a href='<c:url value="/" />'>На главную</a></li>
    <li><a href='<c:url value="/find-all-departments" />'>Вернуться к списку департаментов</a></li>
</ul>
<form method="post">
    <input type="hidden" value="${department.id}" name="id" />
    <label>Название департамента</label><br>
    <input name="name" value="${department.name}" /><br><br>
    <input type="submit" value="Изменить" />
</form>

</body>
</html>
