package EjemploSuper;

public class Usuario {
    
    private String id;
    private String nombre;
    private CarritoCompra carrito;

    public Usuario(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.carrito = new CarritoCompra();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + "]";
    }

    

}
