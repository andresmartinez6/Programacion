package principal;

import gestion.TiendaRopaOnline;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalTiendaRopa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        TiendaRopaOnline tienda = new TiendaRopaOnline();
        int opcion = -1;
        String nombre,marca;
        double precio;
        char temporada;
        
        

        //DATOS DE PRUEBA
	tienda.añadirRopa("Sudadera con capucha","Adidas",45,'P');
        tienda.añadirRopa("Camisa de cuadros","Hugo",70,'I');
        tienda.añadirRopa("Chandal","Nike",35,'P');
        tienda.añadirRopa("Camiseta con logo","Adidas",20,'V');
        tienda.añadirRopa("Pantalones cortos de deporte","Nike",15,'V');
        do {
            try {
                System.out.println("======================================================");
                System.out.println("0.Salir");
                System.out.println("1.Añadir Ropa");
                System.out.println("2.Ver toda las Ropas de la tienda ordenadas alfabeticamente(toString)");
                System.out.println("3.Sumas ropas por marca");
                System.out.println("4.Ropa de temporada más cara");
                System.out.println("5.Guardar Ropas en un fichero");
                System.out.println("6.Cargar Ropas desde un fichero");
                System.out.println("======================================================");
                System.out.println("Elige una opción:");
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Adios");
                        break;
                    case 1:
                        System.out.println("Dime el nombre de la Ropa:");
                        nombre = teclado.nextLine();
                        System.out.println("Dime el nombre de la marca de la Ropa:");
                        marca = teclado.nextLine();
                        System.out.println("Dime el precio de venta:");
                        precio = teclado.nextDouble();
                        System.out.println("Dime la temporada:");
                        temporada = teclado.next().charAt(0);
                        tienda.añadirRopa(nombre, marca, precio,temporada);
                        System.out.println("Ropa añadida con éxito");
                        break;
                    case 2:
                        System.out.println("Toda la tienda:\n"+tienda.toString());
                        break;
                    case 3:
                        System.out.println("Resumen suma precios por marca:\n"+
                                            tienda.sumarPreciosMarcas());
                        break;
                    case 4:
                        System.out.println("Dime la temporada:");
                        temporada = teclado.next().charAt(0);
                        System.out.println("Ropa mas cara temporada\n"+tienda.MasCaraTemporada(temporada));
                        break;
                    case 5:
                        System.out.println("Dime el nombre del fichero a guardar:");
                        nombre = teclado.next();
                        tienda.guardarRopas(nombre);
                        System.out.println("Ropas guardadas con exito");
                        break;
                    case 6:
                        System.out.println("Dime el nombre del fichero a cargar:");
                        nombre = teclado.next();
                        tienda.cargarRopas(nombre);
                        System.out.println("Ropas recuperadas con exito");
                        break;
                    default:
                        System.out.println("Opcion erronea¡¡¡");
                }
            } catch (InputMismatchException ime) {
                System.out.println("======================================================");
                System.out.println("Formato de entrada de teclado incorrecto");
                System.out.println("======================================================");
                teclado.nextLine();
            } // catch (RopaExcepcion be){
            //  System.out.println(be.getMessage());
            // }
        } while (opcion != 0);
    }

}
