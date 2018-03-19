<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <jsp:include page="Header.jsp" />
        
        <jsp:include page="Carousel.jsp" />
        <jsp:include page="GridActivities.jsp" />
    
      <br>
      <h1 id="horario" class="text-center">Horario</h1>
      <c:set var = "xmltext">
      <%@ include file="/WEB-INF/Horario.xml" %>
      </c:set>
      <c:import url = "http://localhost:8080/PlayFitHeroku/Main/StyleXSL.xsl" var = "xslt"/>
      <x:transform xml = "${xmltext}" xslt = "${xslt}"/>
      
      <br>
      <h1 id="cuotas" class="text-center">Cuotas</h1>
      <c:set var = "xmltext">
      <%@ include file="/WEB-INF/Cuotas.xml" %>
      </c:set>
      <c:import url = "http://localhost:8080/PlayFitHeroku/Main/StyleXSLCuotas.xsl" var = "xslt"/>
      <x:transform xml = "${xmltext}" xslt = "${xslt}"/>
      
      <jsp:include page="Footer.jsp" />
    </body>
</html>
