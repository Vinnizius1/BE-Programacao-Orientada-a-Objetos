import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    // A GRANDE MUDANÇA: Uma única lista para todos os veículos!
    private static List<Veiculo> veiculos = new ArrayList<>();
    // As outras 2 listas
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {


        /*  */
        // Adicionando alguns veículos para teste inicial
        veiculos.add(new Carro("Chevrolet", "Onix", 2015, "Prata", 45000, 38000, 4, "Flex", 280));
        veiculos.add(new Moto("Honda", "CB 500", 2020, "Vermelha", 32000, 29500, 500, true, "Naked"));

        // Testando o novo Caminhão!
        veiculos.add(new Caminhao("Volvo", "FH 540", 2021, "Branco", 750000, 680000, 74, 6));

        // Testando o novo Cliente com biotipo "grande"
        clientes.add(new Pessoa("João Silva", 30, "Rua A, 123", "11999999999", "joao@mail.com", 1.90, 100));
        // Testando o novo Cliente com biotipo "pequeno"
        clientes.add(new Pessoa("Maria Oliveira", 25, "Rua B, 456", "11988888888", "maria@mail.com", 1.60, 60));
        /*  */


        // Força o Scanner a usar o padrão US (ponto como separador decimal)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int escolha = 0;

        do{
            try{
                System.out.println("### Menu Concessionaria ###");
                System.out.println("1 - Mostrar Veiculos");
                System.out.println("2 - Adicionar Veículo ao Estoque");
                System.out.println("3 - Vender Veiculo");
                System.out.println("4 - Cadastrar um cliente");
                System.out.println("5 - Mostrar Clientes"); // 1. Nova opção no menu
                System.out.println("6 - Sugerir Veículo por Biotipo");
                System.out.println("7 - Gerar relatorio");  // 3. Opção antiga renumerada
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (escolha) {
                    case 1:
                        mostrarVeiculos();
                        break;
                    case 2:
                        comprarVeiculo(scanner);
                        break;
                    case 3:
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5: // 4. Novo case para chamar o método de mostrar clientes
                        mostrarClientes();
                        break;
                    case 6: // 5. Novo case para sugerir veículo
                        sugerirVeiculo(scanner);
                        break;
                    case 7: // 6. Case antigo ajustado para o novo número
                        gerarRelatorio();
                        break;
                    case 0:
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                }
            }catch (InputMismatchException e){
                System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
                scanner.nextLine();
            }catch (PrecoCustoInvalidoException e) { // Captura exceção de negócio
                System.out.println("Erro de Negócio: " + e.getMessage());
                escolha = 0; // Força a volta ao menu
            }catch (NoSuchElementException e) { // Captura o Ctrl+C (interrupção do input)
                System.out.println("\nPrograma encerrado pelo usuário.");
                escolha = 0; // Garante a saída limpa do loop
            }catch (Exception e){
                System.out.println("Erro desconhecido: "+e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    // 7. NOVO MÉTODO: Sugerir Veículo por Biotipo
    private static void sugerirVeiculo(Scanner scanner) {
        if (clientes.isEmpty() || veiculos.isEmpty()) {
            System.out.println("Não é possível sugerir veículos. Verifique se há clientes e veículos cadastrados.");
            return; // Sai do método
        }

        try {
            System.out.println("Selecione o cliente para a sugestão:");
            mostrarClientes(); // Mostra todos os clientes cadastrados
            int indiceCliente = scanner.nextInt() - 1; // Ajusta por causa do índice começar em 0
            Pessoa cliente = clientes.get(indiceCliente);
            scanner.nextLine(); // Limpa o buffer

            System.out.println("\nAnalisando o biotipo de " + cliente.getNome() + " (Altura: " + cliente.getAltura() + "m, Peso: " + cliente.getPeso() + "kg) para sugerir veículos...");

            // REGRA de Biotipo: consideramos "grande" se for alto OU pesado. 
            boolean clienteGrande = cliente.getAltura() >= 1.85 || cliente.getPeso() >= 95;

            // NOVA LISTA: Veículos sugeridos com base no biotipo
            List<Veiculo> veiculosSugeridos = new ArrayList<>();
            
            // Percorre a lista de veículos e aplica as regras de sugestão
            // Usamos o polimorfismo para lidar com diferentes tipos de veículos
            for (Veiculo veiculo : veiculos) {
                // A palavra-chave 'instanceof' verifica o tipo real do objeto
                // A partir do Java 16, podemos usar "Pattern Matching" para simplificar o código. Ele combina o 'instanceof' e o 'cast' em uma única linha.
                if (veiculo instanceof Caminhao && clienteGrande) {
                    // Não precisamos de cast aqui, pois a lógica para o caminhão não exige o acesso a nenhum método ou atributo específico da classe `Caminhao`.
                    // Apenas adicionamos o `veiculo` genérico à lista, o que é suficiente.
                    veiculosSugeridos.add(veiculo);
                } else if (veiculo instanceof Carro carro) {
                    // A variável 'carro' já está declarada e pronta para uso
                    // Carros com porta-malas grande (>=450L) são considerados maiores/SUVs
                    if (clienteGrande && carro.getCapacidadePortaMalas() >= 450) {
                        veiculosSugeridos.add(carro);
                    } else if (!clienteGrande && carro.getCapacidadePortaMalas() < 450) {
                        veiculosSugeridos.add(carro);
                    }
                } else if (veiculo instanceof Moto moto) {
                    // O mesmo para a moto.
                    // Motos com mais de 500cc são consideradas maiores/mais robustas
                    if (clienteGrande && moto.getCilindradas() >= 500) {
                        veiculosSugeridos.add(moto);
                    } else if (!clienteGrande && moto.getCilindradas() < 500) {
                        veiculosSugeridos.add(moto);
                    }
                }
            }

            if (veiculosSugeridos.isEmpty()) {
                System.out.println("\nNenhum veículo em estoque parece ideal para o biotipo de " + cliente.getNome() + " no momento.");
            } else {
                System.out.println("\nCom base no biotipo, encontramos os seguintes veículos recomendados:");
                for (Veiculo veiculo : veiculosSugeridos) {
                    System.out.println("----------------------------------------");
                    veiculo.exibirInformacoes();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar a sugestão. Verifique os dados inseridos.");
        }
    }

    private static void mostrarVeiculos() {
        // 2. MÉTODO REATORADO: Simples, limpo e funciona para TUDO!
        if (!veiculos.isEmpty()) {
            System.out.println("### Lista de Veículos em Estoque ###");
            int x = 1;

            // Graças ao polimorfismo, o Java sabe qual `exibirInformacoes` chamar (se é de Carro, Moto ou Caminhao).
            for (Veiculo veiculo : veiculos) {
                System.out.println("--- Veículo " + x + " ---");
                veiculo.exibirInformacoes();
                System.out.println();
                x++;
            }
        } else {
            System.out.println("Nenhum veículo foi encontrado no estoque!");
        }
    }

    // Add "throws" para indicar que este método pode lançar nossa exceção checada (checked exception)
    private static void comprarVeiculo(Scanner scanner) throws PrecoCustoInvalidoException {
        try{
            System.out.println("### Adicionar Veículo ao Estoque ###");
            int escolha;

            System.out.println("Qual o tipo de veículo que será adicionado ao estoque?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Caminhão");
            System.out.println("0 - Voltar ao menu"); 
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 3) { // Ajustado o limite
                throw new InputMismatchException();
            }
            while (escolha != 0) {
                System.out.print("Digite a marca do veículo: ");
                String marca = scanner.nextLine();

                System.out.print("Digite o modelo do veículo: ");
                String modelo = scanner.nextLine();

                System.out.print("Digite o ano do veículo: ");
                int ano = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite a cor do veículo: ");
                String cor = scanner.nextLine();

                System.out.print("Digite o preço do veículo: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Digite o preço de CUSTO do veículo: ");
                double precoDeCusto = scanner.nextDouble();

                // LANÇANDO NOSSA EXCEÇÃO PERSONALIZADA
                if (precoDeCusto > preco) {
                    // Usamos String.format para ter controle total sobre a aparência da mensagem
                    String errorMessage = String.format("O preço de custo (R$ %.2f) não pode ser maior que o preço de venda (R$ %.2f).", precoDeCusto, preco);
                    throw new PrecoCustoInvalidoException(errorMessage);
                }

                scanner.nextLine();
            
                switch (escolha) {
                    case 1:
                        System.out.print("Digite o numero de portas veículo: ");
                        int nPortar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite o tipo de combustivel: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.print("Digite a capacidade do porta malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();
                        scanner.nextLine();

                        // "Veículo", do tipo Carro, adicionado diretamente na lista unificada "veiculos"
                        veiculos.add(new Carro(marca, modelo, ano, cor, preco, precoDeCusto, nPortar, tipoCombustivel, capacidadePortaMalas));
                        System.out.println("Carro modelo: "+modelo+", cadastrado com sucesso!");
                        escolha = 0;
                        break;
                    
                    case 2:
                        System.out.print("Digite as cilindradas do veiculo: ");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("O veiculo possui partida eletrica? S - sim, N - não");
                        String partida = scanner.nextLine();

                        /*boolean partidaEletrica;
                        if(partida == "S" || partida == "s"){ */
                        // CORREÇÃO: Em Java, strings devem ser comparadas com .equals() ou .equalsIgnoreCase()
                        /*if(partida.equalsIgnoreCase("S")){
                            partidaEletrica = true;
                        }else{
                            partidaEletrica = false;
                        } */

                        // DICA DE QUALIDADE: O resultado de .equalsIgnoreCase() já é um boolean.
                        // Podemos atribuí-lo diretamente à variável. Fica mais limpo e profissional.
                        boolean partidaEletrica = partida.equalsIgnoreCase("S");

                        System.out.print("Digite a categoria do veiculo: ");
                        String categoria = scanner.nextLine();

                        veiculos.add(new Moto(marca, modelo, ano, cor, preco, precoDeCusto, cilindradas, partidaEletrica, categoria));
                        System.out.println("moto modelo: "+modelo+", cadastrada com sucesso!");
                        escolha = 0;
                        break;

                    case 3: // NOVO CASO (Caminhão)
                        System.out.print("Digite a capacidade de carga (em toneladas): ");
                        double capacidadeCarga = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite o número de eixos: ");
                        int numeroEixos = scanner.nextInt();
                        scanner.nextLine();

                        veiculos.add(new Caminhao(marca, modelo, ano, cor, preco, precoDeCusto, capacidadeCarga, numeroEixos));
                        System.out.println("Caminhão modelo: " + modelo + ", cadastrado com sucesso!");
                        escolha = 0;
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                        break;
                }
            }
            
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }
    }

    private static void venderVeiculo(Scanner scanner) {
        try{
            if (clientes.isEmpty() || veiculos.isEmpty()) {
                System.out.println("Não é possível vender. Verifique se há clientes e veículos cadastrados.");
                return; // Sai do método
            }else{
                mostrarClientes();
                Pessoa comprador = clientes.get(scanner.nextInt()-1);
                scanner.nextLine();
                
                System.out.println("Qual veículo deseja vender? (Escolha pelo número)");
                mostrarVeiculos(); // Mostra todos os veículos disponíveis
                int indiceVeiculo = scanner.nextInt() - 1;
                
                // LANÇANDO NOSSA EXCEÇÃO PERSONALIZADA
                if (indiceVeiculo < 0 || indiceVeiculo >= veiculos.size()) {
                    throw new VeiculoNaoEncontradoException("Seleção inválida. O veículo número " + (indiceVeiculo + 1) + " não existe no estoque.");
                }
                scanner.nextLine();
                
                Veiculo veiculoParaVenda = veiculos.get(indiceVeiculo); // Agora esta linha é segura porque já verificamos o índice

                // Exibindo informações cruciais para o vendedor antes da negociação
                System.out.println("\n--- Informações para Negociação ---");
                System.out.printf("Veículo Selecionado: %s %s\n", veiculoParaVenda.getMarca(), veiculoParaVenda.getModelo());
                System.out.printf("Preço de Tabela: R$%.2f\n", veiculoParaVenda.getPreco());
                System.out.printf("Preço de Custo: R$%.2f\n", veiculoParaVenda.getPrecoDeCusto());
                System.out.println("------------------------------------");

                double valorFinalVenda;
                boolean vendaConfirmada = false;

                do {
                    System.out.print("\nInforme o valor proposto para a venda: R$");
                    valorFinalVenda = scanner.nextDouble();
                    scanner.nextLine();

                    double resultado = valorFinalVenda - veiculoParaVenda.getPrecoDeCusto();
                    System.out.printf("Resultado da operação: %s de R$%.2f\n", (resultado >= 0 ? "Lucro" : "Prejuízo"), resultado);

                    System.out.print("Confirmar esta venda? (S/N): ");
                    String confirmacao = scanner.nextLine();
                    if (confirmacao.equalsIgnoreCase("S")) {
                        vendaConfirmada = true;
                        vendas.add(new Venda(veiculoParaVenda, comprador, valorFinalVenda, LocalDateTime.now()));
                        veiculos.remove(indiceVeiculo);
                        System.out.println("\n>> Venda executada com sucesso! <<");
                    }
                } while (!vendaConfirmada);
            }
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (VeiculoNaoEncontradoException e){ // Capturando nossa exceção específica
            System.out.println("Erro ao Vender: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void mostrarClientes() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes ###");
            int x = 1;
            for (Pessoa cliente : clientes) {
                System.out.println(x+" - "+cliente.getNome()+" - "+cliente.getTelefone());
                x++;
                System.out.println("----------------------------------------");
            }
        }else{
            System.out.println("Nenhum cliente foi encontrado!"); 
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try{
            System.out.println("### Cadastro de Cliente ###");

            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.println("Digite um telefone para contato do cliente: ");
            String telefone = scanner.nextLine();

            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            System.out.println("Digite a altura do cliente (em metros, ex: 1.75): ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println("O cliente: "+nome+", foi cadastrado com sucesso!");
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
        }else{
            System.out.println("### Relatorio de vendas ###");
            System.out.println();
            // O formatador de data só precisa ser criado uma vez, fora do loop.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            for (Venda venda : vendas) {
               Veiculo veiculoVendido = venda.getVeiculo();
               double valorVenda = venda.getValor();
               double custoVeiculo = veiculoVendido.getPrecoDeCusto();
               double resultado = valorVenda - custoVeiculo;

               System.out.println("Data: "+ venda.getDataVenda().format(formatter));
               System.out.println("Veiculo: "+veiculoVendido.getModelo()+" - "+veiculoVendido.getAno());
               System.out.println("Comprador: "+venda.getComprador().getNome()+" - "+venda.getComprador().getTelefone());
               System.out.printf("Valor da venda: R$%.2f\n", valorVenda);
               System.out.printf("Custo do veículo: R$%.2f\n", custoVeiculo); // Adicionado para clareza

               if (resultado >= 0) {
                   System.out.printf("Lucro: R$%.2f\n", resultado);
               } else {
                   System.out.printf("Prejuízo: R$%.2f\n", resultado);
               }
               System.out.println("----------------------------------------------------------------"); 
               System.out.println();
            }
        }
    }
}
