package tienda.poo;

import java.util.HashMap;


public class Producto {
    
    
    private int orden,stock,unidades_vendidas=0;
    private String nombre,fabricante,nombre_juegos;
    private double precio,coste_unitario;
    private char categoria;
    
    private static int contador=1;
    
    private HashMap<Character,String>juegosCompletos=new HashMap<>(){
        {
            put('A',"Arcade");
            put('D',"Deportivos");
            put('E',"Estrategia");
            put('R',"Rol");
            put('S',"Simulación");
        }
    };

    public Producto(int stock, String nombre, String fabricante, String nombre_juegos, double precio, double coste_unitario, char categoria) {
        
        
        if (nombre.equals("")) {
            throw new TiendaException("Fallo al construir, nombre vacío.");
        }
        if (precio < 0 || precio < coste_unitario) {
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
        if (!(juegosCompletos.containsKey(categoria))) {
            throw new TiendaException("Fallo al construir, la categoria no es correcta.");
        }
        if (fabricante.equals("")) {
            throw new TiendaException("Fallo al construir, el nombre del fabricante no puede estar vacio.");
        }
        
        this.stock = stock;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.nombre_juegos = nombre_juegos;
        this.precio = precio;
        this.coste_unitario = coste_unitario;
        this.categoria = categoria;
        this.orden=this.contador;
        this.contador++;
    }

    //Constructor copias
    public Producto(Producto prd){
        this.stock = prd.stock;
        this.nombre = prd.nombre;
        this.fabricante = prd.fabricante;
        this.nombre_juegos = prd.nombre_juegos;
        this.precio = prd.precio;
        this.coste_unitario = prd.coste_unitario;
        this.categoria = prd.categoria;
        this.orden=this.contador;
        this.contador++;
    }
    
    public int getOrden() {
        return orden;
    }

    public int getStock() {
        return stock;
    }

    public int getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre_juegos() {
        return nombre_juegos;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCoste_unitario() {
        return coste_unitario;
    }

    public char getCategoria() {
        return categoria;
    }
    
    public static String getTipoCompleto(char tipo) {
        return tiposCompletos.get(tipo);
    }
    
    public double getBeneficio() {
        return (this.precio - this.coste_unitario) * this.unidades_vendidas;
    }

    public void subirPrecio(double e_cantidad) {
        if (e_cantidad > 0) {
            this.precio += e_cantidad;
        } else {
            throw new TiendaException("Error precio incorrecto.");
        }
    }

    public void bajarPrecio(double e_cantidad) {
        if (this.precio - e_cantidad < this.coste_unitario) {
            throw new TiendaException("No se puede bajar el precio por debajo del coste de producción.");
        } else {
            this.precio -= e_cantidad;
        }
    }

    public void venderProducto(int e_cantidad) {
        if (e_cantidad > this.stock) {
            throw new TiendaException("No hay suficiente stock para vender.");
        } else {
            this.stock -= e_cantidad;
            this.unidades_vendidas += e_cantidad;
        }
    }

    //Método modificar categoría
    public void modificarCategoria(char e_categoria) {
        if (this.juegosCompletos.containsKey(e_categoria)) {
            this.categoria = e_categoria;
        } else {
            throw new TiendaException("Tipo incorrecto");
        }
    }

    public void reponerStock(int e_stock) {
        if (e_stock > 0) {
            this.stock += e_stock;
        } else {
            throw new TiendaException("Por favor, introduzca cantidad mayor que 0");
        }

    }

    public void actualizarCosteUnitario(double e_coste) {
        if (e_coste <= 0) {
            throw new TiendaException("El coste unitario debe ser mayor que 0.");
        } else if (e_coste >= this.precio) {
            throw new TiendaException("El coste unitario no puede ser mayor o igual que el precio de venta.");
        } else {
            this.coste_unitario = e_coste;
        }
    }


    @Override
    public String toString(){
        String res="";
        
            res+="=======================================================\n"
                    + "\n                RESUMEN DE COMPRA                 "
                    + "\nNombre:"+this.nombre+"."
                    + "\nNombre producto:"+this.juegosCompletos.get(nombre_juegos)+"."
                    + "\nCategoria:"+this.categoria+"."
                    + "\nCod_cliente:"+this.orden+"."
                    + "\n=======================================================";
        
        return res;
    }
    
    
    
    
}
