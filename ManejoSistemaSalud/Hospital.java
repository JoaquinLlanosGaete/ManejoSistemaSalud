import java.util.*;
import java.util.Scanner;
public class Hospital {
    private List<Medico> listaMedicos;
    private HashMap<String, Paciente> mapaPacientes;
    private List<Cama> listaCamas;

    //CONSTRUCT
    public Hospital(){
        listaMedicos = new ArrayList<>();
        mapaPacientes = new HashMap<>();
        listaCamas = new ArrayList<>();
    }
    //GETTER Y SETTER
    public void setListaCamas(List Cama){
        this.listaCamas = Cama;
    }
    public void setListaMedicos(List Medicos){
        this.listaMedicos = Medicos;
    }
    public void setListaPacientes(HashMap Medicos){
        this.mapaPacientes = Medicos;
    }
    public List<Cama> getListaCamas(){
        return listaCamas;
    }
    public Paciente getPaciente(String rut){
        return mapaPacientes.get(rut);
    }
    public int getCantCamas(){
        return listaCamas.size();
    }
    public Cama getCama(int numCama){
        int cantCamas = listaCamas.size(),i;
        for(i = 0;i<cantCamas;i++){
            if(listaCamas.get(i).getNumCama()==numCama)
                return listaCamas.get(i);
        }
        return null;
    }
    public AtencionMedica getAtencionMedica(String rut,String fecha){
        if(existeAtencionMedica(rut,fecha)){
            AtencionMedica atencion = mapaPacientes.get(rut).getAtencionMedica(fecha);
            return atencion;
        }
        return null;
    }
    //METODOS
    //Agrega un medico a la lista
    public void agregarMedico(Medico medico){
        if(!listaMedicos.contains(medico))
            listaMedicos.add(medico);
    }
    //Elimina el registro de un medico con el medico como parametro
    public void eliminarMedico(Medico medico){
        if(listaMedicos.contains(medico))
            listaMedicos.remove(medico);
    }
    //Elimina el registro de un medico con el medico como parametro
    public void eliminarMedico(String rut){
        int cantMedicos = listaMedicos.size(),i;
        for(i=0;i<cantMedicos;i++){
            if(listaMedicos.get(i).getRut().equals(rut)){

                listaMedicos.remove(i);
                return;
            }
        }        
    }
    //agrega un paciente al mapa pacientes
    public void agregarPaciente(String rut,Paciente paciente){
        if(!mapaPacientes.containsKey(rut))
            mapaPacientes.put(rut,paciente);
    }
    //elimina un paciente del mapa
    public void eliminarPaciente(String rut){
        if(mapaPacientes.containsKey(rut)){
            mapaPacientes.remove(rut);
            System.out.println("El paciente fue eliminado con exito");
            return;
        }
        System.out.println("El rut del paciente ingresado no existe");
    }
    //agrega cama a lista camas
    public void agregarCama(Cama cama){
        if(!listaCamas.contains(cama))
            listaCamas.add(cama);
    }
    //elimina cama de lista camas
    public void eliminarCama(Cama cama){
        if(listaCamas.contains(cama)){
            listaCamas.remove(cama);
        }
    }
    //ubica un paciente en una cama disponible
    public void ubicarPacienteEnCama(String rut){
         int gravedad,cantCamas,i;
         Paciente paciente;
         
         
         Scanner scanner = new Scanner(System.in);
         if(!mapaPacientes.containsKey(rut)){
             System.out.println("El paciente no se encuentra registrado.");
             return;
         }
         System.out.println("Por favor ingrese la gravedad del paciente");
         gravedad = Integer.parseInt(scanner.nextLine());
         paciente = mapaPacientes.get(rut);
         paciente.setGravedad(gravedad);
         cantCamas = listaCamas.size();
         if(gravedad==1){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("general")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(rut);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas generales disponibles");
             }
         } 
         if(gravedad==2){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intermedia")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(rut);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas intermedias disponibles");
             }
         }
         if(gravedad==3){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intensiva")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(rut);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas intensivas disponibles, el paciente tendrá la mayor prioridad");
             }
         }
    }
    //ubica paciente en cama disponible
    public boolean ubicarPacienteEnCama(String rut,int gravedad){
        int cantCamas,i; 
         if(!mapaPacientes.containsKey(rut)){
             return false;
         }
         Paciente paciente = mapaPacientes.get(rut);
         cantCamas = listaCamas.size();
         if(gravedad==1){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("general")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(paciente);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return true;
                 }
             }
             System.out.println("No hay camas generales disponibles, el paciente se encuentra en lista de espera");
             return false;
         } 
         if(gravedad==2){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intermedia")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(paciente);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return true;
                 }                
             }
             System.out.println("No hay camas intermedias disponibles, el paciente será atendido pronto");
             return false;
         }
         if(gravedad==3){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intensiva")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(paciente);
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return true;
                 }               
             }
             System.out.println("No hay camas intensivas disponibles, el paciente tendrá la mayor prioridad");
             return false;
         }
         return false;
    }
    //ubica paciente en cama disponible con paciente como parametro
    public void ubicarPacienteEnCama(Paciente paciente){
         int gravedad,cantCamas,i;
         Paciente pacienteParaUbicar = paciente;
         
         
         Scanner scanner = new Scanner(System.in);
         if(!mapaPacientes.containsKey(pacienteParaUbicar.getRut())){
             System.out.println("El paciente no se encuentra registrado.");
             return;
         }
         System.out.println("Por favor ingrese la gravedad del paciente");
         gravedad = Integer.parseInt(scanner.nextLine());
         pacienteParaUbicar = mapaPacientes.get(pacienteParaUbicar.getRut());
         pacienteParaUbicar.setGravedad(gravedad);
         cantCamas = listaCamas.size();
         if(gravedad==1){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("general")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(pacienteParaUbicar.getRut());
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas generales disponibles");
             }
         } 
         if(gravedad==2){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intermedia")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(pacienteParaUbicar.getRut());
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas intermedias disponibles");
             }
         }
         if(gravedad==3){
             for(i=0;i<cantCamas;i++){
                 if(listaCamas.get(i).getTipo().equals("intensiva")&&(listaCamas.get(i).getDisponible()==true)){
                     listaCamas.get(i).asignarPaciente(pacienteParaUbicar.getRut());
                     System.out.println("El paciente fue asignado en la cama "+listaCamas.get(i).getNumCama());
                     listaCamas.get(i).setDisponible(false);
                     return;
                 }
                 System.out.println("No hay camas intensivas disponibles, el paciente tendrá la mayor prioridad");
             }
         }
    }
    //reasigna paciente en otra cama
    public boolean reasignarPacienteEnCama(String rut,String tipoDeCamaAAsignar){
        Paciente paciente = mapaPacientes.get(rut);
        int cantCamas = listaCamas.size(),i;
        if (paciente == null) {
            System.out.println("El paciente no se encuentra registrado.");
            return false;
        }
        for(i=0;i<cantCamas;i++){
            if(listaCamas.get(i).getTipo().equals(tipoDeCamaAAsignar)&& (listaCamas.get(i).getDisponible() == true)){
                listaCamas.get(i).asignarPaciente(rut);
                System.out.println("El paciente fue reasignado con exito en la cama "+ listaCamas.get(i).getNumCama());
                listaCamas.get(i).setDisponible(false);
                return true;
            }
        }
        if(paciente.getGravedad() == 3){
            System.out.println("No hay camas "+tipoDeCamaAAsignar+" disponibles, el paciente tiene prioridad");
            return false;
        }
        else {
            System.out.println("No hay camas "+tipoDeCamaAAsignar+" disponibles");
            return false;
        }
    }
    //da el alta a paciente
    public void darAltaPaciente(String rut){
        int cantCamas,i;
        if(!mapaPacientes.containsKey(rut)){
            System.out.println("El paciente no se encuentra registrado");
            return;
        }
        mapaPacientes.get(rut).setGravedad(0);
        cantCamas = listaCamas.size();
        for(i=0;i<cantCamas;i++){
            if (listaCamas.get(i).getPacienteAsignado() != null && listaCamas.get(i).getPacienteAsignado().equals(rut)) {
                listaCamas.get(i).setPacienteAsignado(null);
                listaCamas.get(i).setDisponible(true);
            }
        }
        System.out.println("El paciente fue dado de alta");
    }
    //verifica que exista paciente
    public boolean existePaciente(String rut){
        if(mapaPacientes.containsKey(rut))
            return true;
        return false;
    }
    //verifica que exista cama
    public boolean existeCama(int numeroCama){
        int cantCamas = listaCamas.size(),i;
        if(cantCamas == 0)
            return false;
        for(i=0;i<cantCamas;i++){
            if(listaCamas.get(i).getNumCama()==numeroCama)
                return true;
        }
        return false;
    }
    //retorna una cama nueva
    public Cama crearCama(int numero, String tipo, boolean disponible){
        Cama cama = new Cama(numero,tipo,true);     
        return cama;
    }
    //verifica existencia de medico
    public boolean existeMedico(String rut){
        int cantMedicos = listaMedicos.size(),i;
        for(i=0;i<cantMedicos;i++){
            if(listaMedicos.get(i).getRut().equals(rut))
                return true;
        }
        return false;
    }
    //retorna un medico nuevo
    public Medico crearMedico(String nombre,String rut,String especialidad,Boolean disponibilidad){
        Medico medico = new Medico(nombre,rut,especialidad,disponibilidad);
        return medico;
    }
    //agrega atencion medica a paciente
    public void agregarAtencionMedica(String rutPaciente,String fecha, String diagnostico){
        mapaPacientes.get(rutPaciente).agregarAtencionMedica(fecha, diagnostico);
    }
    //agrega atencion medica a paciente
    public void agregarAtencionMedica(String rut, AtencionMedica atencion){
        mapaPacientes.get(rut).agregarAtencionMedica(atencion);
    }
    //verifica que exista una atencion medica
    public boolean existeAtencionMedica(String rut, String fecha){
        int cantAtenciones = mapaPacientes.get(rut).getCantAtenciones();
        if(cantAtenciones == 0)
            return false;
        for(int i=0;i<cantAtenciones;i++){
            if(mapaPacientes.get(rut).existeAtencion(fecha))
                return true;
        }
        return false;
    }
    //muestra por consola las atenciones de un paciente
    public void mostrarAtencionesPaciente(String rut){
        Paciente paciente = mapaPacientes.get(rut);
        if(paciente == null){
            System.out.println("El paciente no se encuentra registrado");
            return;
        }
        if (paciente.getAtencionesMedicas() != null) {
            int cantAtenciones = paciente.getCantAtenciones();
            if (cantAtenciones > 0) {
                List<AtencionMedica> atenciones = paciente.getAtencionesMedicas();
                for (int i = 0; i < cantAtenciones; i++) {
                    AtencionMedica atencion = atenciones.get(i);
                    System.out.println("Atencion " + (i + 1) + ":");
                    System.out.println("Fecha: " + atencion.getFecha());
                    System.out.println("Diagnostico: " + atencion.getDiagnostico() + "\n");
                }
            }
            else
                System.out.println("El paciente no tiene atenciones medicas registradas.");
            } 
        else 
            System.out.println("El paciente no tiene atenciones medicas");
    }
    //muestra las camas existentes
    public void mostrarCamasExistentes(){
        int cantCamas = listaCamas.size(),i;
        if(cantCamas == 0){
            System.out.println("No hay camas registradas.");
            return;
        }
        System.out.println("Camas existentes:");
        for(i=0;i<cantCamas;i++){
             System.out.println("Cama numero: "+listaCamas.get(i).getNumCama());
             System.out.println("Tipo de cama: "+listaCamas.get(i).getTipo());
             if(listaCamas.get(i).getDisponible()){
                 System.out.println("Disponibilidad: Desocupada\nasda");
             }
             else{
                 System.out.println("Disponibilidad: Ocupada\n");
             }  
             
        }
    }
    public void inicializarCamas() {
        listaCamas.add(new Cama(1,"general",true));
        listaCamas.add(new Cama(2,"intensiva",false));
        listaCamas.add(new Cama(3,"intermedia",false));
        listaCamas.add(new Cama(4,"general",true));
        listaCamas.add(new Cama(5,"intermedia",false));
        listaCamas.add(new Cama(6,"intermedia",true));
    }
    public void inicializarPacientesConAtencionesMedicas() {
        Paciente paciente1 = new Paciente("Carlos", "123456789", 30, 2);
        Paciente paciente2 = new Paciente("Maria", "213456789", 25, 1);
        Paciente paciente3 = new Paciente("Fernando", "897654357", 30, 2);
        Paciente paciente4 = new Paciente("Maria", "908756432", 25, 1);
        
        paciente1.agregarAtencionMedica("01/02/2003","resfrio");
        paciente1.agregarAtencionMedica("02/04/2003","gripe");
        paciente2.agregarAtencionMedica("01/08/2002","cancer");
        paciente2.agregarAtencionMedica("02/09/2007","resfrio");
        paciente3.agregarAtencionMedica("01/10/2008","resfrio");
        paciente3.agregarAtencionMedica("02/11/2010","gripe");
        paciente4.agregarAtencionMedica("01/10/2020","dolor de barriga");
        paciente4.agregarAtencionMedica("02/04/2005","esguince");
        
        mapaPacientes.put(paciente1.getRut(), paciente1);
        mapaPacientes.put(paciente2.getRut(), paciente2);
        mapaPacientes.put(paciente3.getRut(), paciente3);
        mapaPacientes.put(paciente4.getRut(), paciente4);
    }
    public void mostrarPacientes(String rut){
        System.out.println("Paciente: ");
        System.out.println("Nombre :"+mapaPacientes.get(rut).getNombre());
        System.out.println("Rut: "+mapaPacientes.get(rut).getRut());
        System.out.println("Edad: "+mapaPacientes.get(rut).getEdad());
        System.out.println("Su nivel de gravedad es: "+mapaPacientes.get(rut).getGravedad());
    }
}