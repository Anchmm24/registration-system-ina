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
        byte tipoUsuario;
        
        do{
            tipoUsuario = menu();
            
            switch (tipoUsuario) {
                case 1:
                    usuario();
                    break;
                case 2:
                    administrador();
                default:
                    throw new AssertionError();
            }
        } while(tipoUsuario);
    }

    static byte menu() {
        byte opcion = 0;
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
            }
        } catch (InputMismatchException ex) {
            System.out.println("\n\t[ Error ] - Ingrese un número válido");
        }
        return opcion;
    }
    
    static void usuario(){
        
    }
    
    static void administrador(){
        
    }
}
