package gestioninventario;

/**
 * Clase principal de prueba del sistema de inventario.
 * Demuestra independencia de objetos, casos válidos/error y aliasing.
 */
public class MainInventario {

    public static void main(String[] args) {
        // 1) Tres productos distintos: cada new reserva su propio espacio en el Heap
        Producto productoUno = new Producto();
        productoUno.codigo = "P-001";
        productoUno.nombre = "Teclado mecánico";
        productoUno.precio = 45000.0;
        productoUno.stock = 12;

        Producto productoDos = new Producto();
        productoDos.codigo = "P-002";
        productoDos.nombre = "Mouse inalámbrico";
        productoDos.precio = 18500.0;
        productoDos.stock = 30;

        Producto productoTres = new Producto();
        productoTres.codigo = "P-003";
        productoTres.nombre = "Monitor 24\"";
        productoTres.precio = 120000.0;
        productoTres.stock = 8;

        System.out.println("--- Fichas iniciales ---");
        productoUno.mostrarFicha();
        productoDos.mostrarFicha();
        productoTres.mostrarFicha();

        // 2) Modificar un objeto no afecta a los demás
        System.out.println("\n--- Independencia de objetos (Heap) ---");
        System.out.println("Stock productoDos antes: " + productoDos.stock);
        System.out.println("Stock productoTres antes: " + productoTres.stock);

        // 3) Casos de uso válidos
        System.out.println("\n--- Casos válidos ---");
        productoUno.venderUnidades(3);
        productoUno.reponerStock(20);
        productoUno.actualizarPrecio(39900.0);
        productoDos.venderUnidades(5);
        productoTres.aplicarDescuento(10);

        System.out.println("Stock productoDos tras venta propia (productoUno no lo alteró): "
                + productoDos.stock);
        System.out.println("Stock productoTres sin cambios de venta: " + productoTres.stock);

        // 3) Casos de error
        System.out.println("\n--- Casos de error ---");
        productoUno.venderUnidades(50);
        productoUno.venderUnidades(0);
        productoUno.venderUnidades(-2);
        productoDos.reponerStock(0);
        productoDos.reponerStock(-5);
        productoTres.aplicarDescuento(-10);
        productoTres.aplicarDescuento(150);

        // 4) Aliasing: dos variables apuntan al mismo objeto en el Heap
        System.out.println("\n--- Demostración de Aliasing ---");
        Producto copia = productoUno; // no es un objeto nuevo: misma referencia
        productoUno.stock = 15; // valor distinto solo para evidenciar el cambio vía alias
        System.out.println("Stock de productoUno antes: " + productoUno.stock);
        copia.stock = 29; // modifica el único objeto; productoUno ve el mismo cambio
        System.out.println("Stock de productoUno tras modificar copia: "
                + productoUno.stock + " (mismo objeto en el Heap)");

        // 5) Desafío: arreglo de Producto + for + mostrarFicha()
        System.out.println("\n--- Recorrido del arreglo de productos ---");
        Producto[] catalogo = {productoUno, productoDos, productoTres};
        for (int i = 0; i < catalogo.length; i++) {
            catalogo[i].mostrarFicha();
        }
    }
}
