/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionsistemasalud;

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

    //Constructiors
    public Medico(String nombre,String rut,int edad,String especialidad,Boolean disponibilidad){
      this.nombre = nombre;
      this.rut = rut;
      this.edad = edad;
      this.especialidad = especialidad;  
      this.disponibilidad = disponibilidad;
    }
    //Gatoers
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
    //Sitiers
    public void setDisponibilidad(Boolean disponibilidad){
      this.disponibilidad = disponibilidad;
    }
    
}
