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

    static String password = "cheeseburger09"; //Contraseña para acceso a Administrador.
    static Scanner scan = new Scanner(System.in); //Instancia de la clase Scanner para ingresar datos.

    //Declaración de listas a usar.
    static List<Docente> docentes = new ArrayList<>();
    static List<Curso> cursos = new ArrayList<>();
    static List<Estudiante> estudiantes = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte tipoUsuario, opc;

        do {
            tipoUsuario = menuGeneral();

            switch (tipoUsuario) {
                case 1:
                    //Se dirige al usuario al menú de acciones para Usuario.
                    opc = usuarioMenu();
                    gestionesUsuario(opc);
                    break;
                case 2:
                    //Se valida el ingreso a Administrador.
                    boolean entra = validacionAdmin();
                    if (entra) {
                        //Se dirige al usuario al menú de acciones para Administrador.
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
    static byte menuGeneral() {
        byte opcion = 0;
        boolean error = false;

        do {
            error = false; // Se inicializa al entrar al ciclo, sino entra en loop infinito
            System.out.print("\n\t[ Bienvenido (a) al sistema de matrícula ]"
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

    // Menú con las gestiones disponibles para el usuario.
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
                    + "\n\t[5] - Salir"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 4)) {
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

    //Se realizan acciones de acuerdo con la selección del usuario en la sección de Usuario.
    static void gestionesUsuario(byte opc) {
        switch (opc) {
            case 1:
                imprimirCursos();
                break;
            case 2:
                imprimirDocentes();
                break;
            case 3:
                imprimirEstudiantes();
                break;
            case 4:
                matricula();
                break;
            default:
                break;

        }
    }

    // Método que valida la contraseña ingresada para administrador.
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

    // Menú con las gestiones disponibles para el administrador.
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
                    + "\n\t[6] - Salir"
                    + "\n\n\tElija una opción: ");
            try {
                opcion = scan.nextByte();
                if ((opcion < 1) && (opcion > 6)) {
                    opcion = 0;
                    System.out.print("\n\tIngrese una opción válida entre 1 y 6");
                    error = true;
                }
            } catch (InputMismatchException ex) {
                error = true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        } while (error);

        return opcion;
    }

    // Se realizan acciones de acuerdo con la
    // selección del administardor.
    static void gestionesAdministrador(byte opc) {

        byte opc2 = 0;

        switch (opc) {
            case 1:
                // Se redirige al menú de gestiones referentes a los cursos.
                System.out.println("ADMINISTRACIÓN CURSOS");
                opc2 = administracionClases();
                gestionCursos(opc2);
                break;
            case 2:
                // Se redirige al menú de gestiones referentes a los profesores.
                System.out.println("ADMINISTRACIÓN PROFESORES");
                opc2 = administracionClases();
                gestionDocentes(opc2);
                break;
            case 3:
                // Se redirige al menú de gestiones referentes a los estudiantes.
                System.out.println("ADMINISTRACIÓN ESTUDIANTES");
                opc2 = administracionClases();
                gestionEstudiantes(opc2);
                break;
            case 4:
                // Se muestran cursos de un docente específico
                buscarCursosDocente();
                break;
            case 5:
                // Se muestran cursos de un estudiante específico
                buscarCursosEstudiante();
                break;
            default:
                break;

        }
    }

    //Método general que muestra las acciones que se pueden realizar con Cursos, Docentes y Estudiantes. Retorna la opción seleccionada por el usuario
    static byte administracionClases() {
        byte opcion = 0;
        boolean error = false;

        do {
            error = false; // Se inicializa al entrar al ciclo, sino entra en loop infinito
            System.out.print("\n\t[1] - Agregar"
                    + "\n\t[2] - Eliminar"
                    + "\n\t[3] - Editar"
                    + "\n\t[4] - Salir"
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
            default:
                break;
        }
    }

    //Método que agrega los cursos a la lista correspondiente.
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
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCreditos((byte) num);
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

    //Método que modifica un curso específico.
    static void modificarCurso() {
        Curso curso;
        short num = 0;

        do {
            imprimirCursos();
            System.out.print("\n\tNúmero del curso a modificar: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                } else if (num > cursos.size()) {
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
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        curso.setCreditos((byte) num);
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

        curso.setDocenteEncargado(docentes.get(num));
        cursos.add(curso);
        System.out.println("\n\t[ Curso modificado con éxito ]");
    }

    //Método que elimina un curso seleccionado.
    static void eliminarCurso() {
        short num = 0;

        do {
            imprimirCursos();
            System.out.print("\n\tNúmero del curso a modificar: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                } else if (num > cursos.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        try {
            cursos.remove(num-1);
            System.out.println("\n\tCurso eliminado con éxito");
        } catch (Exception ex) {
            System.out.print("\n\t[ Error ] - Ha ocurrido un error, curso NO eliminado");
        }
    }

    //Método que ordena los cursos por nombre y de forma ascendente.
    static void ordenarCursos(){
        Comparator<Curso> orderByName = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Collections.sort(cursos, orderByName);
    }

    //Método que imprime los cursos por nombre y de forma ascendente.
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
    static void gestionEstudiantes(byte opc) {
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
            default:
                break;
        }
    }

    //Se agrega un estudiante a la lista
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

        do {
            System.out.print("\tEdad: ");
            try {
                num = scan.nextByte();
                if (num < 15 || num > 100) {
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

        do {
            System.out.print("\tGrado actual: ");
            try {
                num = scan.nextByte();
                if (num < 1 || num > 10) {
                    System.out.println("\n\t[ Error ] - Ingrese un número entre 1 - 10");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        estud.setGradoActual((byte) num);
        num = 0;

        System.out.print("\tRequiere adecuación? (S/N): ");
        estud.setAdecuacion(validarSN());

        System.out.print("\tRequiere solicitar beca? (S/N): ");
        estud.setBeca(validarSN());

        estudiantes.add(estud);
        System.out.println("\n\t[ Estudiante agregado con éxito ]");
    }

    static void eliminarEstudiante() {
        short num = 0;

        do {
            imprimirCursos();
            System.out.print("\n\tNúmero del estudiante a eliminar: ");
            try {
                num = scan.nextShort();
                if (num < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    num = 0;
                } else if (num > estudiantes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        try {
            cursos.remove(num-1);
            System.out.println("\n\tEstudiante eliminado con éxito");
        } catch (Exception ex) {
            System.out.print("\n\t[ Error ] - Ha ocurrido un error, estudiante NO eliminado");
        }
    }

    static void modificarEstudiante(){
        short num = 0;
        short index = 0;
        do {
            imprimirEstudiantes();
            System.out.print("\n\tNúmero del estudiante a modificar: ");
            try {
                index = scan.nextShort();
                if (index < 1) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                    index = 0;
                } else if (index > estudiantes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    index = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (index == 0);

        index = (short) (index - 1);

        System.out.print("\n\tNombre: ");
        estudiantes.get(index).setNombre(scan.nextLine());
        System.out.print("\tApellidos: : ");
        estudiantes.get(index).setApellidos(scan.nextLine());
        System.out.print("\tCédula: ");
        estudiantes.get(index).setCedula(scan.nextLine());
        System.out.print("\tDirección actual: ");
        estudiantes.get(index).setDireccion(scan.nextLine());
        System.out.print("\tCorreo electrónico: ");
        estudiantes.get(index).setCorreo(scan.nextLine());

        do {
            System.out.print("\tEdad: ");
            try {
                num = scan.nextByte();
                if (num < 15 || num > 100) {
                    System.out.println("\n\t[ Error ] - Ingrese un número entre 15 - 100");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        estudiantes.get(index).setEdad((byte) num);
        num = 0;

        do {
            System.out.print("\tGrado actual: ");
            try {
                num = scan.nextByte();
                if (num < 1 && num > 10) {
                    System.out.println("\n\t[ Error ] - Ingrese un número entre 1 - 10");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        estudiantes.get(index).setGradoActual((byte) num);
        num = 0;

        System.out.print("\tRequiere adecuación? (S/N): ");
        estudiantes.get(index).setAdecuacion(validarSN());

        System.out.print("\tRequiere solicitar beca? (S/N): ");
        estudiantes.get(index).setBeca(validarSN());

        System.out.println("\n\t[ Estudiante modificado con éxito ]");

    }

    static void ordenarEstudiantes() {
        Comparator<Estudiante> orderByName = (p1, p2) -> p1.getApellidos().compareTo(p2.getApellidos());
        Collections.sort(estudiantes, orderByName);
    }

    static void imprimirEstudiantes() {
        ordenarEstudiantes();
        short count = 1;
        if (!estudiantes.isEmpty()) {
            for (Estudiante estudiante : estudiantes) {
                System.out.print("\n\t[" + (count++) + "]" + estudiante.toString());
            }
        }
    }

    static void gestionDocentes(byte opc2) {
        Docente doc = new Docente();
        switch (opc2) {
            case 1:
                doc = agregarDocente();
                docentes.add(doc);
                break;
            case 2:
                eliminarDocente();
                break;
            case 3:
                modificarDocente();
                break;
            default:
                break;
        }
    }

    //Método que agrega docentes a la lista correspondiente
    static Docente agregarDocente() {
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
                cedula = validarCedula(); //Se valida que en cédula se ingresen datos válidos
                System.out.println("Dirección:");
                direccion = scan.nextLine();
                System.out.println("Correo:");
                correo = scan.nextLine();
                System.out.println("Edad:");
                edad = validarEdad(); //Se valida que en edad se ingresen datos válidos
                System.out.println("Seleccione la materia que imparte: ");
                imprimirCursos();
                int num = 0;
                do {
                    try {
                        num = scan.nextInt();
                        if (num == 0) {
                            System.out.println("[Error] - Ingrese datos válidos");
                        } else {
                            if (num < cursos.size()) {
                                System.out.println("[Error] - Ingrese datos válidos");
                                num = 0;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("[Error] - Ingrese datos válidos");
                    }

                } while (num == 0);

                newMateria = cursos.get(num - 1); // Por el índice?

                cursosDocente.add(newMateria); // Se agrega la materia al arraylist local del objeto.
                System.out.println("Grado académico: ");
                gradoAcad = scan.nextLine();
                System.out.println("¿Es colegiado? (s/n)");
                colegiado = validarSN(); // Se obtiene verdadero o falso de acuerdo con la respuesta del usuario.
                System.out.println("¿Está en propiedad? (s/n)");
                propiedad = validarSN();
                System.out.println("Fecha de inicio en la institución (DD/MM/YYYY)");
                String fecha = scan.nextLine();
                // Se necesita formatear la fecha y pasarla a formato Date.

            } catch (Exception e) {
                System.out.println(" [ Error ] - ingrese datos válidos ");
                error = true;
            }

        } while (error == true);

        Docente newdocente = new Docente(cursosDocente, gradoAcad, colegiado, propiedad, fechaInicio, nombre, apellidos, cedula, direccion, correo, edad);

        return newdocente;
    }

    // Método que valida las respuestas en formato S/N
    static boolean validarSN() {
        boolean error = false;

        do {
            String word = scan.nextLine();
            word = toUpperCase(word); // Se pasa la respuesta a mayúsculas.
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

    //Método que valida la cédula.
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

    //Método que valida la edad.
    static byte validarEdad() {

        boolean error = false;
        byte edad = 0;

        do {
            try {
                edad = scan.nextByte();

                if (edad < 0 || edad > 99) {
                    System.out.println("[ERROR] - Ingrese datos válidos.");
                    error = true;
                }

            } catch (Exception e) {
                error = true;
                System.out.println("[ERROR] - Ingrese sólo números.");
            }
        } while (error);

        return edad;
    }

    //Método que ordena por apellido los docentes, de forma ascendente. 
    static void ordenarDocentes() {
        Comparator<Docente> orderByName = (p1, p2) -> p1.getApellidos().compareTo(p2.getApellidos());
        Collections.sort(docentes, orderByName);
    }
    
    // Método que imprime los docentes.
    static void imprimirDocentes() {
        System.out.println("DOCENTES REGISTRADOS");
        ordenarDocentes();
        int l = 0;
        if (!docentes.isEmpty()) {
            for (Docente doc : docentes) {
                l++;
                System.out.println("[" + (l + 1) + "] " + "Nombre: " + doc.getNombre());
                System.out.println("Apellidos " + doc.getApellidos());
                System.out.println("Cédula " + doc.getCedula());
                System.out.println("Dirección " + doc.getDireccion());
                System.out.println("Correo: " + doc.getCorreo());
                System.out.println("Edad: " + doc.getEdad());
                System.out.println("Colegiado: " + doc.isColegiado());
                System.out.println("Propiedad: " + doc.isPropiedad());
                System.out.println("Fecha de inicio en la institución: " + doc.getInicioInstitucion() + "\n");
                // Se imprimen los cursos que imparte un profesor determinado
                for (int i = 0; i < cursos.size(); i++) {
                    if (cursos.get(i).getDocenteEncargado().getNombre() == null ? docentes.get(i).getNombre() == null
                            : cursos.get(i).getDocenteEncargado().getNombre().equals(docentes.get(i).getNombre())) {
                        System.out.println("\n" + cursos.get(i).getNombre());
                    }
                }
            }
        } else {
            System.out.println("LISTA VACÍA");
        }
    }

    //Método que elimina un objeto docente.
    static void eliminarDocente(){
        byte num = 0;

        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente a eliminar: ");
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
            docentes.remove(num);
            System.out.println("\n\tDocente eliminado con éxito");
        } catch (Exception ex) {
            System.out.print("\n\t[ Error ] - Ha ocurrido un error, docente NO eliminado");
        }
    }

    //Método que modifica un docente.
    static void modificarDocente(){
        int num=0;
        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente a eliminar: ");
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

        Docente doc = new Docente();
        doc = agregarDocente();

        try {
            docentes.remove(num);
            docentes.add(num, doc);
            System.out.println("\n\tDocente modificado con éxito");
        } catch (Exception ex) {
            System.out.print("\n\t[ Error ] - Ha ocurrido un error, docente NO modificado");
        }
    }

    //Método que muestra los cursos por docente específico.
    static void buscarCursosDocente(){
        int num=0;
        System.out.println("CURSOS POR DOCENTE");
        do {
            imprimirDocentes();
            System.out.print("\n\tNúmero del docente a consultar: ");
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

        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getDocenteEncargado().getNombre() == null ? docentes.get(num).getNombre() == null
                    : cursos.get(i).getDocenteEncargado().getNombre().equals(docentes.get(num).getNombre())) {
                System.out.println("Curso: " + cursos.get(i).getNombre() + "\n");
            }
        }
    }

    //Método que muestra los cursos por estudiante específico.
    static void buscarCursosEstudiante() {
        int num = 0;
        System.out.println("CURSOS POR ESTUDIANTE");
        do {
            imprimirEstudiantes();
            System.out.print("\n\tNúmero del estudiante a consultar: ");
            try {
                num = scan.nextByte();
                if (num == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                } else if (num > estudiantes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    num = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (num == 0);

        for (int i = 0; i < estudiantes.get(num + 1).getCursos().size(); i++) {
            System.out.println("Curso: " + estudiantes.get(num + 1).getCursos().get(i).getNombre() + "\n");
        }

    }

    /**
     * Método para realizar matrícula de estudiantes
     */
    static void matricula() {
        boolean seguir = true;
        short num = 0;
        int index = 0;
        List<Curso> list = new ArrayList<>();

        do {
            imprimirEstudiantes();
            System.out.print("\n\tNúmero del estudiante a matricular: ");
            try {
                index = scan.nextShort();
                if (index == 0) {
                    System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                } else if (index > estudiantes.size() || index < estudiantes.size()) {
                    System.out.println("\n\t[ Error ] - Elija un número válido");
                    index = 0;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
                scan.nextLine();
            }
        } while (index == 0);
        index = (short) (index - 1);

        while (seguir) {
            imprimirCursos();
            do {
                System.out.print("\n\tNúmero del curso a añadir: ");
                try {
                    num = scan.nextShort();
                    if (num < 1) {
                        System.out.println("\n\t[ Error ] - Ingrese un número mayor a 0");
                        num = 0;
                    } else if (num > cursos.size()) {
                        System.out.println("\n\t[ Error ] - Elija un número válido");
                        num = 0;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("\n\t[ Error ] - Ingrese un número válido");
                    scan.nextLine();
                }
            } while (num == 0);

            list.add(cursos.get(num - 1));
            System.out.print("\n\t¡Curso matriculado con éxito!");

            System.out.print("\n\tDesea añadir otro curso? (S/N): ");
            seguir = validarSN();
        }
        estudiantes.get(index).setCursos(list);
    }
}
