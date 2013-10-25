/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpHibernate extends GenericDAOImpHibernate<EntidadBancaria, Integer>implements EntidadBancariaDAO {
    
 
   
   
 public  EntidadBancariaDAOImpHibernate(SessionFactory sessionFactory){
     super(sessionFactory);
 } 
 
 

  
   @Override
    public List<EntidadBancaria> findByCodigo(String codigo){
       Session session=sessionFactory.openSession();
       Query query = session.createQuery("SELECT eb FROM entidadBancaria eb where codigoEntidad=?");
       List<EntidadBancaria> listaporCodigo = query.list();
        session.close();
       return listaporCodigo;
       
   }
   
   @Override
     public List<EntidadBancaria> findByNombre(String nombre){
       Session session=sessionFactory.openSession();
       Query query = session.createQuery("SELECT eb FROM entidadBancaria eb where nombre=?");
       List<EntidadBancaria> listaporNombre = query.list();
        session.close();
       return listaporNombre;
       
   }
    
}
