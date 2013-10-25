/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory  {




    @Override
    public Connection getConnection() throws Exception {
      DataSource datasource = null;
      
    InitialContext initialContext = new InitialContext();
    
      // actual jndi name is "jdbc/postgres"
      datasource = (DataSource) initialContext.lookup( "java:/comp/env/jdbc/Banco" );
      Connection connection= datasource.getConnection();
      return connection;
}
    

  
  
}