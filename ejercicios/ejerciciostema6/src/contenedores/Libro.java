package contenedores;

public class Libro {
    private String titulo,ISBN,autor;
    private int num_paginas,calificacion;

    public Libro(String titulo, String ISBN, String autor, int num_paginas, int calificacion) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
        this.num_paginas = num_paginas;
        this.calificacion = calificacion;
    }
    
     public Libro(Libro l) {
        this.titulo = l.titulo;
        this.ISBN = l.ISBN;
        this.autor = l.autor;
        this.num_paginas = l.num_paginas;
        this.calificacion = l.calificacion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNum_paginas() {
        return this.num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(int calificacion) {
        if(calificacion>=1 && calificacion<=5){
           this.calificacion = calificacion;     
        }else{
            System.out.println("Calificacion incorrecta");
        }
        
    }

    public String toString() {
        return "Libro:\ntitulo=" + titulo +
                       "\n ISBN=" + ISBN + 
                       "\n autor=" + autor + 
                       "\n numero de páginas=" + num_paginas +
                       "\n calificacion=" + calificacion + "\n"+
                       "==================";
    }
     
     
     
    
}
