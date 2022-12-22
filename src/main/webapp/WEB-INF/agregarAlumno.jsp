<%-- 
    Document   : agregarAlumno
    Created on : 2 nov. 2022, 21:41:04
    Author     : Fernando Davila
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="plantillas/head.jsp"%>



<div class="container mb-3">
    <form name="form1" action="${pageContext.request.contextPath}/ServletAgregar" method="post">


        Nombre: <input class="form-control" type="text" name="nombre">
        Apellido: <input class="form-control" type="text" name="apellido"> <br>
        <hr>
        Datos de domicilio: <br>
        Calle:<input class="form-control"  type="text" name="calle"> <br>
        Numero<input class="form-control" type="text" name="noCalle"> <br>
        Pais:<input class="form-control" type="text" name="Pais"> <br>
        Telefono: <input class="form-control" type="text"  maxlength="9" name="telefono"> <br>
        Email <input class="form-control" type="email" name="mail"> <br>
        
        <div class="d-grid gap-2 col-2 mx-auto">
            <button type="submit" name="Agregar" value="Agregar" class="btn btn-primary" >
                <a style="color:white" href="${pageContext.request.contextPath}/ServletAgregar">Agregar</a>
            </button>
        </div> 
    </form>
</div>
<%@include file="plantillas/foot.jsp"%>
