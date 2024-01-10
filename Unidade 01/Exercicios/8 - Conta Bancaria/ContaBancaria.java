public class ContaBancaria {
    private double saldo;
    private int numeroConta;

    public ContaBancaria(double saldo, int numeroConta) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.0, 12345);
        System.out.println("Saldo inicial: " + conta.saldo);

        conta.depositar(500.0);
        System.out.println("Saldo após depósito: " + conta.saldo);

        conta.sacar(300.0);
        System.out.println("Saldo após saque: " + conta.saldo);

        conta.sacar(1500.0); // Tentativa de saque com saldo insuficiente
    }
}
