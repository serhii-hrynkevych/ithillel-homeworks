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
</ul>
<ol>
    <c:forEach items="${departments}" var="department">
        <li>${department}
            &nbsp; &nbsp;
            <a href='<c:url value="/edit-department?id=${department.id}" />'>Редактировать</a>
            &nbsp; &nbsp;
            <form method="post" action='<c:url value="/delete-department" />' style="display:inline;">
                <input type="hidden" name="id" value="${department.id}">
                <input type="submit" value="Удалить">
            </form>
        </li>
    </c:forEach>
</ol>
<h4>Добавить новый департамент</h4>
<form action='<c:url value="/add-department" />' method="post">
    <input type="hidden" value="${department.id}" name="id" />
    <label>Название департамента</label><br>
    <input name="name" value="${department.name}" /><br><br>
    <input type="submit" value="Добавить" />
</form>

</body>
</html>
