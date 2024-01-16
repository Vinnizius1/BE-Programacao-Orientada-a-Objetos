public class Banco {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("001", "123-4", 100.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("002", "567-8", 1200.34);
        ContaInvestimento contaInvestimento = new ContaInvestimento("003", "910-1", 10000);

        System.out.println("Conta Corrente");
        contaCorrente.consultarSaldo();
        contaCorrente.consultarLimite();

        contaCorrente.depositar(200.45);
        contaCorrente.sacar(50.25);
        contaCorrente.ExecutarTaxa();
        contaCorrente.consultarSaldo();

        System.out.println();
        System.out.println("----------------------------");

        System.out.println();
        System.out.println("Conta Poupança");
        contaPoupanca.consultarSaldo();
        contaPoupanca.depositar(120.56);
        contaPoupanca.sacar(1000);
        contaPoupanca.aplicarJurosMensal();

        System.out.println();
        System.out.println("----------------------------");

        System.out.println();
        System.out.println("Conta Investimento");
        contaInvestimento.consultarSaldo();
        contaInvestimento.consultarSaldoInvestido();
        contaInvestimento.Investir(1000);
        contaInvestimento.Resgatar(100);

        contaInvestimento.aplicarJurosMensal();
    }
}
