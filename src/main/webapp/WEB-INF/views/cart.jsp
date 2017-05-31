<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/common/header.jspf" %>

<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Your shopping cart</h1>

            <h4>All the selected books in your shopping cart</h4>
        </div>

        <div class="container" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
                <table class="table table-hover">
                    <tr>
                        <th>Book</th>
                        <th>Author</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                    <tr ng-repeat = "item in cart.list">
                        <td>{{item.book.name}}</td>
                        <td>{{item.book.autor}}</td>
                        <td>{{item.book.price}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="glyphicon glyphicon-remove" style="color:#ff5d47;" ng-click="removeFromCart(item.book.id)"></a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>&#36;{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>
            </div>
            <div>
                <div class="col-md-2 pull-right">
                    <a href="<spring:url value="/order/${cartId}"/>"
                       class="btn btn-success">Check out</a>
                </div>
                <div class="col-md-1 pull-right">
                    <a href="/books/" class="btn btn-default pull-right">Go to all books</a>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="/resources/js/controller.js"></script>
<%@include file="/WEB-INF/views/common/footer.jspf" %>