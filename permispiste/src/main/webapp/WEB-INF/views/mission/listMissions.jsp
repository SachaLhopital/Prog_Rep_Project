<jsp:include page="../commun/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>${pageTitle}</h1>

<h2>Une mission s'enregistre automatiquement lorsqu'un apprenant fait un jeu.</h2>

<%-- Listing des Jeux --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Historique des Missions :</caption>
                <tr>
                    <td>Jeux</td>
                    <td>Intitul&eacute; de la mission</td>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.game.libellejeu}</td>
                        <td>${item.libmission}</td>
                        <td>
                            <a href="/missions/delete/${item.nummission}">
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="fa fa-times" aria-hidden="true"></span>
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp" />
