/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.ServicioAlumno;

/**
 *
 * @author Fernando Davila
 */
@WebServlet(name = "ServletAgregar", urlPatterns = {"/ServletAgregar"})
public class ServletAgregar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAgregar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAgregar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String calle = request.getParameter("calle");
                String noCalle = request.getParameter("noCalle");
                String pais = request.getParameter("Pais");
                String telefono = request.getParameter("telefono");
                String mail = request.getParameter("mail");

                Domicilio domicilio = new Domicilio();
                domicilio.setCalle(calle);
                domicilio.setNoCalle(noCalle);
                domicilio.setPais(pais);

                Contacto contacto = new Contacto();
                contacto.setTelefono(telefono);
                contacto.setEmail(mail);

                Alumno alumno = new Alumno();
                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
                alumno.setContacto(contacto);
                alumno.setDomicilio(domicilio);

                ServicioAlumno servicioAlumno = new ServicioAlumno();
                servicioAlumno.guardarAlumno(alumno);

                request.getRequestDispatcher("index.jsp").forward(request, response);

        }

}
