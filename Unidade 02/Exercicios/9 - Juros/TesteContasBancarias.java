// Classe base ContaBancaria
class ContaBancaria {
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado. Novo saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor + ".");
        }
    }

    // Método para aplicar juros (será sobrescrito nas subclasses)
    public void aplicarJuros() {
        // Implementação padrão (nenhum juros na classe base)
        System.out.println("Nenhum juros aplicado na conta base.");
    }
}

// Subclasse ContaCorrente
class ContaCorrente extends ContaBancaria {
    private static final double JUROS_CONTA_CORRENTE = 0.15;  // 15%

    public ContaCorrente(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    // Sobrescrevendo o método aplicarJuros na ContaCorrente
    @Override
    public void aplicarJuros() {
        double juros = getSaldo() * JUROS_CONTA_CORRENTE;
        sacar(juros);
        System.out.println("Juros de " + (JUROS_CONTA_CORRENTE * 100) + "%, removidos do saldo da Conta Corrente.");
    }
}

// Subclasse ContaPoupanca
class ContaPoupanca extends ContaBancaria {
    private static final double JUROS_CONTA_POUPANCA = 0.065;  // 6.5%

    public ContaPoupanca(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    // Sobrescrevendo o método aplicarJuros na ContaPoupanca
    @Override
    public void aplicarJuros() {
        double juros = getSaldo() * JUROS_CONTA_POUPANCA;
        depositar(juros);
        System.out.println("Juros de " + (JUROS_CONTA_POUPANCA * 100) + "% aplicados na Conta Poupança.");
    }
}

// Classe principal para testar as subclasses
public class TesteContasBancarias {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("123", 1000.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("456", 2000.0);

        // Aplicando juros nas contas
        contaCorrente.aplicarJuros();
        contaPoupanca.aplicarJuros();

        // Visualizando saldos após juros
        System.out.println("\nSaldo após juros na Conta Corrente: R$" + contaCorrente.getSaldo());
        System.out.println("Saldo após juros na Conta Poupança: R$" + contaPoupanca.getSaldo());
    }
}
