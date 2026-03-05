package atv6_FilaComListaEncadeada;

public class ListaEncadeadaGenerica <T> {
	private Element head;
	private Element tail;
	
	//classe element
	public final class Element {
		private T data; //tipo de elemento que vai armazenar (so os dados sao do tipo generico,os ponteiros nao)
		private Element next; //referencia ao proximo elemento
		
		public Element(T data, Element next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Element getNext() {
			return next;
		}

		public void getNext(Element head) {
			
			
		}

		public void setData(T data) {
			this.data = data;
		}

		public void setNext(Element next) {
			this.next = next;
		}
	   //Método inserirDepois()
		public void inserirDepois(T item) {
			this.next= new Element(item,this.next); // o lado direito vai criar um elemento com o ponteiro apontando
			//pro mesmo no que o objeto que usou o metodo 
			//em seguida o ponteiro do objeto que usou o metodo vai apontar pro novo no criado(Element)
			
			if(this == tail) {
				tail=this.next;
				
			}
		}
		//Método inserirAntes()
		public void inserirAntes(T item) {
			Element temp = new Element(item, this);
			
			if(this == head) {
				head= temp;
			}else {
				Element prevPtr=head;
				while(prevPtr !=null && prevPtr.next != this) {
					prevPtr= prevPtr.next;
				}
				prevPtr.next=temp;
			}
			
			
			
		}
		
	} //fim da classe element

	
	//construtor da lista encadeada
	public ListaEncadeadaGenerica () {				
	}
	
	//Este método descarta os elementos da lista,tornando-a vazia.
	public void fazVazia() {
		head=null;
		tail=null;
	}
	
	//metodos de acesso
	
	public Element getHead() {
		return this.head;
	}
	public Element getTail() {
		return this.tail;
	}
	public boolean estaVazia() {
		return (head==null);
	}
	
	//O método getPrimeiro() retorna o primeiro elemento da lista.
	
	public T getPrimeiro() throws ListaVaziaException {
		
			if(head==null) { //verifica se o primeiro termo e nulo
				throw new ListaVaziaException();
				
			}
			
		
		// se nao for nulo ele retorna o objeto que head guarda,que pode ser int,string etc;
		return head.getData();
		
	}
	
	
	//O método getUltimo() retorna o último	elemento da lista.
	public T getUltimo() throws ListaVaziaException {
		
			if(tail==null) { //verifica se o ultimo termo e nulo
				throw new ListaVaziaException();
				
			}
			
		
		
		// se nao for nulo ele retorna o objeto que tail guarda,que pode ser int,string etc;
		return tail.getData();
		
	}
	
	//Método inserirInicio() Insere um elemento como primeiro elemento da lista.
	public void inserirInicio(T e) {
		Element temp = new Element(e,head);// o ponteiro do novo  elemento aponta pra antiga cabeca
		if(head==null) { // se a lista tiver vazia,head e tail apontam pro mesmo objeto			
			tail=temp;
		}
		head=temp;
		
		
		
	}
	//Método inserirFim() Coloca o novo elemento no final da lista.
	public void inserirFim(T e) {
		Element temp = new Element(e,null);
		if(head==null) { //se a lista tiver vazia,head e tail apontam pro mesmo objeto
			head=temp;
		}else {
			tail.next=temp;
		}
		tail=temp;
		
		
	}
	
	//Método atribuir() Este método é usado para atribuir elementos de uma lista para outra.
	public void atribuir(ListaEncadeadaGenerica <T>  listaPraCopiar) { // o que ta dentro do parentese sera copiado
		if(this != listaPraCopiar) {
			this.fazVazia(); // o objeto que usar o metodo atribuir tera sua lista "esvaziada"
			
			for(Element ptr = listaPraCopiar.head; ptr!=null; ptr=ptr.getNext()) {
				/*o for comeca do primeiro elemento da lista pra copiar,que tem seu valor atribuido pra ptr,
				 enquanto os elementos forem diferentes de null o for  continua iterando e a cada iteracao 
				 passamos pro proximo elemento				 */
			     //this.inserirFim(ptr.getData(),null);
				this.inserirFim(ptr.getData());


			}
		}
	}
	
	//Método extrair() Este método deleta um elemento específico da lista.
	
	public void extrair(T itemParaRemover) throws ObjetoNaoEncontradoException  {
		
		Element ptr=head;
		Element prevPtr=null;
		
		
		while( ptr!=null && !ptr.getData().equals(itemParaRemover)) {
			prevPtr=ptr;
			ptr=ptr.getNext();
						
		}
		if(ptr==null) {
			throw new ObjetoNaoEncontradoException();
		}
		
		if(ptr ==head ) {
			head=ptr.getNext();
			
		}else {
			prevPtr.setNext(ptr.getNext());
		}
		
		if(ptr==tail) {
			tail=prevPtr;
			//tail.setNext(null);
		}
		
	}
	//metodo imprimir
	public void imprimir() {
		Element ptr = head;
		
		System.out.println("elementos da lista: ");
		while(ptr !=null) {
			System.out.print( ptr.getData()+" ");
			ptr=ptr.getNext();
			
			
		}
		System.out.println("\n");
	}
	
	
	
}
