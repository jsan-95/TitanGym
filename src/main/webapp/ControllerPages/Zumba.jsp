<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <jsp:include page="/Main/Header.jsp" />
    
        <br>
        <div class="container-fluid w-75" style="border: solid">
            
            <h1>Zumba</h1>
            <p>
                Disciplina fitness creada a mediados de los años 90 por el colombiano Alberto 
                "Beto" Pérez,1​ enfocada por una parte a mantener un cuerpo saludable y por otra 
                a desarrollar, fortalecer y dar flexibilidad al cuerpo mediante movimientos de 
                baile combinados con una serie de rutinas aeróbicas.
            </p>
            
        </div>
    <br>
        <jsp:include page="/Main/GridActivities.jsp" />
        <br>
        <h1 id="horario" class="text-center">Horario</h1>
        <c:import url = "http://localhost:8080/PlayFitHeroku/Main/StyleXSL.xsl" var = "xslt"/>
        <x:transform xml = "<%=request.getAttribute("xml")%>" xslt = "${xslt}"/>
        <br>
        <h1 id="cuotas" class="text-center">Cuotas</h1>
        <c:import url = "http://localhost:8080/PlayFitHeroku/Main/StyleXSLCuotasStage2.xsl" var = "xslt"/>
        <x:transform xml = "<%=request.getAttribute("xmlTwoStep")%>" xslt = "${xslt}"/>
        <br>
        
        <jsp:include page="/Main/Footer.jsp" />
        
    </body>
</html>
