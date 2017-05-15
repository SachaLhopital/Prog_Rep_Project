
<jsp:include page="/includes/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

</h1>${pageTitle}<h1>

<%-- Listing des Jeux --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            ${list}
            <table class="table table-hover table-striped table-bordered">
                <caption>Jeux disponibles pour un entrainement</caption>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.libelleJeu}</td>
                        <td>
                            <a href="/games/lancer/${item.numjeu}">
                                <button type="button" class="btn btn-info" aria-label="Left Align">
                                    <span class="fa fa-play-circle-o" aria-hidden="true"></span>
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
<jsp:include page="/includes/footer.jsp" />
