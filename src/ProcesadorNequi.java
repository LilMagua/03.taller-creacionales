// aqui se esta implementando Factory Method porque esta clase decide
// crear la pasarela concreta para pagos con Nequi.

public class ProcesadorNequi extends ProcesadorPago {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PasarelaNequi();
    }
}