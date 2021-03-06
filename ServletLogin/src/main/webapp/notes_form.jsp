<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Note-it-down</title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">

</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: black">
   <div>
    <a href="<%=request.getContextPath()%>/home" class="navbar-brand">Note-it-down</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/home"
     class="nav-link">Notes list</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${todo != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${todo == null}">
     <form action="insert" method="post">
    </c:if>

    <caption>
     <h2>
      <c:if test="${todo != null}">
               Edit Note
              </c:if>
      <c:if test="${todo == null}">
               Add New Note
              </c:if>
     </h2>
    </caption>

    <c:if test="${todo != null}">
     <input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Note's Title</label> <input type="text"
      value="<c:out value='${todo.title}' />" class="form-control"
      name="title" required="required" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Note's Decription</label> <input type="text"
      value="<c:out value='${todo.description}' />" class="form-control"
      name="description" minlength="5">
    </fieldset>

    <fieldset class="form-group">
     <label>Note's Status</label> <select class="form-control"
      name="isDone">
      <option value="Progress">Progress</option>
      <option value="Complete">Complete</option>
     </select>
    </fieldset>

    <fieldset class="form-group">
     <label>Note's Target Date</label> <input type="date"
      value="<c:out value='${todo.targetDate}' />" class="form-control"
      name="targetDate" required="required">
    </fieldset>
    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

</body>
</html>