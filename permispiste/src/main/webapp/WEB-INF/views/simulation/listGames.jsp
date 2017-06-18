<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../commun/header.jsp"/>
<c:set var="numeroJeu" value="0"/>

<div class="page-header">
    <h1>Jeux disponibles</h1><small> Jeux disponibles pour un entrainement</small>
</div>

<a href="/games/add/" class="btn btn-default"><span class="fa fa-plus"></span> Ajouter un nouveau jeu</a>


</br></br>

<form name='selectionJeu' method="post" action="/simulations/select_game" onsubmit="return teste()">
    <div class="panel-body">
        <div class="form-group">
            <input type="hidden" value="${num_apprenant}" name="num_apprenant">
            <label for="jeu">Selectionner un jeu</label>
            <select id="jeu" name="num_jeu">
                <c:forEach var="jeu" items="${jeux}">
                    <option value="${jeu.numjeu}">${jeu.libellejeu}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="panel-footer">
        <button type="submit" name="bt" class="btn btn-primary">Valider</button>
    </div>

</form>

<jsp:include page="../commun/footer.jsp"/>
