package tienda.poo;
   
import Excepciones.TiendaException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Tienda {
    
    private HashMap<Integer, Producto> productos;

    // ...

    public void guardarDatos(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Producto producto : productos.values()) {
                String linea = producto.getOrden() + "|" + producto.getStock() + "|" + producto.getUnidades_vendidas()
                        + "|" + producto.getNombre() + "|" + producto.getFabricante() + "|" + producto.getPrecio()
                        + "|" + producto.getCoste_unitario() + "|" + producto.getCategoria();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new TiendaException("Error al guardar los datos en el archivo.");
        }
    }

    public void cargarDatos(String nombreArchivo) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length == 8) {
                    int orden = Integer.parseInt(datos[0]);
                    int stock = Integer.parseInt(datos[1]);
                    int unidades_vendidas = Integer.parseInt(datos[2]);
                    String nombre = datos[3];
                    String fabricante = datos[4];
                    double precio = Double.parseDouble(datos[5]);
                    double coste_unitario = Double.parseDouble(datos[6]);
                    char categoria = datos[7].charAt(0);

                    Producto producto = new Producto(orden, stock, unidades_vendidas, nombre, fabricante, precio, coste_unitario, categoria);
                    productos.put(producto.getOrden(),producto);
                } else {
                    throw new TiendaException("El formato del archivo es incorrecto.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new TiendaException("El archivo no existe.");
        } catch (IOException e) {
            throw new TiendaException("Error al leer los datos del archivo.");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new TiendaException("Error en el formato de los datos en el archivo.");
        }
    }
}
