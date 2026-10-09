// aqui se esta implementando Factory Method porque esta clase decide
// que pasarela concreta utilizar para procesar el pago con tarjeta.

public class ProcesadorTarjeta extends ProcesadorPago {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PasarelaTarjeta();
    }
}