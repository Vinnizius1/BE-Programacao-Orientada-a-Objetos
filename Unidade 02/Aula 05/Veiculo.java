class Veiculo{
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public void Acelerar(){
        System.out.println("Veiculo acelerando...");
    }

    public void Abastecer(){
        System.out.println("Abastecendo o Veiculo...");
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}