public interface PasarelaPago {

    // Devuelve el nombre del medio de pago.
    String nombre();

    // Simula el cobro y devuelve true si el pago es aprobado.
    boolean cobrar(double monto);
}