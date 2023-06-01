package tienda.Poo;

import java.util.HashMap;

public class Joya {
    
    private int orden;
    private double precio,peso;
    private String nombre,tipo;
    private char material;
    private static int contador=1;
    
    private static final HashMap<Character,String>materialesCompletos=new HashMap<>(){
        {
            put('o',"ORO");
            put('p',"PLATA");
            put('P',"PLATINO");
            put('i',"IRIDIO");
            put('r',"RODIO");
        }
    };
    
    public Joya(double precio, double peso, String nombre, String tipo, char material) {
        this.precio = precio;
        this.peso = peso;
        this.nombre = nombre;
        this.tipo = tipo;
        this.material = material;
        this.orden=this.contador;
        this.contador++;
    }
    
    public Joya(Joya j) {
        this.precio =j.precio;
        this.peso = j.peso;
        this.nombre = j.nombre;
        this.tipo = j.tipo;
        this.material = j.material;
        this.orden=j.orden;
    }

    
    public int getOrden() {
        return this.orden;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getMaterial() {
        return this.material;
    }

    public void setMaterial(char material) {
        this.material = material;
    }
    
    public boolean equals(Joya j){
        return this.nombre.equals(j.nombre);
    }
    
    public String toString(){
        String res="";
        
        res+="##############################\n";
        res+="ORDEN DE ENTRADA:"+this.orden+"\n"+
             "NOMBRE:"+this.nombre+"\n"+
             "PRECIO:"+this.precio+"\n"+
             "PESO:"+this.peso+"\n"+
             "TIPO:"+this.tipo+"\n"+
             "MATERIAL:"+this.materialesCompletos.get(this.material);
        res+="##############################\n";
        
        return res;
    }
    
    
    public void subirPrecio(double cant){
        if(cant>0){
            this.precio+=cant;
        }else{
            throw new JoyeriaException("ERROR,no se puede subir precio con cantidades"
                    + "negativas");
        }
    }
    
    public static String getMaterialesCompletos(char e_material){
        return materialesCompletos.get(e_material);
    }
        
}

    

