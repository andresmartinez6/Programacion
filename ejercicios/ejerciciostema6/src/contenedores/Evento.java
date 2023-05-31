package contenedores;

public class Evento {

    private String nombre, descripcion;
    private int orden, aforo_max, entradas_vendidas, dia, mes, año;
    private double precio_entrada;
    private char tipo;
    private static int contador = 1;

    public Evento(String nombre, String descripcion, int aforo_max, int entradas_vendidas, int dia, int mes, int año, double precio_entrada, char tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aforo_max = aforo_max;
        this.entradas_vendidas = entradas_vendidas;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.precio_entrada = precio_entrada;
        this.tipo = tipo;
        this.orden = this.contador;
        this.contador++;
    }

    public Evento(Evento e) {
        this.nombre = e.nombre;
        this.descripcion = e.descripcion;
        this.orden = e.orden;
        this.aforo_max = e.aforo_max;
        this.entradas_vendidas = e.entradas_vendidas;
        this.dia = e.dia;
        this.mes = e.mes;
        this.año = e.año;
        this.precio_entrada = e.precio_entrada;
        this.tipo = e.tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOrden() {
        return this.orden;
    }

    public int getAforo_max() {
        return this.aforo_max;
    }

    public void setAforo_max(int aforo_max) {
        this.aforo_max = aforo_max;
    }

    public int getEntradas_vendidas() {
        return this.entradas_vendidas;
    }

    public void venderEntradas(int cantidad) {
        if (cantidad + this.entradas_vendidas <= this.aforo_max) {
            this.entradas_vendidas += cantidad;
            System.out.println("Entradas vendidas con exito");
        } else {
            System.out.println("No hay entradas suficientes");
        }
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio_entrada() {
        return this.precio_entrada;
    }

    public void setPrecio_entrada(double precio_entrada) {
        this.precio_entrada = precio_entrada;
    }

    public char getTipo() {
        return this.tipo;
    }

    public String toString() {
        String res = "";

        res += "##############################\n";
        res += "ORDEN DE ENTRADA:" + this.orden + "\n"
                + "NOMBRE:" + this.nombre + "\n"
                + "DESCRIPCION:" + this.descripcion + "\n"
                + "PRECIO:" + this.precio_entrada + "\n"
                + "AFORO:" + this.aforo_max + "\n"
                + "ENTRADAS VENDIDAS:" + this.entradas_vendidas + "\n";
        switch (this.tipo) {
            case 'f':
                res += "Fiesta\n";
                break;
            case 'o':
                res += "Obra de teatro\n";
                break;
            case 'd':
                res += "Deportivo\n";
                break;
            case 'c':
                res += "Concierto\n";
                break;
        }
        res += "FECHA:";
        if (this.dia <= 9) {
            res += "0";
        }
        res += this.dia + "-";

        if (this.mes <= 9) {
            res += "0";
        }
        res += this.mes + "-";

        if (this.año <= 9) {
            res += "0";
        }
        res += this.año + "\n";

        res += "##############################\n";

        return res;
    }

    public boolean equals(Evento e) {
        return this.nombre.equals(e.nombre);
    }
}
