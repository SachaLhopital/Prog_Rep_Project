<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Missions de ${trainee.prenomapprenant} ${trainee.nomapprenant}</h1>
</div>

<%-- Listing des Missions --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Missions :</caption>
                <th>
                    <td>Jeux</td>
                    <td>Intitul&eacute; de la mission</td>
                </th>
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
