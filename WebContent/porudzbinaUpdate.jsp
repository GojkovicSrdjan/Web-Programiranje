<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<title>Izmena porudzbine</title>
</head>
<body>
<c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
<div id="srednji">
<div id="sadrzaj">
	<form action="./UpdateControllerPorudzbina" method="post">
		<table>
			<tr>
				<td>Ime kupca</td>
				<td>${porudzbina.kupacIme}</td>
			</tr>
				<tr>
				<td>Prezime kupca</td>
				<td>${porudzbina.kupacPrezime}</td>
			</tr>
			<tr>
				<td>Kupac adresa</td>
				<td>${porudzbina.kupacAdresa}</td>
			</tr>
			<tr>
				<td>Datum</td>
				<td>${porudzbina.datum}</td>
			</tr>
			<tr>
				<td>Iznos</td>
				<td>${porudzbina.iznos}</td>
			</tr>
			<tr>
				<td>Status porudzbine</td>
				<td><select name="status" >
				<option value="1"<c:if test="${porudzbina.status==1 }">selected="selected"</c:if>>Naruceno</option>
				<option value="2" <c:if test="${porudzbina.status==2 }">selected="selected"</c:if>>Poslato</option>
				<option value="3"<c:if test="${porudzbina.status==3 }">selected="selected"</c:if>>Isporuceno</option>
				<%-- <option value="4"<c:if test="${porudzbina.status==4 }">selected="selected"</c:if>>Otkazano</option> --%>
			</select></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${porudzbina.porudzbinaId }" name="pId"></td>
				<td><input id="dodaj" type="submit" value="Izmeni"></td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>