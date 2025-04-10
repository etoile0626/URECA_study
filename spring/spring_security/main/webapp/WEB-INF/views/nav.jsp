<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="/">HOME</a>

  <!-- Links -->
  <ul class="navbar-nav">

    <li class="nav-item">
      <a class="nav-link" href="/user/join/form">Join</a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="user/login/form">Login</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="user/logout/form">Logout</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        EMP
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/emp/list">LIST</a>
        <a class="dropdown-item" href="/emp/insform">Insert</a>
        <a class="dropdown-item" href="#">login</a>
        <a class="dropdown-item" href="#">logout</a>
      </div>
    </li>

  </ul>
</nav>
