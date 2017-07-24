<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<title>Korisnici</title>
</head>
<body>
<c:if test="${sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
<div id="srednji">
	<div id="sadrzaj">
		<table>
		<thead>
		<tr>
			<td>Korisnicko ime:</td>
			<td>Lozinka:</td>
			<td>Ime:</td>
			<td>Prezime:</td>
			<td>Tip korisnika:</td>
			
		</tr>
		</thead>
	<c:forEach items="${korisnici}" var="korisnik">

			<tr>
			<td>${korisnik.korisnickoIme }</td>
			<td>${korisnik.lozinka }</td>
			<td>${korisnik.ime }</td>
			<td>${korisnik.prezime }</td>
			<c:if test="${korisnik.tipKorisnika==1}">
			<td>Poslovodja</td>
			</c:if>
			<c:if test="${korisnik.tipKorisnika==2}">
			<td>Administrator</td>
			</c:if>
			<td><a href="./PrepareUpdateController?korId=${korisnik.korisnikId}">Izmeni</a></td>
			<c:if test="${admin.korisnickoIme!=korisnik.korisnickoIme }">
				<td><a href="./DeleteController?korId=${korisnik.korisnikId}">Obrisi</a></td>
			</c:if>
			
			
			</tr>
		
	</c:forEach>
	</table>
	<a id="naruci" href="./korisnikCreate.jsp">Dodaj Korisnika</a>
	</div>
</div>
</body>
</html>