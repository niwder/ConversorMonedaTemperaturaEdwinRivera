package apiclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * La clase ApiClient se encarga de realizar solicitudes HTTP a una API especificada.
 * Utiliza la ExchangeRate-API para obtener tasas de cambio entre diferentes monedas.
 */
public class ApiClient {
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;

    /**
     * Constructor que inicializa ApiClient con la clave de API especificada.
     *
     * @param apiKey La clave de API para acceder a la ExchangeRate-API.
     */
    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Realiza una solicitud GET a la ExchangeRate-API para obtener las tasas de cambio de una moneda base especificada.
     *
     * @param baseCurrency La moneda base para la cual obtener las tasas de cambio.
     * @return La respuesta de la API como una cadena de texto.
     * @throws IOException Si ocurre una excepción de entrada o salida.
     */
    public String getExchangeRate(String baseCurrency) throws IOException {
        // Construye la URL de la solicitud
        URL url = new URL(API_BASE_URL + this.apiKey + "/latest/" + baseCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Verifica el código de respuesta de la API
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            // Si la solicitud falla, lanza una excepción
            throw new IOException("Error al obtener datos de la API: " + responseCode);
        } else {
            // Si la solicitud es exitosa, lee la respuesta
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();

            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }

            scanner.close();
            return response.toString();
        }
    }
}