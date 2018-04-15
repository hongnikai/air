<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<script src="${ctx }/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="${ctx }/js/validate.js" type="text/javascript"></script>
<script src="${ctx }/js/checkform.js" type="text/javascript"></script>
<script src="${ctx }/js/autocheckform.js" type="text/javascript"></script>
<script src="${ctx }/js/checkAll.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/page.css">

<%
	String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
	application.setAttribute("picturePath", picturePath);
%>
<c:set var="picturePath" value="${picturePath}"></c:set>