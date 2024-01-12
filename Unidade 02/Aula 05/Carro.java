class Carro extends Veiculo{
    private int portas;

    public Carro(String marca, String modelo, int portas){
        super(marca, modelo);
        this.portas = portas;
    }

    @Override
    public void Acelerar() {
        System.out.println("Carro acelerando...");
    }

    public void Abastecer(int litros){
        System.out.println("Abastecendo o carro com: "+litros+" Lts");
    }

    public int getPortas() {
        return portas;
    }
    public void setPortas(int portas) {
        this.portas = portas;
    }

}