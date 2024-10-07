public class Cama{
  private int numCama;
  private String tipo;//3 tipos (general, intermedia, intensiva)
  private boolean disponible;
  private String rutPacienteAsignado;

  //CONSTRUCTORES
  public Cama(int numCama, String tipo,boolean disponible){
    this.numCama = numCama;
    this.tipo = tipo;
    this.disponible = disponible;
  }
  public Cama(int numCama, String tipo,boolean disponible, String rutPacienteAsignado){
    this.numCama = numCama;
    this.tipo = tipo;
    this.disponible = disponible;
    this.rutPacienteAsignado = rutPacienteAsignado;
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
  //METODOS
  //Asigna el rut pasado por parametro al rut de la clase
  public void asignarPaciente(String rut){
        rutPacienteAsignado = rut;
  }
  //Realiza lo mismo que el metodo anterior pero con el paciente por parametro
  public void asignarPaciente(Paciente paciente){
      rutPacienteAsignado = paciente.getRut();
  }
}
