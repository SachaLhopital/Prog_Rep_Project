<jsp:include page="commun/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="alert alert-warning">
    <p class="text-center bg-danger"><c:out value="${messageErreur}" /></p>
</div>

<jsp:include page="commun/footer.jsp" />
