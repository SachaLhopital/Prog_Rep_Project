<%--
  Created by IntelliJ IDEA.
  User: Sachouw
  Date: 14/06/2017
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>

<div class="page-header">
    <h1>Inscriptions aux Jeux</h1>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-info alert-dismissable">
            <i class="fa fa-info-circle"></i> Visualisez les inscriptions passées en cliquant sur <span class="fa fa-history" aria-hidden="true"></span>
        </div>
    </div>
</div>

<%-- Listing des Inscrits --%>
<div>
    <ul class="nav nav-tabs" id="myTabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true" style="">Prochains candidats</a>
        </li>
        <li role="presentation" class="">
            <a href="#history" role="tab" id="history-tab" data-toggle="tab" aria-controls="history" style="" aria-expanded="false">
                <span class="fa fa-history" aria-hidden="true"></span>
            </a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade active in" role="tabpanel" id="home">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-bordered">
                            <tr>
                                <th>Nom</th>
                                <th>Pr&eacute;nom</th>
                                <th>Jeu</th>
                                <th></th>
                            </tr>
                            <c:forEach var="apprenant" items="${list}">
                                <c:if test = "${apprenant.datejour > now}">
                                    <tr>
                                        <td>${apprenant.apprenant.nomapprenant}</td>
                                        <td>${apprenant.apprenant.prenomapprenant}</td>
                                        <td>${apprenant.jeu.libellejeu}</td>
                                        <td>
                                            <a href="/apprenants/">
                                                <button type="button" class="btn btn-primary" aria-label="Left Align">
                                                    <span class="fa fa-user" aria-hidden="true"></span>
                                                </button>
                                            </a>
                                            <a href="/games/">
                                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                                    <span class="fa fa-gamepad" aria-hidden="true"></span>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" role="tabpanel" id="history">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-bordered">
                            <tr>
                                <th>Nom</th>
                                <th>Pr&eacute;nom</th>
                                <th>Jeu</th>
                                <th>Date</th>
                                <th></th>
                            </tr>
                            <c:forEach var="apprenant" items="${list}">
                                <c:if test = "${apprenant.datejour < now}">
                                    <tr>
                                        <td>${apprenant.apprenant.nomapprenant}</td>
                                        <td>${apprenant.apprenant.prenomapprenant}</td>
                                        <td>${apprenant.jeu.libellejeu}</td>
                                        <td>${apprenant.datejour}</td>
                                        <td>
                                            <a href="/apprenants/">
                                                <button type="button" class="btn btn-primary" aria-label="Left Align">
                                                    <span class="fa fa-user" aria-hidden="true"></span>
                                                </button>
                                            </a>
                                            <a href="/games/">
                                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                                    <span class="fa fa-gamepad" aria-hidden="true"></span>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../commun/footer.jsp" />

