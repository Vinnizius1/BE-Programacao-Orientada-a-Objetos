public class Aluno {
    //atributos privados
    private String nome;
    private int idade;
    private String curso;

    //metodo construtor
    public Aluno(String nome, int idade, String curso){
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    //getters
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getCurso() {
        return curso;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
}