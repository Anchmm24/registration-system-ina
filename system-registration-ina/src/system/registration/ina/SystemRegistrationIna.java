package system.registration.ina;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemRegistrationIna {
    static String password = "cheeseburger09";
    static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte tipoUsuario, opc;
        
        do{
            tipoUsuario = menu();
            
            switch (tipoUsuario) {
                case 1:
                    opc = usuarioMenu();
                    gestionesUsuario(opc);
                    
                    break;
                case 2:
                    boolean entra = validacionAdmin();
                    if(entra){
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
            
        } while(tipoUsuario==1 || tipoUsuario==2);
    }

    //Menú general del programa.
    static byte menu() {
        byte opcion = 0;
        boolean error = false;
        
        do{
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
                    error= true;
                }
            } catch (InputMismatchException ex) {
                error= true;
                System.out.println("\n\t[ Error ] - Ingrese un número válido");
            }
        }while(error);
        
        return opcion;
    }
    
    //Menú con las gestiones disponibles para el usuario.
    static byte usuarioMenu(){
        byte opcion = 0;
        boolean error = false;
        
        do{
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
        }while(error);
        
        return opcion;
    }
    
    //Método que contiene un switch. Se realizan acciones de acuerdo con la selección del usuario.
    static void gestionesUsuario(byte opc){
        switch(opc){
            case 1: 
                //Se listan los cursos.
                break;
            case 2: 
                //Se listan los profesores
                break;
            case 3: 
                //Se listan los estudiantes
                break;
            case 4: 
                //Se realiza la matrícula
                
        }
    }
    
    //Método que valida la contraseña ingresada para administrador. 
    static boolean validacionAdmin(){
        byte intentos = 3;
        
        do{
            System.out.println("\nIngrese la contraseña:");
            String contraIngresada = scan.nextLine();
            if(contraIngresada == null ? password == null : contraIngresada.equals(password)){
                return true;
            }else{
                intentos--;
                System.out.println("\nCONTRASEÑA INCORRECTA. Intentos restantes: "+ intentos);
            }
        }while(intentos!=0);
        
        
        return false;
        
    }
    
    //Menú con las gestiones disponibles para el administrador.
    static byte administradorMenu(){
        
        byte opcion = 0;
        boolean error = false;
        
        do{
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
        }while(error);
        
        return opcion;
    }
    
    //Método que contiene un switch. Se realizan acciones de acuerdo con la selección del administardor.
    static void gestionesAdministrador(byte opc){
        
        byte opc2=0;
        
        switch(opc){
            case 1: 
                //Se redirige al menú de gestiones referentes a los cursos.
                System.out.println("ADMINISTRACIÓN CURSOS");
                opc2 = administracionClases();
                break;
            case 2: 
                //Se redirige al menú de gestiones referentes a los profesores.
                System.out.println("ADMINISTRACIÓN PROFESORES");
                opc2 = administracionClases();
                
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
    
    static byte administracionClases(){
        byte opcion = 0;
        boolean error = false;
        
        do{
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
        }while(error);
        
        return opcion;
    }
    
    
}
