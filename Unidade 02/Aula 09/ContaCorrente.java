public class ContaCorrente extends ContaBancaria{
    private static final double TAXA_MANUTENCAO = 15.0;
    private static final double LIMITE_TOTAL = 1000.0;
    private double limite;

    public ContaCorrente(String nagencia, String nconta, double saldo) {
        super(nagencia, nconta, saldo);
        this.limite = LIMITE_TOTAL;
    }

    @Override
    public void sacar(double valor) {
        double saldoAtual = getSaldo();
        if(valor <= saldoAtual + limite){
            if (valor <= saldoAtual){
                setSaldo(saldoAtual -=valor);
                imprimirOperacao("Saque", valor);
            }else{
                limite -= (valor - saldoAtual);
                setSaldo(saldoAtual -= valor);
                imprimirOperacao("Saque", valor);
            }    
        }else{
            System.out.println("Saldo + limite insuficiente para a operação! Tente outro valor.");
            System.out.println("Saldo: R$"+saldoAtual+" Limite disponivel: R$"+limite);
        }
    }

    public void consultarLimite(){
        System.out.println("Seu limite atual é de: R$"+limite);
    }

    public void ExecutarTaxa(){
        setSaldo(getSaldo() - TAXA_MANUTENCAO);
        System.out.println("Taxa de manutenção executada!");
    }
    
}
