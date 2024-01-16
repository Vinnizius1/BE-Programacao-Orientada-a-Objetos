public class ContaPoupanca extends ContaBancaria{
    private static final double JUROS_POUCANCA = 0.06;

    public ContaPoupanca(String nagencia, String nconta, double saldo) {
        super(nagencia, nconta, saldo);
    }

    @Override
    public double consultarSaldo() {
        double saldoAtual = saldo;
        System.out.println("Saldo atual: R$"+saldoAtual);
        System.out.println("Rendendo a: "+JUROS_POUCANCA*100+"% ao ano");
        return saldoAtual;
    }

    public void aplicarJurosMensal(){
        double jurosMensal = JUROS_POUCANCA/12;
        double juros = saldo * jurosMensal;
        saldo += juros;
        super.consultarSaldo();
    }
    
}
