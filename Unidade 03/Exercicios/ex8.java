class SenhaInvalidaException extends Exception {
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class ValidadorSenha {
    public void validarSenha(String senha) throws SenhaInvalidaException {
        if (senha.length() < 8) {
            throw new SenhaInvalidaException("A senha deve ter no mínimo 8 caracteres.");
        }
        System.out.println("Senha válida.");
    }
}

public class ex8 {
    public static void main(String[] args) {
        ValidadorSenha validador = new ValidadorSenha();

        try {
            validador.validarSenha("12345"); // Tentando validar uma senha muito curta
        } catch (SenhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
