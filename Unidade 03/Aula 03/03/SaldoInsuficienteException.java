public class SaldoInsuficienteException extends Exception{
    
    public SaldoInsuficienteException(){
        super("Saldo insuficiente para realizar a operação!");
    }

    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }

    public SaldoInsuficienteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
