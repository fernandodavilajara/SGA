<%-- 
    Document   : listarAlumnos
    Created on : 21 oct. 2022, 21:38:57
    Author     : Fernando Davila
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="plantillas/head.jsp"%>

<!--Cuerpo de la pagina  -->

    <div class="table-responsive" style="margin-left:10%; margin-right: 10%;" >
        <table class="table table-dark table-hover caption-top table-bordered max-width-75 ">
                <tr class="table-dark">
                    <Caption>Listar Alumnos:</Caption>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Domicilio</th>
                        <th>Email</th>
                        <th>Telefono</th>
                 </tr>
            <tbody class="table-group-divider ">
            <c:forEach var="alumno" items="${alumnos}" >
                <tr class="table-light">
                    <td>
                        <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">
                            ${alumno.idAlumno}
                        </a>                        
                    </td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>${alumno.domicilio.calle} ${alumno.domicilio.noCalle}, ${alumno.domicilio.pais} </td>
                    <td>${alumno.contacto.email}</td>
                    <td>${alumno.contacto.telefono}</td>

                </tr>
            </c:forEach>   
            </tbody>    

        </table>
    </div>

    <div class="my-3">
        <a class="d-grid gap-2 col-2 mx-auto" href="${pageContext.request.contextPath}/ServletRedireccionar">
            <button style="color:white"  type="button" class="btn btn-primary" >
                Agregar 
            </button>
        </a> 
    </div>     
<%@include file="plantillas/foot.jsp"%>
