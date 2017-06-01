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
        <th>Consumer: </th>
        <th>Date: </th>
        <th>Price: </th>
        </thead>
        <tbody>
        <c:forEach var="order" items="${list}">
            <tr>
                <td>
                    ${order.consumer.firstName} ${order.consumer.lastName}
                </td>
                <td>
                    ${order.date}
                </td>
                <td>
                    &#36;${order.price}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
