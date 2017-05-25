<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Admin page:</h1>
</div>
<div class="container">
    <div class="btn-group">
        <div class="col-md-5">
            <a href="/admin/add" class="btn btn-primary">Add book</a>
        </div>

        <div class="col-md-4">
            <a href="/books/" class="btn btn-primary">Show all</a>
        </div>
    </div>
    <br>
    <table class="table table-striped">
        <thead>
            <th>ID:</th>
            <th>Name:</th>
            <th>Autor:</th>
            <th>Genre:</th>
            <th>Price:</th>
            <th>Units:</th>
            <th>Has description:</th>
            <th></th>
            <th></th>
        </thead>
        <tbody>
            <c:forEach var="book" items="${list}">
                <tr style="${book.unitsInStock == 0? 'color:#ff0000;' : ''}">
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.autor}</td>
                    <td>${book.genre}</td>
                    <td>${book.price}</td>
                    <td>${book.unitsInStock}</td>
                    <td>${book.desc != null && book.desc.length() > 0}</td>
                    <td>
                        <a href="/admin/books/update/${book.id}" class="glyphicon glyphicon-pencil"></a>
                    </td>
                    <td>
                        <a href="/admin/books/${book.id}" class="glyphicon glyphicon-remove"></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>