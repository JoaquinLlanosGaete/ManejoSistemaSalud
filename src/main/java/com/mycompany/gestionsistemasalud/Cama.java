/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionsistemasalud;

/**
 *
 * @author joaquin
 */
public class Cama{
  private int numCama;
  private String tipo;
  private boolean disponible;
  private String rutPacienteAsignado;

  //CONSTRUCTORES
  public Cama(int numCama, String tipo,boolean disponible){
    this.numCama = numCama;
    this.tipo = tipo;
    this.disponible = disponible;
  }
  
  //GETTERS
  public int getNumCama(){
    return numCama;
  }
  public String getTipo(){
    return tipo;
  }
  public boolean getDisponible(){
    return disponible;
  }
  public String getPacienteAsignado(){
    return rutPacienteAsignado;
  }
  
  //SETTERS
  public void setNumCama(int numCama){
    this.numCama = numCama;
  }
  public void setTipo(String tipo){
    this.tipo = tipo;
  }
  public void setDisponible(boolean disponible){
    this.disponible = disponible;
  }
  public void setPacienteAsignado(String rutPacienteAsignado){
    this.rutPacienteAsignado = rutPacienteAsignado;
  }
}
