import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAlunos {

    private ArrayList<Aluno> alunos;

    public CadastroAlunos(){
        alunos = new ArrayList<>();
    }

    //metodo para cadastrar um novo aluno na lista
    public void cadastrarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    //metodo para exibir alunos cadastrados
    public void mostrarAlunos(){
        for (Aluno aluno : alunos) {
            System.out.println("Nome: "+ aluno.getNome());
            System.out.println("Idade: "+ aluno.getIdade());
            System.out.println("Curso: "+ aluno.getCurso());
            System.out.println("");
        }
    }
    //metodo main
    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();
        Scanner scanner = new Scanner(System.in);

        //menu de escolha da funcao a ser realizada
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Mostrar alunos cadastrados");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    //cadastrando um novo aluno
                    System.out.print("Informe o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe o curso do aluno: ");
                    String curso = scanner.nextLine();
                    cadastro.cadastrarAluno(new Aluno(nome, idade, curso));
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;
                case 2:
                    //exibindo alunos cadastrados
                    System.out.println("Alunos Cadastrados: ");
                    cadastro.mostrarAlunos();
                    break;
                case 3:
                    //saindo do programa
                    continuar = false;
                    break;
                default:
                    //caso seja digitado um numero invalido
                    System.out.println("Opção invalida, tente novamente!");
                    break;
            }
        }

        //fechando o scanner e encerrando o programa
        scanner.close();
        System.out.println("Programa Encerrado!");

    }
}