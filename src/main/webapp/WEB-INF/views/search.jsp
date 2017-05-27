<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Searching page</h1>
</div>

<div class="container">
    <div class="col-md-4">
        <form:form commandName="book" action="/search" method="post">
            <fieldset class="form-group">
                <form:label path="name">Name: </form:label>
                <form:input path="name" type="text" cssClass="form-control"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="autor">Author: </form:label>
                <form:input path="autor" type="text" cssClass="form-control"/>
            </fieldset>

            <fieldset class="form-group">
                <form:label path="genre">Genre: </form:label>
                <form:select path="genre" cssClass="form-control">
                    <form:option value="-">---</form:option>
                    <form:options items="${genres}"/>
                </form:select>
            </fieldset>

            <input type="submit" value="Submit" class="btn btn-primary"/>
        </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>