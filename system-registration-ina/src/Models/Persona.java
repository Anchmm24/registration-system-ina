package Models;

/**
 *
 * @author angyc
 */
public class Persona {

    
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String correo;
    private byte edad;

    //Constructor con parámetros
    public Persona() {
    }
    
    //Constructor con parámetros
    public Persona(String nombre, String apellidos, String cedula, String direccion, String correo, byte edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.correo = correo;
        this.edad = edad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public byte getEdad() {
        return edad;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }
    
}
