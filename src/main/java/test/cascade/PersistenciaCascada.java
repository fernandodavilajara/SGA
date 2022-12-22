/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cascade;

import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando Davila
 */
public class PersistenciaCascada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Domicilio domicilio = new Domicilio ();
        domicilio.setCalle("calle 1 ");
        domicilio.setNoCalle("12321");
        domicilio.setPais("aoetuh");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("caeunt@gmail.com");
        contacto.setTelefono("3634985");
        
        Alumno alumno = new Alumno();
        alumno.setNombre("carlos");
        alumno.setApellido("Lara");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("alumno = " + alumno);
        
    }

}
