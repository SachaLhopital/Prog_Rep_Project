<%--
  Created by IntelliJ IDEA.
  User: Sachouw
  Date: 13/04/2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Permis Piste</title>
</head>
<body>
<h2>Action Management Screen</h2>
ATTENTION NE FONCTIONNE PAS EN DBB A CAUSE DES CLEFS ETRANGERES : juste une test
<form:form method="post" action="add" commandName="action">
    <table>
        <tr>
            <td><form:label path="libaction"><spring:message code="label.libaction"/></form:label></td>
            <td><form:input path="libaction" /></td>
        </tr>
        <tr>
            <td><form:label path="scoremin"><spring:message code="label.scoremin"/></form:label></td>
            <td><form:input path="scoremin" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<h3>Actions</h3>
<c:if  test="${!empty actionList}">
    <table class="data">
        <tr>
            <th>libaction</th>
            <th>scoremin</th>
        </tr>
        <c:forEach items="${actionList}" var="action">
            <tr>
                <td>${action.libaction}</td>
                <td>${action.scoremin}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>