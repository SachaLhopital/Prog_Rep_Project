<jsp:include page="../commun/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>${pageTitle}</h1>

<a href="/trainees/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un apprenant</a>

<%-- Listing des Apprenants --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Liste des apprenants</caption>
                <tr>
                    <th>Num&eacute;ro</th>
                    <th>Nom</th>
                    <th>Pr&eacute;nom</th>
                    <th>Modifer/Supprimer</th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.numapprenant}</td>
                        <td>${item.nomapprenant}</td>
                        <td>${item.prenomapprenant}</td>
                        <td>
                            <a href="/trainees/detail/${item.numapprenant}" class="btn btn-info"><span class="fa fa-pencil"></span></a>
                            <a href="/trainees/delete/${item.numapprenant}" class="btn btn-danger"><span class="fa fa-times"></span></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp"/>
