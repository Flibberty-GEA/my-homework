<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book recommendations</title>
    <jsp:include page="../includes.jsp"/>
</head>
<body>
<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="RECOMMEND"/>
</jsp:include>

<div class="container">

    <div class="row">
        <h2>Books recommended specially for you!</h2>
    </div>

    <div>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Published on</th>
            </tr>
            <tbody>
            <c:forEach var="items" items="${items}">
                <tr>
                    <td>
                        <a href="/books/${item.id}"> ${item.title} </a>
                    </td>
                    <td>${item.author.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
