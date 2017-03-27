/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jcaldeon
 */
public abstract class Servicio {
    
    

    protected Connection conn = null;    
    private final static String URL_DB = "jdbc:mysql://localhost:3306/test";
    private final static String DRIVER_DB = "com.mysql.jdbc.Driver";
    private final static String USER_DB = "root";
   // private final static String PASS_DB = "1234"; 
    private final static String PASS_DB = "jhon656"; 

    
    
    protected void conectar() throws Exception {

        try {
            Class.forName(DRIVER_DB);
            conn = DriverManager.getConnection(URL_DB, USER_DB, PASS_DB);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("Error en metodo conectar"+ex.getMessage());
        }
    }

    protected void desconectar() throws Exception {

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }


    
}
