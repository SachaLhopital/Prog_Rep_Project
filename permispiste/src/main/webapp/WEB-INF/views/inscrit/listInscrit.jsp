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
    </div>
</div>

<%-- Listing des Inscrits --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Apprenants inscrit pour aujourd'hui :</caption>
                <tr>
                    <th>Nom</th>
                    <th>Pr&eacute;nom</th>
                    <th>Jeu</th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <c:if test = "${item.datejour lt now}">
                        <tr>
                            <td>${item.apprenant.nomapprenant}</td>
                            <td>${item.apprenant.prenomapprenant}</td>
                            <td>${item.jeu.libellejeu}</td>
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
<jsp:include page="../commun/footer.jsp" />

