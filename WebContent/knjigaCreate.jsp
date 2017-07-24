<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<script src="js/script.js"></script>
<script src="js/jquery-2.1.0.min.js"></script>
<title>Dodavanje knjige</title>
</head>
<body>
<c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
	<div id="srednji">
	<div id="sadrzaj">
	<form action="./AddControllerKnjiga" method="post">
		<table>
			<tr>
				<td>Naziv knjige </td>
				<td><input type="text" name="naziv" required></td>
			</tr>
			<tr>
				<td>Izdavac </td>
				<td><input type="text" name="izdavac" ></td>
			</tr>
			
			<tr>
				<td>Autor knjige </td>
				<td><input type="text" name="autor" required></td>
			</tr> 
			
			<tr>
				<td>Godina izdanja </td>
				<td><input type="text" onkeypress="return isNumberKey(event)" name="godIzdanja"></td>
			</tr>
			
			<tr>
				<td>Opis knjige </td>
				<td><textarea type="text" name="opis" rows="4" cols="40"></textarea></td>
			</tr>
			<tr>
				<td>Kategorija </td>
				<td>
				<select name="kategorija">
					<c:forEach items="${kategorije}" var="kategorija">
						<option value="${kategorija.kategorijaId}">${kategorija.nazivKategorije}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			
			<tr>
				<td>Raspoloziva kolicina knjige </td>
				<td><input type="text" name="raspolozivaKolicina" onkeypress="return isNumberKey(event)" required></td>
			</tr>
			
			<tr>
				<td>Cena knjige </td>
				<td><input type="text" name="cena" onkeypress="return isNumberKey(event)" required></td>
			</tr>

			<tr>
				<td>Slika </td>
				<td><input type="file"  name="slika"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input id="dodaj" type="submit" name="submit" value="Dodaj"/></td>				
			</tr>
			
		</table>
	</form>
	</div>
	</div>
</body>
</html>