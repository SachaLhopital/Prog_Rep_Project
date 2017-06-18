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

                <li class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle"
                                    id="dropdownApprenant"
                                    data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="true">
                                <span class="fa fa-user"></span>&nbsp;Apprenants
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownApprenant">
                                <li><a href="/apprenants/">Liste</a></li>
                                <li><a href="/actions/apprenant/all/">Historique des Parties</a></li>
                                <li><a href="/inscrits/">Inscriptions</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle"
                                    id="dropdownJeux"
                                    data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="true">
                                <span class="fa fa-gamepad"></span>&nbsp;Jeux
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownApprenant">
                                <li><a href="/games/">Liste complète</a></li>
                                <li><a href="/missions/">Missions</a></li>
                                <li><a href="/actions/">Actions</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <div id="page-wrapper">
            <div class="container-fluid">