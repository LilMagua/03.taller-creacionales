// aqui se esta implementando Factory Method porque esta clase decide
// crear la pasarela concreta para pagos en efectivo.

public class ProcesadorEfectivo extends ProcesadorPago {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PasarelaEfectivo();
    }
}