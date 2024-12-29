import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TasaCambio {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/TU_API_KEY_AQUI/latest/";

    public static double obtenerTasa(Moneda origen, Moneda destino) throws Exception {
        String url = URL_API + origen.getCodigo();

        // Crear cliente HTTP
        HttpClient clienteHttp = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(new java.net.URI(url)).build();

        // Enviar solicitud y obtener respuesta
        HttpResponse<String> respuesta = clienteHttp.send(solicitud, HttpResponse.BodyHandlers.ofString());
        String cuerpoRespuesta = respuesta.body();

        // Parsear JSON para obtener tasa de cambio
        JsonObject objetoJson = JsonParser.parseString(cuerpoRespuesta).getAsJsonObject();
        JsonObject tasasConversion = objetoJson.getAsJsonObject("conversion_rates");
        return tasasConversion.get(destino.getCodigo()).getAsDouble();
    }
}
