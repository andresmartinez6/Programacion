package tienda.Poo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
            throw new JoyeriaException("No se puede añadir una joya ya existente");
        }else{
            nuevo=new Joya(precio,peso,nombre,tipo,material);
            this.Joyeria.put(nombre,nuevo);
        }
    }
    
    
    @Override
    public String toString(){
        String res="";
            res+="Bienvenidos a la Joyeria";
           if(this.Joyeria.isEmpty()){
               res+="SIN JOYAS";
           }else{
               for(Joya jy : this.Joyeria.values()){
                   res+=jy.toString();
               }
           }
        return res;
    }
    
    
    private String buscarJoya(String e_joya){
        String res="";
            for(Joya joya : this.Joyeria.values()){
                if(joya.getNombre().toLowerCase().contains(e_joya.toLowerCase())){
                    res+=joya.toString();
                }
            }
            if(res.equals("")){
                res+="SIN RESULTADOS";
            }
        return res;
    }
    
    
    public String verPorMaterial(char material){
        String res="";
            for (Joya joya : this.Joyeria.values()) {
                if(joya.getMaterial()==material){
                    res+=joya.toString();
                }
            }
            if(res.equals("")){
                res="No ";
            }
        return res;
    }
    
    
    public void borrarJoya(String e_nom){
        Joya busqueda;
        busqueda=this.encontrarJoya(e_nom);
        if(busqueda==null){
            throw new JoyeriaException("ERROR,NO EXISTE LA JOYA A BORRAR");
        }else{
            this.Joyeria.remove(e_nom);
        }
    }
    
    
    public double sumaPrecio(){
       double suma = 0;
        if(this.Joyeria.isEmpty()){
            throw new JoyeriaException("La joyeria esta vacía");
        }else{
            for (Joya joya : this.Joyeria.values()) {
                suma+=joya.getPrecio();
            }
        }
        return suma;
    }
    
    
    public void subirPrecio(double e_porcentaje,String n_joya){
        double pr=e_porcentaje/100;
        Joya busqueda;
        busqueda=this.encontrarJoya(n_joya);
        if(busqueda==null){
            throw new JoyeriaException("No hay joyas en la tienda a las que "
                    + "subir el precio");
        }else{
            busqueda.subirPrecio(busqueda.getPrecio()*pr+(busqueda.getPrecio()));
        }
    }
    
    
    public void borrarBaratas(){
        Iterator<Joya>it=this.Joyeria.values().iterator();
        Joya puntero;
        while (it.hasNext()) {
            puntero=it.next();
            if(puntero.getPrecio()<=20){
                it.remove();
            }
        }
    }
    
    private HashMap<Character,Integer>listamateriales(){
        int conteo=0;
        HashMap<Character,Integer>lista=new HashMap<>();
            for (Joya jo : this.Joyeria.values()) {
                conteo=lista.getOrDefault(jo.getMaterial(), 0 );
                lista.put(jo.getMaterial(), conteo++);
            }
        return lista;
    }
    
    public String contadorMateriales(){
        String res="";
            for(Map.Entry<Character,Integer>par : this.listamateriales().entrySet()) {
                String nombre;
                int numero=0;
                nombre=Joya.getMaterialesCompletos(par.getKey());
                numero=par.getValue();
                res+="Nombre Joya:"+nombre+" | Numero de Joyas:"+numero;
            }
        return res;
    }
    
    
    
    
    
}
