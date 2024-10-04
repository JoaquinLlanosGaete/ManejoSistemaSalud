//Maneja el error de rut invalido, el rut debe tener 9 digitos exactamente
public class RutInvalidoException extends Exception {
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
