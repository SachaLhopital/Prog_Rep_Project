<jsp:include page="../commun/header.jsp"/>

<div class="panel panel-primary">

    <div class="panel-heading">Formulaire d'apprenant</div>

    <form name='identification' method="post" action="${actionSubmit}" onsubmit="return teste()">
        <input type="hidden" name="txtNum" value="${apprenant.numapprenant}">
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3">Nom :</label>
                <input type="text" name="txtNom" value="${apprenant.nomapprenant}" id="nom">
            </div>
            <div class="form-group">
                <label class="col-sm-3">Pr&eacute;nom :</label>
                <input type="text" name="txtPrenom" value="${apprenant.prenomapprenant}" id="prenom">
            </div>
            <div class="panel-footer">
                <button type="submit" name="bt" class="btn btn-primary">Enregistrer</button>
            </div>
        </div>
    </form>
</div>

<SCRIPT language="Javascript" type="text/javascript">
    function teste() {
        if (document.identification.txtPrenom.value == "" && document.identification.txtNom.value == "") {
            alert("Veuillez saisir tous les champs.")
            return false;
        }
        return true;
    }
</script>

<%@include file="../commun/footer.jsp" %>