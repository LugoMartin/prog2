package biblioteca;

/**
 * Representa un libro del catálogo. Garantiza invariantes de dominio
 * en el constructor canónico y en las operaciones de modificación.
 */
public class Libro {

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;

    /**
     * Constructor canónico: único lugar con la validación completa de inicialización.
     */
    public Libro(String titulo, String autor, String isbn,
                 int copiasDisponibles, double precioReposicion) {
        if (estaEnBlanco(titulo)) {
            System.out.println("Título inválido, se usó \"Sin título\" por defecto.");
            this.titulo = "Sin título";
        } else {
            this.titulo = titulo;
        }

        if (estaEnBlanco(autor)) {
            System.out.println("Autor inválido, se usó \"Autor desconocido\" por defecto.");
            this.autor = "Autor desconocido";
        } else {
            this.autor = autor;
        }

        if (estaEnBlanco(isbn)) {
            System.out.println("ISBN inválido, se usó \"ISBN pendiente\" por defecto.");
            this.isbn = "ISBN pendiente";
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            System.out.println("Copias disponibles inválidas (" + copiasDisponibles
                    + "), se usó 0 por defecto.");
            this.copiasDisponibles = 0;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        if (precioReposicion <= 0) {
            System.out.println("Precio de reposición inválido ($" + precioReposicion
                    + "), se usó $15000.0 por defecto.");
            this.precioReposicion = 15000.0;
        } else {
            this.precioReposicion = precioReposicion;
        }
    }

    /**
     * Constructor de conveniencia para libros nuevos (1 copia, precio $15000.0).
     * Delega toda la validación al constructor canónico.
     */
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    /**
     * Equivalente a String.isBlank() (Java 11+) para compatibilidad con Java 8.
     */
    private static boolean estaEnBlanco(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    /**
     * Actualiza el precio solo si es mayor a 0.
     *
     * @return true si se aceptó el nuevo precio; false si se rechazó
     */
    public boolean setPrecioReposicion(double precio) {
        if (precio <= 0) {
            return false;
        }
        double precioAnterior = this.precioReposicion;
        this.precioReposicion = precio;
        System.out.println("Precio de reposición actualizado de \"" + titulo
                + "\": $" + precioAnterior + " -> $" + this.precioReposicion);
        return true;
    }

    public boolean prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo
                    + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        }
        System.out.println("Error: no hay copias disponibles de \"" + titulo
                + "\" para prestar.");
        return false;
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo
                + "\". Copias disponibles: " + copiasDisponibles);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("=======================");
    }
}
