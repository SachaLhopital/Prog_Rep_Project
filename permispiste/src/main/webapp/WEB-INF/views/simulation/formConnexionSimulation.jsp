<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:include page="../commun/header.jsp" />

<div class="panel panel-primary">

    <div class="panel-heading">Selection d'un Appremant</div>

    <form name='identification' method="post" action="/simulations/verif_user/" onsubmit="return teste()">
                <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3">Nom de l'apprenant </label>
                <input type="text" name="txtNom" value="" id ="nom">
            </div>
        </div>

        <div class="form-group">
            ${messageErreur}
        </div>

        <div class="panel-footer">
            <button type="submit" name="bt" class="btn btn-primary">Rechercher</button>
        </div>
    </form>
</div>

<SCRIPT language="Javascript" type="text/javascript">
    function teste(){
        if(document.identification.txtNom.value == ""){
            alert("Veuillez entrer un libellé.")
            return false;
        }
        return true;
    }
</script>

<%@include file="../commun/footer.jsp"%>