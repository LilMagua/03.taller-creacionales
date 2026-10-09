// aqui se implementa una pasarela concreta para simular pagos en efectivo.

public class PasarelaEfectivo implements PasarelaPago {

    @Override
    public String nombre() {
        return "Efectivo";
    }

    @Override
    public boolean cobrar(double monto) {
        // Se simula que el pago en efectivo siempre es aceptado.
        System.out.println("Pago en efectivo realizado.");
        return true;
    }
}