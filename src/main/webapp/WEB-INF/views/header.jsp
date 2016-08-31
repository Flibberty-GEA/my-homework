<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li><a class="navbar-brand" href="#">Book store</a></li>

        <li class="${param.activePage == 'RECOMMEND' ? 'active' : ''}">
            <a href="/books/recommendations">Recommendations</a>
        </li>
        <li class="${param.activePage == 'ALL' ? 'active' : ''}">
            <a href="/books/allBooks">All books</a>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <%--<li style="padding-right: 15px;"><a href="#">Logout</a></li>--%>
        <li class="dropdown" style="padding-right: 15px">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
                <sec:authentication property="principal.username"/>
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="<c:url value='/logout' />">Logout</a></li>
            </ul>
        </li>
    </ul>

    <%--<div class="container-fluid">--%>
    <%--<!-- Brand and toggle get grouped for better mobile display -->--%>
    <%--<div class="navbar-header">--%>
    <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"--%>
    <%--data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
    <%--<span class="sr-only">Toggle navigation</span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--<span class="icon-bar"></span>--%>
    <%--</button>--%>
    <%--<a class="navbar-brand" href="#">Book store</a>--%>
    <%--</div>--%>

    <%--<!-- Collect the nav links, forms, and other content for toggling -->--%>
    <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
    <%--<ul class="nav navbar-nav">--%>
    <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
    <%--<li><a href="#">Link</a></li>--%>
    <%--<li class="dropdown">--%>
    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
    <%--aria-haspopup="true" aria-expanded="false">Dropdown <span--%>
    <%--class="caret"></span></a>--%>
    <%--<ul class="dropdown-menu">--%>
    <%--<li><a href="#">Action</a></li>--%>
    <%--<li><a href="#">Another action</a></li>--%>
    <%--<li><a href="#">Something else here</a></li>--%>
    <%--<li role="separator" class="divider"></li>--%>
    <%--<li><a href="#">Separated link</a></li>--%>
    <%--<li role="separator" class="divider"></li>--%>
    <%--<li><a href="#">One more separated link</a></li>--%>
    <%--</ul>--%>
    <%--</li>--%>
    <%--</ul>--%>
    <%--<form class="navbar-form navbar-left" role="search">--%>
    <%--<div class="form-group">--%>
    <%--<input type="text" class="form-control" placeholder="Search">--%>
    <%--</div>--%>
    <%--<button type="submit" class="btn btn-default">Submit</button>--%>
    <%--</form>--%>
    <%--<ul class="nav navbar-nav navbar-right">--%>
    <%--<li><a href="#">Link</a></li>--%>
    <%--<li class="dropdown">--%>
    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
    <%--aria-haspopup="true" aria-expanded="false">Dropdown <span--%>
    <%--class="caret"></span></a>--%>
    <%--<ul class="dropdown-menu">--%>
    <%--<li><a href="#">Action</a></li>--%>
    <%--<li><a href="#">Another action</a></li>--%>
    <%--<li><a href="#">Something else here</a></li>--%>
    <%--<li role="separator" class="divider"></li>--%>
    <%--<li><a href="#">Separated link</a></li>--%>
    <%--</ul>--%>
    <%--</li>--%>
    <%--</ul>--%>
    <%--</div><!-- /.navbar-collapse -->--%>
    <%--</div><!-- /.container-fluid -->--%>
</nav>