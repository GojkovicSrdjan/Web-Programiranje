<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="model.beans.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" >
<title>Knjige</title>
</head>
<body>
<c:set var="brojac" value="0"/>
<c:import url="header.jsp"/>

	<div id="srednji">
	
	<div id="tabela">
	<table align="left">
	<tr>
	<c:forEach items="${knjige}" var="knjiga"  begin="0" end="9" >

	<c:if test="${brojac <=5 }">
	<td>
	
		<a href="./ReadController?knjigaId=${knjiga.knjigaId}">
		<c:if test="${knjiga.slikaURL==null}">
		<img src="images/books/100.jpg" width="115px" height="205px" /><br>
		</c:if>
		<c:if test="${knjiga.slikaURL!=null}">
		<img src="${knjiga.slikaURL}" width="100px" height="190px" /><br>
		</c:if>
			<h1>${knjiga.nazivKnjige}</h1>
			<h2>${knjiga.autor}</h2></a>
			
			<c:if test="${sessionScope.poslovodja!=null || sessionScope.admin!=null }">
			<a class="link" href="./PrepareUpdateController?knjigaId=${knjiga.knjigaId}">Izmeni</a><br>
			<a class="link" href="./DeleteController?knjigaId=${knjiga.knjigaId}" onclick="return confirm('Da li ste sigruni?')">Ukloni</a>
			</c:if>
	</td>
	<c:set var="brojac" value="${brojac+1 }"/>
	
	</c:if>
	
	<c:if test="${brojac==5 }">
		<tr></tr>
	<c:set var="brojac" value="0" />
	</c:if>
	
	</c:forEach>
	</tr>
	</table>
	</div>
	
	<div id="kategorije">
	<ul id="kategorijeLista">
		<c:forEach items="${kategorije}" var="kategorija">
		<li>
		<a href="./ReadController?kategorijaId=${kategorija.kategorijaId}">${kategorija.nazivKategorije}</a>
		</li>
		</c:forEach>
	</ul>
	</div>
	</div>


</body>
</html>