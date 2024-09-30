/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manejosistemasalud;
/**
 *
 * @author 
 */
import java.io.*;
import java.util.Scanner;

public class ManejoSistemaSalud {
    public static void main(String[] args)throws IOException {
        Hospital hospital = new Hospital();
        Controlador controlador = new Controlador(hospital);
    }
}
        /*
        Scanner scanner = new Scanner(System.in);
        String nombreHospital;
        System.out.println("Ingrese el nombre del hospital: ");
        nombreHospital = scanner.nextLine();
        Hospital hospital = new Hospital(nombreHospital); 
        hospital.inicializarCamas();
        hospital.inicializarPacientesConAtencionesMedicas();
        int opcion;
        do{
            mostrarMenu(nombreHospital);
            System.out.println("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1:
                    int subOpcion;
                    do{
                        menuPacientes();
                        System.out.println("Seleccione una opcion: ");
                        subOpcion = Integer.parseInt(scanner.nextLine());                                             
                        switch(subOpcion){
                            case 1:
                                String nombre;
                                String rut;
                                int edad;
                                int nivelGravedad;                                

                                System.out.println("Ingrese el rut del paciente: ");
                                rut = scanner.nextLine();
                                if(hospital.existePaciente(rut)){
                                    System.out.println("El paciente ya esta registrado");
                                    break;
                                }
                                System.out.println("Ingrese el nombre del paciente: ");
                                nombre = scanner.nextLine();
                                System.out.println("Ingrese la edad del paciente: ");
                                edad = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese la gravedad del paciente: ");
                                System.out.println("1. Leve");
                                System.out.println("2. Mediana gravedad");
                                System.out.println("3. Grave");
                                nivelGravedad = Integer.parseInt(scanner.nextLine());
                                while(nivelGravedad<1 || nivelGravedad>3){
                                    System.out.println("Valor invalido, ingrese nuevamente: ");
                                    nivelGravedad = Integer.parseInt(scanner.nextLine());
                                }
                                Paciente paciente = new Paciente(nombre,rut,edad,nivelGravedad);
                                hospital.agregarPaciente(rut, paciente);
                                System.out.println("El paciente fue registrado con exito");
                                hospital.ubicarPacienteEnCama(rut, nivelGravedad);                               
                                break;
                            case 2:
                                System.out.println("Ingrese el rut del paciente");
                                rut = scanner.nextLine();
                                if(hospital.existePaciente(rut)){
                                    int dia;
                                    int mes;
                                    int año;
                                    String diagnostico;
                                    String fecha;
                                    System.out.println("Ingrese el dia: ");
                                    dia = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese el mes: ");
                                    mes = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese el año: ");
                                    año = Integer.parseInt(scanner.nextLine());
                                    fecha = String.format("%02d/02d/%04d", dia,mes,año);
                                    System.out.println("Ingrese el diagnostico: ");
                                    diagnostico = scanner.nextLine();
                                    hospital.agregarAtencionMedica(rut, fecha, diagnostico);
                                    System.out.println("La atencion medica fue registrada con exito");
                                    break;
                                }
                                System.out.println("El paciente no se encuentra registrado");
                                break;
                            case 3:
                                System.out.println("Ingrese el rut del paciente: ");
                                rut = scanner.nextLine();
                                hospital.darAltaPaciente(rut);
                                break;

                            case 4:
                                System.out.println("Ingrese el rut del paciente: ");
                                rut = scanner.nextLine();
                                hospital.eliminarPaciente(rut);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    }while(subOpcion!=5);
                    break;
                case 2:
                    int subOpci0n;
                    do{
                    menuCamas();
                    System.out.println("Seleccione una opcion");
                    subOpci0n = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
                    switch(subOpci0n){
                        case 1:
                            String rut;
                            int gravedad;
                            System.out.println("Ingrese el rut del paciente: ");
                            rut = scanner.nextLine();
                            if(hospital.existePaciente(rut)){
                                Paciente paciente = hospital.getPaciente(rut);
                                System.out.println("Ingrese nivel de gravedad del paciente: ");
                                gravedad = Integer.parseInt(scanner.nextLine());
                                paciente.setGravedad(gravedad);
                                hospital.ubicarPacienteEnCama(rut);
                            }
                            System.out.println("El paciente no esta registrado");
                            break;

                        case 2:
                            System.out.println("Ingrese el rut del paciente: ");
                            rut = scanner.nextLine();
                            if(hospital.existePaciente(rut)){
                                Paciente paciente = hospital.getPaciente(rut);
                                System.out.println("Ingrese nivel de gravedad del paciente: ");
                                gravedad = Integer.parseInt(scanner.nextLine());
                                paciente.setGravedad(gravedad);
                                if(gravedad == 1){
                                    hospital.reasignarPacienteEnCama(rut,"general");
                                    break;
                                }
                                if(gravedad == 2){
                                    hospital.reasignarPacienteEnCama(rut,"intermedia");
                                    break;
                                }
                                if(gravedad == 3){
                                    hospital.reasignarPacienteEnCama(rut,"intensiva");
                                    break;
                                }                                   
                            }
                            System.out.println("El paciente no esta registrado");
                            break;

                        case 3:
                            int numCama,tipo;
                            Cama cama;
                            System.out.println("Ingrese el numero de cama a registrar");
                            numCama = Integer.parseInt(scanner.nextLine());
                            if(!hospital.existeCama(numCama)){
                                System.out.println("Ingrese el tipo de cama a registrar: ");
                                System.out.println("1. General");
                                System.out.println("2. Intermedia");
                                System.out.println("3. Intensiva");
                                tipo = Integer.parseInt(scanner.nextLine());
                                while(tipo<1 || tipo>3){
                                    System.out.println("Valor invalido, ingrese nuevamente: ");
                                    tipo = Integer.parseInt(scanner.nextLine());
                                }
                                if(tipo==1){
                                    cama = hospital.crearCama(numCama, "general", true);
                                    hospital.agregarCama(cama);
                                    System.out.println("Registrada correctamente");
                                    break;
                                }
                                if(tipo==2){
                                    cama = hospital.crearCama(numCama, "intermedia", true);
                                    hospital.agregarCama(cama);
                                    System.out.println("Registrada correctamente");
                                    break;
                                }
                                if(tipo==3){
                                    cama = hospital.crearCama(numCama, "intensiva", true);
                                    hospital.agregarCama(cama);
                                    System.out.println("Registrada correctamente");
                                    break;
                                }                                                                                          
                            }
                            System.out.println("Ya existe una cama registrada con el numero "+numCama);
                            break;
                        case 4:
                            System.out.println("Ingrese el numero de cama a eliminar");
                            numCama = Integer.parseInt(scanner.nextLine());
                            if(hospital.existeCama(numCama)){
                                hospital.eliminarCama(hospital.getCama(numCama));
                                System.out.println("Cama eliminada con exito");
                                break;
                            }
                            System.out.println("No hay camas registradas con el numero ingresado");
                            break;
                        case 5:
                            break;
                        default:
                                System.out.println("Opcion no valida");
                        }
                    }while(subOpci0n!=5); 
                    break;
                case 3:
                    int option;
                    do{
                        menuMedicos();
                        System.out.println("Seleccione una opcion");
                        option = Integer.parseInt(scanner.nextLine());
                        switch(option){
                            case 1:
                                String rut;
                                String nombre;
                                int edad;
                                String especialidad;
                                System.out.println("Ingrese el rut del medico a registrar: ");
                                rut = scanner.nextLine();
                                if(!hospital.existeMedico(rut)){
                                    System.out.println("Ingrese el nombre del medico: ");
                                    nombre = scanner.nextLine();
                                    System.out.println("Ingrese la edad del medico: ");
                                    edad = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese la especialidad del medico: ");
                                    especialidad = scanner.nextLine();
                                    hospital.agregarMedico(hospital.crearMedico(nombre, rut, edad, especialidad, false));
                                    System.out.println("Se registro el medico correctamente");
                                    break;
                                }
                                System.out.println("El medico ya esta registrado");
                                break;
                            case 2:
                                System.out.println("Ingrese el rut del medico a eliminar: ");
                                rut = scanner.nextLine();
                                if(hospital.existeMedico(rut)){
                                    hospital.eliminarMedico(rut);
                                    System.out.println("El medico fue eliminado con exito");
                                    break;
                                }
                                System.out.println("El medico no existe");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcion no valida");                               
                        }
                    }while(option!=3);
                    break;
                case 4:
                    int opti0n;
                    do{
                        menuMostrar();
                        System.out.println("Seleccione una opcion");
                        opti0n = Integer.parseInt(scanner.nextLine());
                        switch(opti0n){
                            case 1:
                                int dia;
                                int mes;
                                int anio;
                                String rut;
                                System.out.println("Ingrese el rut del paciente");                               
                                rut = scanner.nextLine();
                                AtencionMedica atencion;
                                if(hospital.existePaciente(rut)){                                                                  
                                    System.out.println("Ingrese dia de la atencion medica");
                                    dia = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese mes de la atencion medica");
                                    mes = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese anio de la atencion medica");
                                    anio = Integer.parseInt(scanner.nextLine());
                                    String fecha = String.format("%02d/02d/%04d", dia,mes,anio);
                                    if(!hospital.existeAtencionMedica(rut, fecha)){
                                        atencion = hospital.getAtencionMedica(rut, fecha);
                                        System.out.println("Atencion medica de paciente:");
                                        System.out.println("Rut: "+rut);
                                        System.out.println("Fecha: "+atencion.getFecha());
                                        System.out.println("Diagnostico: "+atencion.getDiagnostico());
                                        break;
                                    }                                       
                                }
                                System.out.println("El paciente no esta registrado");
                                break;
                            case 2:
                                System.out.println("Ingrese el rut del paciente");
                                rut = scanner.nextLine();
                                if(hospital.existePaciente(rut)){
                                    hospital.mostrarAtencionesPaciente(rut);
                                    break;
                                }
                                System.out.println("El paciente no esta registrado");
                                break;
                            case 3:
                                System.out.println("Ingrese el rut del paciente: ");
                                rut = scanner.nextLine();
                                if(hospital.existePaciente(rut)){
                                    hospital.mostrarPacientes(rut);
                                    break;
                                }
                                System.out.println("El paciente no esta registrado");
                                break;
                            case 4:
                                hospital.mostrarCamasExistentes();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcion no valida"); 
                        }
                    }while(opti0n!=5);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no valida");                   
            }
        }while(opcion!=5);        
        System.out.println("Programa finalizado.");
}
   public static void mostrarMenu(String nombreHospital){
       System.out.println("------Menu Hospital "+nombreHospital+"------");
       System.out.println("1. Menu pacientes");
       System.out.println("2. Menu Camas");
       System.out.println("3. Menu Medicos");
       System.out.println("4. Menu Mostrar");
       System.out.println("5. Salir");
   }
   public static void menuPacientes(){
       System.out.println("------Menu Pacientes------");
       System.out.println("1. Registrar paciente");
       System.out.println("2. Registrar atencion medica a paciente");
       System.out.println("3. Dar de alta a paciente");
       System.out.println("4. Eliminar paciente");
       System.out.println("5. Regresar al menu principal");
   }
   public static void menuCamas(){
       System.out.println("------Menu Camas------");
       System.out.println("1. Asignar paciente a cama");
       System.out.println("2. Reubicar paciente en cama");
       System.out.println("3. Registrar cama");
       System.out.println("4. Eliminar cama");
       System.out.println("5. Regresar al menu principal");
   }
   public static void menuMedicos(){
       System.out.println("------Menu Medicos------");
       System.out.println("1. Registrar medico");
       System.out.println("2. Eliminar medico");
       System.out.println("3. Regresar al menu principal");
   }
   public static void menuMostrar(){
       System.out.println("------Menu Mostrar en pantalla------");
       System.out.println("1. Mostrar atencion medica");
       System.out.println("2. Mostrar todas las atenciones de paciente");
       System.out.println("3. Mostrar paciente");
       System.out.println("4. Mostrar camas existentes");
       System.out.println("5. Regresar al menu principal");
   }
}
*/