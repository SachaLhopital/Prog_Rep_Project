<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Jeux disponibles</h1>
</div>

<a href="/games/add/" class="btn btn-default"><span class="fa fa-plus"></span>Ajouter un nouveau jeu</a>

<%-- Listing des Jeux --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Jeux disponibles pour un entrainement :</caption>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.libellejeu}</td>
                        <td>
                            <a href="/missions/add/${item.numjeu}">
                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                    <span class="fa fa-play-circle-o" aria-hidden="true"></span>
                                </button>
                            </a>
                            <a href="/games/detail/${item.numjeu}">
                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                    <span class="fa fa-pencil" aria-hidden="true"></span>
                                </button>
                            </a>
                            <a href="/games/delete/${item.numjeu}">
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
