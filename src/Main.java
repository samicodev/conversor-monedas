import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();
        int opcion;

        System.out.println("********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda");

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("********************************************");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    conversor.realizarConversion(new Moneda("USD"), new Moneda("ARS"));
                    break;
                case 2:
                    conversor.realizarConversion(new Moneda("ARS"), new Moneda("USD"));
                    break;
                case 3:
                    conversor.realizarConversion(new Moneda("USD"), new Moneda("BRL"));
                    break;
                case 4:
                    conversor.realizarConversion(new Moneda("BRL"), new Moneda("USD"));
                    break;
                case 5:
                    conversor.realizarConversion(new Moneda("USD"), new Moneda("COP"));
                    break;
                case 6:
                    conversor.realizarConversion(new Moneda("COP"), new Moneda("USD"));
                    break;
                case 7:
                    System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
                    break;
            }

        } while (opcion != 7);

        entrada.close();
    }
}
