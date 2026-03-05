package trabalhoShellSort;

public class CompararAlgoritmosDeOrdenacao {

    /**
     * BUBBLE SORT 
     * Complexidade: O(n²)
     * Lento, compara pares adjacentes e "flutua" o maior para o final.
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        // Loop externo controla as passagens
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            // Loop interno faz as comparações e trocas
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            // Otimização: se não houve trocas nesta passagem, está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    /**
     * INSERTION SORT (Ordenação por Inserção)
     * Complexidade: O(n²)
     * Mais rápido que o Bubble Sort na prática. Constrói a lista ordenada
     * pegando um elemento por vez e inserindo-o na posição correta.
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int chave = arr[i]; // O elemento a ser inserido
            int j = i - 1;

            // Move os elementos maiores que a 'chave' para a direita
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Insere a 'chave' na posição correta
            arr[j + 1] = chave;
        }
    }

    /**
     * SHELL SORT 
     * Complexidade: O(n^(4/3)) ou O(n^(3/2))
     * Muito mais rápido que O(n²). É uma otimização do Insertion Sort.
     */
    public void shellSort(int[] arr) {
        int n = arr.length;

        // Inicia com o gap e vai reduzindo
        for (int gap = n / 3; gap > 0; gap /= 3) { // gap igual a n/3
            // Aplica o Insertion Sort com o 'gap' atual
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
