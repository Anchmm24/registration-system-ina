package Models;



import java.util.Date;
import java.util.List;

/**
 *
 * @author royden
 */
public class Curso {
    String nombre;
    byte cupoMax;
    byte creditos;
    Docente docenteEncargado;
    List<Date> horarios;

    public Curso() {
    }

    public Curso(String nombre, byte cupoMax, byte creditos, Docente docenteEncargado, List<Date> horarios) {
        this.nombre = nombre;
        this.cupoMax = cupoMax;
        this.creditos = creditos;
        this.docenteEncargado = docenteEncargado;
        this.horarios = horarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(byte cupoMax) {
        this.cupoMax = cupoMax;
    }

    public byte getCreditos() {
        return creditos;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

    public Docente getDocenteEncargado() {
        return docenteEncargado;
    }

    public void setDocenteEncargado(Docente docenteEncargado) {
        this.docenteEncargado = docenteEncargado;
    }

    public List<Date> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Date> horarios) {
        this.horarios = horarios;
    }
}
