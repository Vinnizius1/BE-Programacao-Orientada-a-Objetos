public class Principal {
    public static void main(String[] args){
        Carro carro = new Carro("BMW", "320I", 2022, "Preto");
        Carro carro2 = new Carro("Volkwagem", "Jetta");

        carro2.setCor("Vermelho");

        System.out.println("Marca:  " + carro.getMarca());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Ano:    " + carro.getAno());
        System.out.println("Cor:    " + carro.getCor());

        System.out.println("Marca:  " + carro2.getMarca());
        System.out.println("Modelo: " + carro2.getModelo());
        System.out.println("Ano:    " + carro2.getAno());
        System.out.println("Cor:    " + carro2.getCor());


        //formas de alterar a info pq esta publica
        carro.cor = "Azul";
        carro.setCor("Azul");

        //forma correta
        carro.setModelo("420I");
    }
}
