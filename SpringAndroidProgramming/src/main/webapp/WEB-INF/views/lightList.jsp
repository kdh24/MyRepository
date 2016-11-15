<%@ page contentType="application/json; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="light" items="${list}" varStatus="status">
	{
		"image":"${light.image}",
		"imageLarge":"${light.imageLarge}",
		"title":"${light.title}",
		"content":"${light.content}"
	}
	<c:if test="${!status.last}">,</c:if>
	
</c:forEach>
]