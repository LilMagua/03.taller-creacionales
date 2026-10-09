public class CalcularTotal {

    // Calcula el subtotal sumando el precio de cada producto
    // multiplicado por su cantidad.
    public static double subtotal(Pedido pedido) {
        double total = 0;

        for (ItemPedido item : pedido.getItems()) {
            total += item.getSubtotal();
        }

        return total;
    }
}