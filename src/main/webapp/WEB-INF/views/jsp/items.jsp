<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Нові публікації</title>
    <jsp:include page="../includes.jsp"/>
</head>
<body>
<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="RECOMMEND"/>
</jsp:include>

<div class="container">

    <div class="row">
        <h2 id="my-css-title">Нові публікації</h2>
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

    <div>
        <a href="/items/create" class="btn btn-danger">Створити нову публікацію</a>
<%--        <sec:authorize access="hasRole('ADMIN')">
            <a href="/admin/create" class="btn btn-danger">Створити нову публікацію</a>
        </sec:authorize>--%>
    </div>

</div>

</body>
</html>
