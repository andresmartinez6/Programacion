
package Principal;

import tienda.poo.Producto;


public class Main {

    
    public static void main(String[] args) {
        
    // Crear un objeto Producto
    Producto producto = new Producto(1, 10, 0, "Producto 1", "Fabricante 1", 100.0, 50.0, 'A');
        
    // Mostrar información del producto
        System.out.println(producto.toString());
        
    // Vender unidades del producto
        producto.venderStock(5);
        
    // Subir el precio del producto
        producto.subirPrecioProd(10.0);
        
    // Bajar el precio del producto
        producto.bajarPrecioProd(80.0);
        
    // Cambiar la categoría del producto
        producto.modificarCategoria('D');
        
    // Reponer el stock del producto
        producto.reponerStock(20);
        
    // Actualizar el coste unitario del producto
        producto.actualizarCosteUnitario(60.0);
        
    // Calcular el beneficio obtenido del producto
    double beneficio = producto.beneficioObtenido();
        System.out.println("Beneficio obtenido: " + beneficio);
    }
}

        