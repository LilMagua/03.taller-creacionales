public class GeneradorConsecutivo {

    // aqui se esta implementando Singleton porque solo debe existir
    // una instancia que controle los consecutivos.
    private static GeneradorConsecutivo instancia;
    private int numeroPedido = 0;

    private GeneradorConsecutivo() {
        System.out.println("[Consecutivo] Instancia creada.");
    }

    // Devuelve la instancia existente o crea una si no existe.
    // Sin Singleton: GeneradorConsecutivo g = new GeneradorConsecutivo();
    // Cada objeto tendria su propio contador.
    public static GeneradorConsecutivo obtenerInstancia() {
        if (instancia == null) {
            instancia = new GeneradorConsecutivo();
        }
        return instancia;
    }

    // Aumenta el contador y genera un codigo como PED-0001.
    public String siguiente() {
        numeroPedido++;
        return String.format("PED-%04d", numeroPedido);
    }
}