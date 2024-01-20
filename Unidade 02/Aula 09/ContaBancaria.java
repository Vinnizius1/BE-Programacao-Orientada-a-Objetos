public class ContaBancaria implements OperacoesBancarias {
    private String nagencia;
    private String nconta;
    private double saldo;

    public String getNagencia() {
        return nagencia;
    }
    public String getNconta() {
        return nconta;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setNagencia(String nagencia) {
        this.nagencia = nagencia;
    }
    public void setNconta(String nconta) {
        this.nconta = nconta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria(String nagencia, String nconta, double saldo){
        this.nagencia = nagencia;
        this.nconta = nconta;
        this.saldo = saldo;
    }
    
    protected void imprimirOperacao(String operacao, double valor){
        System.out.println();
        System.out.println("---- Operação de "+ operacao +" ----");
        System.out.println("Valor "+ operacao.toLowerCase() +": R$"+ valor);
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println("------------------------------");
        System.out.println();
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        imprimirOperacao("Depósito", valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            imprimirOperacao("Saque", valor);
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
