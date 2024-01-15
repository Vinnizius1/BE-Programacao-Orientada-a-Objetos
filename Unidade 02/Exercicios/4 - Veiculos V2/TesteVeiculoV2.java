// Classe base Veiculo
class Veiculo {
    private String modelo;
    private int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    // Método na classe base para imprimir informações
    public void imprimirInformacoes() {
        System.out.println("Modelo: " + getModelo() + ", Ano: " + getAno());
    }
}

// Subclasse Carro que herda de Veiculo
class Carro extends Veiculo {
    private int numeroPortas;
    private String cor;

    public Carro(String modelo, int ano, int numeroPortas, String cor) {
        super(modelo, ano);
        this.numeroPortas = numeroPortas;
        this.cor = cor;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public String getCor() {
        return cor;
    }

    // Sobrescrevendo o método imprimirInformacoes na subclasse Carro
    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Número de Portas: " + getNumeroPortas() + ", Cor: " + getCor());
    }
}

// Subclasse Moto que herda de Veiculo
class Moto extends Veiculo {
    private boolean partidaEletrica;
    private String tipo;

    public Moto(String modelo, int ano, boolean partidaEletrica, String tipo) {
        super(modelo, ano);
        this.partidaEletrica = partidaEletrica;
        this.tipo = tipo;
    }

    public boolean temPartidaEletrica() {
        return partidaEletrica;
    }

    public String getTipo() {
        return tipo;
    }

    // Sobrescrevendo o método imprimirInformacoes na subclasse Moto
    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Partida Elétrica: " + (temPartidaEletrica() ? "Sim" : "Não") + ", Tipo: " + getTipo());
    }
}

// Classe principal para testar as subclasses
public class TesteVeiculoV2 {
    public static void main(String[] args) {
        Carro carro = new Carro("Fusca", 1970, 2, "Azul");
        Moto moto = new Moto("Harley Davidson", 2022, true, "Cruiser");

        System.out.println("Informações do Carro:");
        carro.imprimirInformacoes();

        System.out.println("\nInformações da Moto:");
        moto.imprimirInformacoes();
    }
}
