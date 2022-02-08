package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angyc
 */
public class Docente extends Persona{

    private ArrayList<Curso> materiasImparte;
    private String gradoAcademico;
    private boolean colegiado;
    private boolean propiedad;
    private Date inicioInstitucion;
    
    //Constructor con parámetros
    public Docente(ArrayList<Curso> materiasImparte, String gradoAcademico, boolean colegiado, boolean propiedad, Date inicioInstitucion, String nombre, String apellidos, String cedula, String direccion, String correo, String edad) {
        super(nombre, apellidos, cedula, direccion, correo, edad);
        this.materiasImparte = materiasImparte;
        this.gradoAcademico = gradoAcademico;
        this.colegiado = colegiado;
        this.propiedad = propiedad;
        this.inicioInstitucion = inicioInstitucion;
    }
    
    //Getters
    public ArrayList<Curso> getMateriasImparte() {
        return materiasImparte;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public boolean isColegiado() {
        return colegiado;
    }

    public boolean isPropiedad() {
        return propiedad;
    }

    public Date getInicioInstitucion() {
        return inicioInstitucion;
    }

    //Setters
    public void setMateriasImparte(ArrayList<Curso> materiasImparte) {
        this.materiasImparte = materiasImparte;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public void setColegiado(boolean colegiado) {
        this.colegiado = colegiado;
    }

    public void setPropiedad(boolean propiedad) {
        this.propiedad = propiedad;
    }

    public void setInicioInstitucion(Date inicioInstitucion) {
        this.inicioInstitucion = inicioInstitucion;
    }
    
    
    
}
