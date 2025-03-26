<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="/">HOME</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        Servlet Home
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/j1test.jsp">j1Start</a>
        <a class="dropdown-item" href="/j2var_scope.jsp">j2var_scope</a>
        <a class="dropdown-item" href="/j3include_file.jsp">j3include_file</a>
        <a class="dropdown-item" href="/j4param_set.jsp">j4param_set</a>
        <a class="dropdown-item" href="/j4param_get.jsp">j4param_get</a>
        <a class="dropdown-item" href="/j5scriptlet.jsp">j5scriptlet</a>
        <a class="dropdown-item" href="/j6data_scope.jsp">j6scope</a>
        <a class="dropdown-item" href="/j7action_forward.jsp">j7action_forward</a>
        <a class="dropdown-item" href="/j8action_include.jsp">j8action_include</a>
        <a class="dropdown-item" href="/insert_form.html">j9use_bean</a>
      </div>
    </li>
  </ul>
</nav>