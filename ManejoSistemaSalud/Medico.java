public class Medico{
    private String nombre;
    private String rut;
    private String especialidad;
    private Boolean disponibilidad;

    //CONSTRUCTORES
    public Medico(String nombre,String rut,String especialidad,Boolean disponibilidad){
      this.nombre = nombre;
      this.rut = rut;
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
   public void setEspecialidad(String especialidad){
       this.especialidad = especialidad;
   }
}