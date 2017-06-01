<%@include file="/WEB-INF/views/common/header.jspf"%>
<div class="page-header">
<h1>Admin page:</h1>
</div>
<div class="container">
    <table style="float: right;">
        <tr>
            <td style="padding: 5px;"><a href="/admin/books/add" class="btn btn-primary">Add book</a></td>
            <td style="padding: 5px;"><a href="/books/" class="btn btn-primary">Show books</a></td>
            <td style="padding: 5px;"><a href="/admin/consumers" class="btn btn-primary">Show consumers</a></td>
            <td style="padding: 5px;"> <a href="/admin/orders" class="btn btn-primary">Show orders</a></td>
        </tr>
    </table>
    <br>
    <table class="table">
        <thead>
        <th>ID: </th>
        <th>Name: </th>
        <th>Surname: </th>
        <th>Age: </th>
        <th>Email: </th>
        <th>Username: </th>
        <th>Enabled: </th>
        </thead>
        <tbody>
        <c:forEach var="consumer" items="${list}">
            <tr>
                <td>
                        ${consumer.id}
                </td>
                <td>
                        ${consumer.firstName}
                </td>
                <td>
                        ${consumer.lastName}
                </td>
                <td>
                        ${consumer.age}
                </td>
                <td>
                        ${consumer.email}
                </td>
                <td>
                        ${consumer.username}
                </td>
                <td>
                        ${consumer.enabled}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
