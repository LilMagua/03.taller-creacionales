// aqui se implementa una pasarela concreta para simular pagos con tarjeta.

public class PasarelaTarjeta implements PasarelaPago {

    @Override
    public String nombre() {
        return "Tarjeta";
    }

    @Override
    public boolean cobrar(double monto) {
        // Se simula un limite maximo de pago con tarjeta.
        if (monto > 500000) {
            System.out.println("La tarjeta supera el limite permitido.");
            return false;
        } else {
            System.out.println("Cobro con tarjeta realizado.");
            return true;
        }
    }
}