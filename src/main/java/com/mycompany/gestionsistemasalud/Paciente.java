/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionsistemasalud;

/**
 *
 * @author joaquin
 */
public class Paciente {
    private String nombre;
    private String rut;
    private int edad;
    private int nivelGravedad;
    private boolean dadoDeAlta;

    //CONSTRUCTORES
    public Paciente(String nombre,String rut,int edad){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
}
    public Paciente(String nombre,String rut,int edad,int nivelGravedad){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.nivelGravedad = nivelGravedad;
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
    public int getGravedad(){
        return nivelGravedad;
    }
    public boolean getAlta(){
        return dadoDeAlta;
    }

    //SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setGravedad(int nivelGravedad){
        this.nivelGravedad = nivelGravedad;
    }
    }