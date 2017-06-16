<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp" />

<div class="page-header">
    <h1>Toutes les parties</h1>
</div>

<%-- Listing des parties --%>
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table table-hover table-striped table-bordered">
                <tr>
                    <th>Apprenant</th>
                    <th>Action</th>
                    <th>Score</th>
                    <th>Date</th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td><a href="/apprenants/detail/${item.apprenant.numapprenant}">${item.apprenant.nomapprenant} ${item.apprenant.prenomapprenant}</a></td>
                        <td><a href="/actions/detail/${item.action.numaction}">${item.action.libaction}</a></td>
                        <c:choose>
                            <c:when test="${item.action.scoremin > item.valeurfin}">
                                <td class="bad-grade">${item.valeurfin}/20</td>
                            </c:when>
                            <c:otherwise>
                                <td class="good-grade">${item.valeurfin}/20</td>
                            </c:otherwise>
                        </c:choose>
                        <td><fmt:formatDate value="${item.datejour}" pattern="yyyy-mm-dd"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../commun/footer.jsp" />
