<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/webjars/jquery/2.0.3/jquery.min.js" var="jQuery"/>
<script src="${jQuery}"></script>
<spring:url value="/webjars/bootstrap/3.0.2/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<spring:url value="/webjars/bootstrap/3.0.2/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>