package biblioteca;

/**
 * Pruebas del catálogo de biblioteca: constructores, validaciones,
 * préstamos y fichas. Demuestra que no quedan datos basura en los objetos.
 */
public class MainBiblioteca {

    public static void main(String[] args) {
        // new Libro(); // no compila: al definir constructores propios,
        // el compilador ya no genera el constructor sin argumentos por defecto.

        // Instanciación con constructor de conveniencia y canónico
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro(
                "Efectivo con Java",
                "Ana Restrepo",
                "9781234567897",
                3,
                22000.0
        );
        Libro libro3 = new Libro(
                "Cien Años de Soledad",
                "Gabriel García Márquez",
                "9780307474728",
                2,
                18500.0
        );

        // Validaciones y rechazos en construcción
        System.out.println("--- Validación al crear ---");
        Libro libroInvalido = new Libro("   ", "Ana Restrepo", "9780000000000", 1, 15000.0);
        System.out.println("getTitulo() del libro inválido: \"" + libroInvalido.getTitulo() + "\"");

        // Rechazo de precio inválido vía setter
        System.out.println("\n--- Validación de setPrecioReposicion ---");
        double precioAntes = libro1.getPrecioReposicion();
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado
                + " (se mantiene el precio anterior)");
        System.out.println("Precio conservado: $" + libro1.getPrecioReposicion()
                + " (antes era $" + precioAntes + ")");

        // Fichas de los tres libros del catálogo
        System.out.println("\n--- Fichas ---");
        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        // Ciclo de préstamos hasta agotar copias
        System.out.println("\n--- Préstamos y devolución ---");
        while (libro1.prestar()) {
            // presta hasta que no queden copias
        }
        System.out.println("Copias tras agotar préstamos (no negativo): "
                + libro1.getCopiasDisponibles());
        libro1.devolver();

        // Actualización válida de precio
        System.out.println("\n--- Actualización válida de precio ---");
        libro1.setPrecioReposicion(18000.0);
    }
}
