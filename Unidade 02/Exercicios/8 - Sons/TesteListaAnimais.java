import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void emitirSom() {
        System.out.println("Peixe emitindo algum som específico (pode ser o som de bolhas, por exemplo).");
    }

    public void nadar() {
        System.out.println("Peixe nadando na água.");
    }
}

// Classe principal para testar a hierarquia de classes
public class TesteListaAnimais {
    public static void main(String[] args) {
        List<Animal> listaAnimais = new ArrayList<>();

        // Adicionando animais à lista
        listaAnimais.add(new Mamifero("Leão", 5, "Pelagem curta"));
        listaAnimais.add(new Ave("Pardal", 2, true));
        listaAnimais.add(new Peixe("Tubarão", 10, "Cauda bifurcada"));

        // Percorrendo a lista e chamando o método emitirSom de cada animal
        for (Animal animal : listaAnimais) {
            animal.emitirSom();
            System.out.println();
        }
    }
}
