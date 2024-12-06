import java.util.Scanner; // Importa la clase Scanner para permitir la entrada de datos del usuario
import java.util.Random; // Para generar números aleatorios
@SuppressWarnings("unused")

class Personaje { // Clase base que representa a un personaje
    String nombre; // Atributo para almacenar el nombre del personaje
    int vida; // Atributo para almacenar la vida del personaje
    int fuerza; // Atributo para almacenar la fuerza del personaje
    int defensa; // Atributo para almacenar la defensa del personaje
    int energia; // Nueva estadística para energía, utilizada para poderes especiales

    public Personaje(String nombre, int vida, int fuerza, int defensa, int energia) { // Constructor de la clase Personaje
        this.nombre = nombre; // Asigna el nombre al atributo
        this.vida = vida; // Asigna la vida al atributo
        this.fuerza = fuerza; // Asigna la fuerza al atributo
        this.defensa = defensa; // Asigna la defensa al atributo
        this.energia = energia; // Asigna la energía al atributo
    }

    public void atacar(Personaje objetivo) { // Método para atacar a otro personaje
        int danio = this.fuerza - objetivo.defensa; // Calcula el daño considerando la defensa del objetivo
        if (danio > 0) { // Si el daño es mayor que 0
            objetivo.recibirDanio(danio); // Llama al método para que el objetivo reciba daño
            System.out.println(this.nombre + " ataca a " + objetivo.nombre + " y le hace " + danio + " de daño."); // Muestra el resultado del ataque
        } else {
            System.out.println(this.nombre + " ataca a " + objetivo.nombre + " pero no hace daño."); // Muestra que no se hizo daño
        }
    }

    public void recibirDanio(int danio) { // Método para recibir daño
        this.vida -= danio; // Resta el daño a la vida del personaje
        if (this.vida < 0) this.vida = 0; // Si la vida es menor que 0, se establece en 0
    }

    public boolean estaVivo() { // Método para verificar si el personaje está vivo
        return this.vida > 0; // Devuelve true si la vida es mayor que 0
    }

    // Método para usar una habilidad especial (genérica)
    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        System.out.println(this.nombre + " intenta usar su habilidad especial: " + habilidad);
    }

    // Método para validar la entrada del usuario
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine()); // Intenta leer un número entero
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
            }
        }
    }
}

class Heroe extends Personaje { // Clase Heroe que hereda de Personaje
    public Heroe(String nombre, int vida, int fuerza, int defensa, int energia) { // Constructor de la clase Heroe
        super(nombre, vida, fuerza, defensa, energia); // Llama al constructor de la clase base
    }

    // Habilidad especial de héroe
    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        if (habilidad.equals("Golpe Divino")) {
            if (this.energia >= 30) {
                this.energia -= 30; // Gasta energía
                int danio = (this.fuerza * 3) - objetivo.defensa; // Aumenta el daño
                if (danio > 0) {
                    objetivo.recibirDanio(danio); // Llama al método para que el objetivo reciba daño
                    System.out.println(this.nombre + " usa su habilidad especial 'Golpe Divino' y le hace " + danio + " de daño a " + objetivo.nombre + ".");
                } else {
                    System.out.println(this.nombre + " usa su habilidad especial, pero no hace daño.");
                }
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Golpe Divino'.");
            }
        } else if (habilidad.equals("Escudo Protector")) {
            if (this.energia >= 20) {
                this.energia -= 20; // Gasta energía
                this.defensa += 10; // Aumenta la defensa temporalmente
                System.out.println(this.nombre + " usa su habilidad especial 'Escudo Protector'. La defensa de " + this.nombre + " ha aumentado.");
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Escudo Protector'.");
            }
        } else {
            super.usarHabilidadEspecial(objetivo, habilidad);
        }
    }
}

class Villano extends Personaje { // Clase Villano que hereda de Personaje
    public Villano(String nombre, int vida, int fuerza, int defensa, int energia) { // Constructor de la clase Villano
        super(nombre, vida, fuerza, defensa, energia); // Llama al constructor de la clase base
    }

