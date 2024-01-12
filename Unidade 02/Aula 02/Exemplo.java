public class Exemplo{
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5.0, 3.0);
        Circulo circulo = new Circulo(6.0);

        System.out.println("Area do retangulo: "+ retangulo.calcularArea());
        System.out.println("Perimetro do retangulo: "+ retangulo.calcularPerimetro());

        System.out.println("Area do circulo: "+ circulo.calcularArea());
        System.out.println("Perimetro do circulo: "+ circulo.calcularPerimetro());
    }
}