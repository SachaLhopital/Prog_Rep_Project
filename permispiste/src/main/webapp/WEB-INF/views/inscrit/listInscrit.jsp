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

<div class="page-header">
    <h1>Inscriptions aux Jeux</h1>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-info alert-dismissable">
            <i class="fa fa-info-circle"></i> Visualisez les inscriptions passées en cliquant sur <span class="fa fa-history" aria-hidden="true"></span>
        </div>
        <div class="alert alert-info">
            <i class="fa fa-info-circle"></i>
            Visualisez les détails d'un apprenant en cliquant sur <span class="fa fa-user"></span>
        </div>
        <div class="alert alert-info">
            <i class="fa fa-info-circle"></i>
            Visualisez les détails d'un jeu en cliquant sur <span class="fa fa-gamepad"></span>
        </div>
    </div>
</div>

<%-- Listing des Inscrits --%>
<div>
    <ul class="nav nav-tabs" id="myTabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">
                Prochains candidats
            </a>
        </li>
        <li role="presentation" class="">
            <a href="#history" role="tab" id="history-tab" data-toggle="tab" aria-controls="history" aria-expanded="false">
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
                                <th>Nom - Prénom</th>
                                <th>Jeu</th>
                            </tr>
                            <c:forEach var="inscrit" items="${list}">
                                <c:if test = "${inscrit.datejour > now}">
                                    <tr>
                                        <td>
                                            <a href="/apprenants/detail/${inscrit.apprenant.numapprenant}">
                                                <span class="fa fa-user" aria-hidden="true"></span>
                                            </a>
                                                ${inscrit.apprenant.nomapprenant} ${inscrit.apprenant.prenomapprenant}
                                        </td>
                                        <td>
                                            <a href="/games/detail/${inscrit.jeu.numjeu}">
                                                <span class="fa fa-gamepad" aria-hidden="true"></span>
                                            </a>
                                                ${inscrit.jeu.libellejeu}
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
                                <th>Nom - Pr&eacute;nom</th>
                                <th>Jeu</th>
                                <th>Date</th>
                            </tr>
                            <c:forEach var="inscrit" items="${list}">
                                <c:if test = "${inscrit.datejour < now}">
                                    <tr>
                                        <td>
                                            <a href="/apprenants/detail/${inscrit.apprenant.numapprenant}">
                                                <span class="fa fa-user" aria-hidden="true"></span>
                                            </a>
                                                ${inscrit.apprenant.nomapprenant} ${inscrit.apprenant.prenomapprenant}
                                        </td>
                                        <td>
                                            <a href="/games/detail/${inscrit.jeu.numjeu}">
                                                <span class="fa fa-gamepad" aria-hidden="true"></span>
                                            </a>
                                                ${inscrit.jeu.libellejeu}
                                        </td>
                                        <td><fmt:formatDate value="${inscrit.datejour}" pattern="yyyy-MM-dd"/></td>
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

