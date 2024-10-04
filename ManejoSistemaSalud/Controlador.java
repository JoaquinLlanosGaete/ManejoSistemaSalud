import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {
    private Hospital hospital;
    private VentanaPrincipal ventanaPrincipal;
    private String directorioRuta = "src\\main\\resources\\data";
    private File directorio = new File(directorioRuta);
    private File camas = new File(directorioRuta+"\\camas.csv");
    private File medicos = new File(directorioRuta+"\\medicos.csv");
    private File pacientes = new File(directorioRuta+"\\pacientes.csv");
    private File atencion = new File(directorioRuta+"\\atenciones.csv");

    //CONSTRUCTOR
    //Recibe el hospital por parametro a controlar, inicializa el hospital, inicia los archivos y crea una ventana principal haciendola visible
    public Controlador(Hospital hospital) throws CsvValidationException {
        this.hospital = hospital;
        inicioArchivo();
        ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
    //Retorna un objeto tipo File
    public File getDirectorio(String nombre) {
        switch (nombre) {
            case "cama": return camas;
            case "medicos": return medicos;
            case "pacientes": return pacientes;
            case "atencion": return atencion;
            default: return null;
        }
    }
    //Ventanas, aqui se realiza el control de las ventanas
    public void mostrarVentanaPrincipal(){
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
    }
    public void mostrarVentanaPaciente(){
        VentanaPaciente ventanaPaciente = new VentanaPaciente(this);
        ventanaPaciente.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(false);
        ventanaPaciente.setVisible(true);
    }
    public void mostrarVentanaCama(){
        VentanaCama ventanaCama = new VentanaCama(this);
        ventanaPrincipal.setVisible(false);
        ventanaCama.setLocationRelativeTo(null);
        ventanaCama.setVisible(true);
    }
    public void mostrarVentanaMedico(){
        VentanaMedico ventanaMedico = new VentanaMedico(this);
        ventanaPrincipal.setVisible(false);
        ventanaMedico.setLocationRelativeTo(null);
        ventanaMedico.setVisible(true);
    }
    public void mostrarVentanaMostrar(){
        VentanaMostrarDatos ventanaMostrar = new VentanaMostrarDatos(this);
        ventanaPrincipal.setVisible(false);
        ventanaMostrar.setLocationRelativeTo(null);
        ventanaMostrar.setVisible(true);
    }
    public void mostrarVentanaRP(){
        VentanaRegistrarPaciente ventanaRP = new VentanaRegistrarPaciente(this);
        ventanaRP.setLocationRelativeTo(null);
        ventanaRP.setVisible(true);
    }
    public void mostrarVentanaAtencion(){
        VentanaRegistrarAtencion ventanaAm = new VentanaRegistrarAtencion(this);
        ventanaAm.setLocationRelativeTo(null);
        ventanaAm.setVisible(true);
    }
    public void mostrarVentanaAlta(){
        VentanaAltaPaciente ventanaAlta = new VentanaAltaPaciente(this);
        ventanaAlta.setLocationRelativeTo(null);
        ventanaAlta.setVisible(true);
    }
    public void mostrarVentanaEP(){
        VentanaEliminarPaciente ventanaEp = new VentanaEliminarPaciente(this);
        ventanaEp.setLocationRelativeTo(null);
        ventanaEp.setVisible(true);
    }
    public void mostrarVentanaAsignarCama(){
        VentanaAsignarCama ventanaAc = new VentanaAsignarCama(this);
        ventanaAc.setLocationRelativeTo(null);
        ventanaAc.setVisible(true);
    }
    public void mostrarVentanaReubicarCama(){
        VentanaReubicarCama ventantaRc = new VentanaReubicarCama(this);
        ventantaRc.setLocationRelativeTo(null);
        ventantaRc.setVisible(true);
    }
    public void mostrarVentanaRegistrarCama(){
        VentanaRegistrarCama ventantaRc = new VentanaRegistrarCama(this);
        ventantaRc.setLocationRelativeTo(null);
        ventantaRc.setVisible(true);
    }
    public void mostrarVentanaEliminarCama(){
        VentanaEliminarCama ventanaEc = new VentanaEliminarCama(this);
        ventanaEc.setLocationRelativeTo(null);
        ventanaEc.setVisible(true);
    }
    public void mostrarVentanaRegistrarM(){
        VentanaRegistrarMedico ventanaRm = new VentanaRegistrarMedico(this);
        ventanaRm.setLocationRelativeTo(null);
        ventanaRm.setVisible(true);
    }
    public void mostrarVentanaEliminarM(){
        VentanaEliminarMedico ventanaEm = new VentanaEliminarMedico(this);
        ventanaEm.setLocationRelativeTo(null);
        ventanaEm.setVisible(true);
    }
    public void mostrarVentanaEdicion(){
        VentanaEdicion ventanaE = new VentanaEdicion(this);
        ventanaE.setLocationRelativeTo(null);
        ventanaE.setVisible(true);
    }
    public void mostrarVentanaEditarAt(){
        VentanaEditarAt ventanaE = new VentanaEditarAt(this);
        ventanaE.setLocationRelativeTo(null);
        ventanaE.setVisible(true);
    }
    public void mostrarVentanaEliminarAt(){
        VentanaEliminarAt ventanaAt = new VentanaEliminarAt(this);
        ventanaAt.setLocationRelativeTo(null);
        ventanaAt.setVisible(true);
    }
    public void mostrarVentanaAtencionMedica(){
        VentanaMostrarAt vent = new VentanaMostrarAt(this);
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
    }
    public void mostrarVentanaMostrarAtenciones(){
        VentanaMostrarAtenciones vent = new VentanaMostrarAtenciones(this);
        vent.setLocationRelativeTo(null);

        vent.setVisible(true);
    }
    public void mostrarVentanaMostrarPaciente(){
        VentanaMostrarPaciente vent = new VentanaMostrarPaciente(this);
        vent.setLocationRelativeTo(null);

        vent.setVisible(true);
    }
    public void mostrarVentanaMostrarCamas(){
        VentanaMostrarCamas vent = new VentanaMostrarCamas(this);
        vent.setLocationRelativeTo(null);

        vent.setVisible(true);
    }
    public void mostrarVentanaFiltrarCamas(){
        VentanaFiltrarCamas vent = new VentanaFiltrarCamas(this);
        vent.setLocationRelativeTo(null);

        vent.setVisible(true);
    }
    
    //METODOS
    //Valida que el rut tenga exactamente 9 digitos
    public boolean validarRut(String rut) {
        return rut.matches("\\d{9}");
    }
    //retorna la cantidad de camas que tiene el hospital
    public int getCantCamas(){
        int cant = hospital.getCantCamas();
        return cant;
    }
    //retorna la lista de camas del hospital
    public List<Cama> getListaCamas(){
        List<Cama> lista = hospital.getListaCamas();
        return lista;
    }
    //retorna un paciente buscandolo por su rut
    public Paciente getPaciente(String rut){
        Paciente p = hospital.getPaciente(rut);
        return p;
    }
    //retorna la cantidad de atenciones de un paciente
    public int getCantAtenciones(String rutP){
        Paciente p = hospital.getPaciente(rutP);
        int cant = p.getCantAtenciones();
        return cant;
    }
    //retorna la fecha de una atencion
    public String getFechaAtencion(String rutP, int posicion){
        Paciente p = hospital.getPaciente(rutP);
        List<AtencionMedica> lista = p.getAtencionesMedicas();
        AtencionMedica at = lista.get(posicion);
        String fecha = at.getFecha();
        return fecha;
    }
    //retorna el diagnostico de una atencion
    public String getDiagnosticoAtencion(String rut, String fecha){
        Paciente paciente = hospital.getPaciente(rut);
        AtencionMedica at = paciente.getAtencionMedica(fecha);
        String diagnostico = at.getDiagnostico();
        return diagnostico;
    }
    //Elimina una atención medica
    public void eliminarAtencionMedica(String rut, String fecha){
        Paciente paciente = hospital.getPaciente(rut);
        paciente.eliminarAtencionMedica(fecha);
    }
    //Modifica el diagnostico de una atencion medica
    public void modificarDiagnosticoAt(String rut, String fecha, String diagnostico){
        Paciente paciente = hospital.getPaciente(rut);
        AtencionMedica at = paciente.getAtencionMedica(fecha);
        at.setDiagnostico(diagnostico);
    }
    //verifica que exista una atencion medica
    public boolean existeAtencionMedica(String rut,String fecha){
        if(hospital.existeAtencionMedica(rut, fecha)){
            return true;
        }
        return false;
    }
    //Elimina el registro de un medico
    public void eliminarMedico(String rut){
        hospital.eliminarMedico(rut);
    }
    //Verifica que exista un medico
    public boolean existeMedico(String rut){
        if(hospital.existeMedico(rut)){
            return true;
        }
        return false;
    }
    //Registra un medico en el hospital
    public void registrarMedico(String nombre,String rut, String especialidad){
        Medico medicoN = new Medico(nombre,rut,especialidad,true);
        hospital.agregarMedico(medicoN);
    }
    //Elimina el registro de una cama
    public void eliminarCama(int numCama){
        Cama cama = hospital.getCama(numCama);
        hospital.eliminarCama(cama);
    }
    //verifica que exista una cama
    public boolean existeCama(int numCama){
        if(hospital.existeCama(numCama)){
            return true;
        }
        else return false;
    }
    //Registra una cama
    public void registrarCama(int numCama, String tipo){
        Cama camaN;
        camaN = hospital.crearCama(numCama, tipo, true);
        hospital.agregarCama(camaN);
    }
    //Reubica un paciente en una cama
    public boolean reubicarPaciente(String rut, int gravedad){
        if(gravedad == 1){
            if(hospital.reasignarPacienteEnCama(rut,"general")){
                return true;
            }
            else return false;
        }
        if(gravedad == 2){
            if(hospital.reasignarPacienteEnCama(rut,"intermedia")){
                return true;
            }
            else return false;
        }
        if(gravedad == 3){
            if(hospital.reasignarPacienteEnCama(rut,"intensiva")){
                return true;
            }
            else return false;
        }
        return false;
    }
    //Asigna un paciente en una cama
    public boolean asignarCama(String rut, int gravedad){
        if(hospital.ubicarPacienteEnCama(rut, gravedad)){
                return true;
        }
        else return false;
    }
    //elimina el registro de un paciente
    public void eliminarPaciente(String rut){
        hospital.eliminarPaciente(rut);
    }
    //da el alta a un paciente
    public void darAltaPaciente(String rut){
        Paciente paciente = hospital.getPaciente(rut);
        paciente.setAlta(true);
    }
    //verifica que exista un paciente
    public boolean existePaciente(String rut){
        if(hospital.existePaciente(rut)){
            return true;
        }
        return false;
    }
    //Registra una atencion medica a paciente
    public void registrarAtencionMedica(String rut,AtencionMedica atencion){
        hospital.agregarAtencionMedica(rut,atencion);
    }
    //Registra un paciente
    public void registrarPaciente(String nombre,String rut, int edad){
        Paciente paciente = new Paciente(nombre, rut, edad);
        hospital.agregarPaciente(rut, paciente);
    }
    //Verifica existencia de paciente
    public boolean verificarExistenciaPaciente(String rut){
        if(hospital.existePaciente(rut))
            return true;
        return false;
    }
    //Inicia los archivos CSV
    public void inicioArchivo() {
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio de datos creado: ManejoSistemaSalud\\src\\main\\" + directorioRuta);
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        }
        try {
            if(camas.createNewFile()){
                System.out.println("[!] Archivo de datos de Camas inexistente.\n- Creando camas.csv en: "+ camas);
            } else {
                cargarCamas(camas);
            }
            if(medicos.createNewFile()){
                System.out.println("[!] Archivo de datos de Medicos inexistente.\n- Creando medicos.csv en: "+ medicos);
            } else {
                cargarMedicos(medicos);
            }
            if(pacientes.createNewFile()){
                System.out.println("[!] Archivo de datos de Pacientes inexistente.\n- Creando pacientes.csv en: "+ pacientes);
            } else {
                cargarPacientes(pacientes);
            }
            if(atencion.createNewFile()){
                System.out.println("[!] Archivo de datos de Atenciones Medicas inexistente.\n- Creando atencion.csv en: "+ atencion);
            } else {
                cargarAtenciones(atencion);
            }
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Carga la lista de camas desde el csv
    public void cargarCamas(File arch) {
        List <Cama> camas = new ArrayList<>();
        String separador = ";";  // Separador de columnas en el CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] nextLine = linea.split(separador);
                int numCama = Integer.parseInt(nextLine[0]);
                String tipo = nextLine[1];
                boolean disponible = true;
                String rut = "Sin rut"
;                if (nextLine.length >= 3) {
                    try {
                        disponible = Boolean.parseBoolean(nextLine[2]);
                        if(Boolean.parseBoolean(nextLine[2]) && nextLine.length==4){
                            rut = nextLine[3];
                        }
                    } catch (NumberFormatException e) {
                    }
                }
                Cama camita = new Cama(numCama, tipo, disponible, rut);
                camas.add(camita);
            }

        } catch (IOException ignored) {
        }
        System.out.println("CAMAS CARGADAS\n--------------");
        for(Cama c: camas){
            System.out.println("Tipo cama: " + c.getTipo() + " Nro de Cama: " + c.getNumCama() + " Disponibilidad: " + (c.getDisponible() ? "Sí" : "No"));
        }
        hospital.setListaCamas(camas);

    }
    //Carga la lista de medicos desde el CSV
    public void cargarMedicos(File arch) {
        List <Medico> medicos = new ArrayList<>();
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] nextLine = linea.split(separador);
                String nombre = nextLine[0];
                String rut = nextLine[1];
                String especialidad = nextLine[2];
                boolean disponible = Boolean.parseBoolean(nextLine[3]);

                Medico mediquito = new Medico(nombre, rut, especialidad, disponible);
                medicos.add(mediquito);
            }

        } catch (IOException ignored) {
        }
        System.out.println("MEDICOS CARGADOS\n--------------");
        for(Medico c: medicos){
            System.out.println("Nombre: " + c.getNombre() + " Rut: " + c.getRut() + " Especialidad: " + c.getEspecialidad() + " Disponibilidad: " + (c.getDisponibilidad() ? "Sí" : "No"));
        }
        hospital.setListaMedicos(medicos);
    }
    //carga el mapa Pacientes desde el CSV
    public void cargarPacientes(File arch) {
        HashMap <String, Paciente> mapa = new HashMap<>();
        String separador = ";";

        try(BufferedReader br = new BufferedReader(new FileReader(arch))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] nextLine = linea.split(separador);
                String nombre = nextLine[0];
                String rut = nextLine[1];
                int edad = Integer.parseInt(nextLine[2]);
                int gravedad = 0;
                if(nextLine.length >= 4){
                    try{
                        gravedad = Integer.parseInt(nextLine[3]);
                    }catch(NumberFormatException e){
                    }
                }
                Paciente pacientecito = new Paciente(nombre, rut, edad, gravedad);

                mapa.put(rut, pacientecito);
            }

        }catch(IOException ignored){
        }
        System.out.println("PACIENTES CARGADOS\n--------------");

        for(Map.Entry<String, Paciente> c: mapa.entrySet()){
            System.out.println("Nombre: " + c.getValue().getNombre() + " Rut: " + c.getValue().getRut() + " Edad: " + c.getValue().getEdad() + " Gravedad: " + c.getValue().getGravedad());
        }
        hospital.setListaPacientes(mapa);
    }
    public void cargarAtenciones(File arch) {
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] nextLine = linea.split(separador);
                String rut = nextLine[0];
                String fecha = nextLine[1];
                String diagnostico = nextLine[2];

                AtencionMedica atenczao = new AtencionMedica(fecha, diagnostico);
                hospital.agregarAtencionMedica(rut,atenczao);
            }

        } catch (IOException ignored) {
        }

    }
    //Elimina un dato del CSV
    public void eliminarDato(File arch, String criterio) throws CsvValidationException{
        List<String> lineasFiltradas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(arch))){
            String linea;
            while((linea = br.readLine()) != null){
                if(!linea.contains(criterio)){
                    lineasFiltradas.add(linea);
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(arch))){
                for(String l : lineasFiltradas){
                    bw.write(l);
                    bw.newLine();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //graba un dato en el CSV
    public void grabarDato(File arch, String criterio) throws CsvValidationException{

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arch, true))){
            bw.write(criterio);
            bw.newLine();
            System.out.println("Línea agregada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

