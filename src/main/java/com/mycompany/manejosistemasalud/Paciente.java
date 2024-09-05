/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manejosistemasalud;

/**
 *
 * @author joaquin
 */
import java.util.*;
import java.util.ArrayList;
public class Paciente {
    private String nombre;
    private String rut;
    private int edad;
    private int nivelGravedad;//de 1 a 3, 0 no se encuentra en asistencia
    private boolean dadoDeAlta;
    private List<AtencionMedica> listaAtencionesMedicas;

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
    public AtencionMedica getAtencionMedica(String fecha){
        int cantAtenciones = listaAtencionesMedicas.size();
        if(cantAtenciones>0){
            for(int i=0;i<cantAtenciones;i++){
                if(listaAtencionesMedicas.get(i).getFecha().equals(fecha))
                    return listaAtencionesMedicas.get(i);
                }
            }
        return null;
    }
    public int getCantAtenciones(){
        return listaAtencionesMedicas.size();
    }
    public List<AtencionMedica> getAtencionesMedicas() {
        return listaAtencionesMedicas;
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
    //METODOS
    public void agregarAtencionMedica(String fecha, String diagnostico){
        if(this.listaAtencionesMedicas == null){
            this.listaAtencionesMedicas = new ArrayList<>();
        }
        this.listaAtencionesMedicas.add(new AtencionMedica(fecha,diagnostico));
    }
    public boolean existeAtencion(String fecha){
        int cantAtenciones = listaAtencionesMedicas.size();
        for(int i = 0;i<cantAtenciones;i++){
            if(listaAtencionesMedicas.get(i).getFecha().equals(fecha))
                return true;
        }
        return false;
    }
}

