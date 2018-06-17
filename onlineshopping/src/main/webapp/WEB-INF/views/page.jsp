<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" /> 
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
 
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Online Shopping -${title} </title>
    <script>
    window.menu='${title}'
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/myapp.css" rel="stylesheet">
     <%-- <link href="${css}/bootstrap-cyborg.css" rel="stylesheet">    --%>

</head>

<body>
<div class="wrapper">
    <!-- Navigation -->
 
 <%@include file="./shared/navbar.jsp"%>
 
    <!-- Page Content --> 
    
    <div class="content"> 
    <!--loading home  --> 
    <c:if test="${userClickHome==true}">
    <%@include file="home.jsp" %>
    </c:if>
    
    <!--loading about  --> 
    <c:if test="${userClickAbout==true}">
    <%@include file="about.jsp" %>
    </c:if>
    
    <!--loading contact  --> 
    <c:if test="${userClickConatct==true}">
    <%@include file="contact.jsp" %>
    </c:if>
    
    <!--loading ListProducts and category  --> 
    <c:if test="${userClickAllProducts==true ||userClickCategoryProducts==true}">
    <%@include file="listProducts.jsp" %>
    </c:if>
    
  </div>

   <!-- footer comes here -->
   <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>

<!-- Self Loaded JavaScript -->
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>
