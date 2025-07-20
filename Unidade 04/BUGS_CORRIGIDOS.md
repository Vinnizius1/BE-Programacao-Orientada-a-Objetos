# Relatório de Busca e Correção de Bugs

Este documento detalha os bugs identificados e corrigidos no sistema da concessionária, conforme a Tarefa 7 da avaliação.

---

### Bug 1: Comparação Incorreta de Strings

- **Sintoma:** A verificação de partida elétrica na Moto (`S/N`) não funcionava corretamente. Mesmo digitando "S", a condição era avaliada como falsa.
- **Causa Raiz:** O código utilizava o operador `==` para comparar strings (`partida == "S"`). Em Java, `==` compara as referências de memória dos objetos, e não o seu conteúdo.
- **Correção Aplicada:** O operador `==` foi substituído pelo método `.equalsIgnoreCase()`. Este método compara o conteúdo das strings, ignorando diferenças entre maiúsculas e minúsculas, tornando a verificação robusta e correta.

```java
// Antes
if(partida == "S" || partida == "s")

// Depois
if(partida.equalsIgnoreCase("S"))
```

---

### Bug 2: `Scanner` Pulando a Leitura de Texto

- **Sintoma:** Em várias partes do sistema (cadastro de veículo, cliente, etc.), após a leitura de um número (`.nextInt()` ou `.nextDouble()`), o programa pulava a próxima solicitação de texto (`.nextLine()`).
- **Causa Raiz:** Os métodos `.nextInt()` e `.nextDouble()` leem o número, mas deixam o caractere de nova linha (`\n`), gerado ao pressionar Enter, no buffer de entrada. A chamada seguinte a `.nextLine()` consumia essa linha vazia e seguia adiante.
- **Correção Aplicada:** Foi adicionada uma chamada extra a `scanner.nextLine()` imediatamente após cada leitura de número para consumir o caractere de nova linha pendente, limpando o buffer e garantindo que a próxima leitura de texto funcione como esperado.

---

### Bug 3: Erro de Formato de Número (`InputMismatchException`) com Ponto Decimal

- **Sintoma:** Ao digitar um número decimal com ponto (ex: `1.75` para altura), o programa lançava uma `InputMismatchException`.
- **Causa Raiz:** O `Scanner` estava usando a localidade padrão do sistema operacional (pt-BR), que espera uma vírgula (`,`) como separador decimal.
- **Correção Aplicada:** A instância do `Scanner` foi configurada para usar a localidade `Locale.US`, que utiliza o ponto como separador decimal. Isso torna o programa consistente e independente da configuração da máquina onde é executado.

```java
// Antes
Scanner scanner = new Scanner(System.in);

// Depois
Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
```

---

### Bug 4: Tratamento de Encerramento Abrupto (`Ctrl+C`)

- **Sintoma:** Ao pressionar `Ctrl+C` para fechar o programa, uma mensagem de erro "Erro desconhecido: null" era exibida.
- **Causa Raiz:** O `Ctrl+C` lança uma `NoSuchElementException`, que não estava sendo tratada especificamente e era capturada pelo `catch (Exception e)` genérico. A mensagem dessa exceção é `null`.
- **Correção Aplicada:** Foi adicionado um bloco `catch` específico para `NoSuchElementException`. Em vez de mostrar um erro, ele exibe uma mensagem amigável ("Programa encerrado pelo usuário.") e finaliza o loop principal de forma limpa.
