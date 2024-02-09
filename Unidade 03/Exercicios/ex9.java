class TransferenciaInvalidaException extends Exception {
    public TransferenciaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void transferir(double valor) throws TransferenciaInvalidaException {
        if (valor <= 0) {
            throw new TransferenciaInvalidaException("Valor de transferência inválido.");
        }
        saldo -= valor;
        System.out.println("Transferência de " + valor + " realizada com sucesso.");
    }
}

public class ex9 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(100);

        try {
            conta.transferir(-50); // Tentando transferir um valor negativo
        } catch (TransferenciaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
