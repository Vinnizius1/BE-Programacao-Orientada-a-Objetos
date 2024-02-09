class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= valor;
        System.out.println("Saque de " + valor + " realizado com sucesso.");
    }
}

public class ex7 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(100);

        try {
            conta.sacar(150); // Tentando sacar mais do que o saldo disponível
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
