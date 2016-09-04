<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="ALL"/>
</jsp:include>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/items/allItems">Усі публікації</a></li>
    </ol>

    <div class="row">
        <h2 id="my-css-title">Зміст
            <c:forEach var="tag" items="${item.tags}">${tag.name}</c:forEach></h2>
    </div>


    <div class="row">

        <form:form modelAttribute="item" action="/admin/items/${item.id}">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6">

                        <label for="itemTitle">Назва</label>
                        <form:input type="text" path="title" class="form-control" id="itemTitle"
                                    placeholder="Write title of item" readonly="${param.readonly}"/>
                    </div>
                    <div class="col-md-6">


                        <label for="itemTitle">Автор</label>
                        <form:input type="text" path="author.name" class="form-control" id="itemTitle"
                                    placeholder="Write author name" readonly="${param.readonly}"/>
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-12">


                        <label for="itemTitle">Короткий зміст</label>
                        <form:input type="text" path="summary" class="form-control" id="itemTitle"
                                    placeholder="Write some summary" readonly="${param.readonly}"/>
                    </div>
                </div>
            </div>

            <c:choose>
                <c:when test="${param.readonly}">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="/admin/items/${item.id}" class="btn btn-danger">Редагувати</a>
                    </sec:authorize>
                </c:when>
                <c:otherwise>
                    <input type="submit" class="btn btn-primary" value="Зберігти зміни"/>
                </c:otherwise>
            </c:choose>
        </form:form>
    </div>
</div>