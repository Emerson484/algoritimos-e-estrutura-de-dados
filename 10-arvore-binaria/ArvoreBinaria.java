package atv11_ArvoreBinaria;

/**
 * ATIVIDADE VII: Árvore Binária (Estrutura Não-Linear).
 * - Diferente da Árvore de Busca, esta implementação não utiliza o valor para decidir o lado da inserção.
 * - A inserção é feita por nível (em largura) para garantir que a árvore seja preenchida de forma equilibrada.
 * - A busca torna-se exaustiva (percorre ambos os lados), pois não há garantia de ordenação dos nós.
 */
public class ArvoreBinaria <T extends Comparable<T>> {
    Node <T> raiz;
    
    public ArvoreBinaria() {
        this.raiz = null;
    }

    /* 
       Buscamos o primeiro espaço vazio disponível usando uma Fila para manter a árvore compacta. */
    public void inserirNo(T valor) throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException {
        Node<T> novoNo = new Node<>(valor);
        
        if (raiz == null) { // se a arvore tiver vazia
            this.raiz = novoNo;
            return;
        }

        // Usamos uma fila para achar o primeiro nó que tem um filho nulo (Inserção em Largura)
        FilaEncadeada<Node<T>> fila = new FilaEncadeada<>();
        fila.enfileirar(raiz);

        while (!fila.estaVazia()) {
            Node<T> atual = (Node<T>) fila.desinfileirar();

            // Verifica se pode inserir à esquerda
            if (atual.getFilhoEsquerda() == null) {
                atual.setFilhoEsquerda(novoNo);
                break;
            } else {
                fila.enfileirar(atual.getFilhoEsquerda());
            }

            // Verifica se pode inserir à direita
            if (atual.getFilhoDireita() == null) {
                atual.setFilhoDireita(novoNo);
                break;
            } else {
                fila.enfileirar(atual.getFilhoDireita());
            }
        }
    }

    public void imprimirPreOrdem(Node<T> atual) {
        if(atual!=null) {
            System.out.print(atual.getValor()+" ");
            imprimirPreOrdem(atual.getFilhoEsquerda());
            imprimirPreOrdem(atual.getFilhoDireita());
        }
    }
    
    public void imprimirPosOrdem(Node<T> atual) {
        if(atual!=null) {
            imprimirPosOrdem (atual.getFilhoEsquerda());
            imprimirPosOrdem (atual.getFilhoDireita());
            System.out.print(atual.getValor()+" ");
        }
    }

    public void imprimirOrdemSimetrica(Node<T> atual) {
        if(atual!=null) {
            imprimirOrdemSimetrica(atual.getFilhoEsquerda());
            System.out.print(atual.getValor()+" ");
            imprimirOrdemSimetrica(atual.getFilhoDireita());
        }
    }
    
    public void imprimirEmLargura() throws ContainerVazioException,ListaVaziaException,ObjetoNaoEncontradoException  {
        if(raiz==null) {
            System.out.println("arvore vazia");
        }
        
        FilaEncadeada<Node<T>> fila = new FilaEncadeada<>();
        fila.enfileirar(raiz); // this vai ser a raiz da arvore que usar o metodo
        Node<T> no;
        
        while(!fila.estaVazia()) {
            no =(Node<T>) fila.desinfileirar();
            
            if(no.getFilhoEsquerda()!=null) {
                fila.enfileirar( no.getFilhoEsquerda() ); //o metodo enfileirar so recebe tipo T e nao
                // Node <T> por isso a conversao pra T
            }
            
            if(no.getFilhoDireita()!=null) {
                fila.enfileirar( no.getFilhoDireita());
            }
            
            System.out.print(no.getValor()+" ");
        }
    }

    /*Na Árvore Binária comum, a busca não pode descartar lados.
      por isso deve criar um metodo para procurar recursivamente na esquerda e, se não achar, na direita. */
    public Node<T> procurarValor(T valor) {
        return auxiliarProcurar(raiz, valor);
    }

    private Node<T> auxiliarProcurar(Node<T> atual, T valor) {
        if (atual == null) return null;
        if (atual.getValor().equals(valor)) return atual; // Encontrou o nó

        // Busca na subárvore esquerda
        Node<T> noEncontrado = auxiliarProcurar(atual.getFilhoEsquerda(), valor);
        
        // Se não encontrar na esquerda, busca na direita
        if (noEncontrado == null) {
            noEncontrado = auxiliarProcurar(atual.getFilhoDireita(), valor);
        }
        
        return noEncontrado;
    }

    public int CalcularAltura() throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
        return auxiliarCalcularAltura(raiz);
    }

    public int auxiliarCalcularAltura(Node<T> no) throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
        if(no==null) {
            return 0;
        }
        int alturaEsquerda=0;
        int alturaDireita=0;
        
        if(no.getFilhoEsquerda()!=null) {
            alturaEsquerda = auxiliarCalcularAltura(no.getFilhoEsquerda())+1;
        }
        if(no.getFilhoDireita()!=null) {
            alturaDireita = auxiliarCalcularAltura(no.getFilhoDireita())+1;
        }
        
        if(alturaEsquerda>alturaDireita) {
            return alturaEsquerda;
        } else {
            return alturaDireita; // caso dos 2 iguais
        }
    }
    
    public int calcularTotalNodes() {
        int total = calcularTotalNodes(raiz);
        return total;
    }

    public int calcularTotalNodes(Node<T> atual) {
        int totalNosEsquerda=0;
        int totalNosDireita=0;
        if(atual == null) return 0;
        if(atual.getFilhoEsquerda()!=null) {
            totalNosEsquerda = calcularTotalNodes(atual.getFilhoEsquerda());
        }
        if(atual.getFilhoDireita()!=null) {
            totalNosDireita = calcularTotalNodes(atual.getFilhoDireita());            
        }
        return totalNosEsquerda + totalNosDireita + 1;
    }
}
