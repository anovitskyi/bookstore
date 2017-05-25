<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>
    <div class="page-header">
        <h1>Add new book: </h1>
    </div>
    <div class="container">
        <div class="col-md-5">
            <form:form commandName="book" action="/admin/books/" method="post" enctype="multipart/form-data">
                <%@include file="/WEB-INF/views/common/book.jspf"%>
            </form:form>
        </div>
    </div>
<%@include file="/WEB-INF/views/common/footer.jspf"%>
