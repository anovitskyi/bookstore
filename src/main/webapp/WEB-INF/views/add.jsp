<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>
    <div class="page-header">
        <h1>${message}</h1>
    </div>
    <div class="container">
        <div class="col-md-5">
            <form:form commandName="book" action="/admin/books/" method="post">
                <fieldset>
                    <form:label path="name">Name:</form:label>
                    <form:input cssClass="form-control" path="name" type="text" required="required"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="autor">Autor:</form:label>
                    <form:input cssClass="form-control" path="autor" type="text" required="required"/>
                    <form:errors path="autor" cssClass="text-danger"/>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="genre">Genre:</form:label>
                    <form:select cssClass="form-control" path="genre">
                        <form:options items="${genres}"/>
                    </form:select>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="desc">Description:</form:label>
                    <form:textarea cssClass="form-control" maxlength="150" cols="10" rows="3" cssStyle="resize: none;" path="desc"/>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="price">Price:</form:label>
                    <form:input cssClass="form-control" path="price" type="number" required="required"/>
                    <form:errors path="price" cssClass="text-danger"/>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="unitsInStock">Units:</form:label>
                    <form:input cssClass="form-control" path="unitsInStock" type="number" required="required"/>
                    <form:errors path="unitsInStock" cssClass="text-danger"/>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="img">Image:</form:label>
                    <form:input cssClass="form-control" path="img" type="text" required="required"/>
                    <form:errors path="img" cssClass="text-danger"/>
                </fieldset>

                <div class="col-mg-2" style="float:right;">
                    <input type="submit" value="Submit" class="btn btn-success" style="float:right;">
                </div>
            </form:form>
        </div>
    </div>
<%@include file="/WEB-INF/views/common/footer.jspf"%>
