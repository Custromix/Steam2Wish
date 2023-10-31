<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<nav class="main-nav">
    <!-- ***** Logo Start ***** -->
    <a href="/" class="logo">
        <img src="/public/assets/images/logo.png" alt="">
    </a>
    <!-- ***** Logo End ***** -->
    <!-- ***** Search End ***** -->
    <%--<div class="search-input">
      <form id="search" action="#">
        <input type="text" placeholder="Type Something" id='searchText' name="searchKeyword" onkeypress="handle" />
        <i class="fa fa-search"></i>
      </form>
    </div>--%>
    <!-- ***** Search End ***** -->
    <!-- ***** Menu Start ***** -->
    <ul class="nav">
        <li><a href="/" class="active">Home</a></li>
        <li><a href="store">Store</a></li>
        <li><a href="details.html">Details</a></li>
        <li><a href="streams.html">Streams</a></li>
        <li><a href="profile">${sessionScope.username}<img src="/public/assets/images/profile-header.jpg" alt=""></a></li>
    </ul>
    <a class='menu-trigger'>
        <span>Menu</span>
    </a>
    <!-- ***** Menu End ***** -->
</nav>
