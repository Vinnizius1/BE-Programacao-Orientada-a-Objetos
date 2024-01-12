public class Exemplo {

    public static void main(String[] args) {
        Passaro passaro = new Passaro("Gaivota");
        Cachorro cachorro = new Cachorro("Rex");

        passaro.fazerBarulho();
        passaro.voar();

        cachorro.fazerBarulho();
    }
}