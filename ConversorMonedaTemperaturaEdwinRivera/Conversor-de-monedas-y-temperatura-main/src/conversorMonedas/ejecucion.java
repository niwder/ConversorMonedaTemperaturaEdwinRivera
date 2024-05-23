package conversorMonedas;

import apiclient.ApiClient;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * La clase ejecucion es responsable de gestionar las conversiones de moneda utilizando la clase CurrencyConverter.
 */
public class ejecucion {
	// Instancia de CurrencyConverter con un ApiClient configurado con la clave de API
	CurrencyConverter currencyConverter = new CurrencyConverter(new ApiClient("819327f5989b2c83f3840935"));

	/**
	 * Método que maneja la lógica para convertir una cantidad de dinero entre diferentes monedas.
	 *
	 * @param cantidad La cantidad de dinero a convertir.
	 */
	public void CurrencyConverter(double cantidad) {
		// Mostrar el menú de opciones de conversión de moneda
		String opcion = (JOptionPane.showInputDialog(null,
				"Elije la moneda a la que deseas convertir tu dinero ", "Monedas",
				JOptionPane.PLAIN_MESSAGE, null, new Object[]{
						"1. Dólar a Peso Argentino",
						"2. Peso Argentino a Dólar",
						"3. Dólar a Real Brasileño",
						"4. Real Brasileño a Dólar",
						"5. Dólar a Peso Colombiano",
						"6. Peso Colombiano a Dólar",
						"7. Dólar a Peso Dominicano",
						"8. Peso Dominicano a Dólar",
						"9. Salir"},
				"Seleccion")).toString();

		try {
			// Manejar la opción seleccionada por el usuario
			switch (opcion) {
				case "1. Dólar a Peso Argentino":
					mostrarResultado("USD", "ARS", cantidad);
					break;
				case "2. Peso Argentino a Dólar":
					mostrarResultado("ARS", "USD", cantidad);
					break;
				case "3. Dólar a Real Brasileño":
					mostrarResultado("USD", "BRL", cantidad);
					break;
				case "4. Real Brasileño a Dólar":
					mostrarResultado("BRL", "USD", cantidad);
					break;
				case "5. Dólar a Peso Colombiano":
					mostrarResultado("USD", "COP", cantidad);
					break;
				case "6. Peso Colombiano a Dólar":
					mostrarResultado("COP", "USD", cantidad);
					break;
				case "7. Dólar a Peso Dominicano":
					mostrarResultado("USD", "DOP", cantidad);
					break;
				case "8. Peso Dominicano a Dólar":
					mostrarResultado("DOP", "USD", cantidad);
					break;
				case "9. Salir":
					// Finalizar el programa
					JOptionPane.showMessageDialog(null, "Programa terminado");
					System.exit(0);
				default:
					// Manejar opción no válida
					JOptionPane.showMessageDialog(null, "Opción no válida");
					break;
			}
		} catch (IOException e) {
			// Manejar errores de conexión con la API
			JOptionPane.showMessageDialog(null, "Error al conectar con la API: " + e.getMessage());
		}
	}

	/**
	 * Método privado que muestra el resultado de la conversión de moneda.
	 *
	 * @param fromCurrency La moneda origen.
	 * @param toCurrency La moneda destino.
	 * @param cantidad La cantidad a convertir.
	 * @throws IOException Si ocurre un error al conectar con la API.
	 */
	private void mostrarResultado(String fromCurrency, String toCurrency, double cantidad) throws IOException {
		// Realiza la conversión de moneda
		double resultado = currencyConverter.convert(fromCurrency, toCurrency, cantidad);
		// Muestra el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, cantidad + " " + fromCurrency + " equivalen a " + resultado + " " + toCurrency);
	}
}