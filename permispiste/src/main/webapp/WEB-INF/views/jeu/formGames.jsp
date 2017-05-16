<jsp:include page="../commun/header.jsp" />

<div class="panel panel-primary">

    <div class="panel-heading">Formulaire de jeu</div>

    <form name='identification' method="post" action="${actionSubmit}" onsubmit="return teste()">
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3">Libellé :</label>
                <input type="text" name="txtlibelle" value="${jeu.libelleJeu}" id ="libelle">
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
        return true;
    }
</script>

<%@include file="../commun/footer.jsp"%>