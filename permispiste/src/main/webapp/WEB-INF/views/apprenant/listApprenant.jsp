
<jsp:include page="../commun/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Liste des Apprenants</h1>

<a href="/apprenants/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un nouvel apprenant</a>

<%-- Listing des Apprenants --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Apprenants actuellement inscrits :</caption>
                <tr>
                    <td>Nom</td>
                    <td>Pr&eacute;nom</td>
                    <td></td>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.nomapprenant}</td>
                        <td>${item.prenomapprenant}</td>
                        <td>
                            <a href="/apprenants/detail/${item.numapprenant}">
                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                    <span class="fa fa-pencil" aria-hidden="true"></span>
                                </button>
                            </a>
                            <a href="/apprenants/delete/${item.numapprenant}" class="btn btn-danger">
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
