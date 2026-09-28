package gestioninventario;

/**
 * Representa un producto del inventario con operaciones de venta,
 * reposición, actualización de precio y descuentos.
 */
public class Producto {

    public String nombre;
    public String codigo;
    public double precio;
    public int stock;

    /**
     * Vende unidades del producto si la cantidad es válida y hay stock suficiente.
     *
     * @param cantidad cantidad de unidades a vender
     */
    public void venderUnidades(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: cantidad inválida (" + cantidad
                    + "). Debe ser mayor a 0 para vender " + nombre + ".");
            return;
        }
        if (cantidad > stock) {
            System.out.println("Error: stock insuficiente para vender " + cantidad
                    + " unidades de " + nombre + ".");
            return;
        }
        stock -= cantidad;
        System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre
                + ". Stock restante: " + stock);
    }

    /**
     * Repone stock del producto si la cantidad es mayor a 0.
     *
     * @param cantidad unidades a sumar al stock
     */
    public void reponerStock(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: cantidad inválida (" + cantidad
                    + "). Debe ser mayor a 0 para reponer stock de " + nombre + ".");
            return;
        }
        stock += cantidad;
        System.out.println("Reposición registrada: +" + cantidad
                + " unidades. Stock actual: " + stock);
    }

    /**
     * Actualiza el precio del producto. El parámetro sombrea al atributo;
     * se usa this.precio para distinguirlos.
     *
     * @param precio nuevo precio del producto
     */
    public void actualizarPrecio(double precio) {
        double precioAnterior = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de " + nombre + ": $" + precioAnterior
                + " -> $" + this.precio);
    }

    /**
     * Imprime la ficha del producto con formato estructurado.
     */
    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
        System.out.println("========================");
    }

    /**
     * Aplica un descuento porcentual al precio.
     * El porcentaje debe estar entre 0 y 100 inclusive.
     *
     * @param porcentaje porcentaje de descuento a aplicar
     */
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            System.out.println("Error: el porcentaje de descuento (" + porcentaje
                    + ") debe estar entre 0 y 100.");
            return;
        }
        double precioAnterior = this.precio;
        this.precio = this.precio * (1 - porcentaje / 100.0);
        System.out.println("Descuento del " + porcentaje + "% aplicado a " + nombre
                + ": $" + precioAnterior + " -> $" + this.precio);
    }
}
