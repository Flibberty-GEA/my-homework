<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Опублікувати</title>
    <jsp:include page="../includes.jsp"/>
</head>
<body>



<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="ALL"/>
</jsp:include>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/items/allItems">Усі публікації</a></li>
    </ol>
    <sec:authentication property="principal.username" />
<%--<p><%= application.getContext(session.getAttribute("user").toString())%></p>--%>
    <div class="row">
        <h2 id="my-css-title">Зміст
            <%--<c:forEach var="tag" items="${item.tags}">${tag.name}</c:forEach>--%></h2>
    </div>


    <div class="row">

        <form:form modelAttribute="item" action="/items/create">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6">
                        <label for="itemTitle">Назва</label>
                        <form:input type="text" path="title" class="form-control" id="itemTitle"
                                    placeholder="Write title of item" />
                    </div>

                    <div class="col-md-6">
                        <label for="itemTitle">#</label>
                        <%--<form:hidden path="user.username" />--%>
                        <form:input type="text" path="tags" class="form-control" id="itemTitle"
                                    placeholder="Write any tags" />
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-12">
                        <label for="itemTitle">Короткий зміст</label>
                        <form:input type="text" path="summary" class="form-control" id="itemTitle"
                                    placeholder="Write some summary"/>
                    </div>
                </div>
            </div>
<%--            <div class="form-group">
                <div class="row">
                    <div class="col-md-12">
                        <label for="itemTitle">Розділ</label>
                        <form:input type="text" path="tags" class="form-control" id="itemTitle"
                                    placeholder="Write tag"/>
                    </div>
                </div>
            </div>--%>

<%--            <div class="form-group">
                <div class="row">
                    <div class="col-md-12">
                        <label for="itemTitle">Розділ</label>
                        <form:select path="tags">
                            <form:options items="${param.values()}" />
                        </form:select>
                    </div>
                </div>
            </div>--%>
            <input type="submit" class="btn btn-primary" value="Зберігти зміни"/>

        </form:form>
    </div>
</div>


</body>
</html>