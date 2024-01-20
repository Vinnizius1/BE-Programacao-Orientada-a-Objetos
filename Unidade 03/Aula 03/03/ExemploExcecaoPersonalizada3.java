public class ExemploExcecaoPersonalizada3 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);

        try {
            conta.realizarTransacao(20000);
        } catch (TransacaoInvalidaException e) {
            System.out.println("Erro ao realizar a transação "+e.getMessage());
            if (e.getCause() instanceof SaldoInsuficienteException) {
                System.out.println("Causa: Saldo insuficiente!");
            }
        }
    }
}
