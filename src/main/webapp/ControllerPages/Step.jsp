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
            
            <h1>Step</h1>
            <p>
                Uno de los diferentes tipos de aeróbic que existen. Es un programa dinámico que 
                consiste subir y bajar de un plataforma combinando pasos al ritmo de la música 
                de aerobic. Incluye una amplia variedad de patrones o ejercicios que se desarrollan
                con  la música. El body step y subir escaleras no son ejercicios nuevos en el campo
                del entrenamiento físico, sin embargo sí lo es su uso en las clases de fitness como
                el aeróbic.
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
