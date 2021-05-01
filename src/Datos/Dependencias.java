/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import conexion.Conexion;
import Logica.Ldependencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Dependencias {
    
    public int totalDependencias;

    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public Dependencias(){
    
    }
    
     public DefaultTableModel mostrarCarreras() {
    
    ResultSet rs;
    DefaultTableModel modelo=null;  
    
    try{
    
    Object datos[]=new Object[2];
    String titulos[]={"Id","Dependencia"};
    String sql="SELECT*FROM campus";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("idCampus");
       datos[1]=rs.getObject("nombreCampus");
            
       modelo.addRow(datos);
       totalDependencias++;
       }       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar Campus "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
   
   }
    
    return modelo;    
    }
     
    public void agregarDependencia(Ldependencias l){
     
        try{
        String sql="INSERT INTO campus(nombreCampus) VALUES('"+l.getNombreCampus()+"')";
        Statement st=cn.createStatement();
        st.executeUpdate(sql);
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Se Registro Nueva Dependencia","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Registrar Nueva Dependencia "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void editarDependencia(Ldependencias l){
    
    try{
        String sql="UPDATE campus SET nombreCampus=? WHERE idCampus=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,l.getNombreCampus());
        pst.setInt(2, l.getCampusId());
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Dependencia Actualizada","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Editar Dependencia "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    public void bajaDependencia(int dependenciaId){
    
    try{
        String sql="DELETE FROM campus Where idCampus=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setInt(1,dependenciaId);
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"La Dependencia "+dependenciaId+" ha sido eliminada ","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al dar de baja esta Dependencia "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
     public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT*FROM campus WHERE "+consulta+" like '%"+atributo+"%' ORDER BY nombreCampus asc";
     String titulos[]={"Id","Dependencia"};
     Object datos[]=new Object[2];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
    
     
         while(rs.next()){
       
         datos[0] = rs.getString("idCampus");
         datos[1] = rs.getString("nombreCampus");
                         
         totalDependencias = totalDependencias + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
} 

     public int getTotalDependencias() {
        return totalDependencias;
    }

    public void setTotalDependencias(int totalDependencias) {
        this.totalDependencias = totalDependencias;
    }
    
     
     
}
