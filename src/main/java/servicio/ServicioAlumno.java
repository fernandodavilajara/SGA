/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.AlumnoDAO;
import domain.Alumno;
import java.util.List;

/**
 *
 * @author Fernando Davila
 */
public class ServicioAlumno {
    private AlumnoDAO alumnoDAO = new AlumnoDAO();
    
    public List<Alumno> listar(){
        return alumnoDAO.listar();
    }
    
    /***
     * metodo que sirve para ACTUALIZAR y guardar un nuevo registro en la bd: 
     * 
     * -actualiza si el id es distinto a nulo.
     * 
     * -guarda si el valor es nulo. La base de datos se encarga de
     * crear el id (autoincrementable)
     * 
     * @return 
     */
    public void guardarAlumno(Alumno alumno){
        if(alumno != null && alumno.getIdAlumno() != null){
            alumnoDAO.actualizar(alumno);
        }if (alumno != null && alumno.getIdAlumno() == null){
            alumnoDAO.insertar(alumno);
            
        }   
    }
    
    public void eliminarAlumno(Alumno alumno){
            alumnoDAO.eliminar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno){
        return alumnoDAO.buscarPorId(alumno);
    }
    
    
    
    
}