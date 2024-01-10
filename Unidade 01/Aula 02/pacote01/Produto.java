package pacote01;

public class Produto {
    //atributos
    public String nome;
    protected Double preco;
    private Double peso;

    //getters
    public String getNome() {
        return nome;
    }
    public Double getPreco() {
        return preco;
    }
    public Double getPeso() {
        return peso;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
