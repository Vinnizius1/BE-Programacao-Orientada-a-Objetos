public class ex1 {

    public static void dividir(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        
        int resultado = dividendo / divisor;
        System.out.println("Resultado da divisão: " + resultado);
    }

    public static void main(String[] args) {
        int dividendo = 10;
        int divisor = 0;

        try {
            dividir(dividendo, divisor);
        } catch (ArithmeticException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            // Você pode tratar o erro de forma adequada aqui, se necessário
        }
    }
}
