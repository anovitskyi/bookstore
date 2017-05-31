<%@include file="/WEB-INF/views/common/header.jspf"%>
</div>
<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="/resources/images/bac1.png" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to my bookstore</h1>
                    <p>Best store to purchase any book</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="/resources/images/bac2.png" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Big variety</h1>
                    <p>Here you can find different books in different colors</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="/resources/images/bac3.png" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Very simple way to order</h1>
                    <p>Ordering textbooks and other materials is easy. Be sure to make a hard copy (printout) of your course material from your course Syllabus and take it with you when you go to the bookstore so you know for sure what you need to order.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">
    <input type="hidden" id="foo" value="hidden">
    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-6">
            <a href="/search">
                <img class="img-circle" src="/resources/images/search.png" alt="Go searching" width="150" height="150">
            </a>
        </div><!-- /.col-lg-6-->
        <div class="col-lg-6">
            <a href="/books/">
                <img class="img-circle" src="/resources/images/list.png" alt="Show all books" width="150" height="150">
            </a>
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <!-- FOOTER -->
    <footer class="footer">
        <br>
        <p>&copy; <%=new java.util.GregorianCalendar().getWeekYear()%> Andrii Novitskyi &middot;</p>
    </footer>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/jquery-1.11.3.min.js"></script>
<script>window.jQuery || document.write('<script src="/resources/js/jquery-1.11.3.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
<script>
    $(function() {
        $('#inputWithoutSpaces').on('keypress', function(e) {
            if (e.which == 32)
                return false;
        });
    });
</script>
<script>

    $(document).ready(function() {
        $('#myCarousel').carousel({
            interval: false
        });
        setInterval(function(){if($('.carousel-inner .item:first').hasClass('active')) {
            $('#myCarousel').carousel('next');
        }
        else if($('.carousel-inner .item:last').hasClass('active')) {
            $('#myCarousel').carousel('prev');
        }
        else if(!$('.carousel-inner .item:first').hasClass('active') && !$('.carousel-inner .item:last').hasClass('active')) {
            if ($('#foo').attr('value') == 'hidden')
            {
                document.getElementById('foo').value = 'password';
                $('#myCarousel').carousel('next');
            }
            else {
                document.getElementById('foo').value = 'hidden';
                $('#myCarousel').carousel('prev');
            }
        } }, 3000);
    });
</script>
</body>
</html>
