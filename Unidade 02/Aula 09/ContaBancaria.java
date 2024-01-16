public class ContaBancaria implements OperacoesBancarias {
    protected String nagencia;
    protected String nconta;
    protected double saldo;

    public String getNagencia() {
        return nagencia;
    }
    public String getNconta() {
        return nconta;
    }

    public void setNagencia(String nagencia) {
        this.nagencia = nagencia;
    }
    public void setNconta(String nconta) {
        this.nconta = nconta;
    }

    public ContaBancaria(String nagencia, String nconta, double saldo){
        this.nagencia = nagencia;
        this.nconta = nconta;
        this.saldo = saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println();
        System.out.println("---- Operação de Depósito ----");
        System.out.println("Valor depositado: R$"+ valor);
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println("------------------------------");
        System.out.println();
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println();
            System.out.println("---- Operação de Saque ----");
            System.out.println("Valor sacado: R$"+ valor);
            System.out.println("Saldo atual: R$"+saldo);
            System.out.println("------------------------------");
            System.out.println();
        }else{
            System.out.println("Saldo insuficiente para a operação! Tente outro valor.");
        }
    }

    @Override
    public double consultarSaldo() {
        System.out.println("Saldo atual: R$"+saldo);
        return saldo;
    }
    
}
