import java.util.*;
import java.util.ArrayList;

public class Paciente{
    private String nombre;
    private String rut;
    private int edad;
    private int nivelGravedad;//de 1 a 3, 0 no se encuentra en asistencia
    private boolean dadoDeAlta;
    private List<AtencionMedica> listaAtencionesMedicas = new ArrayList<>();
    
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
    public void setListaAtencionesMedicas(List Atenciones){
        this.listaAtencionesMedicas = Atenciones;
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
    public void setAlta(boolean alta){
        this.dadoDeAlta = alta;
    }
    //METODOS
    //Valida que el rut tenga 9 digitos exactamente
    public boolean validarRut(String rut) {
        return rut.matches("\\d{9}");
    }
    //agrega atencion medica a paciente
    public void agregarAtencionMedica(String fecha, String diagnostico){
        if(this.listaAtencionesMedicas == null){
            this.listaAtencionesMedicas = new ArrayList<>();
        }
        this.listaAtencionesMedicas.add(new AtencionMedica(fecha,diagnostico));
    }
    //agrega atencion medica a paciente
    public void agregarAtencionMedica(AtencionMedica atencion){
        listaAtencionesMedicas.add(atencion);
    }
    //verifica existencia de atencion
    public boolean existeAtencion(String fecha){
        int cantAtenciones = listaAtencionesMedicas.size();
        for(int i = 0;i<cantAtenciones;i++){
            if(listaAtencionesMedicas.get(i).getFecha().equals(fecha))
                return true;
        }
        return false;
    }
    //elimina atencion medica
    public void eliminarAtencionMedica(String fecha){
        int cantAtenciones =  listaAtencionesMedicas.size();
        for(int i = 0;i<cantAtenciones;i++){
            if(listaAtencionesMedicas.get(i).getFecha().equals(fecha)){
                listaAtencionesMedicas.remove(i);
                return;
            }
        }
    }
}
