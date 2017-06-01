<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

    <div class="page-header">
        <h1>${message}</h1>
        <h5>${msg}</h5>
    </div>

<div class="container">
    <div class="col-md-4">
        <form:form name="loginForm" action="/j_spring_security_check" method="post">

            <fieldset class="form-group">
                <label for="username" >Username: </label>
                <input class="form-control inputWithoutSpaces" type="text" id="username" name="username"/>
            </fieldset>
            <fieldset class="form-group">
                <label for="password">Password: </label>
                <input class="form-control" type="password" id="password" name="password"/>
            </fieldset>

            <p class="text-danger">${error}</p>
            <div class="row">
                <div class="col-md-1">
                    <input type="submit" value="Submit" class="btn btn-primary">
                </div>
                <div class="col-md-1" style="margin-left: 45px;">
                    <a href="/singup" class="btn btn-primary">Sing up</a>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>

</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>