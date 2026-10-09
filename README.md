## Getting Started

Taller patrones creacionales
Singleton: Garantiza que exista un solo objeto de una clase.

Builder: Permite construir un objeto paso a paso.

Factory Method: Permite crear objetos sin decidir directamente qué clase concreta utilizar.

Prototype: Permite crear un objeto copiando otro existente.

## Folder Structure

Joshua David Riaño Vargas 20251020123, Javier Alexander Buitrago Torres 20252020086
Universidad Distrital Francisco Jose de Caldas

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).





// Un contador suelto, repetido en cada clase que necesita numerar algo
private static int contador = 0;

// Constructor con 8 parametros: ¿que significa cada uno? ¿cual es opcional?
Pedido p = new Pedido("PED-" + (++contador), "Ana Torres", "DOMICILIO",
        "Cra 7 # 45-10", items, "", 10, 3000);

// Cada medio de pago nuevo obliga a tocar este bloque
if (medioPago.equals("TARJETA")) {
    // cobrar con tarjeta ...
} else if (medioPago.equals("PSE")) {
    // cobrar con PSE ...
} else if (medioPago.equals("EFECTIVO")) {
    // cobrar en efectivo ...
}

Problema #1 El contador de pedidos, si necesita llamarse desde otro punto, podria fallar.
Problema #2 Un constructor con tantos parametros obliga al desarrollador a recordar el orden y obligatoriedad exactos
Problema #3 Si se añade un metodo de pago se debe tocar el codigo anterior (No respesta Solid ->  Open / Close)