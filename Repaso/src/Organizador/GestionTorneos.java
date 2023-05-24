package Organizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class GestionTorneos {
    
    //CREAMOS EL HASHMAP
    private HashMap<String,Torneo>almacen;
    
    //LO INICIALIZAMOS A 0
    public GestionTorneos(){
        almacen=new HashMap<>();
    }
    
    
    private Torneo encontrarTorneo(String e_encontrarTorneo){
        return this.almacen.get(e_encontrarTorneo);
    }
    
    
    public void añadirTorneo(int orden, int dia, int mes, int anio, 
                                String nombre, char ambito, double premio)
    {
        Torneo busqueda,nuevo;
        busqueda=this.encontrarTorneo(nombre);
        if(busqueda==null){
            nuevo=new Torneo(orden,dia,mes,anio,nombre,ambito,premio);
            this.almacen.put(nombre, nuevo);
        }else{
            System.out.println("No se puede añadir un torneo ya existente");
        }
        
    }
    
    
    @Override
    public String toString(){
        String res="";
        
        if(almacen.isEmpty()){
            res="No existe ningun torneo en el sistema";   
        }else{
            res="LISTA DE TORNEOS:";
            for(Torneo torneos:almacen.values()){
                res+=torneos.toString();
            }
        }
        return res;
    }  
    
    
    public String filtrarTorneos(){
        String res="";
            
        for(Torneo torneos:this.almacen.values()){
            if(torneos.getAmbito()=='N' || torneos.getPremio()>=50000){
                res+=torneos.toString();
            }
        }
        
        if(res.equals("")){
            res="No existen torneos con las caracteristicas requeridas";
        }
            
        return res;
    }
    
    public void borrarPocoRentables(){
        Iterator<Torneo> iterador=this.almacen.values().iterator();
        Torneo objeto;
        while(iterador.hasNext()){
            objeto=iterador.next();
            if(objeto.getPremio()<=3000){
                iterador.remove();
                System.out.println("Se ha borrado un torneo poco eficiente");
            }
        }
    }
    
    public void subirPremio(double e_subirDinero,String e_subirNombre){
        Torneo busqueda;
        busqueda=this.encontrarTorneo(e_subirNombre);
        if(busqueda==null){
            System.out.println("El torneo no existe");
        }else{
            busqueda.modificarPremio(e_subirDinero/100*busqueda.getPremio()+
                                        busqueda.getPremio());
        }
    }
    
     private ArrayList<Torneo> filtrarAmbito(char ambito){
        ArrayList<Torneo>res=new ArrayList<>();
        for(Torneo torneo:this.almacen.values()){
            if(torneo.getAmbito()==ambito){
                res.add(torneo);
            }
        }
        return res;
    }
    
    public String menorPremioAmbito(char e_mpAmbito){
        String menor="";
        ArrayList<Torneo>ordenar=this.filtrarAmbito(e_mpAmbito);
        if(ordenar==null){
            System.out.println("No se encuentra este ambito en el programa");
        }else{
            ordenar.sort((a,b)->Double.compare(a.getPremio(),b.getPremio()));
            menor=ordenar.get(0).toString();
        }
        return menor;
    }
    
    
    public String sumarPremiosPorAmbito(){
        String res="";
        
        return res;
    }
    
}
