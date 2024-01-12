public class Exemplo {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Leo", 5000, "Financeiro");
        Analista analista = new Analista("Joao", 3000, "Engenharia");

        System.out.println("Bonus do Gerente "+ gerente.getNome()+ ": "+ gerente.calcularBonus());
        System.out.println("Departamento do gerente "+ gerente.getNome()+": "+ gerente.getDepartamento());

        System.out.println("Bonus do Analista "+ analista.getNome()+ ": "+ analista.calcularBonus());
        System.out.println("Projeto do analista "+ analista.getNome()+ ": "+ analista.getProjeto());
    }
}