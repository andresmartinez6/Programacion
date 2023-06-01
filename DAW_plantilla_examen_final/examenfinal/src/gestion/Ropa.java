package gestion;

import java.util.HashMap;

public class Ropa {
    
    private String nombre,marca;
    private double precio;
    private char temporada;
        
    private static HashMap<Character,String>temporadaCompleta=new HashMap<>(){
        {
            put('P',"PRIMAVERA");
            put('V',"VERANO");
            put('O',"OTOÑO");
            put('I',"INVIERNO");
        }
    };

    //constructor
    public Ropa(String nombre, String marca, double precio, char temporada) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.temporada = temporada;
    }
    
    //constructor de copias
    public Ropa(Ropa rp){
        this.nombre = rp.nombre;
        this.marca = rp.marca;
        this.precio = rp.precio;
        this.temporada = rp.temporada;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public char getTemporada() {
        return temporada;
    }

    public void setNombre(String nombre) {
        if(!nombre.equals("")){
            this.nombre = nombre;
        }else{
            throw new TiendaRopaOnlineException("ERROR,no se pueden añadir productos"
                    + "sin nombre");
        }
    }

    public void setPrecio(double precio) {
        if(precio>0){
            this.precio = precio;
        }else{
            throw new TiendaRopaOnlineException("ERROR,no se admiten valores negativos"
                    + "para el precio");
        }
    }
    
    
    @Override
    public String toString(){
        String res="";
            res+="=========================================================\n"
                    + "Producto:"+this.nombre+"\n"
                    + "Marca:"+this.marca+"\n"
                    + "Precio:"+this.precio+"\n"
                    + "Temporada:"+this.temporadaCompleta.get(this.marca)+"\n"
               + "=========================================================\n"; 
        return res;
    }
    
    
    public void subirPrecio(double e_precio){
        if(e_precio>0){
            this.precio+=e_precio;
        }else{
            throw new TiendaRopaOnlineException("ERROR,no se puede subir el precio"
                    + "con  numeros negativos");
        }
    }
    
    public static String getTemporadaCompleta(char e_temporada){
        return temporadaCompleta.get(e_temporada);
    }
    
}
