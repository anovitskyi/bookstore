<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Confirm your purchase: </h1>
</div>

<div class="row">
   <form:form action="/books/${book.id}" method="post">
       <div class="col-md-3">
           <img src="/resources/books/${book.id}.png" onerror="this.src='/resources/books/default.png'" alt="Book: ${book.name}" width="250" height="250"/>
       </div>
       <div class="col-md-8">
          <ul style="list-style-type: none;">
              <li> <h3>${book.name}</h3> </li>
              <li> <h4>${book.autor}</h4> </li>
              <li> <a href="/books/genres/${book.genre}"><h4>#${book.genre}</h4></a> </li>
              <li>   <c:choose>
                      <c:when test="${book.desc != null && book.desc.length() > 0}">
                          <h3>Short description:</h3>
                          <p><i>${book.desc}</i></p>
                      </c:when>
                      <c:otherwise>
                          <h3>No book description</h3>
                      </c:otherwise>
                  </c:choose>
              </li>
              <li><h3>&#36;${book.price}</h3></li>
              <li> <input type="submit" value="Confirm" class="btn btn-success">
                  <a href="/books/" class="btn btn-default">Go to all books</a>
              </li>
          </ul>
       </div>
   </form:form>
</div>
<%@include file="/WEB-INF/views/common/footer.jspf"%>
