/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import com.fpmislata.banco.modelo.TipoentidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpJBDC  implements EntidadBancariaDAO{

   ConnectionFactory connectionFactory=new ConnectionFactoryImplDataSource();
    
   public EntidadBancariaDAOImpJBDC(){
       
        
    }
    
    
   @Override
    public EntidadBancaria read(Integer idEntidad){
       try{
        Connection connection=connectionFactory.getConnection();
        String userid;
        String selectSQL = "SELECT idEntidad,codigoEntidad,nombre,CIF,tipoEntidadBancaria FROM entidadBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, idEntidad);
        ResultSet resultset = preparedStatement.executeQuery();
        EntidadBancaria entidadbancaria;

        if(resultset.next()==true){
        entidadbancaria=new EntidadBancaria();
        entidadbancaria.setIdEntidadBancaria(resultset.getInt("idEntidad"));
        entidadbancaria.setCodigoEntidad(resultset.getString("codigoEntidad"));
        entidadbancaria.setNombre(resultset.getString("nombre"));
        entidadbancaria.setCif(resultset.getString("CIF"));
        String tipoEntidadBancaria=resultset.getString("tipoEntidadBancaria");
        entidadbancaria.setEntidad(TipoentidadBancaria.valueOf(tipoEntidadBancaria));
            if (resultset.next()==true){
                //System.out.println("·Existe mas de una entidadBancaria");
               throw new RuntimeException("·Existe mas de una entidadBancaria");
            }
        }else{
            //System.out.println("No existe la entidad Bancaria:");
             RuntimeException runtimeException=new RuntimeException("No existe la entidad Bancaria:");
                throw runtimeException;
                
        }
        connection.close();
        return entidadbancaria;
       }catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
    
    }
    
   @Override
    public void insert(EntidadBancaria entidadBancaria) {
       try{
        Connection connection=connectionFactory.getConnection();
        String insertTableSQL = "INSERT INTO entidadBancaria"
		+ "(idEntidad, codigoEntidad, nombre, cif,tipoEntidadBancaria) VALUES"
		+ "(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getEntidad().name());

        preparedStatement .executeUpdate();
        System.out.println("Insertado registro!");
        connection.close();
       } catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
    }
    
   @Override
    public void update(EntidadBancaria entidadBancaria){
       try{
        Connection connection=connectionFactory.getConnection();
        String updateTableSQL = "UPDATE entidadBancaria SET codigoentidad = ?, nombre = ?, cif = ?,tipoEntidadBancaria = ? WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        
        preparedStatement.setString(1, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(2, entidadBancaria.getNombre());
        preparedStatement.setString(3, entidadBancaria.getCif());
        preparedStatement.setString(4, entidadBancaria.getEntidad().name());
        preparedStatement.setInt(5, entidadBancaria.getIdEntidadBancaria());
// execute insert SQL stetement
        preparedStatement .executeUpdate();
        System.out.println("modificado registro!");
        connection.close();
       }catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
    }
   
 @Override
   public void delete(Integer entidadBancaria){
     try{
        Connection connection=connectionFactory.getConnection();
        String deleteSQL = "DELETE from entidadbancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
        preparedStatement.setInt(1,entidadBancaria);
// execute delete SQL stetement
        preparedStatement.executeUpdate();
        
        System.out.println("Eliminado registro!!");
        connection.close();
     }catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
        
    }
    
   @Override
   public  List<EntidadBancaria> findAll(){
       try{
        Connection connection=connectionFactory.getConnection();
        List <EntidadBancaria> entidadBancarias=new ArrayList();
        EntidadBancaria entidadBancaria;
        String listaSQL="SELECT idEntidad,codigoEntidad, nombre, cif, tipoEntidadBancaria from entidadbancaria";
        PreparedStatement preparedStatement= connection.prepareStatement(listaSQL);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()==true){
        entidadBancaria=new EntidadBancaria();
        
        entidadBancaria.setIdEntidadBancaria(resultset.getInt("idEntidad"));
        entidadBancaria.setCodigoEntidad(resultset.getString("codigoEntidad"));
        entidadBancaria.setNombre(resultset.getString("nombre"));
        entidadBancaria.setCif(resultset.getString("CIF"));
        String tipoEntidadBancaria=resultset.getString("tipoEntidadBancaria");
        entidadBancaria.setEntidad(TipoentidadBancaria.valueOf(tipoEntidadBancaria));
        entidadBancarias.add(entidadBancaria);
        }
        connection.close();
        return entidadBancarias;
       }catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
        
    }
    
   @Override
    public List<EntidadBancaria> findByCodigo(String codigo){
       try{
        Connection connection=connectionFactory.getConnection();
       List <EntidadBancaria> entidadBancarias=new ArrayList();
        EntidadBancaria entidadBancaria;
        String listaSQL="SELECT idEntidad,codigoEntidad, nombre, cif, tipoEntidadBancaria from entidadbancaria where codigoEntidad = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(listaSQL);
         preparedStatement.setString(1, codigo);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()==true){
        entidadBancaria=new EntidadBancaria();
        
        entidadBancaria.setIdEntidadBancaria(resultset.getInt("idEntidad"));
        entidadBancaria.setCodigoEntidad(resultset.getString("codigoEntidad"));
        entidadBancaria.setNombre(resultset.getString("nombre"));
        entidadBancaria.setCif(resultset.getString("CIF"));
        String tipoEntidadBancaria=resultset.getString("tipoEntidadBancaria");
        entidadBancaria.setEntidad(TipoentidadBancaria.valueOf(tipoEntidadBancaria));
        entidadBancarias.add(entidadBancaria);
        }
        connection.close();
        return entidadBancarias;
       }catch(Exception ex){
           throw new RuntimeException("Error",ex);
       }
    }
   
   @Override
     public List<EntidadBancaria> findByNombre(String nombre){
       try{
       Connection connection=connectionFactory.getConnection();
       List <EntidadBancaria> entidadBancarias=new ArrayList();
       if((nombre == null)||(nombre.trim().equals(""))){
           entidadBancarias=findAll();
           
       }else{
       EntidadBancaria entidadBancaria;
       String listaSQL="SELECT idEntidad,codigoEntidad, nombre, cif, tipoEntidadBancaria from entidadbancaria where nombre like ?";
       PreparedStatement preparedStatement= connection.prepareStatement(listaSQL);
       preparedStatement.setString(1,"%"+nombre+"%");
       ResultSet resultset = preparedStatement.executeQuery(); 
       
       while(resultset.next()==true){
        entidadBancaria=new EntidadBancaria();
        
        entidadBancaria.setIdEntidadBancaria(resultset.getInt("idEntidad"));
        entidadBancaria.setCodigoEntidad(resultset.getString("codigoEntidad"));
        entidadBancaria.setNombre(resultset.getString("nombre"));
        entidadBancaria.setCif(resultset.getString("CIF"));
        String tipoEntidadBancaria=resultset.getString("tipoEntidadBancaria");
        entidadBancaria.setEntidad(TipoentidadBancaria.valueOf(tipoEntidadBancaria));
        entidadBancarias.add(entidadBancaria);
        }
       }
        connection.close();
        return entidadBancarias;
       
       }catch(Exception ex){
           throw new RuntimeException("Error",ex);

       }
  
   }

    
}
