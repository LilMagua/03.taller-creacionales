public class ItemPedido {

    // Datos del producto incluido en el pedido.
    private String nombre;
    private double precioUnitario;
    private int cantidad;

    public ItemPedido(String nombre, double precioUnitario, int cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    // Devuelve el nombre del producto.
    public String getNombre() {
        return nombre;
    }

    // Devuelve el precio de una unidad.
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Devuelve la cantidad de unidades compradas.
    public int getCantidad() {
        return cantidad;
    }

    // Calcula el costo total de este producto segun su cantidad.
    public double getSubtotal() {
        return precioUnitario * cantidad;
    }
}