package tienda.poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class Tienda {

    //Cte de reponer stock
    final int porcentaje = 20;

    private String nombre_tienda;
    private HashMap<String, Producto> almacen;

    //Constructor
    public Tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
        this.almacen = new HashMap<>();
    }

    //Imprimir toda la informacion
    @Override
    public String toString() {
        String res = "";
        res += "Bienvenidos a " + this.nombre_tienda + "\n";
        if (this.almacen.isEmpty()) {
            res += "No tenemos torres disponibles.";
        } else {
            res += "Nuestras torres disponibles son:\n";
            for (Producto prod : this.almacen.values()) {
                res += prod.toString();
            }
        }
        return res;
    }

    //Filtrar producto por cadena de texto
    public String filtrarTorres(String patron) {
        String res = "";

        for (Producto torre : this.almacen.values()) {
            if (torre.getNombreProducto().toLowerCase().contains(patron.toLowerCase())) {
                res += torre.toString();
            }
        }
        if (res.equals("")) {
            res = "No coincide ninguna torre con ese patrón de búsqueda\n";
        }
        return res;
    }

    //Buscar objeto por nombre completo
    private Producto buscarTorre(String nombre_producto) {
        return this.almacen.get(nombre_producto);
    }

    //Método añadir producto
    public void añadirTorre(String nombre_producto, double precio_producto, double coste_unitario,
            int stock, char categoria, String fabricante_producto) {
        Producto nuevo, busqueda;
        busqueda = this.buscarTorre(nombre_producto);
        if (busqueda == null) {
            nuevo = new Producto(nombre_producto, precio_producto, coste_unitario, stock, categoria, 0, fabricante_producto);
            this.almacen.put(nombre_producto, nuevo);
        } else {
            throw new TiendaException("Ya existe una torre con ese nombre. No se añade.");
        }
    }

    //Método borrar producto
    public void borrarTorre(String nombre_producto) {
        Producto busqueda;
        busqueda = this.buscarTorre(nombre_producto);
        if (busqueda == null) {
            throw new TiendaException("No se encuentra la torre a borrar.");
        } else {
            this.almacen.remove(nombre_producto);
        }
    }

    //Vender producto
    public void venderTorre(String nombre_producto, int cantidad) {
        Producto busqueda;
        busqueda = this.buscarTorre(nombre_producto);
        if (busqueda == null) {
            throw new TiendaException("No existe esa torre.");
        } else {
            busqueda.venderProducto(cantidad);
        }
    }

    //Reponer producto
    public void reponerTorre() {
        for (Producto producto : almacen.values()) {
            if (producto.getStock() > 0 && producto.getStock() < producto.getUnidadesVendidas()) {
                producto.reponerStock(porcentaje * producto.getStock() / 100);
            }
        }
    }

    //Devolver productos orden alfabético
    public String ordenadasOrdenAlfabetico() {
        String res = "";
        if (this.almacen.isEmpty()) {
            res = "No hay torres que mostrar.";
        } else {
            ArrayList<Producto> ordenado = new ArrayList<>(almacen.values());
            ordenado.sort((a, b) -> a.getNombreProducto().compareTo(b.getNombreProducto()));
            for (Producto producto : ordenado) {
                res += producto.toString();
            }
        }
        return res;
    }

    //Metodo menos beneficios
    public String menosBeneficios() {
        String res = "";
        if (this.almacen.isEmpty()) {
            res = "No hay productos";
        } else {
            ArrayList<Producto> beneficio_ordenado = new ArrayList<>(almacen.values());
            beneficio_ordenado.sort((a, b) -> Double.compare(a.getBeneficio(), b.getBeneficio()));
            res = beneficio_ordenado.get(0).toString();
        }
        return res;
    }

    //Método subir precio
    public void subirPrecioTorre(String nombre_producto, double cantidad) {
        Producto busqueda;
        busqueda = this.buscarTorre(nombre_producto);
        if (busqueda == null) {
            throw new TiendaException("No existe esa torre.");
        } else {
            busqueda.subirPrecio(cantidad);
        }
    }

    //Método bajar precio
    public void bajarPrecioTorre(String nombre_producto, double cantidad) {
        Producto busqueda;
        busqueda = this.buscarTorre(nombre_producto);
        if (busqueda == null) {
            throw new TiendaException("No existe esa torre.");
        } else {
            busqueda.bajarPrecio(cantidad);
        }
    }

    //Método borrar productos
    public void borrarTorres() {
        Iterator<Producto> it = this.almacen.values().iterator();
        Producto objeto;
        while (it.hasNext()) {
            objeto = it.next();
            if (objeto.getUnidadesVendidas() < objeto.getStock() && objeto.getUnidadesVendidas() > 0) {
                it.remove();
            }
        }

    }

    //Método ArrayList de determinada categoría
    private ArrayList<Producto> filtrarPorTipo(char categoria) {
        ArrayList<Producto> res = new ArrayList<>();
        for (Producto producto : this.almacen.values()) {
            if (producto.getCategoria() == categoria) {
                res.add(producto);
            }
        }
        return res;
    }

    //Método torre más cara de determinada categoria
    public String torreMasCaraTipo(char categoria) {
        String res = "";
        ArrayList<Producto> solo_tipo = this.filtrarPorTipo(categoria);
        if (solo_tipo.isEmpty()) {
            res = "No hay torres de ese tipo.\n";
        } else {
            solo_tipo.sort((a, b) -> Double.compare(b.getPrecioProducto(), a.getPrecioProducto()));
            res = solo_tipo.get(0).toString();
        }
        return res;

    }

    //Método beneficios por categoría
    private HashMap<Character, Double> beneficioCategoriasTipo() {
        HashMap<Character, Double> beneficio = new HashMap<>();
        for (Producto producto : this.almacen.values()) {
            double beneficio_actual = beneficio.getOrDefault(producto.getCategoria(), 0.0);
            beneficio.put(producto.getCategoria(), beneficio_actual + producto.getBeneficio());
        }
        return beneficio;
    }

    //String beneficios por categoria
    public String beneficioPorCategorias() {
        String res = "";
        HashMap<Character, Double> beneficio_tipo = this.beneficioCategoriasTipo();
        if (beneficio_tipo.isEmpty()) {
            res = "No hay torres.\n";
        } else {
            for (Entry<Character, Double> producto : beneficio_tipo.entrySet()) {
                String tipoCompleto = Producto.getTipoCompleto(producto.getKey());
                res += tipoCompleto + "->" + producto.getValue() + "\n";
            }
        }
        return res;
    }

    //Método ventas por fabricante
    private HashMap<String, Integer> ventasPorFabricante() {
        HashMap<String, Integer> ventas_fabricante = new HashMap<>();
        for (Producto producto : this.almacen.values()) {
            int ventas_actuales = ventas_fabricante.getOrDefault(producto.getFabricanteProducto(), 0);
            ventas_fabricante.put(producto.getFabricanteProducto(), ventas_actuales + producto.getUnidadesVendidas());
        }
        return ventas_fabricante;
    }

    //String fabricante que mas vende
    public String fabricanteMasVende() {
        String res = "";

        if (this.almacen.isEmpty()) {
            res = "No hay torres.\n";
        } else {
            HashMap<String, Integer> fabricante_mas_vende = this.ventasPorFabricante();
            ArrayList<Entry<String, Integer>> fabricante_ventas = new ArrayList<>(fabricante_mas_vende.entrySet());
            fabricante_ventas.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
            res = fabricante_ventas.get(0).getKey();
        }
        return res;
    }

    //Guardado de datos
    public void guardarTorres(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);//Abre la ruta
            PrintWriter pw = new PrintWriter(fw);//Escribe en el archivo
            for (Producto pro : this.almacen.values()) {
                pw.println(
                        pro.getNombreProducto() + ":"
                        + pro.getPrecioProducto() + ":"
                        + pro.getCosteUnitario() + ":"
                        + pro.getStock() + ":"
                        + pro.getCategoria() + ":"
                        + pro.getUnidadesVendidas() + ":"
                        + pro.getFabricanteProducto()
                );
            }
            pw.close();
            fw.close();
        } catch (IOException ex) {
            throw new TiendaException("Error de escritura de las torres en fichero.");
        }

    }

    //Cargar datos
    public void cargarTorres(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea, nombre, fabricante_producto;
            int stock, unidades_vendidas;
            double coste_unitario, precio;
            char tipo;
            String[] partes;
            Producto nuevo;

            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                nombre = partes[0];
                if(!this.almacen.containsKey(nombre)){
                    precio=Double.parseDouble(partes[1]);
                    coste_unitario=Double.parseDouble(partes[2]);
                    stock=Integer.parseInt(partes[3]);
                    tipo=partes[4].charAt(0);
                    unidades_vendidas=Integer.parseInt(partes[5]);
                    fabricante_producto=partes[6];
                    
                    nuevo=new Producto(nombre, precio, coste_unitario, stock, tipo, unidades_vendidas, fabricante_producto);
                    this.almacen.put(nombre, nuevo);
                }
            }
            br.close();
            fr.close();
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            throw new TiendaException("Faltan datos en el fichero");
        } catch (NumberFormatException nfe) {
            throw new TiendaException("Tipo de dato incorrecto");
        } catch (FileNotFoundException fnf) {
            throw new TiendaException("No existe fichero de torres");
        } catch (IOException io) {
            throw new TiendaException("Error de lectura en disco");
        }
    }

}
