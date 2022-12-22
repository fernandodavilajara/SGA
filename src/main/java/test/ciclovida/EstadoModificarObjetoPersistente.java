/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ciclovida;

import domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando Davila
 */
public class EstadoModificarObjetoPersistente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //iniciar transaccion
        em.getTransaction().begin();

        //recuperar objeto de la base de datos 
        Contacto contacto = em.find(Contacto.class, 2);
        contacto.setEmail("clara@gmail.com");
        em.merge(contacto);
        em.getTransaction().commit();
        
        
        //detached
        System.out.println("Contacto  = " + contacto);

    }

}
