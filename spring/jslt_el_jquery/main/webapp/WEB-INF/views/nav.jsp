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

    <!-- EL Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        EL Home
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/el1">el1basic</a>
        <a class="dropdown-item" href="/el2">el2data</a>
        <a class="dropdown-item" href="/el3">el3collections</a>
      </div>
    </li>
    <!-- JSTL Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        JSTL Home
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/jstl1">jstl1basic</a>
        <a class="dropdown-item" href="/jstl2">jstl2branch</a>
        <a class="dropdown-item" href="/jstl3">jstl3loop</a>
        <a class="dropdown-item" href="/jstl4">jstl4url</a>
        <a class="dropdown-item" href="/jstl6">jstl6import</a>
        <a class="dropdown-item" href="/jstl7">jstl7redirect</a>
        <a class="dropdown-item" href="/jstl8">jstl8format</a>
        <a class="dropdown-item" href="/jstl9">jstl9function</a>
      </div>
    </li>
     <!-- jquery Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="/" id="navbardrop" data-toggle="dropdown">
        JQuery Home
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/jq1">jq1start</a>
        <a class="dropdown-item" href="/jq2">jq2selector</a>
        <a class="dropdown-item" href="/jq3">jq3selector</a>
        <a class="dropdown-item" href="/jq4">jq4selector</a>
        <a class="dropdown-item" href="/jq5">jq5selector</a>
        <a class="dropdown-item" href="/jq6">jq6selector</a>
      </div>
    </li>
  </ul>
</nav>




