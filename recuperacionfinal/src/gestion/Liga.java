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

public class Liga {
    
    //Apartado a)
    //Atributo HashMap
    private HashMap<String,Futbolista>liga;

    //Apartado b)
    //Inicializamos el HashMap a vacio
    public Liga(){
        this.liga=new HashMap<>();
    }
    
    //Apartado c)
    private Futbolista encontrarFutbolista(String nombre){
        return this.liga.get(nombre);
    }
    
    //Apartado d)
    public void añadirFutbolista(String nombre_futbolista, String equipo, 
                                            int goles_marcados, char posicion){
        Futbolista nuevo,busqueda;
        busqueda=this.encontrarFutbolista(nombre_futbolista);
        if(busqueda==null){
            nuevo=new Futbolista(nombre_futbolista,equipo,goles_marcados,posicion);
            this.liga.put(nombre_futbolista,nuevo);
        }else{
            throw new FutbolistaException("El futbolista que has introducido ya "
                    + "existe");
        }
    }
    
    //Apartado e)
    public String toString() {
        String res="";
            if(this.liga.isEmpty()){
                res="La liga no dispone de futbolista todavia";
            }else{
                ArrayList<Futbolista>alfabeticamente=new ArrayList<>(this.liga.values());
                alfabeticamente.sort((a,b)->a.getNombre_futbolista()
                                          .compareTo(b.getNombre_futbolista()));
                for(Futbolista fb:alfabeticamente){
                    res+=fb.toString()+"\n";
                }
            }
        return res;
    }
    
    //Apartado f)
    
    private HashMap<String,Integer>contEquip(){
        HashMap<String,Integer>res=new HashMap<>();
        for (Futbolista fb : this.liga.values()) {
            int contador=res.getOrDefault(fb.getEquipo(),0);
            res.put(fb.getEquipo(),contador+1);
        }
        return res;
    }
    
    public String contadorEquipos() {
        String res="";
            if(this.liga.isEmpty()){
                throw new FutbolistaException("La liga no dispone de futbolistas");
            }else{
                HashMap<String,Integer>mapa=this.contEquip();
                for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
                        res+="\n================================================"
                                + "\nDel equipo "+entrada.getKey()+" existen "
                                        +entrada.getValue()+" futbolistas"
                                + "\n================================================";
                }
            }
        return res;
    }
    
    //Apartado g)
    
    private ArrayList<Futbolista>FiltrarPorPosicion(char posicion){
        ArrayList<Futbolista>lista=new ArrayList<>();
        for (Futbolista fb : this.liga.values()) {
            if(fb.getPosicion()==posicion){
                lista.add(fb);
            }
        }
        return lista;
    }
    
    public String futbolistaPosicionGoleador (char posicion){
        String res="";
            ArrayList<Futbolista>lista=this.FiltrarPorPosicion(posicion);
            if(lista.isEmpty()){
                res="La liga no dispone de futbolista de ese tipo";
            }else{
                lista.sort((a,b)->Double.compare(b.getGoles_marcados(),
                                    a.getGoles_marcados()));
                res+=lista.get(0).getNombre_futbolista().toString();
            }
        return res;
    }
    
    //Apartado h)
    public void guardarFutbolistas(String fichero){
       try{
           FileWriter fw=new FileWriter(fichero);
           PrintWriter pw=new PrintWriter(fw);
           for (Futbolista fb : liga.values()) {
               pw.println(
                       fb.getNombre_futbolista()+"#"+
                       fb.getPosicion()+"#"+
                       fb.getGoles_marcados()+"#"+
                       fb.getEquipo()
               
               );
               pw.close();
               fw.close();
           }
       }catch(IOException ioe){
           throw new FutbolistaException("Error de escritura en el fichero");
       }
    }
    
    //Apartado i)
    public void cargarFutbolistas(String fichero){
        try{
            FileReader fr=new FileReader(fichero);
            BufferedReader br=new BufferedReader(fr);

            String linea,nombre,equipo;
            int goles;
            char posicion;
            String[] partes;
            Futbolista nuevo;

            while((linea=br.readLine())!=null){
                partes=linea.split("#");
                nombre=partes[0];

                if(this.liga.containsKey(nombre)){
                    posicion=partes[1].charAt(0);
                    goles=Integer.parseInt(partes[2]);
                    equipo=partes[3];

                    nuevo=new Futbolista(nombre,equipo,goles,posicion);
                    this.liga.put(nombre,nuevo);
                }
            }
            br.close();
            fr.close();
    }catch(NumberFormatException nfe){
        throw new FutbolistaException("Tipo de dato incorrecto");
    }catch(FileNotFoundException fnfe){
        throw new FutbolistaException("No existe el fichero");
    }catch(IOException ioe){
        throw new FutbolistaException("Error de lectura de disco");
    }
    
}
    
}
