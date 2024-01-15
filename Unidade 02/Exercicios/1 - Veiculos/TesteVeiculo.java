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

    public void acelerar() {
        System.out.println("Veículo acelerando.");
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

    public void abrirPorta() {
        System.out.println("Abrindo a porta do carro.");
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

    public void ligarPartidaEletrica() {
        if (partidaEletrica) {
            System.out.println("Ligando a partida elétrica da moto.");
        } else {
            System.out.println("Essa moto não possui partida elétrica.");
        }
    }
}

// Classe principal para testar as subclasses
public class TesteVeiculo {
    public static void main(String[] args) {
        Carro carro = new Carro("Fusca", 1970, 2, "Azul");
        Moto moto = new Moto("Harley Davidson", 2022, true, "Cruiser");

        System.out.println("Carro: " + carro.getModelo() + ", Ano: " + carro.getAno());
        carro.acelerar();
        carro.abrirPorta();

        System.out.println("\nMoto: " + moto.getModelo() + ", Ano: " + moto.getAno());
        moto.acelerar();
        moto.ligarPartidaEletrica();
    }
}
