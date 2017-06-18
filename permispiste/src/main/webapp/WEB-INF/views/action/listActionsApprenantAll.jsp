<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Toutes les parties</h1>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="alert alert-info">
            <i class="fa fa-info-circle"></i>
            Visualisez les détails de l'apprenant en cliquant sur <span class="fa fa-user" aria-hidden="true"></span>
        </div>
        <div class="alert alert-info">
            <i class="fa fa-info-circle"></i>
            Visualisez les détails d'une action en cliquant sur <span class="fa fa-dot-circle-o"></span>
        </div>
    </div>
</div>

<%-- Listing des parties --%>
<c:forEach var="inscrit" items="${list}">
    <c:choose>
        <c:when test="${empty inscrit.partiesJouees}">
            <caption>
                <a href="/apprenants/detail/${inscrit.numapprenant}">
                    <span class="fa fa-user" aria-hidden="true"></span>
                </a>
                    ${inscrit.nomapprenant} ${inscrit.prenomapprenant}
            </caption>
            <div class="alert alert-info">
                Cet apprenant n'a pas encore fait d'entrainement.
            </div>
        </c:when>
        <c:when test="${not empty inscrit.partiesJouees}">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-bordered">
                            <caption>
                                <a href="/apprenants/detail/${inscrit.numapprenant}">
                                    <span class="fa fa-user" aria-hidden="true"></span>
                                </a>
                                ${inscrit.nomapprenant} ${inscrit.prenomapprenant}
                            </caption>
                            <tr>
                                <th>Action</th>
                                <th>Score</th>
                                <th>Date</th>
                            </tr>
                            <c:forEach var="obtient" items="${inscrit.partiesJouees}">
                                <tr>
                                    <td>
                                        <a href="/actions/detail/${obtient.action.numaction}">
                                            <span class="fa fa-dot-circle-o"></span>
                                        </a>
                                            ${obtient.action.libaction}
                                    </td>
                                    <c:choose>
                                        <c:when test="${obtient.action.scoremin > obtient.valeurfin}">
                                            <td class="bad-grade">${obtient.valeurfin}/20</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="good-grade">${obtient.valeurfin}/20</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><fmt:formatDate value="${obtient.datejour}" pattern="yyyy-MM-dd"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </c:when>
    </c:choose>
</c:forEach>
<jsp:include page="../commun/footer.jsp" />
