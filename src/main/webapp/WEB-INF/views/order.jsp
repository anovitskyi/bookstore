<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

    <div class="container">

        <div class="page-header">
            <h1>Confirm your purchase: </h1>
        </div>

        <div class="col-md-4">
            <table class="table">
                <thead>
                    <th>Order: </th>
                    <th></th>
                </thead>
                <tbody>
                    <tr>
                        <td>Consumer: </td>
                        <td>${order.consumer.firstName} ${order.consumer.lastName}</td>
                    </tr>
                    <c:forEach var="cartItem" items="${order.cart.list}">
                        <tr>
                            <td>Book: </td>
                            <td>${cartItem.book.name}</td>
                        </tr>
                        <tr>
                            <td>Author: </td>
                            <td>${cartItem.book.autor}</td>
                        </tr>
                        <tr>
                            <td>Quantity: </td>
                            <td>${cartItem.quantity} x &#36;${cartItem.book.price}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>Price: </td>
                        <td>&#36;${order.price}</td>
                    </tr>
                </tbody>
            </table>
            <div class="col-lg-3">
                <form:form action="/order/done" method="post">
                    <input type="hidden" value="${order}">
                    <input type="submit" value="Submit" class="btn btn-success"/>
                </form:form>
            </div>
            <div class="col-md-2">
                <a class="btn btn-default" href="/consumer/cart">Cancel</a>
            </div>
        </div>
    </div>



<%@include file="/WEB-INF/views/common/footer.jspf"%>
