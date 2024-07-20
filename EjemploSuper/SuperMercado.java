package EjemploSuper;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperMercado {
    private Map<String, Usuario> usuarios;
    private Map<String, Producto> productos;

    public SuperMercado() {
        usuarios = new HashMap<>();
        productos = new HashMap<>();
        cargarProductos();
    }

    public void registrarUser(String id, String nombre) {
        Usuario usuario = new Usuario(id, nombre);
        usuarios.put(id, usuario);
        System.out.println("Usuario creado :)");
    }

    public Usuario obtenerUsuario(String id) {
        return usuarios.get(id);
    }

    public Producto obtenerProducto(String nombre) {
        return productos.get(nombre);
    }

    private void cargarProductos() {
        productos.put("CocaCola", new Producto("CocaCola", 10.00));
        productos.put("Pan Bimbo", new Producto("Pan Bimbo", 15.00));
        productos.put("Cereal", new Producto("Cereal", 8.00));
    }

    public void mostrarCarritoPorUsuario(String userId) {
        Usuario usuario = obtenerUsuario(userId);
        if (usuario != null) {
            System.out.println("Carrito de compras de " + usuario.getNombre() + ":");
            usuario.getCarrito().mostarCarrito();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese su ID de usuario");
            String userId = scanner.nextLine();

            Usuario usuario = obtenerUsuario(userId);
            if (usuario == null) {
                System.out.println("Este usuario no está registrado, ingrese el nombre para el registro");
                String nombre = scanner.nextLine();
                registrarUser(userId, nombre);
                usuario = obtenerUsuario(userId);
            }

            CarritoCompra carrito = usuario.getCarrito();

            String option;

            do {
                System.out.println("---------MENÚ DE OPCIONES------ ");
                System.out.println("1. Agregar producto al carro");
                System.out.println("2. Mostrar carrito");
                System.out.println("3. Calcular el total a pagar");
                System.out.println("4. Volver al inicio");
                System.out.println("5. Buscar carrito por ID de usuario");
                option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.println("Ingresa el nombre del producto: ");
                        String nombreProducto = scanner.nextLine();
                        Producto producto = obtenerProducto(nombreProducto);
                        if (producto != null) {
                            carrito.agregarProducto(producto);
                            System.out.println("Producto agregado correctamente");
                        } else {
                            System.out.println("Producto no encontrado");
                        }
                        break;

                    case "2":
                        carrito.mostarCarrito();
                        break;

                    case "3":
                        double total = carrito.Total();
                        System.out.println("El total es: " + total);
                        break;

                    case "4":
                        System.out.println("Volviendo al inicio...");
                        break;

                    case "5":
                        System.out.println("Ingrese el ID del usuario para buscar su carrito:");
                        String buscarUserId = scanner.nextLine();
                        mostrarCarritoPorUsuario(buscarUserId);
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (!option.equals("4"));
        }
    }

    public static void main(String[] args) {
        SuperMercado superMercado = new SuperMercado();
        superMercado.ejecutar();

        
    }
}
