package tienda.poo;

import Excepciones.TiendaException;
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
    
    public Producto(int orden, int stock, int unidades_vendidas, String nombre, String fabricante, double precio, double coste_unitario, char categoria) {
        this.stock = stock;
        this.unidades_vendidas = unidades_vendidas;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.nombre_juegos= nombre_juegos;
        this.precio = precio;
        this.coste_unitario = coste_unitario;
        this.categoria = categoria;
        this.orden=this.contador;
        this.contador++;
    }
    
    
    
    public Producto(Producto prod){
        this.stock = prod.stock;
        this.unidades_vendidas = prod.unidades_vendidas;
        this.nombre = prod.nombre;
        this.fabricante = prod.fabricante;
        this.nombre_juegos=prod.nombre_juegos;
        this.precio = prod.precio;
        this.coste_unitario = prod.coste_unitario;
        this.categoria = prod.categoria;
        this.orden=this.contador;
        this.contador++;
    }

    public String getNombre_juegos() {
        return nombre_juegos;
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
        double ingresosTotales = precio * unidades_vendidas;
        double costeTotal = coste_unitario * unidades_vendidas;
        double beneficio = ingresosTotales - costeTotal;
        return beneficio;
    }
    
    public void subirPrecioProd(double e_subirProd){
        if(e_subirProd>=0){
            this.precio+=e_subirProd;
        }else{
            throw new TiendaException("No se puede subir el precio si la "
                    + "cantidad es 0 o es negativa.");

        }
    }
    
    public void bajarPrecioProd(double e_bajarProd){
        if(e_bajarProd>=coste_unitario){
            this.precio-=e_bajarProd;
        }else{
            throw new TiendaException("No se puede actualizar el precio si "
                    + "el precio es inferior al coste de producción.");
        }
    }
    
    
    public void venderStock(int cantidad){
        if(cantidad>stock){
            System.out.println("No se pueden vender mas unidades de las ya"
                    + "existentes");
        }else{
            stock-=cantidad;
            unidades_vendidas+=cantidad;
            System.out.println("Se han vendido " + cantidad + " unidades de " + nombre);
            System.out.println("Stock actual: " + stock);
            System.out.println("Total de unidades vendidas: " +unidades_vendidas);
        }
    }
    
    
    public void modificarCategoria(char e_cambiarCat){
        String nueva_categoria= juegosCompletos.get(e_cambiarCat);
        if (!nueva_categoria.equals("") && e_cambiarCat != this.categoria) {
            this.categoria = e_cambiarCat;
            System.out.println("Categoría cambiada correctamente");
        } else {
            System.out.println("ERROR: No se puede cambiar una categoría "
                    + "si ya existe o si has introducido en blanco");
        }
    }
    
    
    public void reponerStock(int cantidad) {
        if (cantidad>=0) {
            stock+=cantidad;
            System.out.println("Stock repuesto correctamente");
            System.out.println("Nuevo stock: " + stock);
        } else {
            System.out.println("ERROR: No se puede reponer un stock negativo");
        }
    }
    
    
    public void actualizarCosteUnitario(double e_costeUnitario){
        if(e_costeUnitario>0 && e_costeUnitario<=coste_unitario){
            this.coste_unitario=e_costeUnitario;
            System.out.println("Coste unitario actualizado correctamente");
        }else{
            System.out.println("ERROR,El nuevo coste unitario debe ser mayor "
                    + "que 0 y no puede ser superior al precio de venta");
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
