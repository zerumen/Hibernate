/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;



import com.fpmislata.banco.modelo.EntidadBancaria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author alumno
 */
public class Hibernate {
    
    public static void main(String[] args) {
        
        SessionFactory sessionFactory;

 Configuration configuration = new Configuration();
configuration.configure();
ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
sessionFactory = configuration.buildSessionFactory(serviceRegistry);

Session session = sessionFactory.openSession();

EntidadBancaria entidadBancaria=(EntidadBancaria)session.get(EntidadBancaria.class,1);
        System.out.println(entidadBancaria.getNombre());

session.close(); 

sessionFactory.close();
       
    }
}
