package tienda.poo;

import java.util.HashMap;


public class Producto {
    
    
    private int orden,stock,unidades_vendidas;
    private String nombre_prod,fabricante_prod;
    private double precio,coste_unitario;
    private char categoria;
    
    private static int contador=1;
    
    private HashMap<Character,String>categoriasCompletas=new HashMap<>(){
        {
            put('A',"Arcade");
            put('D',"Deportivos");
            put('E',"Estrategia");
            put('R',"Rol");
            put('S',"Simulación");
        }
    };

    public Producto(int orden, int stock, int unidades_vendidas, String nombre_prod, 
            String fabricante_prod, double precio, double coste_unitario, char categoria) {
         
        if (stock < 0) {
            throw new TiendaException("Fallo al construir, el stock tiene que ser mayor que 0.");
        }
        if (unidades_vendidas < 0) {
            throw new TiendaException("Fallo al construir, las unidades vendidas no pueden ser negativas.");
        }
        if (nombre_prod.equals("")) {
            throw new TiendaException("Fallo al construir, nombre vacío.");
        }
        if (fabricante_prod.equals("")) {
            throw new TiendaException("Fallo al construir, el nombre del fabricante no puede estar vacio.");
        }
        if (precio < 0 || precio < coste_unitario) {
            throw new TiendaException("Fallo al construir, precio del producto incorrecto, tiene que ser mayor que 0 y mayor que el coste unitario.");
        }
        if (coste_unitario < 0) {
            throw new TiendaException("Fallo al construir, coste unitario tiene que ser mayor que 0.");
        }
    
        if (!(categoriasCompletas.containsKey(categoria))) {
            throw new TiendaException("Fallo al construir, la categoria no es correcta.");
        }
        
        this.stock = stock;
        this.unidades_vendidas = unidades_vendidas;
        this.nombre_prod = nombre_prod;
        this.fabricante_prod = fabricante_prod;
        this.precio = precio;
        this.coste_unitario = coste_unitario;
        this.categoria = categoria;
        this.orden = this.contador;
        this.contador++;
    }
    
    //constructor de copias
    public Producto(Producto prd){
        this.stock = prd.stock;
        this.unidades_vendidas = prd.unidades_vendidas;
        this.nombre_prod = prd.nombre_prod;
        this.fabricante_prod = prd.fabricante_prod;
        this.precio = prd.precio;
        this.coste_unitario = prd.coste_unitario;
        this.categoria = prd.categoria;
        this.orden = this.contador;
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

    public String getNombre_prod() {
        return nombre_prod;
    }

    public String getFabricante_prod() {
        return fabricante_prod;
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
    
    public double beneficioObtenido(){
        return (this.precio-this.coste_unitario)*this.unidades_vendidas;
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
            throw new TiendaException("No se puede bajar el precio si el nuevo "
                    + "precio es inferior al coste de producción.");
        } else {
            this.precio -= e_cantidad;
        }
    }

    public void venderProducto(int e_cantidad) {
        if (e_cantidad > this.stock) {
            throw new TiendaException("No quedan unidades para vender.");
        } else {
            this.stock -= e_cantidad;
            this.unidades_vendidas += e_cantidad;
        }
    }

    //Método modificar categoría
    public void modificarCategoria(char e_categoria) {
        if (this.categoriasCompletas.containsKey(e_categoria)) {
            this.categoria = e_categoria;
        } else {
            throw new TiendaException("La categoria que has introducido no existe");
        }
    }

    public void reponerStock(int e_stock) {
        if (e_stock > 0) {
            this.stock += e_stock;
        } else {
            throw new TiendaException("ERROR,introduzca una cantidad mayor que 0");
        }

    }

    public void actualizarCosteUnitario(double e_coste) {
        if (e_coste <= 0) {
            throw new TiendaException("El coste unitario debe ser mayor que 0.");
        } else if (e_coste >= this.precio) {
            throw new TiendaException("El coste unitario no puede ser mayor o "
                    + "igual que el precio que hay de venta.");
        } else {
            this.coste_unitario = e_coste;
        }
    }
    
    @Override
    public String toString(){
        String res="";
        
            res+="=======================================================\n"
                   +"\n                RESUMEN DE COMPRA                 "
                   +"\nNombre:"+this.nombre_prod+"."
                   +"\nNombre producto:"+this.categoriasCompletas.get(this.categoria)+"."
                   +"\nCategoria:"+this.categoria+"."
                   +"\nCod_cliente:"+this.orden+"."
                   +"\n=======================================================";
        
        return res;
    }
    
    
}
