import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String id;
    private String cliente;
    private TipoEntrega tipoEntrega;
    private String direccion;
    private List<ItemPedido> items;
    private double propina;
    private double cupon;
    private String notas;

    private Pedido(Builder builder) {
        // aqui se esta implementando Singleton para obtener
        // un consecutivo unico para cada pedido creado.
        this.id = GeneradorConsecutivo.obtenerInstancia().siguiente();

        // Se copian los datos configurados en Builder.
        this.cliente = builder.cliente;
        this.tipoEntrega = builder.tipoEntrega;
        this.direccion = builder.direccion;
        this.items = new ArrayList<>(builder.items);
        this.propina = builder.propina;
        this.cupon = builder.cupon;
        this.notas = builder.notas;
    }

    // aqui se esta implementando Builder porque permite construir
    // un pedido por pasos y configurar sus datos opcionalmente.
    //
    // Sin Builder, el constructor tendria muchos parametros:
    // new Pedido(cliente, tipoEntrega, direccion, items, propina, cupon, notas);

    public static class Builder {

        private String cliente;
        private TipoEntrega tipoEntrega;
        private String direccion;
        private List<ItemPedido> items = new ArrayList<>();
        private double propina = 0;
        private double cupon = 0;
        private String notas;

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

        public Builder agregarItem(ItemPedido item) {
            if (item == null) {
                throw new IllegalStateException("El item no puede ser nulo");
            }

            items.add(item);
            return this;
        }

        public Builder conCupon(double cupon) {
            if (cupon < 0 || cupon > 100) {
                throw new IllegalStateException("El cupon debe estar entre 0 y 100");
            }

            this.cupon = cupon;
            return this;
        }

        public Builder conPropina(double propina) {
            if (propina < 0) {
                throw new IllegalStateException("La propina no puede ser negativa");
            }

            this.propina = propina;
            return this;
        }

        public Builder conNotas(String notas) {
            this.notas = notas;
            return this;
        }

        // Se validan los datos antes de crear el pedido.
        // Si algo falla, no se consume un numero de pedido.
        public Pedido construir() {
            // Si no se especifica el tipo de entrega, se utiliza RECOGER.
            if (tipoEntrega == null) {
                tipoEntrega = TipoEntrega.RECOGER;
            }
            
            if (cliente == null || cliente.trim().isEmpty()) {
                throw new IllegalStateException("El cliente es obligatorio");
            }

            if (tipoEntrega == null) {
                throw new IllegalStateException("El tipo de entrega es obligatorio");
            }

            if (tipoEntrega == TipoEntrega.DOMICILIO &&
                (direccion == null || direccion.trim().isEmpty())) {
                throw new IllegalStateException("La direccion es obligatoria para domicilio");
            }

            if (items.isEmpty()) {
                throw new IllegalStateException("El pedido debe tener al menos un item");
            }

            return new Pedido(this);
        }
    }

    public String getId() {
        return id;
    }

    // Permite consultar la lista de productos del pedido.
    public List<ItemPedido> getItems() {
        return new ArrayList<>(items);
    }

    public double calcularTotal() {
        double subtotal = 0;

        // Se suman los subtotales de todos los productos.
        for (ItemPedido item : items) {
            subtotal += item.getSubtotal();
        }

        // Se aplica el cupon y despues se suma la propina.
        double total = subtotal - (subtotal * cupon / 100) + propina;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    // aqui se esta implementando Prototype porque permite crear
    // una copia de un pedido existente sin configurarlo desde cero.
    //
    // La copia recibe un nuevo ID para no repetir el consecutivo.
    public Pedido clonar() {
        Builder copia = new Builder()
                .conCliente(this.cliente)
                .conTipoEntrega(this.tipoEntrega)
                .conDireccion(this.direccion)
                .conCupon(this.cupon)
                .conPropina(this.propina)
                .conNotas(this.notas);

        // Se copian los productos al nuevo pedido.
        for (ItemPedido item : this.items) {
            copia.agregarItem(item);
        }

        // Sin Prototype, habria que volver a configurar cada dato:
        // Pedido copia = new Pedido.Builder()
        //     .conCliente(cliente).conTipoEntrega(tipoEntrega)...
        return copia.construir();
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DEL PEDIDO ---");
        System.out.println("Pedido: " + id);
        System.out.println("Cliente: " + cliente);
        System.out.println("Entrega: " + tipoEntrega);

        if (tipoEntrega == TipoEntrega.DOMICILIO) {
            System.out.println("Direccion: " + direccion);
        }

        System.out.println("Items:");

        for (ItemPedido item : items) {
            System.out.println("- " + item.getNombre() + " x" +
                item.getCantidad() + " = $" + item.getSubtotal());
        }

        if (notas != null && !notas.trim().isEmpty()) {
            System.out.println("Notas: " + notas);
        }

        System.out.println("Cupon: " + cupon + "%");
        System.out.println("Propina: $" + propina);
        System.out.println("Total: $" + calcularTotal());
    }
}