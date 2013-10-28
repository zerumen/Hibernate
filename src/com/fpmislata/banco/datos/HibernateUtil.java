/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alumno
 */
public class HibernateUtil {

    private static  SessionFactory sessionFactory;
    
    public static synchronized void buildSessionFactory(){
      if (sessionFactory == null) {  
     Configuration configuration = new Configuration();
          configuration.configure();
          
          ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
          sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      }
}
    
    public static SessionFactory getSessionFactory() {
      if (sessionFactory==null)  {
           buildSessionFactory();
        }
         return sessionFactory;
    }
    
    public static void closeSessionFactory() {
        if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
             sessionFactory.close();
        }
     }
}