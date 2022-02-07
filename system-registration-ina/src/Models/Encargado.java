package Models;

/**
 *
 * @author angyc
 */
public class Encargado extends Persona{

    //Constructor sin parámetros
    public Encargado() {
    }

    //Constructor con parámetros
    public Encargado(String nombre, String apellidos, String cedula, String direccion, String correo, String edad) {
        super(nombre, apellidos, cedula, direccion, correo, edad);
    }
    
}
