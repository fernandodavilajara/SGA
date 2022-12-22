
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="plantillas/head.jsp"%>



<div class="container mb-3">
    <form name="form1" action="${pageContext.request.contextPath}/ServletModificar" method="post">
        <!-- mantiene el id alumno oculto para posterior proceso en servlet -->
        <input type="hidden" name="idAlumno" value="${alumno.idAlumno}">

        Nombre: <input class="form-control" type="text" name="nombre" value="${alumno.nombre}">
        Apellido: <input class="form-control" type="text" name="apellido" value="${alumno.apellido}"> <br>
        <hr>
        Datos de domicilio: <br>
        Calle:<input class="form-control"  type="text" name="calle" value="${alumno.domicilio.calle}"> <br>
        Numero<input class="form-control" type="text" name="noCalle" value="${alumno.domicilio.noCalle}"> <br>
        Pais:<input class="form-control" type="text" name="Pais" value="${alumno.domicilio.pais}"> <br>
        Telefono: <input class="form-control" type="text"  maxlength="9" name="telefono" value="${alumno.contacto.telefono}"> <br>
        Email <input class="form-control" type="email" name="mail" value="${alumno.contacto.email}"> <br>
        
        <div class="d-grid gap-2 col-6 mx-auto">
            <button type="submit" name="modificar" value="modificar" style="color: white" class="btn btn-primary btn-lg" > Modificar </button>
            <button type="submit" style="color: white; margin-left: 25px" name="eliminar" value="eliminar" class="btn btn-primary btn-lg" > Eliminar </button>
        </div> 
    </form>
</div>
<%@include file="plantillas/foot.jsp"%>

<!-- href=${pageContext.request.contextPath}/ServletModificar" -->