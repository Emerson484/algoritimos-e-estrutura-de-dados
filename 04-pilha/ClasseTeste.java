package atv4_pilha;

public class ClasseTeste {

    public static void main(String[] args) {

        System.out.println("testando metodos da pilha");
        Pilha<String> pilha = new PilhaEncadeada<>();

        System.out.println("Pilha criada. Vazia? " + pilha.estaVazia()); // Esperado: true

        System.out.println("adicionando elementos: primeiro,segundo,e terceiro(topo)");
        // 1. Empilhar (push)
        pilha.push("Primeiro");
        pilha.push("Segundo");
        pilha.push("Terceiro (Topo)");
        System.out.println("\nApós adicionar 3 eelmentos ,a pila esta vazia? " + pilha.estaVazia()); // Esperado: false

        try {
            // 2. retorna topo da pilha (getTop) e remover (pop)
            System.out.println("Topo atual: " + pilha.getTop()); // Esperado: Terceiro (Topo)
            System.out.println("Item removido: " + pilha.pop());   // Esperado: Terceiro (Topo)
            System.out.println("Novo topo: " + pilha.getTop());     // Esperado: Segundo

            // 3. Esvaziar o resto
            System.out.println("Item removido: " + pilha.pop());   // Esperado: Segundo
            System.out.println("Item removido: " + pilha.pop());   // Esperado: Primeiro

        } catch (Exception e) {
            System.out.println("Um erro inesperado ocorreu: " + e.getMessage());
        }

        System.out.println("\nApós esvaziar,esta Vazia? " + pilha.estaVazia()); // Esperado: true

        // 4. Testar exceção em pilha vazia
        System.out.println("\nTestando pop() em pilha vazia...");
        try {
            pilha.pop();
        } catch (ContainerVazioException e) {
            System.out.println("execao capturada: " + e.getClass());
        } catch (Exception e) {
            System.out.println("ERRO: Capturada exceção inesperada: " + e.getMessage());
        }

        // 5. Testar fazVazia()
        System.out.println("\nTestando metodo fazVazia()...");
        System.out.println("adicionando item a e item b");
        pilha.push("Item A");
        pilha.push("Item B");
        System.out.println("Pilha com itens. Vazia? " + pilha.estaVazia()); // Esperado: false
        pilha.fazVazia();
        System.out.println("Após fazVazia. Vazia? " + pilha.estaVazia()); // Esperado: true

        
    }
}
