<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

    <div class="page-header">
        <h1>${message}</h1>
    </div>

<div class="container col-md-5">
    <form:form name="loginForm" action="/j_spring_security_check" method="post">

        <fieldset class="form-group">
            <form:label path="username" cssClass="form-control">Username: </form:label>
            <form:input path="username" cssClass="form-control" type="text" id="username" name="username"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="password" cssClass="form-control">Password </form:label>
            <form:input path="password" cssClass="form-control" type="password" id="password" name="password"/>
        </fieldset>

        <input type="submit" value="Submit" class="btn btn-primary">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>