<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

    <div class="page-header">
        <h1>${helloMessage}</h1>
        <br>
    </div>
    <c:forEach var="book" items="${list}">
        <div class="row" style="height: 150px; margin-top: 5px; background-color: #989697;">
            <div class="col-md-2" style="padding-left: 0px;">
                <img src="/resources/books/${book.id}.png" onerror="this.src='/resources/books/default.png'" alt="Book: ${book.name}" width="150" height="150"/>
            </div>
            <div class="col-md-4">
                <h3>${book.name}</h3>
                <h4>${book.autor}</h4>
                <a href="/books/genres/${book.genre}"><h4>#${book.genre}</h4></a>
            </div>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${book.desc != null && book.desc.length() > 0}">
                        <h3>Short description:</h3>
                        <p><i>${book.desc}</i></p>
                    </c:when>
                    <c:otherwise>
                        <h3>No book description</h3>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-mf-2" style="text-align: right; padding-top: 2%; padding-right: 2%;">
                <c:choose>
                    <c:when test="${book.unitsInStock > 0}">
                        <h3>Price: &#36;${book.price}</h3>
                        <a class="btn btn-success" href="/books/${book.id}">View</a>
                    </c:when>
                    <c:otherwise>
                        <h3>No more books left</h3>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="/WEB-INF/views/common/footer.jspf"%>
