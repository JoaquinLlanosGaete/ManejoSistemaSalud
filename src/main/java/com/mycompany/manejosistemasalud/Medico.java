/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manejosistemasalud;

/**
 *
 * @author joaquin
 */
public class Medico{
    private String nombre;
    private String rut;
    private int edad;
    private String especialidad;
    private Boolean disponibilidad;

    //CONSTRUCTORES
    public Medico(String nombre,String rut,int edad,String especialidad,Boolean disponibilidad){
      this.nombre = nombre;
      this.rut = rut;
      this.edad = edad;
      this.especialidad = especialidad;  
      this.disponibilidad = disponibilidad;
    }
    //GETTERS
    public String getNombre(){
      return nombre;
    }
    public String getRut(){
      return rut;
    }
    public int getEdad(){
      return edad;
    }
    public String getEspecialidad(){
      return especialidad;
    }
    public Boolean getDisponibilidad(){
      return disponibilidad;
    }
    //SETTERS
    public void setDisponibilidad(Boolean disponibilidad){
      this.disponibilidad = disponibilidad;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
   public void setEspecialidad(String especialidad){
       this.especialidad = especialidad;
   }
}
