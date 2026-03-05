package atv_9ListaClassificada;


public class TesteListaClassificada {

 public static void main(String[] args) {
     //  uma instância de lista para armazenar números inteiros
     ListaClassificadaEncadeada<Integer> lista = new ListaClassificadaEncadeada<>();

     System.out.println("--- 1. Testando Inserção Ordenada ---");
     lista.inserir(10);
     lista.inserir(5);
     lista.inserir(20);
     lista.inserir(15);
     lista.inserir(1);

     imprimirLista(lista); // Esperado: 1, 5, 10, 15, 20

     System.out.println("\n--- 2. Testando 'ehMembro' ---");
     System.out.println("A lista contém o número 15? " + lista.ehMembro(15)); // true
     System.out.println("A lista contém o número 99? " + lista.ehMembro(99)); // false

     System.out.println("\n--- 3. Testando 'procurar' e o Cursor ---");
     // Vamos procurar o elemento 10
     ICursor<Integer> cursor = lista.procurar(10);

     if (cursor != null) {
         System.out.println("Elemento encontrado pelo cursor: " + cursor.getDado());
         
         // Usando o cursor para inserir um novo elemento depois do 10
         System.out.println("Inserindo o número 12 depois do 10 usando o cursor...");
         cursor.inserirDepois(12);
         imprimirLista(lista); // Esperado: 1, 5, 10, 12, 15, 20

         // Usando o cursor para remover o elemento que ele aponta (o 10)
         System.out.println("Removendo o elemento 10 usando o cursor...");
         try {
             cursor.remover();
         } catch (Exception e) {
             e.printStackTrace();
         }
         imprimirLista(lista); // Esperado: 1, 5, 12, 15, 20

     } else {
         System.out.println("Elemento 10 não foi encontrado.");
     }
     
     System.out.println("\n--- 4. Testando Remoção Direta ---");
     try {
         System.out.println("Removendo o elemento 20...");
         lista.remover(20);
         imprimirLista(lista); // Esperado: 1, 5, 12, 15

         System.out.println("Removendo o elemento 1...");
         lista.remover(1);
         imprimirLista(lista); // Esperado: 5, 12, 15

     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 // Método auxiliar para imprimir a lista de forma legível
 public static void imprimirLista(ListaClassificadaEncadeada<Integer> lista) {
     System.out.print("Estado atual da lista: [ ");
     for (int i = 0; i < lista.count; i++) {
         System.out.print(lista.getDado(i) + (i == lista.count - 1 ? "" : ", "));
     }
     System.out.println(" ]");
 }
}
