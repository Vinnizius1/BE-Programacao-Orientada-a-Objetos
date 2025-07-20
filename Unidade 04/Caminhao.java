
public class Caminhao extends Veiculo {

    private double capacidadeCarga; // Em toneladas
    private int numeroEixos;

    public Caminhao(String marca, String modelo, int ano, String cor, double preco, double precoDeCusto,double capacidadeCarga, int numeroEixos) {
        // 1. Chamamos o construtor da classe pai (Veiculo) com todos os parâmetros necessários.
        super(marca, modelo, ano, cor, preco, precoDeCusto);

        // 2. Cuidamos dos atributos que são específicos desta classe.
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
    }

    @Override
    public void exibirInformacoes() {
        // 3. Reutilizamos o método da classe pai para mostrar as infos comuns.
        super.exibirInformacoes();
        // 4. Adicionamos as informações específicas do caminhão.
        System.out.println("Capacidade de Carga: " + capacidadeCarga + "t");
        System.out.println("Número de Eixos: " + numeroEixos);
    }
}
