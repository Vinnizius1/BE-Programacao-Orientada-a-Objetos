//extends significa que estamos herdando caracteristicas do Veiculo
class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, String modelo,int portas){
        //super define que estamos passando informaçoes para a classe pai
        super(marca, modelo);
        this.portas = portas;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
}