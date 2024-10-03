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
  public String getDisponibilidadSiNo(){
      if(disponible == true)
          return "Si";
      return "No";
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
  public void asignarPaciente(String rut){
        rutPacienteAsignado = rut;
    }
  public void asignarPaciente(Paciente paciente){
      rutPacienteAsignado = paciente.getRut();
  }
}
