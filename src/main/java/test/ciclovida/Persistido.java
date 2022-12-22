/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ciclovida;

import domain.Contacto;
import javax.persistence.*;
/**
 *
 * @author Fernando Davila
 */
public class Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("email@gmail.com");
        contacto.setTelefono("132456789");
        
        //2. Persistir el objeto
        em.getTransaction().begin();
        em.persist(contacto);
        em.flush();
        em.getTransaction().commit();
        
        //3. detached (separado)
        System.out.println("contacto: " + contacto);
        
        
        
    }
}
