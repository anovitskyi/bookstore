<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

    <div class="page-header">
        <h1>${message}</h1>
    </div>

<div class="container col-md-5 login-box">
    <form name="loginForm" action="/j_spring_security_check" method="post">

        <fieldset class="form-group">
            <label for="username" >Username: </>
            <input path="username" class="form-control" type="text" id="username" name="username"/>
        </fieldset>
        <fieldset class="form-group">
            <label for="password">Password </label>
            <input path="password" class="form-control" type="password" id="password" name="password" size="5"/>
        </fieldset>

        <input type="submit" value="Submit" class="btn btn-primary">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>