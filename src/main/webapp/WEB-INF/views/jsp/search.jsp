<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="ua.skillsup.javacourse.homework.domain.item.Item" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Пошук за назвою</title>
    <jsp:include page="../includes.jsp"/>
</head>
<body>

<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="ALL"/>
</jsp:include>

<div class="container">

    <div class="row">
        <h2 id="my-css-title">Знайдені публікації</h2>
    </div>

    <div>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Назва</th>
                <th>Автор</th>
                <th>Короткий зміст</th>
                <th>Дата публікації</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>
                        <a href="/items/${item.id}"> ${item.title} </a>
                    </td>
                    <td>${item.user.username}</td>
                    <td>${item.summary}</td>
                    <td>${item.publicationsDate == LocalDate.now() ? 'сьогодні' : item.publicationsDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>