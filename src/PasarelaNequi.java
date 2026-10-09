// aqui se implementa una pasarela concreta para simular pagos con Nequi.

public class PasarelaNequi implements PasarelaPago {

    @Override
    public String nombre() {
        return "Nequi";
    }

    @Override
    public boolean cobrar(double monto) {
        // Se simula que Nequi aprueba el pago.
        System.out.println("Pago por Nequi realizado.");
        return true;
    }
}