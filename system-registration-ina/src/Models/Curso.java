package Models;

/**
 * Clase para manejar los cursos de la escuela
 * 
 * @author royden
 */
public class Curso {
    String nombre;
    short cupoMax;
    byte creditos;
    Docente docenteEncargado;

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
     */
    public Curso(String nombre, byte cupoMax, byte creditos, Docente docenteEncargado) {
        this.nombre = nombre;
        this.cupoMax = cupoMax;
        this.creditos = creditos;
        this.docenteEncargado = docenteEncargado;
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
    public short getCupoMax() {
        return cupoMax;
    }

    /**
     * 
     * @param cupoMax cantidad máxima de estudiantes que se pueden matricular en el curso
     */
    public void setCupoMax(short cupoMax) {
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
    
    @Override
    public String toString(){
        String nombreDocente;
        Docente docente = getDocenteEncargado();
        if(docente != null)
            nombreDocente = docente.getNombre() + " " + docente.getApellidos();
        else
            nombreDocente = "NO hay docente asignado";
        
        return ("\tNombre: " + getNombre()
                + "\n\tCupos máximos: " + getCupoMax()
                + "\n\tCréditos: " +getCreditos()
                + "\n\tDocente a cargo: " + nombreDocente);
    }
}
