package gestion;

import java.util.HashMap;


public class Ropa {
    
    private String nombre,marca;
    private double precio;
    private char temporada;
    
    private static final HashMap<Character,String>temporadasCompletas=new HashMap<>(){
        {
            put('P',"PRIMAVERA");
            put('V',"VERANO");
            put('O',"OTOÑO");
            put('I',"INVIERNO");
        }
    };

    public Ropa(String nombre, String marca, double precio, char temporada){
        
        if(nombre.equals("")){
            throw new RopaException("El nombre no puede ser igual a vacio");
        }
        
        if(marca.equals("")){
            throw new RopaException("La marca no puede ser igual a vacio");
        }
        
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.temporada = temporada;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getPrecio() {
        return this.precio;
    }

    public char getTemporada() {
        return this.temporada;
    }
    
    public String getTemporadasCompletas(char e_temporada){
        return temporadasCompletas.get(e_temporada);                                                
    }
    
    @Override
    public String toString(){
        String res="";
            res+="========================================================\n"
                    + "Nombre:"+this.nombre+"\n"
                    + "Precio:"+this.precio+"\n"
                    + "Marca:"+this.marca+"\n"
                    + "Temporada:"+this.temporadasCompletas.get(this.temporada)+"\n"+
                 "==========================================================";
        return res;
    }
    
    
    
}
