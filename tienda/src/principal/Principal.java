package principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import tienda.poo.Tienda;
import tienda.poo.TiendaException;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tienda la_tienda = new Tienda("TorresGaming EAG");

        //Torres de prueba
        la_tienda.añadirTorre("Corsair iCUE 7000X RGB", 410, 80, 20, 'T', "Corsair");
        la_tienda.añadirTorre("SilverStone ML04B", 108, 45, 5, 't', "SilverStone");
        la_tienda.añadirTorre("Thermaltake Tower 100 Mini Torre", 120, 50, 10, 'm', "Thermaltake");
        la_tienda.añadirTorre("Caja servidor Lanberg", 100, 40, 9, 'b', "Lanberg");
        la_tienda.añadirTorre("Aerocool Genesis ARGB", 80, 40, 4, 's', "Aerocool");

        int opcion=-1;
        String nombre, dis;
        char tipo;
        int existencias, unidades;
        double precio, coste_unitario;
        String ruta;

        do {
            try{
                System.out.println("0.Salir");
                System.out.println("1.Mostrar nombre tienda e informacion");
                System.out.println("2.Filtrar por nombre");
                System.out.println("3.Añadir torre");
                System.out.println("4.Borrar una torre concreta");
                System.out.println("5.Vender torre");
                System.out.println("6.Reponer torres");
                System.out.println("7.Torres en orden alfabético");
                System.out.println("8.Torre que reporta menos beneficios");
                System.out.println("9.Subir precio de una torre");
                System.out.println("10.Bajar precio de una torre");
                System.out.println("11.Borrar segun criterio");
                System.out.println("12.Torre mas cara de una determinada categoria");
                System.out.println("13.Beneficios por categorias");
                System.out.println("14.Fabricante que más vende");
                System.out.println("15.Guardar torres");
                System.out.println("16.Cargar torres");
                System.out.println("Elige una opción disponible:");
                opcion = teclado.nextInt();
                teclado.nextLine();
                    switch (opcion) {
                        case 0:
                            System.out.println("Adios");
                            break;
                        case 1:
                            //Mostrar nombre tienda e información
                            System.out.println(la_tienda.toString());
                            break;
                        case 2:
                            //Filtrar por nombre
                            System.out.println("Dime el patrón de búsqueda:");
                            nombre = teclado.nextLine();
                            System.out.println(la_tienda.filtrarTorres(nombre));
                            break;
                        case 3:
                            //Añadir torre
                            System.out.println("Dime el nombre:");
                            nombre = teclado.nextLine();
                            System.out.println("Dime las existencias:");
                            existencias = teclado.nextInt();
                            System.out.println("Dime el tipo (T,t,m,b,s):");
                            tipo = teclado.next().charAt(0);
                            System.out.println("Dime el precio:");
                            precio = teclado.nextDouble();
                            System.out.println("Dime el coste unitaro:");
                            coste_unitario = teclado.nextDouble();
                            teclado.nextLine();
                            System.out.println("Dime el distribuidor:");
                            dis = teclado.nextLine();
                            la_tienda.añadirTorre(nombre, precio, coste_unitario, existencias, tipo, dis);
                            System.out.println("Torre añadida con éxito");
                            break;
                        case 4:
                            //Borrar una torre concreta
                            System.out.println("Dime el nombre de la torre a borrar");
                            nombre = teclado.nextLine();
                            la_tienda.borrarTorre(nombre);
                            System.out.println("Se ha borrado la torre con éxito");
                            break;
                        case 5:
                            //Vender torre
                            System.out.println("Dime el nombre de la torre:");
                            nombre = teclado.nextLine();
                            System.out.println("Dime cuantas unidades:");
                            unidades = teclado.nextInt();
                            la_tienda.venderTorre(nombre, unidades);
                            System.out.println("Venta de torre realizada con éxito");
                            break;
                        case 6:
                            //Reponer torres
                            la_tienda.reponerTorre();
                            break;
                        case 7:
                            //Torres en orden alfabético
                            System.out.println("torres ordenadas por nombre:\n" + la_tienda.ordenadasOrdenAlfabetico());
                            break;
                        case 8:
                            //Torre que reporta menos beneficios
                            System.out.println("La torre que reporta menos beneficios:\n" + la_tienda.menosBeneficios());
                            break;
                        case 9:
                            //Subir precio de una torre
                            System.out.println("Nombre de la torre a subir precio:");
                            nombre = teclado.nextLine();
                            System.out.println("Cantidad a subir");
                            precio = teclado.nextDouble();
                            la_tienda.subirPrecioTorre(nombre, precio);
                            System.out.println("Se ha subido el precio con éxito");
                            break;
                        case 10:
                            //Bajar precio de una torre
                            System.out.println("Nombre de la torre a bajar precio:");
                            nombre = teclado.nextLine();
                            System.out.println("Cantidad a bajar");
                            precio = teclado.nextDouble();
                            la_tienda.bajarPrecioTorre(nombre, precio);
                            System.out.println("Se ha bajado el precio con éxito");
                            break;
                        case 11:
                            //Borrar torres segun criterio
                            la_tienda.borrarTorres();
                            break;
                        case 12:
                            //Torre mas cara de una determinada categoria
                            System.out.println("Ingrese la categoría:");
                            tipo = teclado.next().charAt(0);
                            teclado.nextLine();
                            System.out.println("La más cara de tipo " + tipo + " es:\n" + la_tienda.torreMasCaraTipo(tipo));
                            break;
                        case 13:
                            //Beneficios por categorias
                            System.out.println("Beneficios por categorías:\n" + la_tienda.beneficioPorCategorias());
                            break;
                        case 14:
                            //Fabricante que más vende
                            System.out.println("Fabricante que más vende:\n" + la_tienda.fabricanteMasVende());
                            break;
                        case 15:
                            System.out.println("Ruta para guardar las torres.");
                            ruta = teclado.next();
                            la_tienda.guardarTorres(ruta);
                            System.out.println("Torres guardadas con exito.");
                            break;
                        case 16:
                            System.out.println("Ruta donde obtener las torres.");
                            ruta = teclado.next();
                            teclado.nextLine();
                            la_tienda.cargarTorres(ruta);
                            System.out.println("Torres cargadas con éxito");
                            break;
                        default:
                            System.out.println("Opción errónea.");
                    }
            }catch(InputMismatchException ime){
                teclado.nextLine();
                System.out.println("Datos de entrada incorrectos");
            }catch(TiendaException te){
                System.out.println(te.getMessage());
            }
            

            System.out.println("Pulsa intro para continuar");
            teclado.nextLine();
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
        } while (opcion != 0);
    }
}
