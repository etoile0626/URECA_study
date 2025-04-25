<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="/">HOME</a>

  <!-- Links -->
  <ul class="navbar-nav">

    <li class="nav-item">
      <a class="nav-link" href="http://localhost:8080/swagger-ui/index.html" target="_blank">Swagger</a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="/dong/code">DongCode</a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="/dong/search">DongSearch</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        INTERCEPTOR
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/itcp1">interceptor1</a>
        <a class="dropdown-item" href="/itcp2">interceptor2</a>
      </div>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        AJAX
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ajax/ajax1">ajax1</a>
        <a class="dropdown-item" href="/ajax/ajax2">ajax2</a>
        <a class="dropdown-item" href="/ajax/ajax3">ajax3</a>
        <a class="dropdown-item" href="/ajax/ajax4">ajax4</a>
      </div>
    </li>

  </ul>
</nav>
