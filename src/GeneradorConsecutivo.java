public class GeneradorConsecutivo {
    private static GeneradorConsecutivo instancia;
    private int numeroPedido;
    private GeneradorConsecutivo() {
        // Constructor privado para evitar instanciación externa
    }

    public int generarNumeroPedido() {
        this.numeroPedido++;
        return numeroPedido;
    }
    
    // Método público para obtener la instancia única
    public static GeneradorConsecutivo obtenerInstancia() {
        if (instancia == null) {
            instancia = new GeneradorConsecutivo();
        }
        return instancia;
    }
}
