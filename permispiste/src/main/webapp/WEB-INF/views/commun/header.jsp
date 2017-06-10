<%--
  Created by IntelliJ IDEA.
  User: lafay
  Date: 15/05/2017
  Time: 08:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Liscence T Learning</title>
    <link rel="stylesheet" href="/includes/template/css/bootstrap.min.css">
    <link rel="stylesheet" href="/includes/template/css/sb-admin.css">
    <link rel="stylesheet" href="/includes/template/font-awesome/css/font-awesome.min.css">
</head>
<body>

    <div class="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Licence T Learning</a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/apprenants/"><span class="fa fa-user"></span>&nbsp;Gestion des Apprenants</a></li>
                        <li><a href="/games/"><span class="fa fa-gamepad"></span>&nbsp;Gestion des Le&ccedil;ons</a></li>
                        <li><a href="/missions/"><span class="fa fa-list-alt"></span>&nbsp;Historique des Missions</a></li>
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <div id="page-wrapper">
            <div class="container-fluid">