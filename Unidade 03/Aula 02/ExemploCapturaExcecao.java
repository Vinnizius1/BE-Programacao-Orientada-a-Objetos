import java.util.Scanner;

public class ExemploCapturaExcecao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        String input = scanner.nextLine();

        try {
            int numero = Integer.parseInt(input);
            System.out.println("Numero digitado: " + numero);
        } catch (Exception e) {
            System.out.println("Erro: Nao foi possivel converter a entrada em numero inteiro");
            System.out.println("Mensagem de exceção: "+ e.getMessage());
        } finally{
            scanner.close();
        }
    }
}
