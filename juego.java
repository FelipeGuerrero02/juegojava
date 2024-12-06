import java.util.Scanner;
import java.util.Random;
@SuppressWarnings("unused")

class Personaje {
    String nombre;
    int vida;
    int fuerza;
    int defensa;
    int energia;

    public Personaje(String nombre, int vida, int fuerza, int defensa, int energia) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.energia = energia;
    }

    public void atacar(Personaje objetivo) {
        int danio = this.fuerza - objetivo.defensa;
        if (danio > 0) {
            objetivo.recibirDanio(danio);
            System.out.println(this.nombre + " ataca a " + objetivo.nombre + " y le hace " + danio + " de daño.");
        } else {
            System.out.println(this.nombre + " ataca a " + objetivo.nombre + " pero no hace daño.");
        }
    }

    public void recibirDanio(int danio) {
        this.vida -= danio;
        if (this.vida < 0) this.vida = 0;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        System.out.println(this.nombre + " intenta usar su habilidad especial: " + habilidad);
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
            }
        }
    }
}

class Heroe extends Personaje {
    public Heroe(String nombre, int vida, int fuerza, int defensa, int energia) {
        super(nombre, vida, fuerza, defensa, energia);
    }

    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        if (habilidad.equals("Golpe Divino")) {
            if (this.energia >= 30) {
                this.energia -= 30;
                int danio = (this.fuerza * 3) - objetivo.defensa;
                if (danio > 0) {
                    objetivo.recibirDanio(danio);
                    System.out.println(this.nombre + " usa su habilidad especial 'Golpe Divino' y le hace " + danio + " de daño a " + objetivo.nombre + ".");
                } else {
                    System.out.println(this.nombre + " usa su habilidad especial, pero no hace daño.");
                }
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Golpe Divino'.");
            }
        } else if (habilidad.equals("Escudo Protector")) {
            if (this.energia >= 20) {
                this.energia -= 20;
                this.defensa += 10;
                System.out.println(this.nombre + " usa su habilidad especial 'Escudo Protector'. La defensa de " + this.nombre + " ha aumentado.");
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Escudo Protector'.");
            }
        } else {
            super.usarHabilidadEspecial(objetivo, habilidad);
        }
    }
}

class Villano extends Personaje {
    public Villano(String nombre, int vida, int fuerza, int defensa, int energia) {
        super(nombre, vida, fuerza, defensa, energia);
    }

    public void usarHabilidadEspecial(Personaje objetivo, String habilidad) {
        if (habilidad.equals("Llama Infernal")) {
            if (this.energia >= 20) {
                this.energia -= 20;
                int danio = (this.fuerza * 2) - objetivo.defensa;
                if (danio > 0) {
                    objetivo.recibirDanio(danio);
                    System.out.println(this.nombre + " usa su habilidad especial 'Llama Infernal' y le hace " + danio + " de daño a " + objetivo.nombre + ".");
                } else {
                    System.out.println(this.nombre + " usa su habilidad especial, pero no hace daño.");
                }
            } else {
                System.out.println(this.nombre + " no tiene suficiente energía para usar 'Llama Infernal'.");
            }
        } else if (habilidad.equals("Tormenta Oscura")) {
            if (this.energia >= 25) {
                this.energia -= 25;
                int danio = (this.fuerza * 2) - objetivo.defensa;
                if (danio > 0) {
                    objetivo.recibirDanio(danio);
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

public class juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre del héroe: ");
        String nombreHeroe = scanner.nextLine();
        Heroe heroe = new Heroe(nombreHeroe, 100, 20, 5, 100);

        System.out.print("Ingresa el nombre del villano: ");
        String nombreVillano = scanner.nextLine();
        Villano villano = new Villano(nombreVillano, 100, 20, 5, 100);

        while (heroe.estaVivo() && villano.estaVivo()) {
            System.out.println("\nTurno del héroe:");
            System.out.println("1. Ataque normal");
            System.out.println("2. 'Golpe Divino' (habilidad especial)");
            System.out.println("3. 'Escudo Protector' (habilidad especial)");
            System.out.print("Elige una acción: ");
            int opcion = Personaje.leerEntero(scanner, "");

            switch (opcion) {
                case 1:
                    heroe.atacar(villano);
                    break;
                case 2:
                    heroe.usarHabilidadEspecial(villano, "Golpe Divino");
                    break;
                case 3:
                    heroe.usarHabilidadEspecial(villano, "Escudo Protector");
                    break;
                default:
                    System.out.println("Opción no válida. Ataque normal por defecto.");
                    heroe.atacar(villano);
                    break;
            }

            System.out.println(villano.nombre + " tiene " + villano.vida + " de vida.");

            if (villano.estaVivo()) {
                System.out.println("\nTurno del villano:");
                System.out.println("1. Ataque normal");
                System.out.println("2. 'Llama Infernal' (habilidad especial)");
                System.out.println("3. 'Tormenta Oscura' (habilidad especial)");
                System.out.print("Elige una acción: ");
                opcion = Personaje.leerEntero(scanner, "");

                switch (opcion) {
                    case 1:
                        villano.atacar(heroe);
                        break;
                    case 2:
                        villano.usarHabilidadEspecial(heroe, "Llama Infernal");
                        break;
                    case 3:
                        villano.usarHabilidadEspecial(heroe, "Tormenta Oscura");
                        break;
                    default:
                        System.out.println("Opción no válida. Ataque normal por defecto.");
                        villano.atacar(heroe);
                        break;
                }

                System.out.println(heroe.nombre + " tiene " + heroe.vida + " de vida.");
            }
        }

        if (heroe.estaVivo()) {
            System.out.println(heroe.nombre + " ha ganado!");
        } else {
            System.out.println(villano.nombre + " ha ganado!");
        }

        scanner.close();
    }
}
