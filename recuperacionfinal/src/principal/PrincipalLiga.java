package principal;

import gestion.FutbolistaException;
import gestion.Liga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalLiga {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        Liga liga22_23 = new Liga();
        
        int opcion = -1;
        String nombre,equipo;
        char posicion;
        int goles;
        
        
        //DATOS DE PRUEBA
        liga22_23.añadirFutbolista("Vinicius Junior","Real Madrid C.F.",25,'D');
        liga22_23.añadirFutbolista("Ter Stegen","F.C. Barcelona",0,'P');
        liga22_23.añadirFutbolista("Luka Modrid","Real Madrid C.F.",5,'C');
        liga22_23.añadirFutbolista("Zlatan Ibrahimovic","A.C. Milan",10,'D');
        liga22_23.añadirFutbolista("Erling Halland","Machester City",50,'D');
        do {
            try {
                System.out.println("======================================================");
                System.out.println("0.Salir");
                System.out.println("1.Añadir Futbolista");
                System.out.println("2.Ver toda los futbolistas de la Liga ordenadas alfabeticamente por nombre(toString)");
                System.out.println("3.Contar futbolistas por equipo");
                System.out.println("4.Máximo goleador por posición");
                System.out.println("5.Guardar futbolistas en un fichero");
                System.out.println("6.Cargar futbolistas desde un fichero");
                System.out.println("======================================================");
                System.out.println("Elige una opción:");
                
                opcion = teclado.nextInt();
                teclado.nextLine();
                
                switch (opcion) {
                    case 0:
                        System.out.println("Adios");
                        break;
                    case 1:
                        System.out.println("Dime el nombre del futbolista:");
                        nombre = teclado.nextLine();
                        System.out.println("Dime el nombre de su equipo:");
                        equipo = teclado.nextLine();
                        System.out.println("Dime los goles que ha marcado:");
                        goles = teclado.nextInt();
                        System.out.println("Dime la posicion:");
                        posicion = teclado.next().charAt(0);
                        liga22_23.añadirFutbolista(nombre, equipo, goles, posicion);
                        
                        System.out.println("Futbolista añadido con éxito");
                        break;
                    case 2:
                        System.out.println("Todos los futbolistas:\n"+liga22_23.toString());
                        break;
                    case 3:
                        System.out.println("Resumen futbolistas por equipo:\n"+
                                            liga22_23.contadorEquipos());
                        break;
                    case 4:
                        System.out.println("Dime la posicion del futbolista:");
                        posicion = teclado.next().charAt(0);
                        System.out.println("Maximo goleador con dicha posicion:\n"+
                                            liga22_23.futbolistaPosicionGoleador(posicion));
                        break;
                    case 5:
                        System.out.println("Dime el nombre del fichero a guardar:");
                        nombre = teclado.next();
                        liga22_23.guardarFutbolistas(nombre);
                        System.out.println("Futbolistas guardados con exito");
                        break;
                    case 6:
                        System.out.println("Dime el nombre del fichero a cargar:");
                        nombre = teclado.next();
                        liga22_23.cargarFutbolistas(nombre);
                        System.out.println("Futbolistas recuperados con exito");
                        break;
                    default:
                        System.out.println("Opcion erronea¡¡¡");
                }
            } catch (InputMismatchException ime) {
                System.out.println("======================================================");
                System.out.println("Formato de entrada de teclado incorrecto");
                System.out.println("======================================================");
                teclado.nextLine();
            }catch (FutbolistaException be){
              System.out.println(be.getMessage());
            }
        } while (opcion != 0);
    }

}
