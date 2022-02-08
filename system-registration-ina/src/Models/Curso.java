package Models;

import java.util.Date;
import java.util.List;

/**
 * Clase para manejar los cursos de la escuela
 * 
 * @author royden
 */
public class Curso {
    String nombre;
    byte cupoMax;
    byte creditos;
    Docente docenteEncargado;
    List<Date> horarios;

    /**
     * Constructor vacio
     */
    public Curso() {
    }

    /**
     * 
     * @param nombre nombre del curso
     * @param cupoMax capacidad máxima de estudiantes
     * @param creditos créditos que otorga la asignatura
     * @param docenteEncargado profesor que imparte el curso
     * @param horarios lista de los horarios disponibles para el curso
     */
    public Curso(String nombre, byte cupoMax, byte creditos, Docente docenteEncargado, List<Date> horarios) {
        this.nombre = nombre;
        this.cupoMax = cupoMax;
        this.creditos = creditos;
        this.docenteEncargado = docenteEncargado;
        this.horarios = horarios;
    }

    /**
     * 
     * @return nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre de la asignatura
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return capacidad máxima de estudiantes
     */
    public byte getCupoMax() {
        return cupoMax;
    }

    /**
     * 
     * @param cupoMax cantidad máxima de estudiantes que se pueden matricular en el curso
     */
    public void setCupoMax(byte cupoMax) {
        this.cupoMax = cupoMax;
    }

    /**
     * 
     * @return créditos que se obtienen por ganar el curso
     */
    public byte getCreditos() {
        return creditos;
    }

    /**
     * 
     * @param creditos créditos que el estudiante ganará por pasar el curso
     */
    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

    /**
     * 
     * @return {@code Docente} encargado de impartir el curso
     */
    public Docente getDocenteEncargado() {
        return docenteEncargado;
    }

    /**
     * 
     * @param docenteEncargado que impartirá la asignatura
     */
    public void setDocenteEncargado(Docente docenteEncargado) {
        this.docenteEncargado = docenteEncargado;
    }

    /**
     * 
     * @return {@code List<Date>} con los horarios disponibles del curso
     */
    public List<Date> getHorarios() {
        return horarios;
    }

    /**
     * 
     * @param horarios lista de horarios que el usuario puede tomar
     */
    public void setHorarios(List<Date> horarios) {
        this.horarios = horarios;
    }
}
