package Models;

import java.util.List;

/**
 *
 * @author royden
 */
public class Estudiante extends Persona{
    byte gradoActual;
    boolean repiteAnio;
    boolean adecuacion;
    boolean beca;
    List<Curso> cursos;
    

    public Estudiante() {
    }

    public Estudiante(byte gradoActual, boolean repiteAnio, boolean reqAdecuacion, boolean beca, List<Curso> cursos) {
        this.gradoActual = gradoActual;
        this.repiteAnio = repiteAnio;
        this.adecuacion = reqAdecuacion;
        this.beca = beca;
        this.cursos = cursos;
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
    
}
