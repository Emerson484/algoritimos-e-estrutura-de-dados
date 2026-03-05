package atv6_FilaComListaEncadeada;

public class FilaTeste {
	public static void main (String[]args) {
		FilaEncadeada <Integer> fila = new FilaEncadeada<>();
		
		System.out.println("testando o metodo esta vazia com lista vazia,esta vazia? "+ fila.estaVazia()+"\n");
		
		System.out.println("adicionando elementos 1 ,7,8,3"+"\n");
		fila.enfileirar(1);
		fila.enfileirar(7);
		fila.enfileirar(8);
		fila.enfileirar(3);
		
		System.out.println("testando o metodo esta vazia apos adicionar 1,7,8,3,esta vazia? "+ fila.estaVazia()+"\n");
		
		try {
			System.out.println("obtendo o primeiro elemento da fila :"+fila.getPrimeiro()+"\n");
			
			System.out.println("usando metodo pra desinfileirar,o que vai fazer com que o 1 seja removido");
			System.out.println(fila.desinfileirar()+"\n");
	
			
			System.out.println("removendo o 7 que virou o novo primeiro elemento:");
			System.out.println(fila.desinfileirar()+"\n");
			
			System.out.println("apos isso vai ficar o elemento 8 e 3,dai vamos adicionar o 5,pra ficar 8 3 5");
			fila.enfileirar(5);
			
			System.out.println("esvaziando a fila...");
			fila.fazVazia();
			
			System.out.println("verificando se esta vazia");
			fila.estaVazia();
			
			
		}catch (ListaVaziaException lve) {
			lve.getMessage();
	     
		}catch (ContainerVazioException lve) {
			lve.getMessage();
		
		}catch (ObjetoNaoEncontradoException onee) {
			onee.getMessage();
			
		}
		
		
	}
	

}
