<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li><a class="navbar-brand" href="#">MyFeed</a>
            <img src="<c:url value='/resources/images/lib.png' />" class="logo" style="padding-right: 15px"></li>

        <li class="${param.activePage == 'RECOMMEND' ? 'active' : ''}">
            <a href="/items/recommendations">Рекомендовані</a>
        </li>
        <li class="${param.activePage == 'ALL' ? 'active' : ''}">
            <a href="/items/allItems">Всі публікації</a>
        </li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <li><form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Назва">
            </div>
            <button type="submit" class="btn btn-default">Пошук</button>
        </form></li>
    <li><a href="#">Контакти</a></li>
        <li style="padding-right: 15px"><a href="<c:url value='/logout' />">Вийти</a></li>

    </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>