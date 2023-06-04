package tienda.poo;

import java.util.HashMap;


public class Tienda {
    
    private String nombre_tienda;
    
    //creamos el hasmap
    private HashMap<String,Producto>almacen;
    
    //inicializamos el hashmap a vacio
    public Tienda(String nombre_tienda){
        this.nombre_tienda=nombre_tienda;
        this.almacen=new HashMap<>();
    }
    
    
    
    
}
