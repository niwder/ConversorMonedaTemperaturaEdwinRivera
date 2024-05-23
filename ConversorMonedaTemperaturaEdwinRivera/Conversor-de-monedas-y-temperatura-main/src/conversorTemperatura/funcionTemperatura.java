package conversorTemperatura;

import javax.swing.JOptionPane;

/**
 * La clase funcionTemperatura gestiona las conversiones de temperatura utilizando la clase ConvertirTemperatura.
 */
public class funcionTemperatura {

    // Instancia de ConvertirTemperatura para realizar las conversiones
    ConvertirTemperatura temperatura = new ConvertirTemperatura();

    /**
     * Método que maneja la lógica para convertir una cantidad de temperatura entre diferentes unidades.
     *
     * @param Minput La cantidad de temperatura a convertir.
     */
    public void ConvertirTemperatura(double Minput) {
        // Mostrar el menú de opciones de conversión de temperatura
        String opcion = (JOptionPane.showInputDialog(null, "Elije una opción para convertir", "Temperatura",
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{
                        "Grados Celsius a Grados Fahrenheit",
                        "Grados Celsius a Kelvin",
                        "Grados Fahrenheit a Grados Celsius",
                        "Kelvin a Grados Celsius",
                        "Kelvin a Grados Fahrenheit"}, "Seleccion")).toString();

        // Manejar la opción seleccionada por el usuario
        switch (opcion) {
            case "Grados Celsius a Grados Fahrenheit":
                // Llamar al método para convertir de Celsius a Fahrenheit
                temperatura.ConvertirCelciusAFarenheit(Minput);
                break;
            case "Grados Celsius a Kelvin":
                // Llamar al método para convertir de Celsius a Kelvin
                temperatura.ConvertirCelciusAKelvin(Minput);
                break;
            case "Grados Fahrenheit a Grados Celsius":
                // Llamar al método para convertir de Fahrenheit a Celsius
                temperatura.ConvertirFarenheitACelcius(Minput);
                break;
            case "Kelvin a Grados Celsius":
                // Llamar al método para convertir de Kelvin a Celsius
                temperatura.ConvertirKelvinACelcius(Minput);
                break;
            case "Kelvin a Grados Fahrenheit":
                // Llamar al método para convertir de Kelvin a Fahrenheit
                temperatura.ConvertirKelvinAFarenheit(Minput);
                break;
            default:
                // Manejar opción no válida
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }
}

