/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mysql.jdbc.Connection;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DLogin {
    
    Conexion mysql =new Conexion();
    Connection cn=mysql.conectar();
    int resultado;
    public DLogin(){}
    
    
    public int validarLogin(String us,String cl){
              
    
        try {
            
            String sql="SELECT*FROM usuarios WHERE username='"+us+"' and password='"+cl+"'";
            java.sql.PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            
            while(rst.next()){
                
                resultado=1;
                
            }
            
            return resultado;
                    } catch (SQLException ex) {
            
                        return 0;
            
        }
           
    }
                
}
