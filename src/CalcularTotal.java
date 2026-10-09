public class CalcularTotal {
    public static double calcularTotal(Pedido pedido){
        double total = 0.0;
        for (ItemPedido item : pedido.getItems()) {
            total += item.getSubtotal();
        }
        total -= total * pedido.getCuponDescuento()/100;
        total += pedido.getPropina();
        return total;
    }
}
