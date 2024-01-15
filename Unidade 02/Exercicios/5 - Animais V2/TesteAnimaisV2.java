// Classe base Animal
class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Novo método na classe base para emitir som
    public void emitirSom() {
        System.out.println("Animal emitindo algum som.");
    }
}

// Subclasse Mamifero
class Mamifero extends Animal {
    private String tipoPelagem;

    public Mamifero(String nome, int idade, String tipoPelagem) {
        super(nome, idade);
        this.tipoPelagem = tipoPelagem;
    }

    public String getTipoPelagem() {
        return tipoPelagem;
    }

    // Sobrescrevendo o método emitirSom na subclasse Mamifero
    @Override
    public void emitirSom() {
        System.out.println("Mamífero emitindo algum som específico.");
    }

    public void amamentar() {
        System.out.println("Mamífero amamentando suas crias.");
    }
}

// Subclasse Ave
class Ave extends Animal {
    private boolean voa;

    public Ave(String nome, int idade, boolean voa) {
        super(nome, idade);
        this.voa = voa;
    }

    public boolean podeVoar() {
        return voa;
    }

    // Sobrescrevendo o método emitirSom na subclasse Ave
    @Override
    public void emitirSom() {
        System.out.println("Ave emitindo algum som específico.");
    }

    public void voar() {
        if (voa) {
            System.out.println("Ave voando pelo céu.");
        } else {
            System.out.println("Essa ave não pode voar.");
        }
    }
}

// Subclasse Peixe
class Peixe extends Animal {
    private String tipoBarbatana;

    public Peixe(String nome, int idade, String tipoBarbatana) {
        super(nome, idade);
        this.tipoBarbatana = tipoBarbatana;
    }

    public String getTipoBarbatana() {
        return tipoBarbatana;
    }

    // Sobrescrevendo o método emitirSom na subclasse Peixe
    @Override
    public void emitirSom() {
        System.out.println("Peixe emitindo algum som específico (pode ser o som de bolhas, por exemplo).");
    }

    public void nadar() {
        System.out.println("Peixe nadando na água.");
    }
}

// Classe principal para testar a hierarquia de classes
public class TesteAnimaisV2 {
    public static void main(String[] args) {
        Mamifero leao = new Mamifero("Leão", 5, "Pelagem curta");
        Ave passaro = new Ave("Pardal", 2, true);
        Peixe peixe = new Peixe("Tubarão", 10, "Cauda bifurcada");

        System.out.println("Leão: " + leao.getNome() + ", Idade: " + leao.getIdade());
        leao.emitirSom();
        leao.amamentar();

        System.out.println("\nPássaro: " + passaro.getNome() + ", Idade: " + passaro.getIdade());
        passaro.emitirSom();
        passaro.voar();

        System.out.println("\nPeixe: " + peixe.getNome() + ", Idade: " + peixe.getIdade());
        peixe.emitirSom();
        peixe.nadar();
    }
}
