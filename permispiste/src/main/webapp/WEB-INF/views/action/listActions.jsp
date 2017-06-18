<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp"/>

<div class="page-header">
    <h1>Toutes les actions</h1>
</div>

<a href="/actions/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter une nouvelle action</a>

<%-- Listing des Missions --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <caption>Actions :</caption>
                <tr>
                    <th>Action</th>
                    <th>Score minimal</th>
                </tr>
                <c:forEach var="inscrit" items="${list}">
                    <tr>
                        <td>${inscrit.libaction}</td>
                        <td>${inscrit.scoremin}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp"/>
