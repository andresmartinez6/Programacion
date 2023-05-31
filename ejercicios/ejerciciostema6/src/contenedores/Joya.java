package contenedores;

public class Joya {
    private int orden;
    private double precio,peso;
    private String nombre,tipo;
    private char material;
    private static int contador=1;
    
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
             "TIPO:"+this.tipo+"\n";
        switch(this.material){
            case 'o':
                res+="Oro\n";
                break;
            case 'p':
                res+="plata\n";
                break;
            case 'P':
                res+="Platino\n";
                break;
            case 'i':
                res+="Iridio\n";
                break;
            case 'r':
                res+="Rodio\n";
                break;
        }
        
        res+="##############################\n";
        
        return res;
    }
    
    
        
}
