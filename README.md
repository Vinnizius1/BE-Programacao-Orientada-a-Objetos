# Projeto Final - Programação Orientada a Objetos

Este repositório é um fork do projeto original do professor para a disciplina. Todo o desenvolvimento e as implementações da avaliação final foram realizados exclusivamente dentro do diretório **`Unidade 04`**.

## Visão Geral do Projeto (Unidade 04)

O projeto da Unidade 4 consiste em um sistema de gerenciamento para uma concessionária de veículos. A partir do código base, foram implementadas diversas funcionalidades, refatorações e correções, aplicando os conceitos fundamentais da Programação Orientada a Objetos para criar uma aplicação robusta, extensível e segura.

## Principais Implementações e Conceitos Aplicados

### 1. Polimorfismo e Herança

- **Novo Veículo (`Caminhao`):** Foi adicionada a classe `Caminhao`, que herda de `Veiculo`, demonstrando a extensibilidade do sistema.
- **Lista Unificada:** O sistema foi refatorado para utilizar uma única lista (`List<Veiculo>`) para armazenar todos os tipos de veículos (Carros, Motos e Caminhões).
- **Métodos Polimórficos:** O método `exibirInformacoes()` foi sobrescrito em cada subclasse, permitindo que uma única chamada no laço de repetição exiba os detalhes específicos de cada tipo de veículo, um exemplo clássico de polimorfismo.

### 2. Lógica de Negócio Avançada

- **Sugestão por Biotipo:** Foi implementado um método inteligente que sugere veículos com base na altura e peso do cliente. A lógica utiliza `instanceof` para verificar o tipo do veículo e `casting` para acessar atributos específicos (como cilindradas da moto ou capacidade do porta-malas do carro).
- **Cálculo de Lucro:** O modelo de dados foi aprimorado com a adição do `precoDeCusto` aos veículos. O relatório de vendas agora calcula e exibe o lucro ou prejuízo real de cada transação.

### 3. Robustez e Tratamento de Exceções

- **Exceções Personalizadas:** Foram criadas duas exceções para lidar com regras de negócio específicas:
  - `PrecoCustoInvalidoException` (Checked): Garante que o preço de custo não seja maior que o preço de venda durante o cadastro.
  - `VeiculoNaoEncontradoException` (Unchecked): Lançada quando o usuário tenta selecionar um veículo com um índice inválido.
- **Tratamento de Entradas:** O sistema foi fortalecido para lidar com entradas inválidas do usuário (`InputMismatchException`) e encerramento abrupto (`Ctrl+C`), fornecendo feedback claro em vez de quebrar.

### 4. Busca e Correção de Bugs

Foi realizada uma análise completa do código para identificar e corrigir bugs. As correções estão documentadas no arquivo `BUGS_CORRIGIDOS.md` e incluem:

- Correção na comparação de Strings (usando `.equals()` em vez de `==`).
- Resolução do problema de "pulo" de leitura do `Scanner` após ler números.
- Padronização da leitura de números decimais para aceitar pontos (`.`) independentemente da configuração do sistema.
