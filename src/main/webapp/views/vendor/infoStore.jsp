<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/image?fname=${store.avatar}" var="imgUrl"></core:url>
<img src="${imgUrl}" class="rounded-circle" style="width: 150px;" alt="Avatar"/>
<p>${store.name}</p>
<p>${store.bio}</p>