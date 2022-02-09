package system.registration.ina;

import Models.Curso;
import Models.Docente;
import Models.Estudiante;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class SystemRegistrationIna {

    static String password = "cheeseburger09";
    static Scanner scan = new Scanner(System.in);
    static List<Docente> docentes = new ArrayList<>();
    static List<Curso> cursos = new ArrayList<>();
    static List<Estudiante> estudiantes = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte tipoUsuario, opc;

        do {
            tipoUsuario = menu();

            switch (tipoUsuario) {
                case 1:
                    opc = usuarioMenu();
                    gestionesUsuario(opc);

                    break;
                case 2:
                    boolean entra = validacionAdmin();
                    if (entra) {
                        opc = administradorMenu();
                        gestionesAdministrador(opc);
                    }
                    break;
                case 3:
                    System.out.println("\n\nFin de la ejecución del programa.");
                    break;
                default:
                    throw new AssertionError();
            }

        } while (tipoUsuario == 1 || tipoUsuario == 2);
    }

    //Menú general del programa.
    static byte menu() {
        byte opcion = 0;
        boolean error = false;

        do {
            error = false; // Se inicializa al entrar al ciclo, sino entra en loop infinito
            System.out.print("\n\t[ Bienvenidx al sistema de matrícula ]"
                    + "\n\t[1] - Usuario"
                    + "\n\t[2] - Administrador"
                    + "\n\t[3] - Salir"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 3)) {
                    opcion = 0;
                    System.out.print("\n\tIngrese una opción válida entre 1 y 3");
                    error = true;
                }
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        } while (error);

        return opcion;
    }

    //Menú con las gestiones disponibles para el usuario.
    static byte usuarioMenu() {
        byte opcion = 0;
        boolean error = false;

        do {
            error = false;
            System.out.print("\n\t[ GESTIONES DE USUARIO ]"
                    + "\n\t[1] - Lista de cursos"
                    + "\n\t[2] - Lista de profesores"
                    + "\n\t[3] - Lista de estudiantes"
                    + "\n\t[4] - Matrícula"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 4)) {
                    opcion = 0;
                    System.out.print("\n\tIngrese una opción válida entre 1 y 4");
                    error = true;
                }
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        } while (error);

        return opcion;
    }

    //Método que contiene un switch. Se realizan acciones de acuerdo con la selección del usuario.
    static void gestionesUsuario(byte opc) {
        switch (opc) {
            case 1:
                imprimirCursos();
                break;
            case 2:
                imprimirDocentes();
                break;
            case 3:
                //Se listan los estudiantes
                break;
            case 4:
            //Se realiza la matrícula

        }
    }

    //Método que valida la contraseña ingresada para administrador. 
    static boolean validacionAdmin() {
        byte intentos = 3;

        do {
            System.out.println("\nIngrese la contraseña:");
            String contraIngresada = scan.nextLine();
            if (contraIngresada == null ? password == null : contraIngresada.equals(password)) {
                return true;
            } else {
                intentos--;
                System.out.println("\nCONTRASEÑA INCORRECTA. Intentos restantes: " + intentos);
            }
        } while (intentos != 0);

        return false;

    }

    //Menú con las gestiones disponibles para el administrador.
    static byte administradorMenu() {

        byte opcion = 0;
        boolean error = false;

        do {
            error = false; // Se inicializa al entrar al ciclo, sino entra en loop infinito
            System.out.print("\n\t[ GESTIONES DE ADMINISTRADOR ]"
                    + "\n\t[1] - Administración cursos"
                    + "\n\t[2] - Administración profesores"
                    + "\n\t[3] - Administración estudiantes"
                    + "\n\t[4] - Cursos por docente"
                    + "\n\t[5] - Cursos por estudiante"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 5)) {
                    opcion = 0;
                    System.out.print("\n\tIngrese una opción válida entre 1 y 5");
                    error = true;
                }
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        } while (error);

        return opcion;
    }

    //Método que contiene un switch. Se realizan acciones de acuerdo con la selección del administardor.
    static void gestionesAdministrador(byte opc) {

        byte opc2 = 0;

        switch (opc) {
            case 1:
                //Se redirige al menú de gestiones referentes a los cursos.
                System.out.println("ADMINISTRACIÓN CURSOS");
                opc2 = administracionClases();
                gestionCursos(opc2);
                break;
            case 2:
                //Se redirige al menú de gestiones referentes a los profesores.
                System.out.println("ADMINISTRACIÓN PROFESORES");
                opc2 = administracionClases();
                gestionDocentes(opc2);
                break;
            case 3:
                //Se redirige al menú de gestiones referentes a los estudiantes.
                System.out.println("ADMINISTRACIÓN ESTUDIANTES");
                opc2 = administracionClases();
                break;
            case 4:
                //Se muestran cursos de un docente específico
                break;
            case 5:
            //Se muestran cursos de un estudiante específico

        }
    }

    static byte administracionClases() {
        byte opcion = 0;
        boolean error = false;

        do {
            error = false; // Se inicializa al entrar al ciclo, sino entra en loop infinito
            System.out.print("\n\t[1] - Agregar"
                    + "\n\t[2] - Eliminar"
                    + "\n\t[3] - Editar"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 3)) {
                    opcion = 0;
                    System.out.print("\n\tIngrese una opción válida entre 1 y 3");
                    error = true;
                }
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        } while (error);

        return opcion;
    }

    
    // Métodos para los cursos
    
    /**
     * Redirige a la acción seleccionada por el usuario
     *
     * @param opc acción a realizar por el usuario
     */
    static void gestionCursos(byte opc) {
        switch (opc) {
            case 1:
                agregarCurso();
                break;
            case 2:
                eliminarCurso();
                break;
            case 3:
                modificarCurso();
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    static void agregarCurso() {
        Curso curso = new Curso();
        short num = 0;
        System.out.print("\n\tNombre del curso: ");
        curso.setNombre(scan.nextLine());

        do {
            System.out.print("\tCantidad máxima de estudiantes: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCupoMax(num);
        num = 0;

        do {
            System.out.print("\tCréditos del curso: ");
            try {
                num = scan.nextByte();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCreditos((byte)num);
        num = 0;

        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente que impartirá el curso: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                } else if (num > docentes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setDocenteEncargado(docentes.get(num - 1));

        cursos.add(curso);
        System.out.println("\n\t[ Curso agregado con éxito ]");
    }

    static void modificarCurso() {
        Curso curso;
        short num = 0;

        do {
            imprimirCursos();
            System.out.print("\n\tNúmero del curso a modificar: ");
            try {
                num = scan.nextShort();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                } else if (num > docentes.size() || num < docentes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso = cursos.get(num - 1);
        cursos.remove(num - 1);

        System.out.print("\n\tNombre del curso: ");
        curso.setNombre(scan.nextLine());

        do {
            System.out.print("\tCantidad máxima de estudiantes: ");
            try {
                num = scan.nextShort();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCupoMax(num);
        num = 0;

        do {
            System.out.print("\tCréditos del curso: ");
            try {
                num = scan.nextByte();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCreditos((byte)num);
        num = 0;

        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente que impartirá el curso: ");
            try {
                num = scan.nextByte();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                } else if (num > docentes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setDocenteEncargado(docentes.get(num));
        cursos.add(curso);
        System.out.println("\n\t[ Curso modificado con éxito ]");
    }

    static void eliminarCurso() {
        byte num = 0;

        do {
            imprimirCursos();
            System.out.print("\n\tNúmero del curso a modificar: ");
            try {
                num = scan.nextByte();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                } else if (num > docentes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        try {
            cursos.remove(num);
            System.out.println("\n\tCurso eliminado con éxito");
        } catch (Exception ex) {
            System.out.print("\n\t[ Error ] - Ha ocurrido un error, curso NO eliminado");
        }
    }

    static void ordenarCursos(){
        Comparator<Curso> orderByName = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Collections.sort(cursos, orderByName);
    }
    
    static void imprimirCursos() {
        ordenarCursos();
        short count = 1;
        if (!cursos.isEmpty()) {
            for (Curso curso : cursos) {
                System.out.print("\n\t[" + (count++) + "]" + curso.toString());
            }
        }
    }
    
    // Métodos para los estudiantes
    
    /**
     * Redirige a la acción seleccionada por el usuario
     *
     * @param opc acción a realizar por el usuario
     */
    static void gestionEstudiantes(byte opc){
        switch (opc) {
            case 1:
                agregarEstudiante();
                break;
            case 2:
                eliminarEstudiante();
                break;
            case 3:
                modificarEstudiante();
                break;
            case 4:
                break;
            default:
                break;
        }
    }
    
    static void agregarEstudiante() {
        Estudiante estud = new Estudiante();
        short num = 0;
        System.out.print("\n\tNombre: ");
        estud.setNombre(scan.nextLine());
        System.out.print("\tApellidos: : ");
        estud.setApellidos(scan.nextLine());        
        System.out.print("\tCédula: ");
        estud.setCedula(validarCedula());        
        System.out.print("\tDirección actual: ");
        estud.setDireccion(scan.nextLine());        
        System.out.print("\tCorreo electrónico: ");
        estud.setCorreo(scan.nextLine());
        
        System.out.print("\tEdad: ");
        do {            
            try {
                num = scan.nextByte();
                if (num < 16 && num > 100) {
                    System.out.println("\n\t[ Error ] - Ingrese un número entre 15 - 100");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        estud.setEdad((byte) num);
        num = 0;

        System.out.print("\tGrado actual: ");
        do {            
            try {
                num = scan.nextByte();
                if (num < 16 && num > 100) {
                    System.out.println("\n\t[ Error ] - Ingrese un número entre 15 - 100");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCreditos((byte)num);
        num = 0;

        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente que impartirá el curso: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                } else if (num > docentes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setDocenteEncargado(docentes.get(num - 1));

        cursos.add(curso);
        System.out.println("\n\t[ Curso agregado con éxito ]");
    }

    static void gestionDocentes(byte opc2) {
        switch (opc2) {
            case 1:
                agregarDocente();
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
            default:
                break;
        }
    }

    static void agregarDocente() {
        boolean error = false;
        ArrayList<Curso> cursosDocente = new ArrayList<>();
        Curso newMateria = new Curso();

        String nombre, apellidos, direccion, cedula, correo, gradoAcad;
        boolean colegiado = false;
        boolean propiedad = false;
        byte edad;
        Date fechaInicio;

        do {
            error = false;
            nombre = "";
            apellidos = "";
            cedula = "";
            direccion = "";
            correo = "";
            edad = 0;
            gradoAcad = "";
            fechaInicio = null;

            try {
                System.out.println("Nombre:");
                nombre = scan.nextLine();
                System.out.println("Apellidos:");
                apellidos = scan.nextLine();
                System.out.println("Cédula:");
                validarCedula();
                System.out.println("Dirección:");
                direccion = scan.nextLine();
                System.out.println("Correo:");
                correo = scan.nextLine();
                System.out.println("Edad:");
                edad = scan.nextByte(); //validar que sea una edad aceptable
                System.out.println("Seleccione la materia que imparte: ");
                newMateria = imprimirCursos();
                cursosDocente.add(newMateria); //Se agrega la materia al arraylist local del objeto.
                System.out.println("Grado académico: ");
                gradoAcad = scan.nextLine();
                System.out.println("¿Es colegiado? (s/n)");
                colegiado = validarSN(); //Se obtiene verdadero o falso de acuerdo con la respuesta del usuario.                
                System.out.println("¿Está en propiedad? (s/n)");
                propiedad = validarSN();
                System.out.println("Fecha de inicio en la institución (DD/MM/YYYY)");
                String fecha = scan.nextLine();
                //Se necesita formatear la fecha y pasarla a formato Date.

            } catch (Exception e) {
                System.out.println(" [ Error ] - ingrese datos válidos ");
                error = true;
            }

        } while (error == true);

        Docente newdocente = new Docente(cursosDocente, gradoAcad, colegiado, propiedad, fechaInicio);
    }

    //Método que valida las respuestas en formato S/N
    static boolean validarSN() {
        boolean error = false;

        do {
            String word = scan.nextLine();
            word = toUpperCase(word); //Se pasa la respuesta a mayúsculas.
            if (!"S".equals(word) && !"N".equals(word)) {
                System.out.println("[Error] - Ingrese datos correctos.");
                error = true;
            } else {
                if ("S".equals(word)) {
                    return true;
                }
            }
        } while (error);

        return false;
    }

    //Método que valida la cédula
    static String validarCedula() {

        boolean error = false;
        String cedula = "";

        do {
            try {
                cedula = scan.nextLine();
                Integer.parseInt(cedula);
                int digitos = cedula.length();

                if (digitos != 10) {
                    System.out.println("[ERROR] - Ingrese la cédula en formato de 10 dígitos.");
                    error = true;
                }

            } catch (Exception e) {
                error = true;
                System.out.println("[ERROR] - Ingrese sólo números.");
            }
        } while (error);

        return cedula;
    }

    //Método que imprime los docentes.
    static void imprimirDocentes() {
        System.out.println("DOCENTES REGISTRADOS");

        if (!docentes.isEmpty()) {
            docentes.stream().map((docente) -> {
                System.out.println("Nombre: " + docente.getNombre());
                return docente;
            }).map((docente) -> {
                System.out.println("Apellidos " + docente.getApellidos());
                return docente;
            }).map((docente) -> {
                System.out.println("Cédula " + docente.getCedula());
                return docente;
            }).map((docente) -> {
                System.out.println("Dirección " + docente.getDireccion());
                return docente;
            }).map((docente) -> {
                System.out.println("Correo: " + docente.getCorreo());
                return docente;
            }).map((docente) -> {
                System.out.println("Edad: " + docente.getEdad());
                return docente;
            }).map((docente) -> {
                //Se imprime la lista de cursos que imparte
                System.out.println("Colegiado: " + docente.isColegiado());
                return docente;
            }).map((docente) -> {
                System.out.println("Propiedad: " + docente.isPropiedad());
                return docente;
            }).map((docente) -> {
                System.out.println("Fecha de inicio en la institución: " + docente.getInicioInstitucion());
                return docente;
            }).forEach((_item) -> {
                System.out.println("\n");
            });
        } else {
            System.out.println("LISTA VACÍA");
        }
    }
    //Hola
}
