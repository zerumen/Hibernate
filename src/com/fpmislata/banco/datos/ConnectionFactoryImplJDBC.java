package com.fpmislata.banco.datos;


import com.fpmislata.banco.datos.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory {

    @Override
    public Connection getConnection() throws Exception {
        Connection connection;
         Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root", "root");
        return connection;
        
    }
    
    
}
