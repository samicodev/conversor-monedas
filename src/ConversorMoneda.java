import java.util.Scanner;

public class ConversorMoneda {
    public void realizarConversion(Moneda origen, Moneda destino) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el valor que desea convertir [" + origen.getCodigo() + "]: ");
        double monto = entrada.nextDouble();

        try {
            double tasaCambio = TasaCambio.obtenerTasa(origen, destino);
            double montoConvertido = monto * tasaCambio;
            System.out.println("El valor de " + monto + " [" + origen.getCodigo() + "] corresponde a " + montoConvertido + " [" + destino.getCodigo() + "]");
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión. Por favor, inténtelo más tarde.");
            e.printStackTrace();
        }
    }
}
