// Interface Autenticavel
interface Autenticavel {
    boolean autenticar(String senha);
}

// Implementação da interface em uma classe
class Usuario implements Autenticavel {
    private String senha;

    public Usuario(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }
}

// Outra implementação da interface em uma classe
class Administrador implements Autenticavel {
    private String senhaAdmin;

    public Administrador(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    @Override
    public boolean autenticar(String senhaDigitada) {
        return senhaAdmin.equals(senhaDigitada);
    }
}

// Classe principal para testar o exercício
public class TesteAutenticacao {
    public static void main(String[] args) {
        // Criando objetos que implementam Autenticavel
        Autenticavel usuario = new Usuario("senha123");
        Autenticavel admin = new Administrador("admin123");

        // Testando autenticação
        System.out.println("Autenticação do usuário: " + usuario.autenticar("senha123"));
        System.out.println("Autenticação do administrador: " + admin.autenticar("admin123"));
    }
}
