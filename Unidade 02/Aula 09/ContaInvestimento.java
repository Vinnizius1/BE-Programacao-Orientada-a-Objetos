public class ContaInvestimento extends ContaBancaria{
    private static final double TAXA_ADMINISTRACAO = 20.0;
    private static final double TAXA_JUROS_MENSAL = 0.012;
    private double saldoInvestido;

    public ContaInvestimento(String nagencia, String nconta, double saldo) {
        super(nagencia, nconta, saldo);
        this.saldoInvestido = 0.0;
    }
    
    public void Investir(double valor){
        if (valor <= saldo) {
            saldo -= valor;
            double valorInvestido = valor - TAXA_ADMINISTRACAO;
            saldoInvestido += valorInvestido;
            System.out.println("Investimento de R$"+valorInvestido+ " realizado!");
            System.out.println("Saldo investido atualizado: R$"+saldoInvestido);
        }else{
            System.out.println("Saldo insuficiente para a operação! Tente outro valor.");
        }
    }

    public void Resgatar(double valor){
        if (valor <= saldoInvestido) {
            saldoInvestido -= valor;
            saldo += valor;
            System.out.println("Saldo investido atualizado: R$"+saldoInvestido);
            super.consultarSaldo();
        }else{
            System.out.println("Saldo investido insuficiente para a operação! Tente outro valor.");
        }
    }

    public double consultarSaldoInvestido(){
        System.out.println("Saldo investido: R$"+saldoInvestido);
        return saldoInvestido;
    }

    public void aplicarJurosMensal(){
        saldoInvestido += saldoInvestido * TAXA_JUROS_MENSAL;
        System.out.println("Saldo investido atualizado: R$"+saldoInvestido);
    }

}
