<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../commun/header.jsp" />

<div class="panel panel-primary">

    <div class="panel-heading">Formulaire d'Action</div>

    <form name='identification' method="post" action="${actionSubmit}">
        <input type="hidden" name="txtId" value="${action.numaction}">
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3">Libell&eacute; : </label>
                <input type="text" name="txtlibelle" value="${action.libaction}" id ="libelle">
            </div>
            <div class="form-group">
                <label class="col-sm-3">Score minimal : </label>
                <input type="text" name="txtscoremin" value="${action.scoremin}" id ="scoremin">
            </div>
            <div class="form-group">
                <label class="col-sm-3">Objectif associé : </label>
                <select name="objectif">
                    <c:forEach var="item" items="${listObjectifs}">
                        <option value="${item.numobjectif}">${item.libobjectif}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="panel-footer">
            <button type="submit" name="bt" class="btn btn-primary">Enregistrer</button>
        </div>
    </form>
</div>

<SCRIPT language="Javascript" type="text/javascript">
    function teste(){
        if(document.identification.txtlibelle.value == ""){
            alert("Veuillez entrer un libellé.")
            return false;
        }
        if(document.identification.txtscoremin.value == ""){
            alert("Veuillez entrer un score minimal.")
            return false;
        }
        return true;
    }
</script>

<%@include file="../commun/footer.jsp"%>