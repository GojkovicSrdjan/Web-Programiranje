<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/script.js"></script>
<link rel="stylesheet" type="text/css" href="styles/style.css" >
<title>Korpa</title>
</head>
<body>
<c:if test="${sessionScope.poslovodja!=null || sessionScope.admin!=null }">
	<c:redirect url="./ReadController"/>
</c:if>
<c:import url="header.jsp"/>

	<div id="srednji">
	<div id="sadrzaj">
<c:if test="${sessionScope.korpa!=null }">
<form action="./ShoppingCartController">
	<table>
	<thead>
	<tr>
	<td>&nbsp;</td>
	<td>Naziv:</td>
	<td>Autor:</td>
	<td>Kolicina:</td>
	<td>Iznos:</td>
	</tr>
	</thead>
	<tbody>
	<c:set var="ukupnaCena" value="0"/>
	<c:set var="ukupnaKolicina" value="0"/>
	<c:set var="brojac" value="0"/>
	
	
	<c:forEach items="${sessionScope.korpa }" var="s" varStatus="kolicina">
	<c:forEach items="${knjige }" var="k">
	<c:if test="${s.knjigaId==k.knjigaId }">
	<tr>
		<td>&nbsp;</td>
		<td>${k.nazivKnjige }</td>
		<td>${k.autor }</td>
		<td><input type="text" size="1" name="kol${kolicina.index }" value="${s.kolicina }" onkeypress="return isNumberKey(event)"></td>
		<c:set var="ukupnaKolicina" value="${ukupnaKolicina+s.kolicina }"/>
		<td>${k.cena }</td>
		<c:set var="ukupnaCena" value="${ukupnaCena+k.cena }" />
		<td><a href="./ShoppingCartController?stavka=${k.knjigaId }">Izbaci iz korpe</a></td>
		<c:set var="brojac" value="${brojac+1 }"/>
		
	</tr>
	</c:if>
	</c:forEach>
	</c:forEach>
	
<%-- 	<c:forEach items="${sessionScope.korpa }" var="s" varStatus="kolicina">

	<tr>
		<td>${s.knjiga.nazivKnjige }</td>
		<td>${s.knjiga.autor }</td>
		<td><input type="text" size="1" name="kol${kolicina.index }" value="${s.kolicina }"></td>
		<c:set var="ukupnaKolicina" value="${ukupnaKolicina+s.kolicina }"/>
		<td>${s.knjiga.cena }</td>
		<c:set var="ukupnaCena" value="${ukupnaCena+s.knjiga.cena }" />
		<td><a href="./ShoppingCartController?stavka=${s.knjiga.knjigaId }">Izbaci iz korpe</a></td>
		<c:set var="brojac" value="${brojac+1 }"/>
		
	</tr>

	</c:forEach> --%>
	
	
	</tbody>
	<tfoot>
	<tr>
	<td>Ukupno: </td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td><c:out value="${ukupnaKolicina }"/> </td>
	<td><c:out value="${ukupnaCena * ukupnaKolicina}"/> </td>
	</tr>
	</tfoot>
	
	</table>
	
	<input type="hidden" value="${brojac }" name="sveKnjige" >
	<input type="submit" value="Izmeni kolicinu" id="izmeni">
	</form>
	<a id="nastavi" href="./ReadController">Nastavi sa kupovinom</a><%-- 
	<a href="./ShoppingCartController?novaKolicina=${brojac }">Promeni kolicinu</a> --%>
	<a id="naruci" href="#" >Naruci</a>
	</c:if>
	<c:if test="${sessionScope.korpa==null }">
	<div id="prazna">
		<p>Vasa korpa je prazna!</p>
		<a href="./ReadController">Vratite se na pocetnu stranu</a>
	</div>
	</c:if>
	<div id="overlay1">
		
        
			<form action="./AddContorllerPorudzbina" method="post" id="porudzbina">
                <table>
				<thead>
				<tr>
				 <th colspan="2">
					<img src="images/close.png" id="close1" height="30px" width="30px"/></tr>
					</th>
					</thead>
                    <tr>
                        <td>Ime</td>
                        <td><input type="text" name="ime" required></td>
                    </tr>
                    <tr>
                        <td>Prezime</td>
                        <td><input type="text" name="prezime" required></td>
                    </tr>
                     <tr>
                        <td>Adresa</td>
                        <td><input type="text" name="adresa" required></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="ukupanIznos" value="${ukupnaCena * ukupnaKolicina}"></td>
                        <td><input id="posalji" name="submit" type="submit" value="Posalji"/></td>
                    </tr>
                </table>
            </form>
		
		</div>
	
		
	<script>
		$("#naruci").click(function(e){
			$("#porudzbina").trigger('reset');
				$("#overlay1").slideToggle(500);
		
		});
		
		$("#close1").click(function(e){
				$("#overlay1").hide();
		
		});
		</script>
		</div>
		
		</div>
		
		

</body>
</html>