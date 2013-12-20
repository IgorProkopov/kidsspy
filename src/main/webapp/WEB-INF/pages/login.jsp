<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authorization</title>
    <jsp:include page="fragments/links.jsp"/>
    <link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>

<div class="navbar navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">InPhoto</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">Login</a></li>
                <li><a href="/registration">Sign up</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <form class="form-signin" action="<c:url value='/j_spring_security_check' />"
          method='POST' role="form">

        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                Login failed. Wrong email or password.
            </div>
        </c:if>

        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username"
               placeholder="Email address" required autofocus>
        <input type="password" class="form-control" name="j_password"
               placeholder="Password" required>
        <label class="checkbox">
            <input type="checkbox" name="_spring_security_remember_me"
                   value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div style="text-align: center; margin-top: 12px">
            <a href="/registration">Create new account</a>
        </div>
    </form>

</div>
</body>
</html>
