//extends significa que estamos herdando caracteristicas do Veiculo
class Moto extends Veiculo{
    private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas){
        //super define que estamos passando informaçoes para a classe pai
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}