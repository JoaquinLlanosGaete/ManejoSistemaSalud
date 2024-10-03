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

    //CONSTRUCTOR
    public Controlador(Hospital hospital) throws CsvValidationException {
        this.hospital = hospital;
        inicioArchivo();
        ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setVisible(true);
    }
    public File getDirectorio(String nombre) {
        switch (nombre) {
            case "cama": return camas;
            case "medicos": return medicos;
            case "pacientes": return pacientes;
            default: return null;
        }
    }
    //VENTANAS
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
    public void mostrarVentanaAtencion(){
        VentanaRegistrarAtencion ventanaAm = new VentanaRegistrarAtencion(this);
        ventanaAm.setVisible(true);
    }
    public void mostrarVentanaAlta(){
        VentanaAltaPaciente ventanaAlta = new VentanaAltaPaciente(this);
        ventanaAlta.setVisible(true);
    }
    public void mostrarVentanaEP(){
        VentanaEliminarPaciente ventanaEp = new VentanaEliminarPaciente(this);
        ventanaEp.setVisible(true);
    }
    public void mostrarVentanaAsignarCama(){
        VentanaAsignarCama ventanaAc = new VentanaAsignarCama(this);
        ventanaAc.setVisible(true);
    }
    public void mostrarVentanaReubicarCama(){
        VentanaReubicarCama ventantaRc = new VentanaReubicarCama(this);
        ventantaRc.setVisible(true);
    }
    public void mostrarVentanaRegistrarCama(){
        VentanaRegistrarCama ventantaRc = new VentanaRegistrarCama(this);
        ventantaRc.setVisible(true);
    }
    public void mostrarVentanaEliminarCama(){
        VentanaEliminarCama ventanaEc = new VentanaEliminarCama(this);
        ventanaEc.setVisible(true);
    }
    public void mostrarVentanaRegistrarM(){
        VentanaRegistrarMedico ventanaRm = new VentanaRegistrarMedico(this);
        ventanaRm.setVisible(true);
    }
    public void mostrarVentanaEliminarM(){
        VentanaEliminarMedico ventanaEm = new VentanaEliminarMedico(this);
        ventanaEm.setVisible(true);
    }
    public void mostrarVentanaEdicion(){
        VentanaEdicion ventanaE = new VentanaEdicion(this);
        ventanaE.setVisible(true);
    }
    public void mostrarVentanaEditarAt(){
        VentanaEditarAt ventanaE = new VentanaEditarAt(this);
        ventanaE.setVisible(true);
    }
    public void mostrarVentanaEliminarAt(){
        VentanaEliminarAt ventanaAt = new VentanaEliminarAt(this);
        ventanaAt.setVisible(true);
    }
    public void mostrarVentanaAtencionMedica(){
        VentanaMostrarAt vent = new VentanaMostrarAt(this);
        vent.setVisible(true);
    }
    public void mostrarVentanaMostrarAtenciones(){
        VentanaMostrarAtenciones vent = new VentanaMostrarAtenciones(this);
        vent.setVisible(true);
    }
    public void mostrarVentanaMostrarPaciente(){
        VentanaMostrarPaciente vent = new VentanaMostrarPaciente(this);
        vent.setVisible(true);
    }    
    
    //METODOS
    public boolean validarRut(String rut) {
        return rut.matches("\\d{9}");
    }
    public int getCantCamas(){
        int cant = hospital.getCantCamas();
        return cant;
    }
    public List<Cama> getListaCamas(){
        List<Cama> lista = hospital.getListaCamas();
        return lista;
    }
    public Paciente getPaciente(String rut){
        Paciente p = hospital.getPaciente(rut);
        return p;
    }
    public int getCantAtenciones(String rutP){
        Paciente p = hospital.getPaciente(rutP);
        int cant = p.getCantAtenciones();
        return cant;
    }
    public String getFechaAtencion(String rutP, int posicion){
        Paciente p = hospital.getPaciente(rutP);
        List<AtencionMedica> lista = p.getAtencionesMedicas();
        AtencionMedica at = lista.get(posicion);
        String fecha = at.getFecha();
        return fecha;
    }
    public String getDiagnosticoAtencion(String rut, String fecha){
        Paciente paciente = hospital.getPaciente(rut);
        AtencionMedica at = paciente.getAtencionMedica(fecha);
        String diagnostico = at.getDiagnostico();
        return diagnostico;
    }
    public void eliminarAtencionMedica(String rut, String fecha){
        Paciente paciente = hospital.getPaciente(rut);
        paciente.eliminarAtencionMedica(fecha);
    }
    public void modificarDiagnosticoAt(String rut, String fecha, String diagnostico){
        Paciente paciente = hospital.getPaciente(rut);
        AtencionMedica at = paciente.getAtencionMedica(fecha);
        at.setDiagnostico(diagnostico);
    }
    public boolean existeAtencionMedica(String rut,String fecha){
        if(hospital.existeAtencionMedica(rut, fecha)){
            return true;
        }
        return false;
    }
    public void eliminarMedico(String rut){
        hospital.eliminarMedico(rut);
    }
    public boolean existeMedico(String rut){
        if(hospital.existeMedico(rut)){
            return true;
        }
        return false;
    }
    public void registrarMedico(String nombre,String rut, String especialidad){
        Medico medicoN = new Medico(nombre,rut,especialidad,true);
        hospital.agregarMedico(medicoN);
    }
    public void eliminarCama(int numCama){
        Cama cama = hospital.getCama(numCama);
        hospital.eliminarCama(cama);
    }
    public boolean existeCama(int numCama){
        if(hospital.existeCama(numCama)){
            return true;
        }
        else return false;
    }
    public void registrarCama(int numCama, String tipo){
        Cama camaN;
        camaN = hospital.crearCama(numCama, tipo, true);
        hospital.agregarCama(camaN);
    }
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
    public boolean asignarCama(String rut, int gravedad){
        if(hospital.ubicarPacienteEnCama(rut, gravedad)){
                return true;
        }
        else return false;
    }
    public void eliminarPaciente(String rut){
        hospital.eliminarPaciente(rut);
    }
    public void darAltaPaciente(String rut){
        Paciente paciente = hospital.getPaciente(rut);
        paciente.setAlta(true);
    }
    public boolean existePaciente(String rut){
        if(hospital.existePaciente(rut)){
            return true;
        }
        return false;
    }
    public void registrarAtencionMedica(String rut,AtencionMedica atencion){
        hospital.agregarAtencionMedica(rut,atencion);
    }
    public void registrarPaciente(String nombre,String rut, int edad){
        Paciente paciente = new Paciente(nombre, rut, edad);
        hospital.agregarPaciente(rut, paciente);
    }
    public boolean verificarExistenciaPaciente(String rut){
        if(hospital.existePaciente(rut))
            return true;
        return false;
    }
    public void inicioArchivo() throws CsvValidationException {
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
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarCamas(File arch) throws CsvValidationException{
        List <Cama> camas = new ArrayList<>();
        String separador = ";";  // Separador de columnas en el CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] nextLine = linea.split(separador);
                int numCama = Integer.parseInt(nextLine[0]);
                String tipo = nextLine[1];
                boolean disponible = true;
                if (nextLine.length >= 3) {
                    try {
                        disponible = Boolean.parseBoolean(nextLine[2]);
                    } catch (NumberFormatException e) {
                    }
                }
                Cama camita = new Cama(numCama, tipo, disponible);
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
    public void cargarMedicos(File arch) throws CsvValidationException{
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
    public void cargarPacientes(File arch) throws CsvValidationException{
        HashMap <String, Paciente> mapa = new HashMap<>();
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] nextLine = linea.split(separador);
                String nombre = nextLine[0];
                String rut = nextLine[1];
                int edad = Integer.parseInt(nextLine[2]);
                int gravedad = 0;
                if (nextLine.length >= 4) {
                    try {
                        gravedad = Integer.parseInt(nextLine[3]);
                    } catch (NumberFormatException e) {
                    }
                }
                Paciente pacientecito = new Paciente(nombre, rut, edad, gravedad);

                mapa.put(rut, pacientecito);
            }

        } catch (IOException ignored) {
        }
        System.out.println("PACIENTES CARGADOS\n--------------");

        for(Map.Entry<String, Paciente> c: mapa.entrySet()){
            System.out.println("Nombre: " + c.getValue().getNombre() + " Rut: " + c.getValue().getRut() + " Edad: " + c.getValue().getEdad() + " Gravedad: " + c.getValue().getGravedad());
        }
        hospital.setListaPacientes(mapa);
    }
    public void eliminarDato(File arch, String criterio) throws CsvValidationException{
        List<String> lineasFiltradas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Aquí puedes aplicar el filtro basado en tus necesidades
                if (!linea.contains(criterio)) {
                    // Si la línea no coincide con el criterio, la agregamos a la lista
                    lineasFiltradas.add(linea);
                }
            }

            // Ahora sobrescribimos el archivo original con las líneas filtradas
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arch))) {
                for (String l : lineasFiltradas) {
                    bw.write(l);
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void grabarDato(File arch, String criterio) throws CsvValidationException{

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arch, true))) {
            // Escribe la nueva línea en el archivo
            bw.write(criterio);
            bw.newLine();  // Añadir salto de línea para que la próxima línea agregada quede en una nueva línea
            System.out.println("Línea agregada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

