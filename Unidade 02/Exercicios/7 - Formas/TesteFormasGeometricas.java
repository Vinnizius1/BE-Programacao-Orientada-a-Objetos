// Classe base FormaGeometrica
class FormaGeometrica {
    // Métodos para calcular área e perímetro
    public double calcularArea() {
        return 0.0;  // Por padrão, a área é 0
    }

    public double calcularPerimetro() {
        return 0.0;  // Por padrão, o perímetro é 0
    }
}

// Subclasse Circulo que herda de FormaGeometrica
class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    // Sobrescrevendo os métodos para calcular área e perímetro do círculo
    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

// Subclasse Retangulo que herda de FormaGeometrica
class Retangulo extends FormaGeometrica {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    // Sobrescrevendo os métodos para calcular área e perímetro do retângulo
    @Override
    public double calcularArea() {
        return comprimento * largura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (comprimento + largura);
    }
}

// Subclasse Triangulo que herda de FormaGeometrica
class Triangulo extends FormaGeometrica {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    // Sobrescrevendo os métodos para calcular área e perímetro do triângulo
    @Override
    public double calcularArea() {
        // Fórmula de Herão para calcular a área de um triângulo
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}

// Classe principal para testar as subclasses
public class TesteFormasGeometricas {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5.0);
        Retangulo retangulo = new Retangulo(4.0, 6.0);
        Triangulo triangulo = new Triangulo(3.0, 4.0, 5.0);

        System.out.println("Área e Perímetro do Círculo:");
        System.out.printf("Área: %.2f %n",circulo.calcularArea());
        System.out.printf("Perímetro: %.2f %n",circulo.calcularPerimetro());

        System.out.println("\nÁrea e Perímetro do Retângulo:");
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());

        System.out.println("\nÁrea e Perímetro do Triângulo:");
        System.out.println("Área: " + triangulo.calcularArea());
        System.out.println("Perímetro: " + triangulo.calcularPerimetro());
    }
}
