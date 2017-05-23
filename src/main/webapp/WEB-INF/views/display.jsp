<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="container" style="margin-top: 50px;">
    <c:forEach var="book" items="${list}">
        <div class="container" style="margin-top: 1%; padding: 2%; background-color: #777777;">
            <img src="/resources/books/${book.img}" onerror="this.src='/resources/books/default.png'" alt="Book: ${book.name}" width="200" height="200"/>
            <h3>${book.name}</h3>
            <h4>${book.autor}</h4>
            <p>
                    ${book.desc}
            </p>
            <h3>${book.price}</h3>
            <h3>${book.genre}</h3>
            <c:choose>
                <c:when test="${book.unitsInStock > 0}">
                    <form method="post" action="/buy">
                        <input type="hidden" value="${book.id}">
                        <input type="submit" value="Buy">
                    </form>
                </c:when>
                <c:otherwise>
                    <h6>${noUnits}</h6>
                </c:otherwise>
            </c:choose>
        </div>
    </c:forEach>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
