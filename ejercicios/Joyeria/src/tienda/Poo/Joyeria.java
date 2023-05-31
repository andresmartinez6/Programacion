package tienda.Poo;

import java.util.HashMap;


public class Joyeria {
    
    private String nombreJoyeria;

    
    //Declaramos el HashMap
    private HashMap<String,Joya>Joyeria;
        
    //Inicializamos el HasMap a vacío
    public Joyeria(String nombreJoyeria){
        this.Joyeria=new HashMap<>();
        this.nombreJoyeria=nombreJoyeria;
    }
    
    
    private Joya encontrarJoya(String e_joya){
        return this.Joyeria.get(e_joya);
    }
    
    public void añadirJoya(double precio, double peso, String nombre, 
                                                    String tipo, char material){
        Joya busqueda,nuevo;
        busqueda=this.encontrarJoya(nombre);
        if(busqueda==null){
            nuevo=new Joya(precio,peso,nombre,tipo,material);
            this.Joyeria.put(nombre,nuevo);
        }else{
            throw new JoyeriaException("No se puede añadir una joya ya existente");
        }
    }
    
    
}
