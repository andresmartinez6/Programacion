package gestion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TiendaRopaOnline {
    
    //Apartado a)
    //Atributo HashMap
    private HashMap<String,Ropa>almacen;
    
    //Apartado b)
    //inicializamos el HashMap a vacio
    public TiendaRopaOnline(){
        this.almacen=new HashMap<>();
    }
   
    //Apartado c)
    private Ropa encontrarRopa(String nombre){
        return this.almacen.get(nombre);
    }
    
    //Apartado d)
    public void añadirRopa(String nombre,String marca,double precio,char temporada){
        Ropa busqueda,añadir;
        busqueda=this.encontrarRopa(nombre);
        if(busqueda==null){
            añadir=new Ropa(nombre,marca,precio,temporada);
            this.almacen.put(nombre,añadir);
        }else{
            throw new RopaException("ERROR,no se puede añadir ropa ya existente");
        }
    }
    
    //Apartado e)
    public String toString() {
        String res="";
            if(this.almacen.isEmpty()){
                res="LA TIENDA ESTA VACIA";
            }else{
                ArrayList<Ropa>ordenados=new ArrayList<>(this.almacen.values());
                ordenados.sort((a,b)->a.getNombre().compareTo(b.getNombre()));
                for (Ropa rp : ordenados) {
                    res+=rp.toString();
                }
            }
        return res;
    }
    
    private HashMap<String,Double>preciosMarca(){
        HashMap<String,Double>r=new HashMap<>();
        for (Ropa rp : this.almacen.values()) {
            double contador=r.getOrDefault(rp.getMarca(),0.0);
            r.put(rp.getMarca(), contador+1);
        }
        return r;
    }
    
    //Apartado f)
    public String sumarPreciosMarcas() {
        String res="";
         if(this.almacen.isEmpty()){
             res="LA TIENDA ESTA VACIA";
         }else{
             HashMap<String,Double>mp=this.preciosMarca();
             for (Map.Entry<String, Double> entrada : mp.entrySet()) {
                res+=entrada.getKey()+" | "+entrada.getValue();
             }
         }
        return res;
    }
    
    private ArrayList<Ropa>filtrarPorTemporada(char temporada){
        ArrayList<Ropa>lista=new ArrayList<>();
        
        for (Ropa rp : this.almacen.values()) {
            if(rp.getTemporada()==temporada){
                lista.add(rp);
            }
        }
        return lista;
    }
    
    //Apartado g)
    public String MasCaraTemporada(char temporada){
        String res="";
            ArrayList<Ropa>lista=this.filtrarPorTemporada(temporada);
            if(lista.isEmpty()){
                throw new RopaException("La tienda no dispone de ropa de esa "
                        + "temporada");
            }else{
                lista.sort((a,b)->Double.compare(b.getPrecio(),a.getPrecio()));
                res+=lista.get(0).toString();
            }
        return res;
    }
    
    //Apartado h)
    public void guardarRopas(String fichero){
        try{
            FileWriter fw=new FileWriter(fichero);
            PrintWriter pw=new PrintWriter(fw);
            
            for (Ropa rp : almacen.values()) {
                pw.println(
                        rp.getNombre()+"@"+
                        rp.getMarca()+"@"+
                        rp.getTemporada()+"@"+
                        rp.getPrecio()+"@"
                );
            }
            pw.close();
            fw.close();
            
        }catch(IOException exc){
            throw new RopaException("ERROR");
        }
    }
    
    //Apartado i)
    public void cargarRopas(String fichero){
        try{
            FileReader fr = new FileReader (fichero);
            BufferedReader br = new BufferedReader (fr);

            String linea, nombre, marca;
            double precio;
            char temporada;
            String [] partes;
            Ropa nueva;

            while ((linea = br.readLine()) != null) {
                partes = linea.split("");
                nombre = partes [0];

                if (!this.almacen.containsKey (nombre)) {
                    
                    marca = partes[1];
                    precio = Double.parseDouble (partes [2]);
                    temporada = partes [3].charAt(0);

                    nueva = new Ropa(nombre, marca, precio,temporada);
                    this.almacen.put (nombre, nueva);
                }

            }
            
            br.close (); 
            fr.close();
            
            }catch (ArrayIndexOutOfBoundsException aiobe) {
                throw new RopaException("Faltan datos en el fichero");
            }catch (NumberFormatException nfe) {
                throw new RopaException("Tipo de dato incorrecto");
            } catch(FileNotFoundException fnf) {
                throw new RopaException ("No existe fichero de Ropa");
            }catch(IOException ioe){
                throw new RopaException("ERROR de lectura en el disco");
            }
        
    }
    
}
