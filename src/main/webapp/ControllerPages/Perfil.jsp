<%@page import="Model.XMLGenerator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.XMLReader"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("username") == null){
%>
        <c:redirect url="/Main/Index.jsp"/>
<%
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <jsp:include page="/Main/Header.jsp" />
    
        <h1>Mi perfil</h1>
        
        <jsp:include page="/Main/GridActivities.jsp" />
        <h1 class="text-center" style="color:black">Mi horario</h1>
        <c:import url = "http://localhost:8080/PlayFitHeroku/Main/StyleXSL.xsl" var = "xslt"/>
        <x:transform xml = "<%=session.getAttribute("miHorario")%>" xslt = "${xslt}"/>
        
        <jsp:include page="/Main/Footer.jsp" />
    </body>
</html>
