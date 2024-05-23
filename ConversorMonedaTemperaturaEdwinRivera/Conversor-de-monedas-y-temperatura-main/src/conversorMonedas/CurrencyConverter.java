package conversorMonedas;

import apiclient.ApiClient;
import org.json.JSONObject; // Importar la clase JSONObject de la biblioteca JSON
import java.io.IOException;

/**
 * La clase CurrencyConverter se encarga de convertir monedas utilizando datos obtenidos de una API.
 */
public class CurrencyConverter {

    private ApiClient apiClient; // Declarar una variable para almacenar el cliente de la API

    // Constructor que recibe un objeto ApiClient como argumento
    /**
     * Constructor que inicializa CurrencyConverter con el ApiClient especificado.
     * @param apiClient El ApiClient utilizado para obtener tasas de cambio.
     */
    public CurrencyConverter(ApiClient apiClient) {
        this.apiClient = apiClient; // Asignar el cliente de la API recibido al campo apiClient
    }
    /**
     * Convierte la cantidad especificada de una moneda a otra.
     *
     * @param amount La cantidad de dinero a convertir.
     * @param fromCurrency El código de la moneda origen.
     * @param toCurrency El código de la moneda destino.
     * @return La cantidad convertida.
     * @throws IOException Si ocurre una excepción de entrada o salida.
     */

    // Método para convertir una cantidad de una moneda a otra
    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        // Obtener los datos de cambio de la moneda de origen utilizando el cliente de la API
        String exchangeData = apiClient.getExchangeRate(fromCurrency);

        // Crear un objeto JSONObject para analizar los datos de la tasa de cambio
        JSONObject jsonObject = new JSONObject(exchangeData);

        // Obtener el objeto JSON que contiene las tasas de conversión
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");

        // Obtener la tasa de cambio de la moneda de origen a la moneda de destino
        double exchangeRate = rates.getDouble(toCurrency);

        // Calcular el monto convertido multiplicando la cantidad por la tasa de cambio
        //Calcular y devuelve la cantidad convertida
        return exchangeRate * amount;
    }
}