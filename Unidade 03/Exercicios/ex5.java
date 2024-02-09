import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex5 {

    public static void lerArquivo(String nomeArquivo) {
        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }
    }

    public static void main(String[] args) {
        lerArquivo("arquivo.txt");
    }
}
