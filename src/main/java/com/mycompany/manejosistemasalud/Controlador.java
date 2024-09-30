/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manejosistemasalud;

/**
 *
 * @author joaquin
 */
public class Controlador {
    private Hospital hospital;
    private VentanaPrincipal ventanaPrincipal;
    //private VentanaPaciente ventanaPaciente;
    //private VentanaCama ventanaCama;
    //private VentanaMedico ventanaMedico;
    //private VentanaMostrarDatos ventanaMostrar;
    //private VentanaRegistrarPaciente ventanaRP;

    //CONSTRUCTOR
    public Controlador(Hospital hospital){
        this.hospital = hospital;
        ventanaPrincipal = new VentanaPrincipal(this);
        //ventanaPaciente = new VentanaPaciente(this);
        //ventanaCama = new VentanaCama(this);
        //ventanaMedico = new VentanaMedico(this);
        //ventanaMostrar = new VentanaMostrarDatos(this);
        //ventanaRP = new VentanaRegistrarPaciente(this);
        ventanaPrincipal.setVisible(true);
    }
    //SETS Y GETS

    //METODOS
    public void mostrarVentanaPrincipal(){
        ventanaPrincipal.setVisible(true);
    }
    public void mostrarVentanaPaciente(){
        VentanaPaciente ventanaPaciente = new VentanaPaciente(this);
        ventanaPrincipal.setVisible(false);
        ventanaPaciente.setVisible(true);
    }
    public void mostrarVentanaCama(){
        VentanaCama ventanaCama = new VentanaCama(this);
        ventanaPrincipal.setVisible(false);
        ventanaCama.setVisible(true);
    }
    public void mostrarVentanaMedico(){
        VentanaMedico ventanaMedico = new VentanaMedico(this);
        ventanaPrincipal.setVisible(false);
        ventanaMedico.setVisible(true);
    }
    public void mostrarVentanaMostrar(){
        VentanaMostrarDatos ventanaMostrar = new VentanaMostrarDatos(this);
        ventanaPrincipal.setVisible(false);
        ventanaMostrar.setVisible(true);
    }
    public void mostrarVentanaRP(){
        VentanaRegistrarPaciente ventanaRP = new VentanaRegistrarPaciente(this);
        ventanaRP.setVisible(true);
    }










    public boolean verificarExistenciaPaciente(String rut){
        if(hospital.existePaciente(rut))
            return true;
        return false;
    }
}
