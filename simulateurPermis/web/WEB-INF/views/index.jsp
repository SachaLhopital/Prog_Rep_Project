<%--
  Created by IntelliJ IDEA.
  User: Sachouw
  Date: 13/04/2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <title>Spring MVC Application</title>

  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
  <link href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

<div class="container">
  <div class="row">
    Cette page s'affiche !
    <a href="/actions">
      <button type="button" class="btn btn-info" aria-label="Left Align">
        <span class="fa fa-plus" aria-hidden="true">&nbsp;Liste des actions ???</span>
      </button>
    </a>
  </div>
</div>

</body>
</html>

