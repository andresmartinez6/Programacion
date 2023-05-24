package Organizador;

import java.util.HashMap;


public class Torneo {
    private int orden,dia,mes,anio;
    private String nombre;
    private char ambito;
    private double premio;
    
    private static int contador=1;
    
    private final static HashMap<Character,String>ambitosCompletos=new HashMap<>(){
        {
            put('L',"Local");
            put('N',"Nacional");
            put('I',"Internacional");
            put('A',"Autonomico");
        }
    };

    public Torneo(int orden, int dia, int mes, int anio, String nombre, char ambito, double premio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.nombre = nombre;
        this.ambito = ambito;
        this.premio = premio;
        this.orden = this.contador;
        this.contador++;
    }

    public int getOrden() {
        return this.orden;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAnio() {
        return this.anio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public char getAmbito() {
        return this.ambito;
    }

    public double getPremio() {
        return this.premio;
    }
    
    public void modificarPremio(double e_premio){
        if(e_premio>=0){
            this.premio=e_premio;
        }else{
            System.out.println("ERROR,no se puede introducir dinero negativo");
        }
    }
    
    
    public void modificarAmbito(char e_ambito){
        if(this.ambitosCompletos.containsKey(this.ambito)){
            this.ambito=e_ambito;
        }else{
            System.out.println("ERROR,no se puede modificar este ambito");
        }
    }
    
    public static String getAmbitoCompleto(char e_ambitocompleto){
        return ambitosCompletos.get(e_ambitocompleto);
    }
    
    
    @Override
    public String toString(){
        String res="";
            
            res+="============================================\n"
                    + "Orden: "+this.orden+"\n"
                    + "Nombre: "+this.nombre+"\n"
                    + "Premio: "+this.premio+"\n"
                    + "Ámbito: "+ambitosCompletos.get(this.ambito)+"\n"
                    + "Fecha: "+this.dia+"/"+this.mes+"/"+this.anio+"\n"
                    + "============================================";
        
        return res;
    }
    
    
    
}
