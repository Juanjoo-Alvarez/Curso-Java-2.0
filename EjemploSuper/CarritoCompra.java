package EjemploSuper;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private List<Producto> productos;

    public CarritoCompra(){
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void mostarCarrito(){
        System.out.println("Tus productos :)");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public double Total(){
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }


}
