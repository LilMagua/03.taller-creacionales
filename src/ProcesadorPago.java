// aqui se esta implementando Factory Method porque las clases hijas
// deciden que pasarela de pago crear.
// Sin este patron, esta clase tendria que elegir entre tarjeta, PSE o efectivo.

public abstract class ProcesadorPago {

    // Cada clase hija crea su propia pasarela de pago.
    protected abstract PasarelaPago crearPasarela();

    // Recibe el pedido, calcula su total y procesa el pago.
    public void procesar(Pedido pedido) {
        PasarelaPago pasarela = crearPasarela();
        double total = pedido.calcularTotal();

        System.out.println("\nProcesando pedido: " + pedido.getId());
        System.out.println("Medio de pago: " + pasarela.nombre());
        System.out.println("Valor a pagar: $" + total);

        // Se intenta cobrar el total mediante la pasarela seleccionada.
        boolean aprobado = pasarela.cobrar(total);

        if (aprobado) {
            System.out.println("Pago aprobado.");
        } else {
            System.out.println("Pago rechazado.");
        }
    }
}