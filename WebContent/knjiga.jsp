<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" >
<title>Knjiga</title>
</head>
<body>
<c:import url="header.jsp"/>
<c:if test="${knjiga.stanjeKnjige!=false }">
	<div id="srednji">
	<div id="slika">
	<c:if test="${knjiga.slikaURL==null}">
		<img src="images/books/100.jpg" width="140px" height="230px" /><br>
		</c:if>
		<c:if test="${knjiga.slikaURL!=null}">
		<img src="${knjiga.slikaURL}" width="140px" height="230px"/><br>
	</c:if>
	
	</div>
	<div id="podaci">
	<p>Naziv: ${knjiga.nazivKnjige }</p>
	<p>Autor: ${knjiga.autor }</p>
	<p>Izdavac: ${knjiga.izdavac }</p>
	<p>Godina izdanja: ${knjiga.godinaIzdanja }</p>
	<p>Cena: ${knjiga.cena }</p>
	<c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
	<br><a id="dodajUKorpu" href="./ShoppingCartController?knjigaId=${knjiga.knjigaId}">Dodaj u korpu</a>
	</c:if>
	
	</div>
	<div id="opis">
	Opis:<br> ${knjiga.opis }
	</div>
	
	</div>
	</c:if>	
</body>
</html>