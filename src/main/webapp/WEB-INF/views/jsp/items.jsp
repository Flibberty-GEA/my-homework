<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="ua.skillsup.javacourse.homework.domain.tag.Tag" %>
<%@ page import="ua.skillsup.javacourse.homework.domain.item.Item" %>
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

        <c:forEach var="item" items="${items}">
            <div class="panel panel-info">
                <div class="panel-heading" id="my-css-news-title">
                    <h3 class="panel-title">${item.title}</h3>
                </div>
                <div class="panel-body" id="my-css-summary">
                        ${item.summary}
                </div>
                <div class="panel-footer">
                    <p>Дата публікації: ${item.publicationsDate == LocalDate.now() ? 'сьогодні' : item.publicationsDate}</p>
                    <p>Автор: <a href="/items/byuser/${item.user.username}">${item.user.username}</a></p>
                    <p>#
                        <c:forEach var="tag" items="${item.tags}" varStatus="loop">
                            <a href="/items/tag/${tag.name}">${tag.name}</a><c:if test="${!loop.last}">, </c:if>
                        </c:forEach>
                    </p>
                </div>
            </div>
        </c:forEach>

     <%--   <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Назва</th>
                    <th>Автор</th>
                    <th>Короткий зміст</th>
                    <th>Дата публікації</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${items}">

                <tr>
                    <td>
                        <a href="/items/${item.id}"> ${item.title} </a>
                    </td>
                    <td><a href="/items/byuser/${item.user.username}">${item.user.username}</a></td>
                    <td>${item.summary}</td>
                    <td>${item.publicationsDate == LocalDate.now() ? 'сьогодні' : item.publicationsDate}</td>
                    <td>
                        <c:forEach var="tag" items="${item.tags}" varStatus="loop">
                            <a href="/items/tag/${tag.name}">${tag.name}</a><c:if test="${!loop.last}">, </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>--%>
    </div>

<%--    <div>
        <a href="/items/create" class="btn btn-danger">Створити нову публікацію</a>
&lt;%&ndash;        <sec:authorize access="hasRole('ADMIN')">
            <a href="/admin/create" class="btn btn-danger">Створити нову публікацію</a>
        </sec:authorize>&ndash;%&gt;
    </div>--%>

</div>

</body>
</html>
