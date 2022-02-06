<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Department</title>
</head>
<body>
<h2>Добавление нового департамента</h2>
<form method="post">
    <input type="hidden" value="${department.id}" name="id" />
    <label>Название департамента</label><br>
    <input name="name" value="${department.name}" /><br><br>
    <input type="submit" value="Добавить" />
</form>

</body>
</html>
