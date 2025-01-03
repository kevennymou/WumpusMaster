# Jogo do Wumpus - Algoritmo de Busca Inteligente

## 📜 Descrição do Projeto

<p style="text-align: justify;">Este projeto implementa um jogo, no qual um robô inteligente, chamado Wumpus, deve encontrar o baú do tesouro em um cenário repleto de perigos, representado por uma matriz 8x8. Durante sua jornada para encontrar o tesouro, Wumpus precisa evitar obstáculos, como pedras e monstros, além de lidar com armadilhas que podem estar nos baús.</p>

<p style="text-align: justify;">A proposta desse jogo, é utilizar estratégias, como: menor distância, menos obstáculos, cada uma utilizando seus algoritmos de busca, para mostrar o melhor caminho ao Wumpus, evitando os perigos: obstáculos, para que ele possa sair vivo dessa, e com seu tesouro!</p>

## 🎯 Objetivo do Jogo

- O robô deve encontrar o baú do tesouro.
- Evitar obstáculos: pedras e monstros.
- Desviar de armadilhas nos baús, aplicando condições específicas.
- Utilizar estratégias de busca inteligentes para determinar o melhor caminho.

## 🛠️ Estrátegias e Algoritmos de busca utilizados

#### 1. Método Guloso
**Estratégia:** Menor distância (**Shortest Distance**).

  - Determina a menor distância que o robô deve percorrer para chegar ao tesouro.
  - A lógica utiliza a distância de Manhattan para priorizar o ponto mais próximo do tesouro.
  - Faz a verficação dos caminhos disponíveis para evitar bloqueios.
  - O algoritmo assegura que o robô não escolha posições onde todos os caminhos futuros estejam bloqueados.

##### Vantagens:
  - **Eficiência Computacional:** Avalia apenas as opções viáveis localmente, economizando recursos.
  - **Gestão de Bloqueios:** Identifica cenários bloqueados e interrompe o processamento com mensagens de erro, evitando loops infinitos.
  - **Flexibilidade:** Funciona bem em mapas dinâmicos ou estáticos.

##### Desvantagens:
  - **Otimização Local vs. Global:** Pode não encontrar o caminho ideal em termos globais.
  - **Dependência do Cenário:** Eficiência depende da distribuição de obstáculos e do tesouro.
  - **Erros em Caso de Empates:** Em situações com múltiplos caminhos de mesma distância, a estratégia escolhe arbitrariamente o primeiro na lista.

---

#### 2. Método Guloso
**Estratégia:** Menor número de obstáculos (**Fewer Obstacles**).

  -  Seleciona o ponto adjacente com o menor número de obstáculos.
  -  Evita pontos bloqueados e prioriza caminhos que sejam mais seguros ou eficientes para o deslocamento.
    
 ##### Vantagens:
   - **Simplicidade de implementação:** Cada decisão é feita com base em informações locais, sem necessidade de avaliar todo o mapa.
   - **Baixa complexidade computacional:** Avalia apenas os vizinhos imediatos, o que é eficiente em tempo de execução.

##### Desvantagens:
   - **Local vs. Global:** Como decisões locais são priorizadas, o algoritmo pode não encontrar o caminho globalmente mais eficiente.
   - **Dependência da Configuração do Cenário:** O desempenho é impactado por como os obstáculos e tesouros estão distribuídos.

___

#### 3. Votação
**Estratégia:** Voting.

  - **A estratégia Voting utiliza a seguinte lógica:**

    <p style="text-align: justify;">É uma técnica híbrida, que combina várias estratégias de tomada de decisão utilizando o método de votação. 
      Assim, cada estratégia fornece uma perspectiva complementar para avaliar as opções disponíveis. Então, a opção mais votada, é a utilizada.</p>
  
     - **Sistema de Votação:**
         - Cada estratégia retorna um ponto como melhor opção.
         - Os pontos escolhidos pelas três estratégias são contabilizados.
         - O ponto com maior número de votos é selecionado como o próximo passo.
         - Caso dois ou mais pontos tenham o mesmo número de votos, uma lógica alternativa pode ser implementada para decidir o desempate.

    ##### Vantagens:
    - **Flexibilidade:** Permite a integração de múltiplos critérios sem priorizar um sobre o outro.
    - **Robustez:** Reduz a probabilidade de erros ao combinar diferentes estratégias.
    - **Escalabilidade:** Outras estratégias podem ser adicionadas ao sistema de votação sem grandes alterações no código.
      
    ##### Desvantagens:
     - **Dependência de Estratégias:** A eficácia do sistema depende da qualidade das estratégias individuais utilizadas.
     - **Complexidade Computacional:** O cálculo combinado de várias heurísticas pode aumentar o tempo de execução.

---

#### 4. Busca Binária

  **Estratégia:** Busca em Profundidade - DSF (
      - É baseada em árvores binárias para a movimentação do robô.
      - É construída uma árvore binária para representar o mapa.
      - Realiza uma busca em profundidade (DFS) para encontrar o caminho até o tesouro e decide o próximo movimento do robô.

##### Vantagens:
  - **Representação Estrutural:** A árvore binária permite uma visão organizada do mapa.
  - **Busca Otimizada:** A DFS reduz o espaço de busca ao explorar apenas caminhos viáveis.
    
##### Desvantagens:
 - **Escalabilidade:** Em mapas grandes, a árvore binária pode consumir muita memória.
 - **Eficiência:** A DFS explora caminhos sequencialmente, o que pode ser lento em mapas complexos.

---

## 🏃 Como Executar o Projeto

#### 1️⃣ Abra o Projeto na IDE:

   1. Certifique-se de que você tem uma IDE instalada (Eclipse, IntelliJ IDEA ou VS Code com extensão para Java).
  
   2. Importe o projeto:
      
   - **Eclipse:** Selecione **File > Open Projects from File System** e escolha a pasta do projeto.
   - **IntelliJ IDEA:** Clique em **File > Open** e selecione a pasta do projeto.
   - **Visual Studio Code:** Abra a pasta do projeto diretamente. 
   
  #### 2️⃣ Escolha a Estratégia:
  
   1. Selecione o package **game** e abra o arquivo **Game.java**.
   2. Na linha **this.player = new Player(new Sort())** escolha a estrátegia como parâmetro para utilizá-la.
     
  #### 3️⃣ Execute o Arquivo Principal:

  1. Selecione o package **main** e abra o arquvivo **Execute.java**.
  2. Clique com o botão direito no arquivo e selecione **Run** ou **Run Main**.

---

### 🎮 Aproveite o jogo! Desfrute de cada estratégia, supere os desafios e conquiste o tesouro! Boa sorte, aventureiro! 🏆



           
         






 







