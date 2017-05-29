<%--
  Created by IntelliJ IDEA.
  User: lafay
  Date: 15/05/2017
  Time: 08:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Liscence T Learning</title>
    <link rel="stylesheet" href="/includes/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/includes/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>

    <div class="container">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/apprenants/"><span class="fa fa-user"></span>&nbsp;Gestion des Apprenants</a></li>
                        <li><a href="/games/"><span class="fa fa-gamepad"></span>&nbsp;Gestion des Le&ccedil;ons</a></li>
                        <li><a href="/missions/"><span class="fa fa-list-alt"></span>&nbsp;Historique des Missions</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>