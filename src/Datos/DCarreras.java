/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import conexion.Conexion;
import Logica.Lcarreras;
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
public class DCarreras {
    
    public int totalCarreras;

    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public DCarreras(){
    
    }
    
     public DefaultTableModel mostrarCarreras() {
    
    ResultSet rs;
    DefaultTableModel modelo=null;  
    
    try{
    
    Object datos[]=new Object[2];
    String titulos[]={"Carrera Id","Carrera"};
    String sql="SELECT*FROM carrera";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("idCarrera");
       datos[1]=rs.getObject("nombreCarrera");
            
       modelo.addRow(datos);
       totalCarreras++;
       }       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar Carreras "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
   
   }
    
    return modelo;    
    }
     
    public void agregarCarreras(Lcarreras l){
     
        try{
        String sql="INSERT INTO carrera(nombreCarrera) VALUES('"+l.getNombreCarrera()+"')";
        Statement st=cn.createStatement();
        st.executeUpdate(sql);
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Se Registro Nueva Carrera","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Registrar Nueva Carrera "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void editarCarreras(Lcarreras l){
    
    try{
        String sql="UPDATE carrera SET nombreCarrera=? WHERE idCarrera=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,l.getNombreCarrera());
        pst.setInt(2, l.getCarreraId());
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Carrera Actualizada","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Editar Carrera "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    public void bajaCarrera(int carreraId){
    
    try{
        String sql="DELETE FROM documentacion Where idDocumento=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setInt(1,carreraId);
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"El reporte "+carreraId+" ha sido Dada de baja","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al dar de baja este Reporte "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
     public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT*FROM carrera WHERE "+consulta+" like '%"+atributo+"%' ORDER BY nombreCarrera asc";
     String titulos[]={"Carrera Id","Carrera"};
     Object datos[]=new Object[2];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
    
     
         while(rs.next()){
       
         datos[0] = rs.getString("idCarrera");
         datos[1] = rs.getString("nombreCarrera");
                         
         totalCarreras = totalCarreras + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
} 

     public int getTotalCarreras() {
        return totalCarreras;
    }

    public void setTotalCarreras(int totalCarreras) {
        this.totalCarreras = totalCarreras;
    }
    
     
     
}
