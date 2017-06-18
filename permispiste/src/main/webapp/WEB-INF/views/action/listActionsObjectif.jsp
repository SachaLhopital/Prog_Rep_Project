<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Actions requises pour l'objectif "${objectif.libobjectif}"</h1>
</div>

<%-- Listing des parties --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <tr>
                    <th>Action</th>
                </tr>
                <c:forEach var="inscrit" items="${list}">
                    <tr>
                        <td><a href="/actions/detail/${inscrit.action.numaction}">${inscrit.action.libaction}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp" />
