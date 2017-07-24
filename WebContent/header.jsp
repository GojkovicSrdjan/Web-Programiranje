<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-2.1.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<c:set var="brojac" value="0"/>
 	<c:forEach items="${sessionScope.korpa }" var="k">
		<c:set var="brojac" value="${brojac+k.kolicina }"/>
	
	</c:forEach>
	
	<div id="header">
		<a href="./ReadController">
		<div id="logo">		
		<h1>Prodavnica knjiga</h1>
		<img src="images/bookstack.png" height="120" width="120" >
      </div>
       </a>
       
       
       <c:if test="${sessionScope.poslovodja!=null || sessionScope.admin!=null }">
       	<p id="login"><a href="./LogoutController"> Logout</a></p>
       	&nbsp;
       	<span id="login">${admin.korisnickoIme }</span>
		<span id="login">${poslovodja.korisnickoIme }</span>
       <div id="meni">
       <ul>
		<li><a href="./PrepareAddController">Dodaj knjigu</a></li>
		<c:if test="${sessionScope.admin != null }">
		<li><a href="./ReadControllerKorisnik">Korisnici</a></li>
		</c:if>
		<li><a href="./ReadControllerPorudzbina">Porudzbine</a></li>
		<li><a href="./IzvestajController">Izvestaji</a></li>

		</ul>
		</div>
		
    </c:if>
    
    <c:if test="${sessionScope.poslovodja==null && sessionScope.admin==null }">
    	<p id="login"><a id="Prijava" href="#">Login</a></p>
    <c:if test="${sessionScope.korpa==null }">
    <div id="korpa">
    	<img src="images/empty.png" width="115px" height="115px">
    	<p >Vasa korpa je prazna</p>
    </div>
    </c:if>
    <c:if test="${sessionScope.korpa!=null }">
     <a href="./ReadControllerShoppingCart">
    	<div id="korpa">
    		<img src="images/full.png" width="115px" height="115px">
    		<p>Broj knjiga u korpi: <c:out value="${brojac }"/> </p>
    	</div>
    </a>
    </c:if>
    	
    </c:if>
    
    <div id="overlay">
		
        
			<form action="./LoginContorller" method="post" id="login">
                <table id="loginTable">
				<thead>
				<tr>
				 <th colspan="2">
					<img src="images/close.png" id="close" height="30px" width="30px"/></tr>
					</th>
					</thead>
                    <tr>
                        <td class="belo">Username</td>
                        <td><input type="text" name="username" required></td>
                    </tr>
                    <tr>
                        <td class="belo">Password</td>
                        <td><input type="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input id="submit" type="submit" value="Prijavi se"/></td>
                    </tr>
                </table>
            </form>
		
		</div>
    </div>
   	
	
	
		<script>
		$("#Prijava").click(function(e){
			$("#login").trigger('reset');
				$("#overlay").slideToggle(500);
		
		});
		
		$("#close").click(function(e){
				$("#overlay").hide();
		
		});
		</script>
    
    
</body>
</html>