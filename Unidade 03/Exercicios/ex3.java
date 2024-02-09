public class ex3 {

    public static void verificarIdade(int idade) throws IllegalArgumentException {
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade inválida. A idade deve estar entre 0 e 150 anos.");
        }
        
        System.out.println("Idade válida: " + idade);
    }

    public static void main(String[] args) {
        int idade = -10;

        try {
            verificarIdade(idade);
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            // Você pode tratar o erro de forma adequada aqui, se necessário
        }
    }
}
