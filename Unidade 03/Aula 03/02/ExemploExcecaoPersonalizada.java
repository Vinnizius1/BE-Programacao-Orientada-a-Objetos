public class ExemploExcecaoPersonalizada {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);

        try {
            conta.sacar(1200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao sacar: "+e.getMessage());
        }
    }    
}
