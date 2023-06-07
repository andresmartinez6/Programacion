package gestion;

import java.util.HashMap;


public class Futbolista {
    
    
   private String nombre_futbolista,equipo;
   private int goles_marcados;
   private char posicion;
   
   private static final HashMap<Character,String>posicionesCompletas=new HashMap<>(){
       {
           put('D',"Delantero");
           put('C',"Centrocampista");
           put('P',"Portero");
       }
   };

    public Futbolista(String nombre_futbolista, String equipo, int goles_marcados, char posicion) {
        
        if(nombre_futbolista.equals("")){
            throw new FutbolistaException("ERROR NO SE HA INTRODUCIDO UN NOMBRE");
        }
        
        if(equipo.equals("")){
            throw new FutbolistaException("ERROR NO SE HA INTRODUCIDO UN EQUIPO");
        }
        
        if(goles_marcados<0){
            throw new FutbolistaException("ERROR NO SE PUEDEN INTRODUCIR GOLES NEGATIVOS");
        }
        
        if(!(posicionesCompletas.containsKey(posicion))){
            throw new FutbolistaException("Error,no ha introducido una posicion correcta");
        }
        
        this.nombre_futbolista = nombre_futbolista;
        this.equipo = equipo;
        this.goles_marcados = goles_marcados;
        this.posicion = posicion;
        
    }

    public String getNombre_futbolista() {
        return nombre_futbolista;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getGoles_marcados() {
        return goles_marcados;
    }

    public char getPosicion() {
        return posicion;
    }
    
    public void modificarPosicion(char nueva_posicion){
        if(posicionesCompletas.containsKey(posicion)){
            this.posicion=nueva_posicion;
        }else{
           throw new FutbolistaException("No existe esa posicion");
        }
    }
    
    public String getPosicionesCompletas(char posicion){
        return this.posicionesCompletas.get(posicion);
    }
    
    @Override
    public String toString(){
        String res="";
            res+="\n==============================================="
                    + "\nNombre:"+this.nombre_futbolista+"."
                    + "\nGoles:"+this.goles_marcados+"."
                    + "\nClub:"+this.equipo+"."
                    + "\nPosicion:"+this.posicionesCompletas.get(this.posicion)+"."
                    + "\n==================================================";
        return res;
    }
   
   
   
}
