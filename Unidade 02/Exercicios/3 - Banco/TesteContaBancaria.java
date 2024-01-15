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
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}

// Subclasse ContaCorrente que herda de ContaBancaria
class ContaCorrente extends ContaBancaria {
    private double taxaDeManutencao;

    public ContaCorrente(String numeroConta, double saldoInicial, double taxaDeManutencao) {
        super(numeroConta, saldoInicial);
        this.taxaDeManutencao = taxaDeManutencao;
    }

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    // Método específico para ContaCorrente
    public void descontarTaxaDeManutencao() {
        sacar(taxaDeManutencao);
        System.out.println("Taxa de manutenção descontada. Novo saldo: R$" + getSaldo());
    }
}

// Subclasse ContaPoupanca que herda de ContaBancaria
class ContaPoupanca extends ContaBancaria {
    private double taxaDeRendimento;

    public ContaPoupanca(String numeroConta, double saldoInicial, double taxaDeRendimento) {
        super(numeroConta, saldoInicial);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    // Novo método para calcular o rendimento mensal
    public double calcularRendimentoMensal() {
        return getSaldo() * (taxaDeRendimento / 100);
    }
}

// Classe principal para testar a hierarquia de classes
public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("123456", 1000.0, 10.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("789012", 500.0, 5.0);

        System.out.println("Conta Corrente: Número " + contaCorrente.getNumeroConta() + ", Saldo R$" + contaCorrente.getSaldo());
        contaCorrente.depositar(200.0);
        contaCorrente.sacar(50.0);
        contaCorrente.descontarTaxaDeManutencao();

        System.out.println("\nConta Poupança: Número " + contaPoupanca.getNumeroConta() + ", Saldo R$" + contaPoupanca.getSaldo());
        contaPoupanca.depositar(100.0);

        // Calcular e aplicar rendimento mensal
        double rendimentoMensal = contaPoupanca.calcularRendimentoMensal();
        System.out.println("Rendimento Mensal: R$" + rendimentoMensal);
        
        // Depositar o rendimento no saldo
        contaPoupanca.depositar(rendimentoMensal);
        
        System.out.println("Novo Saldo: R$" + contaPoupanca.getSaldo());
    }
}
