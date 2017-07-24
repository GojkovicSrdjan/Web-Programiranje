<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<title>Izvestaji</title>
</head>
<body>
<c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>
	
	<c:set var="brojacPorudzbina" value="0"/>
	<c:set var="naruceneKnjige" value="0"/>
	<c:set var="brojacIzvrsenihPorudzbina" value="0"/>
	<c:set var="brojacIsporucenihKnjiga" value="0"/>
	<c:set var="ukupanIznos" value="0"/>
	
	<c:forEach items="${porudzbine }" var="p">
	
		<c:forEach items="${p.naruceneKnjige}" var="k">
			<c:set var="naruceneKnjige" value="${naruceneKnjige + k.kolicina}"/>
			<c:if test="${p.status==3 }">
				<c:set var="brojacIsporucenihKnjiga" value="${brojacIsporucenihKnjiga + k.kolicina}"/>
			</c:if>
		</c:forEach>
		
		<c:set var="brojacPorudzbina" value="${brojacPorudzbina+1 }"/>
		
		<c:if test="${p.status==3 }">
			<c:set var="brojacIzvrsenihPorudzbina" value="${brojacIzvrsenihPorudzbina+1 }"/>
			<c:set var="ukupanIznos" value="${ukupanIznos + p.iznos}"/>
		</c:if>
		
	</c:forEach>
	
	<div id="srednji">
	<div id="sadrzaj">
	<table>
	<thead>
		<tr>
			<td>Broj porudzbina</td>
			<td>Broj narucenih knjiga</td>
			<td>Broj izvrsenih porudzbina</td>
			<td>Broj isporucenih knjiga</td>
			<td>Ukupna dobit</td>
			
		
		</tr>
	</thead>
	<tbody>
	 <tr>
	 <td>${brojacPorudzbina }</td>
	 <td>${naruceneKnjige }</td>
	 <td>${brojacIzvrsenihPorudzbina }</td>
	 <td>${brojacIsporucenihKnjiga }</td>
	 <td>${ukupanIznos }</td>
	 </tr>
	</tbody>
	</table>
	<form action="./IzvestajController">
	<select id="mesec" name="mesec">
		<option value="0">Januar</option>
		<option value="1">Februar</option>
		<option value="2">Mart</option>
		<option value="3">April</option>
		<option value="4">Maj</option>
		<option value="5">Jun</option>
		<option value="6">Jul</option>
		<option value="7">Avgust</option>
		<option value="8">Septembar</option>
		<option value="9">Oktobar</option>
		<option value="10">Novembar</option>
		<option value="11">Decembar</option>
	</select>
	<input id="dodaj" type="submit" value="Prikazi">
	</form>
	</div>
	</div>
</body>
</html>