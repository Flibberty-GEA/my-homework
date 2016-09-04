<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Перегляд публікації</title>
    <jsp:include page="../includes.jsp"/>
</head>
<body>

<jsp:include page="item.jsp">
    <jsp:param name="readonly" value="true"/>
</jsp:include>

</body>
</html>
