public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void calcularAumentoSalario(double aumento) {
        salario += (salario * aumento / 100);
        System.out.println("Novo salário de " + nome + ": " + salario);
    }

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Maria", "Gerente", 5000.0);
        funcionario.calcularAumentoSalario(10); // Aumento de 10%
    }
}
