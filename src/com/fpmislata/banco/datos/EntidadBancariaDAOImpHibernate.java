/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpHibernate implements EntidadBancariaDAO{
    
   private SessionFactory sessionFactory;
   
   
 public  EntidadBancariaDAOImpHibernate(SessionFactory sessionFactory){
     this.sessionFactory=sessionFactory;
 } 
 
 
   @Override
    public EntidadBancaria read(Integer idEntidad){
       Session session=sessionFactory.openSession();
       EntidadBancaria entidad=(EntidadBancaria)session.get(EntidadBancaria.class,idEntidad);
       session.close();
       return entidad;
       
   }
   
    @Override
   public void insert(EntidadBancaria entidadBancaria){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(entidadBancaria);
        session.getTransaction().commit();
        session.close();
  }
    
  @Override
    public void update(EntidadBancaria entidadBancaria){
      Session session=sessionFactory.openSession();
      session.beginTransaction();
      session.update(entidadBancaria);
      session.getTransaction().commit();
      session.close();
      
      
    }
  @Override
   public void delete(Integer idEntidad){
      Session session=sessionFactory.openSession();
      session.beginTransaction();
      EntidadBancaria entidad=(EntidadBancaria)session.get(EntidadBancaria.class,idEntidad);
      session.delete(entidad);
      session.getTransaction().commit();
      session.close();
  }
  
  @Override
   public List<EntidadBancaria> findAll(){
      Session session=sessionFactory.openSession();
      Query query = session.createQuery("SELECT eb FROM entidadBancaria eb");
      List<EntidadBancaria> listaBancos = query.list();
       session.close();
       return listaBancos;
      
       
      
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
