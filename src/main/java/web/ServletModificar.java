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
import javax.servlet.http.HttpSession;
import servicio.ServicioAlumno;

/**
 *
 * @author Fernando Davila
 */
@WebServlet(name = "ServletModificar", urlPatterns = {"/ServletModificar"})
public class ServletModificar extends HttpServlet {

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>POST</code> method.S
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                
                String idAlumnoS = request.getParameter("idAlumno"); // la "S" final es porque se procesa como string
                Integer idAlumno = Integer.parseInt(idAlumnoS);

                Alumno alumno = new Alumno();
                alumno.setIdAlumno(idAlumno);

                ServicioAlumno servicioAlumno = new ServicioAlumno();
                alumno = servicioAlumno.encontrarAlumno(alumno);

                //request.setAttribute("alumno", alumno);
                HttpSession sesion = request.getSession();
                sesion.setAttribute("alumno", alumno);
                request.getRequestDispatcher("WEB-INF/modificarAlumno.jsp").forward(request, response);

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                
                ServicioAlumno servicioAlumno = new ServicioAlumno(); 
                String modificar = request.getParameter("modificar");
                
                if(modificar != null){
                
                        String nombre = request.getParameter("nombre");
                        String apellido = request.getParameter("apellido");
                        String calle = request.getParameter("calle");
                        String noCalle = request.getParameter("noCalle");
                        String pais = request.getParameter("Pais");
                        String telefono = request.getParameter("telefono");
                        //probabilidad de confusion al momento de "mail" o "email"
                        //tener cuidado al modificar y/o leer codigo
                        String mail = request.getParameter("mail");     

                        HttpSession sesion = request.getSession();
                        Alumno alumno = (Alumno) sesion.getAttribute("alumno");

                        alumno.setNombre(nombre);
                        alumno.setApellido(apellido);
                        alumno.getDomicilio().setCalle(calle);
                        alumno.getDomicilio().setNoCalle(noCalle);
                        alumno.getDomicilio().setPais(pais);
                        alumno.getContacto().setTelefono(telefono);
                        alumno.getContacto().setEmail(mail);


                        
                        servicioAlumno.guardarAlumno(alumno); //hace diferencias entre si tiene ID o no 

                        sesion.removeAttribute("alumno");
                } else {
                       String idAlumnoS = request.getParameter("idAlumno");
                       Integer idAlumno = Integer.parseInt(idAlumnoS);
                       Alumno alumno = new Alumno(idAlumno);
                       servicioAlumno.eliminarAlumno(alumno);
                       
                }
                request.getRequestDispatcher("/index.jsp").forward(request, response);

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
                return "Short description";
        }// </editor-fold>

}
