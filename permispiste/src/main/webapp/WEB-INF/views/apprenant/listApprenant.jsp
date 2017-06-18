<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Liste des Apprenants</h1>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-info alert-dismissable">
            <i class="fa fa-info-circle"></i> Visualisez les missions de l'apprenant en cliquant sur <span class="fa fa-list" aria-hidden="true"></span>
        </div>
    </div>
</div>

<a href="/apprenants/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un nouvel apprenant</a>

<%-- Listing des Apprenants --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Apprenants actuellement inscrits :</caption>
                <tr>
                    <th>Nom</th>
                    <th>Pr&eacute;nom</th>
                    <th></th>
                </tr>
                <c:forEach var="apprenant" items="${list}">
                    <tr>
                        <td>${apprenant.nomapprenant}</td>
                        <td>${apprenant.prenomapprenant}</td>
                        <td>
                            <a href="/actions/apprenant/${apprenant.numapprenant}">
                                <button type="button" class="btn btn-primary" aria-label="Left Align">
                                    <span class="fa fa-list" aria-hidden="true"></span>
                                </button>
                            </a>
                            <a href="/apprenants/detail/${apprenant.numapprenant}">
                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                    <span class="fa fa-pencil" aria-hidden="true"></span>
                                </button>
                            </a>
                            <a href="/apprenants/delete/${apprenant.numapprenant}" class="btn btn-danger">
                                <span class="fa fa-times"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp" />
