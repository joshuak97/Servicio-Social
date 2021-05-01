/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import conexion.Conexion;
import Logica.Lalumnos;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USUARIO
 */
public class DAlumnos {
    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    int totalRegistros;
    public boolean agregarAlumno(Lalumnos u){
                try { //alumno_id,no_control,nombre,apellidoP,apellidoM,semestre,foto,eestado;
                String sql = "insert into Alumno(noControl,nombre,apellidoP,apellidoM,nombreCompleto,sexo,idCarrera,idCampus) values"+
                          "('" + u.getNoControl()+"','" +u.getNombre()+"','"+ u.getaPaterno()+"','" + u.getaMaterno()+
                            "','"+u.getNombreCompleto() +"','" +u.getSexo()+"'," + u.getCarreraId()+"," + u.getDependenciaId()+")";
                Statement st= (Statement) cn.createStatement();
                
                st.executeUpdate(sql);
                ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Registro de Forma Correcta","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
                return true;
        } catch (SQLException e){
           JOptionPane.showMessageDialog(null,e,"ERROR",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"Ha Ocurrido un error al Guardar los Datos","ERROR",JOptionPane.ERROR_MESSAGE);
        return false;
        }
                
    }
    
    public ResultSet visualizar(){
    ResultSet rst=null;
    try{
        
        PreparedStatement pst=cn.prepareStatement("Select * from alumno inner join carrera on alumno.idCarrera=carrera.idCarrera inner join campus on alumno.idCampus=campus.idCampus order by noControl asc limit 100");
        rst=pst.executeQuery();
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error de Consulta"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
    
    }
    return rst;
    }
    
    //El metodo baja alumno permite cambiar el estado de un alumno a Baja para que este deje de aparecer en el sistema,
    //sin embargo su registro quedara marcado en la base de daros a no ser que la base  sea reiniciada:
    public void bajaAlumno(String idAlumno){
        
    try {
String sql= "delete from alumno WHERE idAlumno=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1,idAlumno);
pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al Dar de baja al Alumno","Error",JOptionPane.ERROR_MESSAGE);

    }
    }
    public void EditarAlumno(Lalumnos u){
try {
String sql= "update alumno set noControl=?,nombre=?,apellidoP=?,apellidoM=?,nombreCompleto=?,sexo=?, idCarrera=?, idCampus=? WHERE idAlumno=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1, u.getNoControl());
pst.setString(2, u.getNombre());
pst.setString(3, u.getaPaterno());
pst.setString(4, u.getaMaterno());
pst.setString(5, u.getNombre()+" "+u.getaPaterno()+" "+u.getaMaterno());
pst.setString(6, u.getSexo());
pst.setInt(7, u.getCarreraId());
pst.setInt(8, u.getDependenciaId());
pst.setInt(9, u.getAlumnoId());
pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/Imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al editar los datos","Error",JOptionPane.ERROR_MESSAGE);

    }
       
    

    }
    /* Este metodo se utilizara para realizar la consulta que será utilizada para visualizar en los campos de texto de la clase FrmAlumnos
    los datos completos del alumno al seleccionar */
    
    public ResultSet visualizarAlumno(String idAlumno){
    ResultSet rst=null;
    String sql="Select*from alumno inner join carrera on alumno.idCarrera=carrera.idCarrera inner join campus on alumno.idCampus=campus.idCampus WHERE idAlumno="+idAlumno;
    try{
        
        java.sql.Statement s = cn.createStatement();
        rst = s.executeQuery(sql);
        
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error de Consulta","ERROR",JOptionPane.ERROR_MESSAGE);
    
    }
    return rst;
    }
     
       
    
        
    
 public DefaultTableModel mostrarAlumnos(){
     
     ResultSet rs=visualizar();
     String titulos[]= {"id","No.Control","Nombre","Sexo","Carrera","Dependencia"};
     Object datos[]=new Object[6];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     totalRegistros=0;
     try{
     while(rs.next()){
         datos[0] = rs.getInt("idAlumno");
         datos[1] = rs.getString("noControl");
         datos[2] = rs.getString("nombreCompleto");
         datos[3] = rs.getString("Sexo");
         datos[4] = rs.getString("nombreCarrera");
         datos[5] = rs.getString("nombreCampus");
         
         totalRegistros = totalRegistros + 1;
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos"+s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
 
public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="Select*from alumno inner join carrera on alumno.idCarrera=carrera.idCarrera inner join campus on alumno.idCampus=campus.idCampus WHERE "+consulta+" like '%"+atributo+"%'";
     String titulos[]= {"idAlumno","No.Control","Nombre","Sexo","Carrera","Dependencia"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalRegistros=0;
         while(rs.next()){
         datos[0] = rs.getInt("idAlumno");
         datos[1] = rs.getString("noControl");
         datos[2] = rs.getString("nombreCompleto");
         datos[3] = rs.getString("Sexo");
         datos[4] = rs.getString("nombreCarrera");
         datos[5] = rs.getString("nombreCampus");
         
         totalRegistros = totalRegistros + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos"+s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    public int getTotalRegistros() {
        return totalRegistros;
    }
 

}
