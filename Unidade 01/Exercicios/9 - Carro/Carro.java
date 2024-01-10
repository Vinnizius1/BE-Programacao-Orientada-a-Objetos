public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void ligar() {
        System.out.println("O carro está ligado.");
    }

    public void desligar() {
        System.out.println("O carro está desligado.");
    }

    public void acelerar() {
        System.out.println("O carro está acelerando.");
    }

    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022);
        carro.ligar();
        carro.acelerar();
        carro.desligar();
    }
}
