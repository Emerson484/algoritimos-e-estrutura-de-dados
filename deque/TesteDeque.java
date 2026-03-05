package atv7_Deque;

// Importando as classes necessárias
//import atv6_filaComArray.ContainerCheioException;
//import atv6_filaComArray.ContainerVazioException;

public class TesteDeque {

    public static void main(String[] args) {

        IDeque<Integer> deque = new DequeArray<>(5);
        System.out.println("--- Teste Resumido e Completo do Deque ---");
        System.out.println("Capacidade do Deque: 5");

        try {
            // 1. Testando estaVazia() em um deque novo
            System.out.println("\n1. Deque está vazio no início? " + deque.estaVazia()); // Esperado: true

            // 2. Testando enfileirarFim() e enfileirarInicio()
            System.out.println("\n2. Enfileirando 30, 40 (FIM) e 20, 10 (INÍCIO)...");
            deque.enfileirarFim(30);
            deque.enfileirarFim(40);
            deque.enfileirarInicio(20);
            deque.enfileirarInicio(10);
            // Conteúdo esperado do Deque: [10, 20, 30, 40]

            // 3. Testando getPrimeiro() e getUltimo()
            System.out.println("3. Primeiro elemento: " + deque.getPrimeiro()); // Esperado: 10
            System.out.println("   Último elemento: " + deque.getUltimo());   // Esperado: 40

            // 4. Testando desenfileirarFim()
            System.out.println("\n4. Removendo do FIM: " + deque.desinfileirarFim()); // Remove o 40
            
            // 5. Testando desenfileirarInicio()
            System.out.println("5. Removendo do INÍCIO: " + deque.desinfileirarInicio()); // Remove o 10
            System.out.println("   > Novo primeiro: " + deque.getPrimeiro() + " | Novo último: " + deque.getUltimo()); // Esperado: 20 | 30

            // 6. Testando fazVazia()
            System.out.println("\n6. Esvaziando o deque com o método fazVazia()...");
            deque.fazVazia();
            System.out.println("   Deque está vazio agora? " + deque.estaVazia()); // Esperado: true

            // 7. Forçando a exceção ContainerVazioException
            System.out.println("\n7. Tentando remover de um deque já vazio para testar a exceção...");
            deque.desinfileirarFim(); // Esta linha vai falhar e pular para o 'catch'

        } catch (ContainerVazioException | ContainerCheioException e) {
            // Este bloco captura qualquer uma das exceções esperadas
            System.out.println("\nSUCESSO AO CAPTURAR A EXCEÇÃO ESPERADA!");
            System.out.println("   > Tipo da exceção: " + e.toString());
        }

        System.out.println("\n--- Teste finalizado com sucesso ---");
    }
}
