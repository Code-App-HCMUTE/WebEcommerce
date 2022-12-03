<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/templates/admin" var="URL"></core:url>
<core:forEach items="${stores}" var="kq">
	<p>Store: ${kq.name}</p>
	<core:url value="/image?fname=${kq.avatar}" var="imgUrl"></core:url>
	<td><img height="150" width="200" src="${imgUrl}" /></td>
</core:forEach>

