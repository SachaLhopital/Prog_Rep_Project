<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp"/>

<div class="page-header">
    <h1>Jeux disponibles</h1>
    <small> Jeux disponibles pour un entrainement</small>
</div>

<a href="/games/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un nouveau jeu</a>

</br></br>

<c:forEach var="apprenant" items="${list}">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${apprenant.key.libellejeu}</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Mission</th>
                                <th>Objectifs Fixés</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="mission" items="${apprenant.value}">
                                <tr>
                                    <td>${mission.key.libmission}</td>
                                    <td>
                                        <ul>
                                            <c:forEach var="objectif" items="${mission.value}">
                                                <li>
                                                    <a href="/actions/objectif/${objectif.numobjectif}">${objectif.libobjectif}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="text-right">
                        <a href="/missions/add/${apprenant.key.numjeu}">
                            <button type="button" class="btn btn-info" aria-label="Left Align">
                                <span class="fa fa-play-circle-o" aria-hidden="true"></span>
                            </button>
                        </a>
                        <a href="/games/detail/${apprenant.key.numjeu}">
                            <button type="button" class="btn btn-info" aria-label="Left Align">
                                <span class="fa fa-pencil" aria-hidden="true"></span>
                            </button>
                        </a>
                        <a href="/games/delete/${apprenant.key.numjeu}">
                            <button type="button" class="btn btn-danger" aria-label="Left Align">
                                <span class="fa fa-times" aria-hidden="true"></span>
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
<jsp:include page="../commun/footer.jsp"/>
