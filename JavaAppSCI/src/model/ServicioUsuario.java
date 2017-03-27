/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jcaldeon
 */
public class ServicioUsuario extends Servicio {
    
    
     public final static String SELECT_USUARIOS = "SELECT ID,NOMBRE FROM USUARIO";

    public ServicioUsuario() {
    }
     
     
     
     public Usuario buscarUsuario(Usuario usuario) {
       Usuario u = null;
       
        try {
            //    Servicio s=new UsuarioDao();
            conectar();
            Statement st=this.conn.createStatement();
            ResultSet rs =st.executeQuery(SELECT_USUARIOS);
            while(rs.next()){
                if(rs.getInt(1)==usuario.getId() && rs.getString(2).equals(usuario.getNombre())){
                u = new Usuario(rs.getInt(1),rs.getString(2));
                
                }
            }
        } catch (Exception ex) {
          
            System.out.println(ex.getMessage());
        }
        return u;
    }
     
     public void registrarUsuario(Usuario usuario) throws Exception {
    try {
            this.conectar();
            PreparedStatement st =this.conn.prepareStatement("INSERT INTO USUARIO(ID,NOMBRE)values(?,?)");
            st.setInt(1,usuario.getId());
            st.setString(2,usuario.getNombre());
            st.executeUpdate();
        } catch (SQLException ex) {
           ex.getMessage();
        }finally{
        this.desconectar();
        }    
    
    }


}
