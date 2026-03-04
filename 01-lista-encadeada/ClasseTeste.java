package atv2_listaSimplesmenteEncadeada;


public class ClasseTeste {
	public static void main(String[]args) {
		ListaEncadeada MinhaLista= new ListaEncadeada();
		
		try {
		
			System.out.println("adicionar 4 e 3");
			MinhaLista.inserirInicio(4);
			MinhaLista.inserirFim(3);
			MinhaLista.imprimir(); // a lista vai ficar 4 3
			
			System.out.println("remover 4");
			MinhaLista.extrair(4);
			MinhaLista.imprimir();// a lista vai ficar 3
			
			System.out.println("inserir 7 depois do 3 e 8 antes do 3");
			MinhaLista.inserirFim(7);
			MinhaLista.inserirInicio(8);
			MinhaLista.imprimir(); /// a lista vai ficar 8 3 7
			
			System.out.println("imprimir o primeiro e ultimo elemento");
			System.out.println("o primeiro elemento e:"+MinhaLista.getPrimeiro());
			System.out.println("o ultimo elemento e:"+MinhaLista.getUltimo()+"\n");
			
			System.out.println("verificar se a lista ta vazia");
			System.out.println(MinhaLista.estaVazia()+"\n"); // vai retornar falso
			
			System.out.println("copiar lista,a novaLista vai copiar a minhalista");
			ListaEncadeada NovaLista = new ListaEncadeada();
			NovaLista.atribuir(MinhaLista);
			NovaLista.imprimir();
			
			System.out.println("inserir 20 antes do 3");
		    ListaEncadeada.Element Elemento3= MinhaLista.getHead().getNext(); //fazer Element3 apontar pro segundo no que conten o 3	    
		    Elemento3.inserirAntes(20);
		    MinhaLista.imprimir(); //vai imprimir 8 20 3 7
		    
		    System.out.println("inserir 55 depois do 3");
		    
		    ListaEncadeada.Element ptr3 =MinhaLista.getHead(); //vai apontar pro primeiro elemento
		    while(ptr3 !=null && !ptr3.getData().equals(3)) { //vai percorrer ate encontrar a referencia pro elemento 3 e guardar em ptr3
		    	ptr3 = ptr3.getNext();
		    }
		   ptr3.inserirDepois(55); //dai usa essa referencia pra inserir o elemento depois dele		
		   MinhaLista.imprimir(); //vai imprimir 8 20 3 55 7
		   
		   System.out.println("esvaziando a lista:");
		   MinhaLista.fazVazia();
		   MinhaLista.imprimir(); 
		   
		   System.out.println("imprimindo primeiro elemento da lista vazia");
		   System.out.println( MinhaLista.getPrimeiro());
		  
		}catch(ObjetoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		
		}catch(ListaVaziaException e) {
		System.out.println(e.getMessage());
	
	    }
		}
	
	

}
