public class Exemplo {
    public static void main(String[] args){
        Carro carro = new Carro("Toyota", "Corolla", 5);
        Moto moto = new Moto("Honda", "CBR", 600);

        //modificando usando metodos herdados e nativos da classe
        carro.setModelo("Etios");
        carro.setPortas(3);

        moto.setModelo("PCX");
        moto.setCilindradas(1000);

        System.out.println("Carro:");
        System.out.println("Marca:"+carro.getMarca());
        System.out.println("Modelo:"+carro.getModelo());
        System.out.println("Num Portas: "+carro.getPortas());

        System.out.println("Moto:");
        System.out.println("Marca:"+moto.getMarca());
        System.out.println("Modelo:"+moto.getModelo());
        System.out.println("Cilindradas: "+moto.getCilindradas());
    }
}