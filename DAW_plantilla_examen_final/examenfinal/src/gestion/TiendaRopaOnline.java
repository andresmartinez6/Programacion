package gestion;

import java.util.HashMap;


public class TiendaRopaOnline {
    
    //Apartado a)
    private String nombreTienda;
    //Atributo HashMap
    private HashMap<String,Ropa>Tienda;
    
    //Apartado b)

    public TiendaRopaOnline(String nombreTienda) {
        this.Tienda = new HashMap<>();
        this.nombreTienda=nombreTienda;
    }
    
    
    //Apartado c)
    private Ropa encontrarRopa(String nombre){
        return this.Tienda.get(nombre);
    }
    
    //Apartado d)
    public void añadirRopa(String nombre,String marca,double precio,char temporada){
        Ropa busqueda,nuevo;
        busqueda=this.encontrarRopa(nombre);
        if(busqueda==null){
            throw new TiendaRopaOnlineException("");
        }else{
            nuevo=new Ropa(nombre,marca,precio,temporada);
            this.Tienda.put(nombre,nuevo);
        }
    }
    
    //Apartado e)
    public String toString() {
        String res="";
        
        return res;
    }
    
    //Apartado f)
    public String sumarPreciosMarcas() {
        String res="";
        
        return res;
    }
    
    //Apartado g)
    public String MasCaraTemporada(char temporada){
        String res="";
        
        return res;
    }
    
    //Apartado h)
    public void guardarRopas(String fichero){
        
    }
    
    //Apartado i)
    public void cargarRopas(String fichero){
        
    }
    
}
