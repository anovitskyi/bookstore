<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Registration</h1>
</div>

<div class="container">
    <div class="col-md-4">
        <form:form commandName="consumer" action="/singup" method="post">

            <div class="page-header">
                <h3>Personal information:</h3>
            </div>

            <fieldset class="form-group">
                <form:label path="firstName">First name:</form:label>
                <form:input path="firstName" cssClass="form-control" type="text" required="required"/>
                <form:errors path="firstName" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="lastName">Last name:</form:label>
                <form:input path="lastName" cssClass="form-control" type="text" required="required"/>
                <form:errors path="lastName" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="age">Age:</form:label>
                <form:input path="age" cssClass="form-control" type="number" required="required"/>
                <form:errors path="age" cssClass="text-danger"/>
            </fieldset>

            <div class="page-header">
                <h3>Credentials:</h3>
            </div>

            <fieldset class="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email" cssClass="form-control" type="email" required="required"/>
                <form:errors path="email" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="username">Username:</form:label>
                <form:input path="username" cssClass="form-control" type="text" required="required"/>
                <form:errors path="username" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="password">Password:</form:label>
                <form:input path="password" cssClass="form-control" type="password" required="required"/>
                <form:errors path="password" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <label>Confirm password:</label>
                <input id="password" name="password" class="form-control" type="password" required="required"/>
                <errors cssClass="text-warning"/>
            </fieldset>

            <div class="page-header">
                <h3>Adress:</h3>
            </div>

            <fieldset class="form-group">
                <form:label path="adress.country">Country:</form:label>
                <form:select path="adress.country" cssClass="form-control">
                    <form:options items="${countries}"/>
                </form:select>
                <form:errors path="adress.country" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="adress.city">City:</form:label>
                <form:input path="adress.city" cssClass="form-control" type="text" required="required"/>
                <form:errors path="adress.city" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="adress.street">Street:</form:label>
                <form:input path="adress.street" cssClass="form-control" type="text" required="required"/>
                <form:errors path="adress.street" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="adress.number">Number:</form:label>
                <form:input path="adress.number" cssClass="form-control" type="number" required="required"/>
                <form:errors path="adress.number" cssClass="text-danger"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="adress.postCode">Postal code:</form:label>
                <form:input path="adress.postCode" cssClass="form-control" type="text" required="required"/>
                <form:errors path="adress.postCode" cssClass="text-danger"/>
            </fieldset>

            <input type="submit" value="Submit" class="btn btn-primary"/>
        </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>