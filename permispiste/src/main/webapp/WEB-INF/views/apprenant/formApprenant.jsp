<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:include page="../commun/header.jsp" />

<div class="panel panel-primary">

    <div class="panel-heading">
        Formulaire des Apprenants
    </div>

    <form name='identification' method="post" action="${actionSubmit}" onsubmit="return teste()">
        <input type="hidden" name="txtId" value="${apprenant.numapprenant}">
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3">Nom : </label>
                <input type="text" name="txtnom" value="${apprenant.nomapprenant}" id ="nomapprenant">
            </div>
            <div class="form-group">
                <label class="col-sm-3">Pr&eacute;nom : </label>
                <input type="text" name="txtprenom" value="${apprenant.prenomapprenant}" id ="prenomapprenant">
            </div>
        </div>
        <div class="panel-footer">
            <button type="submit" name="bt" class="btn btn-primary">Sauvegarder</button>
        </div>
    </form>
    <ul class="list-group">
        <li class="list-group-item"><a href="/actions/apprenant/${apprenant.numapprenant}">Liste des parties</a></li>
    </ul>
</div>

<SCRIPT language="Javascript" type="text/javascript">
    function teste(){
        if(document.identification.txtnom.value == ""){
            alert("Veuillez entrer un nom.")
            return false;
        }
        if(document.identification.txtprenom.value == ""){
            alert("Veuillez entrer un prenom.")
            return false;
        }
        return true;
    }
</script>

<%@include file="../commun/footer.jsp"%>