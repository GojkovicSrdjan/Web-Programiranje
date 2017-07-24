<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<title>Izmena korisnika</title>
</head>
<body>
<c:if test="${sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
<div id="srednji">
<div id="sadrzaj">
		<form action="./UpdateControllerKorisnik" method="post">
		<table>
			<tr>
				<td>Ime korisnika</td>
				<td><input type="text" name="ime" value="${korisnik.ime }"></td>
			</tr>
			<tr>
				<td>Prezime korisnika</td>
				<td><input type="text" name="prezime" value="${korisnik.prezime }"></td>
			</tr>
			<tr>
				<td>Korisnicko ime</td>
				<td><input type="text" name="korIme" value="${korisnik.korisnickoIme }" required></td>
			</tr>
			<tr>
				<td>Lozinka</td>
				<td><input type="text" name="lozinka" value="${korisnik.lozinka }" required></td>
			</tr>
			<tr>
				<td>Tip korisnika</td>
				<td><select name="tip">
					<option value="2">Administrator</option>
					<option value="1">Poslovodja</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${korisnik.korisnikId }" ></td>
				<td><input id="dodaj" type="submit" name="submit" value="Izmeni"/></td>				
			</tr>
		</table>
	</form>
	</div>
</div>
</body>
</html>