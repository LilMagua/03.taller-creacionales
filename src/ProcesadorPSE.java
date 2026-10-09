// aqui se esta implementando Factory Method porque esta clase decide
// crear la pasarela de pago PSE.

public class ProcesadorPSE extends ProcesadorPago {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PasarelaPSE();
    }
}