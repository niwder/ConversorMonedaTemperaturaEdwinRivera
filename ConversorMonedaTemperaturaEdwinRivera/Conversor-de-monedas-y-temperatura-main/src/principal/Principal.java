package principal;

import javax.swing.JOptionPane;
import conversorMonedas.ejecucion;
import conversorTemperatura.funcionTemperatura;

/**
 * La clase Principal sirve como el punto de entrada principal para la aplicación.
 * Proporciona un menú para elegir entre conversión de moneda y conversión de temperatura.
 */
public class Principal {
    public static void main(String[] args) {
        // Crear instancias de las clases de ejecución para monedas y temperaturas
        ejecucion monedas = new ejecucion();
        funcionTemperatura temperatura = new funcionTemperatura();

        while (true) {
            // Mostrar opciones del menú principal
            String opciones = (JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menú",
                    JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Conversor de Moneda", "Conversor de Temperatura"}, "Seleccion")).toString();

            switch (opciones) {
                case "Conversor de Moneda":
                    // Solicitar la cantidad de dinero a convertir
                    String input = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir: ");
                    if (validarNumero(input)) {
                        double cantidad = Double.parseDouble(input);
                        // Llamar al método para convertir la moneda
                        monedas.CurrencyConverter(cantidad);
                        // Preguntar si desea realizar otra conversión
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
                        if (respuesta != JOptionPane.OK_OPTION) {
                            // Terminar el programa si la respuesta es no
                            JOptionPane.showMessageDialog(null, "Programa terminado");
                            System.exit(0);
                        }
                    } else {
                        // Mostrar mensaje de error si el valor ingresado no es válido
                        JOptionPane.showMessageDialog(null, "Valor inválido");
                    }
                    break;

                case "Conversor de Temperatura":
                    // Solicitar el valor de la temperatura a convertir
                    input = JOptionPane.showInputDialog("Ingresa el valor de la temperatura que deseas convertir: ");
                    if (validarNumero(input)) {
                        double cantidad = Double.parseDouble(input);
                        // Llamar al método para convertir la temperatura
                        temperatura.ConvertirTemperatura(cantidad);
                        // Preguntar si desea realizar otra conversión
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?");
                        if (respuesta != JOptionPane.OK_OPTION) {
                            // Terminar el programa si la respuesta es no
                            JOptionPane.showMessageDialog(null, "Programa terminado");
                            System.exit(0);
                        }
                    } else {
                        // Mostrar mensaje de error si el valor ingresado no es válido
                        JOptionPane.showMessageDialog(null, "Valor inválido");
                    }
                    break;

                default:
                    // Mostrar mensaje de error si la opción seleccionada no es válida
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    /**
     * Método para validar si la entrada es un número válido.
     *
     * @param input La entrada a validar.
     * @return true si la entrada es un número válido, false en caso contrario.
     */
    public static boolean validarNumero(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}