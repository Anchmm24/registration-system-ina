package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author royden
 */
public class Estudiante extends Persona{

    public Estudiante(byte gradoActual, boolean repiteAnio, boolean adecuacion, boolean beca, List<Curso> cursos) {
        this.gradoActual = gradoActual;
        this.repiteAnio = repiteAnio;
        this.adecuacion = adecuacion;
        this.beca = beca;
        this.cursos = cursos;
    }

    public Estudiante(byte gradoActual, boolean repiteAnio, boolean adecuacion, boolean beca, List<Curso> cursos, String nombre, String apellidos, String cedula, String direccion, String correo, byte edad) {
        super(nombre, apellidos, cedula, direccion, correo, edad);
        this.gradoActual = gradoActual;
        this.repiteAnio = repiteAnio;
        this.adecuacion = adecuacion;
        this.beca = beca;
        this.cursos = cursos;
    }
    
    byte gradoActual;
    boolean repiteAnio;
    boolean adecuacion;
    boolean beca;
    List<Curso> cursos = new ArrayList<>();
    

    public Estudiante() {
    }

    public byte getGradoActual() {
        return gradoActual;
    }

    public void setGradoActual(byte gradoActual) {
        this.gradoActual = gradoActual;
    }

    public boolean isRepiteAnio() {
        return repiteAnio;
    }

    public void setRepiteAnio(boolean repiteAnio) {
        this.repiteAnio = repiteAnio;
    }

    public boolean isAdecuacion() {
        return adecuacion;
    }

    public void setAdecuacion(boolean adecuacion) {
        this.adecuacion = adecuacion;
    }

    public boolean isBeca() {
        return beca;
    }

    public void setBeca(boolean beca) {
        this.beca = beca;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }    
    

    @Override
    public String toString(){
        String listaCursos = "\n\t[ Lista de cursos ]";
        if(!cursos.isEmpty()){
            for(Curso curso: cursos){
                listaCursos += "\n\t" +curso.getNombre();
            }
            listaCursos += "\n\t";
        }else
            listaCursos += "\n\t[ NO hay cursos matriculados ]\n\t";
        
        return ("\n\tNombre completo: " + getNombre() + " " + getApellidos()
            + "\n\tC??dula: " + getCedula()
            + "\n\tDirecci??n: " + getDireccion()
            + "\n\tCorreo: " + getCorreo()
            + "\n\tEdad: " + getEdad()
            + "\n\tGrado actual: " + getGradoActual()
            + "\n\t??Repite a??o?: " + isRepiteAnio()
            + "\n\t??Requiere beca?: " + isBeca()
            + "\n\t??Requiere adecuaci??n?: " + isAdecuacion()
            + listaCursos);
    }
}
