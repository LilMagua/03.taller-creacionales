// aqui se implementa una pasarela concreta para simular pagos por PSE.

public class PasarelaPSE implements PasarelaPago {

    @Override
    public String nombre() {
        return "PSE";
    }

    @Override
    public boolean cobrar(double monto) {
        // Se simula que PSE aprueba el pago.
        System.out.println("Pago por PSE realizado.");
        return true;
    }
}