public class Livro {
    private String titulo;
    private String autor;
    private int numPaginas;

    public Livro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de Páginas: " + numPaginas);
    }

    public static void main(String[] args) {
        Livro livro = new Livro("A Guerra dos Tronos", "George R. R. Martin", 694);
        livro.exibirDetalhes();
    }
}
