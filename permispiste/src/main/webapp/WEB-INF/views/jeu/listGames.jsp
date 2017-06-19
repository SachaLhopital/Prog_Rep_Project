<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp"/>
<c:set var="numeroJeu" value="0"/>

<div class="page-header">
    <h1>Jeux disponibles</h1><small> Jeux disponibles pour un entrainement</small>
</div>

<a href="/games/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un nouveau jeu</a>

</br></br>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-info alert-dismissable">
            <i class="fa fa-info-circle"></i> Cliquez sur un jeu pour afficher les missions et objectifs associés.
        </div>
    </div>
</div>

<c:forEach var="inscrit" items="${list}">
    <c:set var="numeroJeu" value="${numeroJeu + 1}"/>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading" data-toggle="collapse" data-target="#jeu${numeroJeu}">
                    <div class="row">
                        <h2 class="panel-title">
                                &nbsp;${inscrit.key.libellejeu} <span class="fa fa-caret-down pull-right"></span>&nbsp;
                        </h2>
                    </div>
                </div>
                <div class="panel-body collapse" id="jeu${numeroJeu}">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Mission</th>
                                <th>Objectifs Fixés</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="mission" items="${inscrit.value}">
                                <tr>
                                    <td>${mission.key.libmission}</td>
                                    <td>
                                        <table class="table table-bordered table-hover table-striped">
                                            <tbody>
                                            <c:forEach var="objectif" items="${mission.value}">
                                                <tr>
                                                    <td>
                                                        <a href="/actions/objectif/${objectif.numobjectif}">
                                                            ${objectif.libobjectif}
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <ul>
                                                        <c:forEach var="estAssocie" items="${objectif.estAssocie}">
                                                            <li>${estAssocie.action.libaction}</li>
                                                        </c:forEach>
                                                        </ul>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="text-right">
                        <a href="/missions/add/${inscrit.key.numjeu}">
                            <button type="button" class="btn btn-info" aria-label="Left Align">
                                <span class="fa fa-play-circle-o" aria-hidden="true"></span>
                            </button>
                        </a>
                        <a href="/games/detail/${inscrit.key.numjeu}">
                            <button type="button" class="btn btn-info" aria-label="Left Align">
                                <span class="fa fa-pencil" aria-hidden="true"></span>
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
<jsp:include page="../commun/footer.jsp"/>
