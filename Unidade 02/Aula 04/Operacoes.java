public class Operacoes{

    public int somar(int a, int b){
        return a + b;
    }

    public double somar(double a, double b){
        return a + b;
    }

    public double somar(double a, double b, double c){
        return a + b + c;
    }

    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();

        int resultado = operacoes.somar(3, 4);
        double resultado2 = operacoes.somar(5.3, 9.1);
        double resultado3 = operacoes.somar(resultado,resultado2 , 5.3);

        System.out.println("Resultado 1 - "+ resultado);
        System.out.println("Resultado 2 - "+ resultado2);
        System.out.println("Resultado 3 - "+ resultado3);
    }
}