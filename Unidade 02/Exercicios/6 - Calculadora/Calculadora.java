public class Calculadora {

    // Soma de dois inteiros
    public int somar(int a, int b) {
        return a + b;
    }

    // Soma de dois doubles
    public double somar(double a, double b) {
        return a + b;
    }

    // Subtração de dois inteiros
    public int subtrair(int a, int b) {
        return a - b;
    }

    // Subtração de dois doubles
    public double subtrair(double a, double b) {
        return a - b;
    }

    // Multiplicação de dois inteiros
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Multiplicação de dois doubles
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Divisão de dois inteiros
    public double dividir(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
    }

    // Divisão de dois doubles
    public double dividir(double a, double b) {
        if (b != 0.0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Exemplos de uso
        System.out.println("Soma (int): " + calculadora.somar(5, 3));
        System.out.println("Soma (double): " + calculadora.somar(5.5, 3.2));

        System.out.println("Subtração (int): " + calculadora.subtrair(8, 4));
        System.out.println("Subtração (double): " + calculadora.subtrair(8.7, 3.1));

        System.out.println("Multiplicação (int): " + calculadora.multiplicar(2, 6));
        System.out.println("Multiplicação (double): " + calculadora.multiplicar(2.5, 3.5));

        System.out.println("Divisão (int): " + calculadora.dividir(9, 3));
        System.out.println("Divisão (double): " + calculadora.dividir(10.0, 2.0));
    }
}
