/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;



import com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate;
import com.fpmislata.banco.datos.HibernateUtil;
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
        
         HibernateUtil.buildSessionFactory();
        
        
        HibernateUtil.openSessionAndBindToThread();

        
        EntidadBancariaDAOImpHibernate entidadbancaria=new EntidadBancariaDAOImpHibernate();
        EntidadBancaria entidadBancaria= entidadbancaria.read(1);
        System.out.println(entidadBancaria.getNombre());
        HibernateUtil.closeSessionAndUnbindFromThread();
        
        HibernateUtil.closeSessionFactory();
        
    }
}
