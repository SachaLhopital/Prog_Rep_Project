<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Missions disponibles</h1>
</div>

<%-- Listing des Jeux --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <tr>
                    <th>Jeux</th>
                    <th>Intitul&eacute; de la mission</th>
                </tr>
                <c:forEach var="inscrit" items="${list}">
                    <tr>
                        <td>${inscrit.game.libellejeu}</td>
                        <td>${inscrit.libmission}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp" />
