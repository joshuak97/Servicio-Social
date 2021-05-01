/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


public class Lalumnos {
    
    int alumnoId;
    String NoControl,nombre,aPaterno,aMaterno,nombreCompleto,sexo;
    int dependenciaId,carreraId;
    
    
    public Lalumnos(){
    }

    public Lalumnos(int alumnoId, String NoControl, String nombre, String aPaterno, String aMaterno, String nombreCompleto, String sexo, int carreraId,int dependenciaId) {
        this.alumnoId = alumnoId;
        this.NoControl = NoControl;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.dependenciaId = dependenciaId;
        this.carreraId = carreraId;     
    }
    
    

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getNoControl() {
        return NoControl;
    }

    public void setNoControl(String NoControl) {
        this.NoControl = NoControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }
    
  
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(int dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }

    

   
    
    
}
