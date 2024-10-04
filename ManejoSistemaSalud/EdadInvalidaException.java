//Maneja la excepcion cuando la edad es invalida 0<edad>150
public class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
