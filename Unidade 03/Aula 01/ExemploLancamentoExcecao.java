public class ExemploLancamentoExcecao {
    public static void main(String[] args) {
        try {
            realizarDivisao(10, 2);
            realizarDivisao(7, 0);
        } catch (ArithmeticException e) {
            System.out.println("Erro ao realizar a divisão: "+e.getMessage());
        }
    }

    public static void realizarDivisao(int numerador, int deniminador){
        if (deniminador == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
            //System.out.println("Divisão por zero não é permitida.");
        }
        int resultado = numerador / deniminador;
        System.out.println("Resultado da divisão: "+ resultado);
    }
}