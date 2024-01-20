import java.util.Scanner;

public class ExemploCapturaExcecao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Digite o numerador: ");
            int numerador = scanner.nextInt();

            System.out.println("Digite o denominador: ");
            int denomidador = scanner.nextInt();

            int resultado = dividir(numerador, denomidador);
            System.out.println("Resultado da divisão: "+ resultado);
        } catch (ArithmeticException e){
            System.out.println("Erro: "+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: "+ e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int dividir(int numerador, int denomidador){
        if (denomidador == 0) {
            throw new ArithmeticException("Divisao por zero não é permitida!");
        }
        return numerador / denomidador;
    }
}
