/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionsistemasalud;

/**
 *
 * @author joaquin
 */
import java.util.*;
public class Hospital {
    private String nombreHospital;
    private List<Medico> listaMedicos;
    private HashMap<String, Pacientes> mapaPacientes;
    private List<Cama> listaCamas;

    //CONSTRUCT
    public Hospital(String nombre){
        nombreHospital = nombre;
        listaMedicos = new ArrayList<>();
        mapaPacientes = new HashMap<>();
        listaCamas = new ArrayList<>();
    }
    //GETTER Y SETTER
    public String getNombreHospital(){
        return nombreHospital;
    }
    public void setNombreHospital(String nombre){
        nombreHospital = nombre;
    }

    //METODOS
    public void agregarMedico(Medico medico){
        if(!listaMedicos.contains(medico))
            listaMedicos.add(medico);
    }
    public void eliminarMedico(Medico medico){
        if(listaMedicos.contains(medico))
            listaMedicos.remove(medico);
    }
    public void agregarPaciente(String rut,Paciente paciente){
        if(!mapaPacientes.containsKey(rut))
            mapaPacientes.put(rut,paciente);
    }
    public void eliminarPaciente(String rut,Paciente paciente){
        if(mapaPacientes.containsKey(rut))
            mapaPacientes.remove(rut);
    }
    public void agregarCama(Cama cama){
        if(!listaCamas.contains(cama))
            listaCamas.add(cama);
    }
    public void eliminarCama(Cama cama){
        if(listaCamas.contains(cama))
            listaCamas.remove(cama);
    }
}
