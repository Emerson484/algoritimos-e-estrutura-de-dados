# algoritimos-e-estrutura-de-dados

Este repositório reúne o material prático e as implementações desenvolvidas durante a disciplina algoritimos e estruturas de dados. O objetivo é consolidar conceitos fundamentais de organização de dados e eficiência de algoritmos utilizando a linguagem Java.

📂 Conteúdo Prático
Estruturas Lineares: Listas Simplesmente Encadeadas, Pilhas e Filas.

Estruturas Não-Lineares: Árvores Binárias (BST), Árvores AVL e Árvores N-árias.

Mapeamento de Dados: Implementação de Tabelas Hash.

Aplicações Práticas e Algoritmos Específicos:Algoritmos para Transformação de Expressões Aritméticas (Aplicações práticas com Pilha),Simulação de Fila de Supermercado com controle de tempo de chegada (Aplicações práticas com Fila)

🎯 Destaques Técnicos e Engenharia de Soluções

Este repositório demonstra a aplicação de conceitos avançados de computação para a construção de sistemas eficientes e escaláveis. Os principais diferenciais técnicos incluem:

⚙️ Alta Reusabilidade com Generics (Type Safety)

Abstração Avançada: Todas as estruturas foram implementadas utilizando Tipos Genéricos (<T>), permitindo que as coleções manipulem qualquer objeto de forma segura e flexível.
Segurança em Tempo de Compilação: Foco total em evitar erros de Cast e garantir que as estruturas sejam robustas para diferentes contextos de dados.

🚀 Otimização e Complexidade Algorítmica (O Notation)

Balanceamento de Árvores (AVL): Implementação de rotações para garantir que a árvore permaneça balanceada, mantendo a complexidade de busca em O(\log n) mesmo em cenários de inserção desordenada.
Eficiência em Acesso (Hash): Desenvolvimento de funções de espalhamento e tratamento de colisões para busca e inserção em tempo constante (O(1)) médio.
Percursos Inteligentes: Implementação de algoritmos de busca em largura (BFS) e profundidade (DFS), essenciais para navegação eficiente em árvores.

🏢 Modelagem de Problemas Reais

Simulação de Sistemas: Uso de Filas Encadeadas para modelar o fluxo de clientes em caixas de supermercado, considerando variáveis de tempo de chegada e processamento.
Processamento de Expressões: Aplicação de Pilhas para transformar e avaliar expressões aritméticas, demonstrando domínio sobre precedência de operadores e estruturas LIFO (Last-In, First-Out).

💎 Boas Práticas e Clean Code

Encapsulamento Estrito: Proteção da lógica interna das estruturas, expondo apenas contratos (métodos públicos) necessários para a interação.
Recursividade vs Iteração: Domínio de técnicas recursivas para cálculos de altura e percursos, contrastando com soluções iterativas para otimização de memória.
Modularidade: Divisão clara entre os nós (Node), a lógica de controle e as classes de teste.


🛠️ Como executar o projeto

Certifique-se de ter o JDK (Java Development Kit) instalado.

Clone o repositório:
git clone https://github.com/Emerson484/algoritimos-e-estruturas-de-dados.git

Importe o projeto em uma IDE (IntelliJ IDEA, Eclipse, VS Code ou NetBeans).

Navegue até a pasta da atividade desejada (ex:Fila de Supermercado).

Execute o arquivo principal (Main.java).
