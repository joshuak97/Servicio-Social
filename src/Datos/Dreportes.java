/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Lreportes;
import conexion.Conexion;
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
 * @author Server-EWS
 */
public class Dreportes {
     public int totalCarreras;

    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public Dreportes(){
    
    }
    
     public DefaultTableModel mostrarCarreras() {
    
    ResultSet rs;
    DefaultTableModel modelo=null;  
    
    try{
    
    Object datos[]=new Object[6];
    String titulos[]={"Id", "No.Control", "Nombre Completo", "Reporte", "Fecha de Entrega", "Calificacion"};
    String sql="SELECT*FROM documentacion inner join tipo_documento on documentacion.idTipoDoc=tipo_documento.idTipoDoc inner join alumno on alumno.idAlumno=documentacion.idAlumno";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("idDocumento");
       datos[1]=rs.getObject("noControl");
       datos[2]=rs.getObject("nombreCompleto");
       datos[3]=rs.getObject("descripcion");
       datos[4]=rs.getObject("fechaEntrega");
       datos[5]=rs.getObject("calificacion");
       
       modelo.addRow(datos);
       totalCarreras++;
       }       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar Reportes "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
   
   }
    
    return modelo;    
    }
     
    public void agregarCarreras(Lreportes l){
     
        try{
        String sql="INSERT INTO documentacion(calificacion,fechaEntrega,fechaRegistro,archivo,idAlumno,idTipoDoc) VALUES("+l.getCalificacion()+",'"+l.getFechaEntrega()+"','"+l.getFechaRegistro()+"','"+l.getArchivo()+"',"+l.getIdAlumno()+","+l.getIdTipoDoc()+")";
        Statement st=cn.createStatement();
        st.executeUpdate(sql);
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Se Registro Nuevo Reporte","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Registrar Nuevo Reporte "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void editarCarreras(Lreportes l){
    
    try{
        String sql="UPDATE documentacion SET calificacion=?,idAlumno=?,idTipoDoc=?,fechaEntrega=? WHERE idDocumento=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setInt(1,l.getCalificacion());
        pst.setInt(2, l.getIdAlumno());
        pst.setInt(3, l.getIdTipoDoc());
        pst.setString(4, l.getFechaEntrega());
        pst.setInt(2, l.getIdDocumento());
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Reporte Actualizado","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Editar reporte "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    public void bajaDocumento(int documentoId){
    
    try{
        String sql="DELETE FROM documentacion Where idDocumento=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setInt(1,documentoId);
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"El reporte "+documentoId+" ha sido Dada de baja","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al dar de baja este reporte "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
     public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT*FROM documentacion inner join tipo_documento on documentacion.idTipoDoc=tipo_documento.idTipoDoc inner join alumno on alumno.idAlumno=documentacion.idAlumno WHERE "+consulta+" like '%"+atributo+"%' ORDER BY nombreCarrera asc";
     String titulos[]={"Carrera Id","Carrera"};
     Object datos[]=new Object[6];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
    
     
         while(rs.next()){
       
         datos[0]=rs.getObject("idDocumento");
       datos[1]=rs.getObject("noControl");
       datos[2]=rs.getObject("nombreCompleto");
       datos[3]=rs.getObject("descripcion");
       datos[4]=rs.getObject("fechaEntrega");
       datos[5]=rs.getObject("calificacion");
                         
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
