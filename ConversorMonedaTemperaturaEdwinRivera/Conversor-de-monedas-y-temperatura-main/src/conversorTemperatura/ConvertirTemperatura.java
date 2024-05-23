package conversorTemperatura;

import javax.swing.JOptionPane;

/**
 * La clase ConvertirTemperatura proporciona métodos para convertir temperaturas entre diferentes unidades.
 * Incluye conversiones entre Celsius, Fahrenheit y Kelvin.
 */
public class ConvertirTemperatura {

	/**
	 * Convierte una temperatura de grados Celsius a grados Fahrenheit.
	 *
	 * @param valor La temperatura en grados Celsius.
	 * @return La temperatura convertida en grados Fahrenheit.
	 */
	public double ConvertirCelciusAFarenheit(double valor) {
		// Fórmula para convertir Celsius a Fahrenheit
		double farenheit = valor * 1.8 + 32;
		// Redondear el resultado a dos decimales
		farenheit = (double) Math.round(farenheit * 100d) / 100;
		// Mostrar el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, valor + " Grados Celsius son " + farenheit + " Grados Fahrenheit");
		return farenheit;
	}

	/**
	 * Convierte una temperatura de grados Celsius a Kelvin.
	 *
	 * @param valor La temperatura en grados Celsius.
	 */
	public void ConvertirCelciusAKelvin(double valor) {
		// Fórmula para convertir Celsius a Kelvin
		double kelvin = valor + 273.15;
		// Redondear el resultado a dos decimales
		kelvin = (double) Math.round(kelvin * 100d) / 100;
		// Mostrar el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, valor + " Grados Celsius son " + kelvin + " Kelvin");
	}

	/**
	 * Convierte una temperatura de grados Fahrenheit a grados Celsius.
	 *
	 * @param valor La temperatura en grados Fahrenheit.
	 */
	public void ConvertirFarenheitACelcius(double valor) {
		// Fórmula para convertir Fahrenheit a Celsius
		double celcius = (valor - 32) / 1.8;
		// Redondear el resultado a dos decimales
		celcius = (double) Math.round(celcius * 100d) / 100;
		// Mostrar el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, valor + " Grados Fahrenheit son " + celcius + " Grados Celsius");
	}

	/**
	 * Convierte una temperatura de Kelvin a grados Celsius.
	 *
	 * @param valor La temperatura en Kelvin.
	 * @return La temperatura convertida en grados Celsius.
	 */
	public double ConvertirKelvinACelcius(double valor) {
		// Fórmula para convertir Kelvin a Celsius
		double kelvinCelcius = valor - 273.15;
		// Redondear el resultado a dos decimales
		kelvinCelcius = (double) Math.round(kelvinCelcius * 100d) / 100;
		// Mostrar el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, valor + " Kelvin son " + kelvinCelcius + " Grados Celsius");
		return kelvinCelcius;
	}

	/**
	 * Convierte una temperatura de Kelvin a grados Fahrenheit.
	 *
	 * @param valor La temperatura en Kelvin.
	 */
	public void ConvertirKelvinAFarenheit(double valor) {
		// Convertir primero de Kelvin a Celsius
		double kelvinFarenheit = ConvertirKelvinACelcius(valor);
		// Convertir luego de Celsius a Fahrenheit
		kelvinFarenheit = ConvertirCelciusAFarenheit(kelvinFarenheit);
		// Redondear el resultado a dos decimales
		kelvinFarenheit = (double) Math.round(kelvinFarenheit * 100d) / 100;
		// Mostrar el resultado en un cuadro de diálogo
		JOptionPane.showMessageDialog(null, valor + " Kelvin son " + kelvinFarenheit + " Grados Fahrenheit");
	}
}