    // Habilidad especial del villano
    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        if (habilidad.equals("Llama Infernal")) {
            if (this.energia >= 20) {
                this.energia -= 20; // Gasta energía
                int danio = (this.fuerza * 2) - objetivo.defensa; // Aumenta el daño
                if (danio > 0) {
                    objetivo.recibirDanio(danio); // Llama al método para que el objetivo reciba daño
                    System.out.println(this.nombre + " usa su habilidad especial 'Llama Infernal' y le hace " + danio + " de daño a " + objetivo.nombre + ".");
                } else {
                    System.out.println(this.nombre + " usa su habilidad especial, pero no hace daño.");
                }
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Llama Infernal'.");
            }
        } else if (habilidad.equals("Tormenta Oscura")) {
            if (this.energia >= 25) {
                this.energia -= 25; // Gasta energía
                int danio = (this.fuerza * 2) - objetivo.defensa; // Aumenta el daño
                if (danio > 0) {
                    objetivo.recibirDanio(danio); // Llama al método para que el objetivo reciba daño
                    System.out.println(this.nombre + " usa su habilidad especial 'Tormenta Oscura' y le hace " + danio + " de daño a " + objetivo.nombre + ".");
                } else {
                    System.out.println(this.nombre + " usa su habilidad especial, pero no hace daño.");
                }
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Tormenta Oscura'.");
            }
        } else {
            super.usarHabilidadEspecial(objetivo, habilidad);
        }
    }
}

public class juego { // Clase principal del juego
    public static void main(String[] args) { // Método principal que inicia la ejecución del programa
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

        // Pedir nombre del héroe
        System.out.print("Ingresa el nombre del héroe: ");
        String nombreHeroe = scanner.nextLine(); // Lee el nombre del héroe
        Heroe heroe = new Heroe(nombreHeroe, 100, 20, 5, 100); // Crea un objeto Heroe con nombre, vida, fuerza, defensa y energía

        // Pedir nombre del villano
        System.out.print("Ingresa el nombre del villano: ");
        String nombreVillano = scanner.nextLine(); // Lee el nombre del villano
        Villano villano = new Villano(nombreVillano, 100, 20, 5, 100); // Crea un objeto Villano con nombre, vida, fuerza, defensa y energía

        // Bucle de combate
        while (heroe.estaVivo() && villano.estaVivo()) { // Bucle que continúa mientras ambos personajes estén vivos
            System.out.println("\nTurno del héroe:");
            System.out.println("1. Ataque normal");
            System.out.println("2. 'Golpe Divino' (habilidad especial)");
            System.out.println("3. 'Escudo Protector' (habilidad especial)");
            System.out.print("Elige una acción: ");
            int opcion = Personaje.leerEntero(scanner, "");

            switch (opcion) { // Usamos un switch para una mejor gestión de las opciones
                case 1:
                    heroe.atacar(villano); // El héroe ataca al villano
                    break;
                case 2:
                    heroe.usarHabilidadEspecial(villano, "Golpe Divino"); // El héroe usa su habilidad especial 'Golpe Divino'
                    break;
                case 3:
                    heroe.usarHabilidadEspecial(villano, "Escudo Protector"); // El héroe usa su habilidad especial 'Escudo Protector'
                    break;
                default:
                    System.out.println("Opción no válida. Ataque normal por defecto.");
                    heroe.atacar(villano); // El héroe ataca por defecto
                    break;
            }

            System.out.println(villano.nombre + " tiene " + villano.vida + " de vida.");

            if (villano.estaVivo()) { // Si el villano sigue vivo
                System.out.println("\nTurno del villano:");
                System.out.println("1. Ataque normal");
                System.out.println("2. 'Llama Infernal' (habilidad especial)");
                System.out.println("3. 'Tormenta Oscura' (habilidad especial)");
                System.out.print("Elige una acción: ");
                opcion = Personaje.leerEntero(scanner, "");

                switch (opcion) { // Usamos un switch para la selección de acción
                    case 1:
                        villano.atacar(heroe); // El villano ataca al héroe
                        break;
                    case 2:
                        villano.usarHabilidadEspecial(heroe, "Llama Infernal"); // El villano usa su habilidad especial 'Llama Infernal'
                        break;
                    case 3:
                        villano.usarHabilidadEspecial(heroe, "Tormenta Oscura"); // El villano usa su habilidad especial 'Tormenta Oscura'
                        break;
                    default:
                        System.out.println("Opción no válida. Ataque normal por defecto.");
                        villano.atacar(heroe); // El villano ataca por defecto
                        break;
                }

                System.out.println(heroe.nombre + " tiene " + heroe.vida + " de vida.");
            }
        }

        // Determinar el ganador
        if (heroe.estaVivo()) {
            System.out.println(heroe.nombre + " ha ganado!");
        } else {
            System.out.println(villano.nombre + " ha ganado!");
        }

        scanner.close(); // Cierra el objeto Scanner
    }
}