class DivisaoInteiraInvalidaException extends Exception {
    public DivisaoInteiraInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class DivisaoInteira {
    public int dividir(int dividendo, int divisor) throws DivisaoInteiraInvalidaException {
        if (dividendo % divisor != 0) {
            throw new DivisaoInteiraInvalidaException("A divisão não é exata.");
        }
        return dividendo / divisor;
    }
}

public class ex10 {
    public static void main(String[] args) {
        DivisaoInteira divisaoInteira = new DivisaoInteira();

        try {
            int resultado = divisaoInteira.dividir(10, 3); // Tentando fazer uma divisão não exata
            System.out.println("Resultado da divisão: " + resultado);
        } catch (DivisaoInteiraInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
