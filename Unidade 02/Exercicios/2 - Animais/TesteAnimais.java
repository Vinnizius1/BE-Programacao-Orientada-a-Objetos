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

    public void nadar() {
        System.out.println("Peixe nadando na água.");
    }
}

// Classe principal para testar a hierarquia de classes
public class TesteAnimais {
    public static void main(String[] args) {
        Mamifero leao = new Mamifero("Leão", 5, "Pelagem curta");
        Ave passaro = new Ave("Pardal", 2, true);
        Peixe peixe = new Peixe("Tubarão", 10, "Cauda bifurcada");

        System.out.println("Leão: " + leao.getNome() + ", Idade: " + leao.getIdade());
        leao.amamentar();

        System.out.println("\nPássaro: " + passaro.getNome() + ", Idade: " + passaro.getIdade());
        passaro.voar();

        System.out.println("\nPeixe: " + peixe.getNome() + ", Idade: " + peixe.getIdade());
        peixe.nadar();
    }
}
