package trabalhoShellSort;

import java.util.Arrays;
import java.util.Random;

public class ClasseTeste {

    public static void main(String[] args) {
        // --- 1. Configuração do Teste ---
        int TAMANHO = 10000; // 10 mil elementos
        int[] arrayOriginal = criarArrayAleatorio(TAMANHO);
        
        // Criando cópias para cada algoritmo testar os mesmos dados
        int[] arrayParaBubble = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        int[] arrayParaInsertion = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        int[] arrayParaShell = Arrays.copyOf(arrayOriginal, arrayOriginal.length);

        AlgoritmosDeOrdenacao ordenador = new AlgoritmosDeOrdenacao();

        System.out.println("Iniciando teste de performance com " + TAMANHO + " elementos...");
        System.out.println("-------------------------------------------------");

        // --- 2. Teste do Bubble Sort ---
        long inicio = System.nanoTime();
        ordenador.bubbleSort(arrayParaBubble);
        long fim = System.nanoTime();
        long duracaoBubble = (fim - inicio) / 1000000; // Convertendo para milissegundos
        System.out.println("Bubble Sort:   " + duracaoBubble + " ms");

        // --- 3. Teste do Insertion Sort ---
        inicio = System.nanoTime();
        ordenador.insertionSort(arrayParaInsertion);
        fim = System.nanoTime();
        long duracaoInsertion = (fim - inicio) / 1000000;
        System.out.println("Insertion Sort: " + duracaoInsertion + " ms");

        // --- 4. Teste do Shell Sort (para comparação) ---
        inicio = System.nanoTime();
        ordenador.shellSort(arrayParaShell);
        fim = System.nanoTime();
        long duracaoShell = (fim - inicio) / 1000000;
        System.out.println("Shell Sort:     " + duracaoShell + " ms");
        System.out.println("-------------------------------------------------");

    }

    /**
     * Método auxiliar para criar um array com números aleatórios.
     */
    public static int[] criarArrayAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(tamanho * 10);
        }
        return arr;
    }
}
