public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double calcularPrecoComDesconto(double desconto) {
        return preco - (preco * desconto / 100);
    }

    public static void main(String[] args) {
        Produto produto = new Produto("Camiseta", 50.0);
        double precoComDesconto = produto.calcularPrecoComDesconto(10);
        System.out.println("Preço com desconto: " + precoComDesconto);
    }
}
