<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../header.jsp">
    <jsp:param name="activePage" value="ALL"/>
</jsp:include>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/books/allBooks">All books</a></li>
        <li class="active">View</li>
    </ol>

    <div class="row">
        <h2>View book</h2>
    </div>


    <div class="row">
        <form:form modelAttribute="book" action="/admin/books/${item.id}">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6">

                        <label for="bookTitle">Title</label>
                        <form:input type="text" path="title" class="form-control" id="bookTitle"
                                    placeholder="Email" readonly="${param.readonly}"/>
                    </div>
                    <div class="col-md-6">


                        <label for="bookTitle">Title</label>
                        <form:input type="text" path="author.name" class="form-control"
                                    id="bookTitle"
                                    placeholder="Email" readonly="${param.readonly}"/>
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="row">
                    <div class="col-md-12">


                        <label for="bookTitle">Title</label>
                        <form:input type="text" path="summary" class="form-control" id="bookTitle"
                                    placeholder="Email" readonly="${param.readonly}"/>
                    </div>
                </div>
            </div>

            <c:choose>
                <c:when test="${param.readonly}">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="/admin/books/${item.id}" class="btn btn-danger">Edit book</a>
                    </sec:authorize>
                </c:when>
                <c:otherwise>
                    <input type="submit" class="btn btn-primary" value="Save Changes"/>
                </c:otherwise>
            </c:choose>

            <%--<table>--%>
            <%--<tr>--%>
            <%--<td>Title:</td>--%>
            <%--<td><form:input path="title" readonly="${param.readonly}"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Author:</td>--%>
            <%--<td><form:input path="author.name" readonly="${param.readonly}"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Abstract:</td>--%>
            <%--<td><form:input path="summary" readonly="${param.readonly}"/></td>--%>
            <%--</tr>--%>

            <%--<c:choose>--%>
            <%--<c:when test="${param.readonly}">--%>
            <%--<sec:authorize access="hasRole('ADMIN')">--%>
            <%--<a href="/admin/books/${book.id}">Edit book</a>--%>
            <%--</sec:authorize>--%>
            <%--</c:when>--%>
            <%--<c:when test="${!param.readonly}">--%>
            <%--<tr>--%>
            <%--<td colspan="2">--%>
            <%--<input type="submit" value="Save Changes"/>--%>
            <%--</td>--%>
            <%--</tr>--%>
            <%--</c:when>--%>
            <%--</c:choose>--%>
            <%--</table>--%>
        </form:form>
    </div>
</div>