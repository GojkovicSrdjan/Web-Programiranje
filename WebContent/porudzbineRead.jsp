<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<title>Porudzbine</title>
</head>
<body>
<c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
	<div id="srednji">
	<div id="sadrzaj">
	<div id="por">
<table>
<thead>
	<tr>
		<td>Kupac ime:</td>
		<td>Kupac prezime:</td>
		<td>Kupac adresa:</td>
		<td>Status:</td>
		<td>Datum:</td>
		<td>Iznos:</td>
		
	</tr>
</thead>
<c:forEach items="${porudzbine }" var="p">
	<tr>
		<td>${p.kupacIme }</td>
		<td>${p.kupacPrezime }</td>
		<td>${p.kupacAdresa }</td>
		<td>
		<c:if test="${p.status==1 }">Naruceno</c:if>
		<c:if test="${p.status==2 }">Poslato</c:if>
		<c:if test="${p.status==3 }">Isporuceno</c:if>
		<c:if test="${p.status==4 }">Otkazano</c:if>
		</td>
		<td>${p.datum }</td>
		<td>${p.iznos }</td>
		<td><a href="./PrepareUpdateController?porudzbinaId=${p.porudzbinaId }">Izmeni</a></td>
	</tr>	
</c:forEach>


</table>
	</div>
	</div>
	<div id="status">
		<p>Prikazi porudzbine po statusu</p>
	<ul>
		<li><a href="./ReadControllerPorudzbina?status=${1}">Naruceno</a></li>
		<li><a href="./ReadControllerPorudzbina?status=${2}">Poslato</a></li>
		<li><a href="./ReadControllerPorudzbina?status=${3}">Isporuceno</a></li>
		<li><a href="./ReadControllerPorudzbina?status=${4}">Otkazano</a></li>
		<li><a href="./ReadControllerPorudzbina">Prikazi Sve</a></li>
		
		
	</ul>
	</div>
	</div>
</body>
</html>