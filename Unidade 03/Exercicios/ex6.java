public class ex6 {

    public static void main(String[] args) {
        String numeroString = "abc";

        try {
            int numero = Integer.parseInt(numeroString);
            System.out.println("Número convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro: A string não é um número válido.");
        }
    }
}
