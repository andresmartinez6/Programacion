package tienda.poo;

import java.util.HashMap;

public class Producto {

    private boolean constructor = true;
    //Atributos
    private String nombre_producto;
    private double precio_producto;
    private int stock;
    private int unidades_vendidas;
    private char categoria;
    private double coste_unitario;
    private String fabricante_producto;
    private int codigo;

    private static int contador = 1;

    private final static HashMap<Character, String> tiposCompletos = new HashMap<>() {
        {
            put('T', "Caja de PC tipo torre");
            put('t', "Caja de PC tipo semitorre");
            put('m', "Caja de PC tipo microtorre");
            put('b', "Caja de PC tipo barebone");
            put('s', "Caja de servidor");
        }
    };

    //Constructor
    public Producto(String nombre_producto, double precio_producto, double coste_unitario,
            int stock, char categoria, int unidades_vendidas, String fabricante_producto) {

        if (nombre_producto.equals("")) {
            throw new TiendaException("Fallo al construir, nombre vacío.");
        }
        if (precio_producto < 0 || precio_producto < coste_unitario) {
            throw new TiendaException("Fallo al construir, precio del producto incorrecto, tiene que ser mayor que 0 y mayor que el coste unitario.");
        }
        if (coste_unitario < 0) {
            throw new TiendaException("Fallo al construir, coste unitario tiene que ser mayor que 0.");
        }
        if (unidades_vendidas < 0) {
            throw new TiendaException("Fallo al construir, las unidades vendidas no pueden ser negativas.");
        }
        if (stock < 0) {
            throw new TiendaException("Fallo al construir, el stock tiene que ser mayor que 0.");
        }
        if (!(tiposCompletos.containsKey(categoria))) {
            throw new TiendaException("Fallo al construir, la categoria no es correcta.");
        }
        if (fabricante_producto.equals("")) {
            throw new TiendaException("Fallo al construir, el nombre del fabricante no puede estar vacio.");
        }
        this.codigo = this.contador;
        this.contador++;

        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.coste_unitario = coste_unitario;
        this.stock = stock;
        this.categoria = categoria;
        this.unidades_vendidas = unidades_vendidas;
        this.fabricante_producto = fabricante_producto;
    }

    //Constructor copias
    public Producto(Producto otro) {
        this.codigo = this.contador;
        this.contador++;

        this.nombre_producto = otro.nombre_producto;
        this.precio_producto = otro.precio_producto;
        this.coste_unitario = otro.coste_unitario;
        this.stock = otro.stock;
        this.categoria = otro.categoria;
        this.unidades_vendidas = otro.unidades_vendidas;
        this.fabricante_producto = otro.fabricante_producto;
    }

    //Crear selectores
    public String getNombreProducto() {
        return this.nombre_producto;
    }

    public double getPrecioProducto() {
        return this.precio_producto;
    }

    public int getStock() {
        return this.stock;
    }

    public int getUnidadesVendidas() {
        return this.unidades_vendidas;
    }

    public char getCategoria() {
        return this.categoria;
    }

    public double getCosteUnitario() {
        return this.coste_unitario;
    }

    public String getFabricanteProducto() {
        return this.fabricante_producto;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static String getTipoCompleto(char tipo) {
        return tiposCompletos.get(tipo);
    }

    public double getBeneficio() {
        return (this.precio_producto - this.coste_unitario) * this.unidades_vendidas;
    }

    public void subirPrecio(double cantidad) {
        if (cantidad > 0) {
            this.precio_producto += cantidad;
        } else {
            throw new TiendaException("Error precio incorrecto.");
        }
    }

    public void bajarPrecio(double cantidad) {
        if (this.precio_producto - cantidad < this.coste_unitario) {
            throw new TiendaException("No se puede bajar el precio por debajo del coste de producción.");
        } else {
            this.precio_producto -= cantidad;
        }
    }

    public void venderProducto(int cantidad) {
        if (cantidad > this.stock) {
            throw new TiendaException("No hay suficiente stock para vender.");
        } else {
            this.stock -= cantidad;
            this.unidades_vendidas += cantidad;
        }
    }

    //Método modificar categoría
    public void modificarCategoria(char categoria) {
        if (this.tiposCompletos.containsKey(categoria)) {
            this.categoria = categoria;
        } else {
            throw new TiendaException("Tipo incorrecto");
        }
    }

    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        } else {
            throw new TiendaException("Por favor, introduzca cantidad mayor que 0");
        }

    }

    public void actualizarCosteUnitario(double nuevoCosteUnitario) {
        if (nuevoCosteUnitario <= 0) {
            throw new TiendaException("El coste unitario debe ser mayor que 0.");
        } else if (nuevoCosteUnitario >= this.precio_producto) {
            throw new TiendaException("El coste unitario no puede ser mayor o igual que el precio de venta.");
        } else {
            this.coste_unitario = nuevoCosteUnitario;
        }
    }

    //toString
    @Override
    public String toString() {
        String res = "";
        res += "\n-----------------------------------"
                + "\nCódigo de llegada: " + this.codigo
                + "\nNombre: " + this.nombre_producto
                + "\nPrecio: " + this.precio_producto + " €."
                + "\nStock: " + this.stock
                + "\nUnidades vendidas: " + this.unidades_vendidas
                + "\nCategoría: " + this.tiposCompletos.get(this.categoria)
                + "\nCoste unitario: " + this.coste_unitario + " €."
                + "\nFabricante: " + this.fabricante_producto
                + "\n-----------------------------------";
        return res;
    }
}
