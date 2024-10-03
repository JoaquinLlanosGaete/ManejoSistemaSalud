public class AtencionMedica {
    private String fecha;
    private String diagnostico;
    
    //CONSTRUCTOR
    public AtencionMedica(int dia,int mes,int año,String diagnostico){
        this.fecha = String.format("%02d/%02d/%04d", dia,mes,año);
        this.diagnostico = diagnostico;
    }
    public AtencionMedica(String fecha,String diagnostico){
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }
    //GETTER Y SETTER
    public String getFecha(){
        return fecha;
    }
    public String getDiagnostico(){
        return diagnostico;
    }
    public void setFecha(int dia,int mes,int año){
        this.fecha = String.format("%02d/%02d/%04d", dia,mes,año);
    }
    public void setDiagnostico(String diagnostico){
        this.diagnostico = diagnostico;
    }
}
