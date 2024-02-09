class ConversorTemperatura {
    public static double converterCelsiusParaFahrenheit(double temperaturaCelsius) {
        if (temperaturaCelsius < -273.15) {
            throw new IllegalArgumentException("Temperatura inválida: menor que o zero absoluto em Celsius.");
        }
        return (temperaturaCelsius * 9 / 5) + 32;
    }
}

public class ex2 {
    public static void main(String[] args) {
        double temperaturaCelsius = -300; // Tente ajustar este valor para testar diferentes casos

        try {
            double temperaturaFahrenheit = ConversorTemperatura.converterCelsiusParaFahrenheit(temperaturaCelsius);
            System.out.println("Temperatura em Fahrenheit: " + temperaturaFahrenheit);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
