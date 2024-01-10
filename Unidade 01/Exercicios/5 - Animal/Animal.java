public class Animal {
    private String nome;
    private String tipoAlimentacao;

    public Animal(String nome, String tipoAlimentacao) {
        this.nome = nome;
        this.tipoAlimentacao = tipoAlimentacao;
    }

    public void emitirSom() {
        System.out.println(nome + " está fazendo um som.");
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Leão", "Carnívoro");
        animal.emitirSom();
    }
}
