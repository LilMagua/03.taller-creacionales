import java.util.ArrayList;
public class Pedido {
    private String cliente;
    private TipoEntrega tipoEntrega;
    private String direccion;
    private int cuponDescuento;
    private int propina;
    private ArrayList<ItemPedido> items;
    private String notas;
    private int numeroPedido;
    private double total;

    private Pedido(Builder builder) {
        this.cliente = builder.cliente;
        this.tipoEntrega = builder.tipoEntrega;
        this.direccion = builder.direccion;
        this.cuponDescuento = builder.cuponDescuento;
        this.propina = builder.propina;
        this.notas = builder.notas;
        this.items = builder.items;
        this.numeroPedido = GeneradorConsecutivo.obtenerInstancia().generarNumeroPedido();
        this.total = CalcularTotal.calcularTotal(this);
    }
    public void mostrarResumen() {
            System.out.println("");
            System.out.println("PED-" + numeroPedido);
            System.out.println("=== Resumen del pedido ===");
            System.out.println("Cliente: " + cliente);
            System.out.println("Tipo de entrega: " + tipoEntrega + (tipoEntrega == TipoEntrega.DOMICILIO ? " (Dirección: " + direccion + ")" : ""));
            System.out.println("Items del pedido:");
            for (ItemPedido item : items) {
                System.out.println("- " + item.getCantidad() + "x " + item.getNombre() + " ($" + item.getSubtotal() + ")");
            }
            System.out.println("Notas adicionales: " + (notas != null ? notas : "Ninguna"));
            System.out.println("Cupón de descuento: " + cuponDescuento+"%");
            System.out.println("Propina: " + propina);
            System.out.println("Total a pagar: $" + total);

            System.out.println(" ");

    }

    // Getters para calcular el total del pedido
    public double getCuponDescuento() {
        return cuponDescuento;
    }
    public double getPropina() {
        return propina;
    }
    public ArrayList<ItemPedido> getItems() {
        return items;
    }

//Creamos una clase interna estática Builder para construir objetos Pedido
public static class Builder {
        private String cliente;
        private TipoEntrega tipoEntrega;
        private String direccion;
        private int cuponDescuento;
        private int propina;
        private String notas;
        private ArrayList<ItemPedido> items = new ArrayList<>();

    public Builder conCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public Builder conTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
        return this;
    }

    public Builder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Builder conCupon(int cuponDescuento) {
        this.cuponDescuento = cuponDescuento;
        return this;
    }

    public Builder conPropina(int propina) {
        this.propina = propina;
        return this;
    }

    public Builder agregarItem(ItemPedido item) {
        this.items.add(item);
        return this;
    }
    public Builder conNotas(String notas) {
        this.notas = notas;
        return this;
    }

    public Pedido construir(){

        //Comprobaciones para validar que el pedido es valido
        if (cliente == null || cliente.isEmpty()) {
            throw new IllegalStateException("El cliente es obligatorio.");
        }
        if (tipoEntrega == null) {
            this.tipoEntrega = TipoEntrega.RECOGER; // Valor por defecto si no se especifica
        }
        if (tipoEntrega == TipoEntrega.DOMICILIO && (direccion == null || direccion.isEmpty())) {
            throw new IllegalStateException("La dirección es obligatoria para entrega a domicilio.");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalStateException("Debe haber al menos un item en el pedido.");
        }
        return new Pedido(this);
    }
}
}
