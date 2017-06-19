<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../commun/header.jsp" />

<div class="panel panel-primary">

    <div class="panel-heading">Selection d'un Appremant</div>

    <form name='identification' method="post" action="/simulations/verif_user/" onsubmit="return teste()">
        <div class="panel-body">
            <div class="form-group">
                <label for="apprenant">Selectionner un apprenant</label>
                <select id="apprenant" name="num_apprenant">
                    <c:forEach var="apprenant" items="${apprenants}">
                        <option value="${apprenant.numapprenant}">${apprenant.nomapprenant} ${apprenant.prenomapprenant}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                ${messageErreur}
            </div>
        </div>
        <div class="panel-footer">
            <button type="submit" name="bt" class="btn btn-primary">Etape suivante</button>
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