<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default" id="my-css-logo">
    <ul class="nav navbar-nav">
        <li><a class="navbar-brand" href="#"  id="my-css-name">MyFeed</a>
            <img src="<c:url value='/resources/images/lib.png' />" class="logo" style="padding: 0 15px"></li>

        <li class="${param.activePage == 'RECOMMEND' ? 'active' : ''}">
            <a href="/items/recommendations"  id="${param.activePage == 'RECOMMEND' ? 'grean' : 'wite'}">Рекомендовані</a>
        </li>
        <li class="${param.activePage == 'ALL' ? 'active' : ''}">
            <a href="/items/allItems" id="${param.activePage == 'ALL' ? 'grean' : 'wite'}">Всі публікації</a>
        </li>
    </ul>



    <ul class="nav navbar-nav navbar-right">
        <li>
            <div class="navbar-form navbar-left">
                <a href="/items/create"  <%--id='wite'--%> class="btn btn-primary">
                    Створити нову публікацію
                </a>
            </div>
        </li>

    <li><form action="/items/search" method="get" class="navbar-form navbar-left" role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Назва" name="title" >
        </div>
        <input type="submit" class="btn btn-default" value="Пошук">
    </form></li>


    <li><a href="#" style="color: #eff4f0">Контакти</a></li>
        <li><a href="#" style="color: #eff4f0">Вітаємо <sec:authentication property="principal.username" /></a></li>
        <li style="padding-right: 15px"><a href="<c:url value='/logout' />" style="color: #eff4f0">Вийти</a></li>
    </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>