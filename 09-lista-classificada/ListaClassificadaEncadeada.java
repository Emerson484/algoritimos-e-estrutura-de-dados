package atv_9ListaClassificada;

public class ListaClassificadaEncadeada <T extends Comparable<T> >implements IListaClassificada<T>{
	ListaEncadeadaGenerica<T> lista;
	int count;
	
	ListaClassificadaEncadeada (){
		lista=new ListaEncadeadaGenerica<>();
		count = 0;
	}
	
	//atual< retorna -1
	//igual retorna 0
	//atual> retorna 1
	
	//metodos de lista classificada
		public void inserir(T object) {
			//lista vazia ou inicio
			if(lista.getHead()==null || object.compareTo(lista.getHead().getData())<0 ){
				lista.inserirInicio(object);
				
				//meio ou fim
			}else {
				/*//inseir menor,compara ja o primeiro
				T primeiroItem = lista.getHead().getData(); //valor e nao referencia
				if(primeiroItem!=null && object.compareTo(primeiroItem)<0) {
					lista.inserirInicio(object);
				}*/
				
				//inserir maior elemento
				ListaEncadeadaGenerica.Element ptr = lista.getHead();
				
				while(ptr.getNext()!=null && ptr.getNext().getData().compareTo(object)<0) {
					ptr=ptr.getNext();
				}
				ptr.inserirDepois(object);
				
			}
			count++;
		}
		
		public T getDado (int offSet) {
			if(offSet<0 || offSet>count) {
				throw new IndexOutOfBoundsException();
			}
			ListaEncadeadaGenerica<T>.Element ptr= lista.getHead();
			
			for(int i=0; i<offSet && ptr!= null;i++) {
				ptr=ptr.getNext();
			}
			return ptr.getData();
			
		}
		
		public boolean ehMembro (T object) {
			ListaEncadeadaGenerica<T>.Element ptr;
			
			for(ptr =lista.getHead(); ptr!=null; ptr=ptr.getNext()) {
				if(ptr.getData()==object) {
					return true;
				}
			}
			return false;
			
		}
		
		public ICursor<T> procurar (T object) {
			ListaEncadeadaGenerica<T>.Element ptr ;
			
			for(ptr=lista.getHead(); ptr!=null; ptr=ptr.getNext()) {
				T objeto =ptr.getData();
				if(objeto.equals(object)) {
					 // Retorna um NOVO CURSOR que aponta para o elemento encontrado
					return new MeuCursor(ptr);
				}
				
			}
			return null;
		}
		
		public void remover (T object) throws ContainerVazioException,ObjetoNaoEncontradoException {
			if(lista.getHead()==null) {
				throw new ContainerVazioException();
			}
			lista.extrair(object);
			count--;
		}
		public ICursor<T> procurarPosicao (T object){
			ListaEncadeadaGenerica<T>.Element ptr;
			
			for(ptr=lista.getHead(); ptr!= null; ptr= ptr.getNext()) {
				T objeto = ptr.getData();
				if(objeto.equals(object)) {
					return new MeuCursor(ptr);
				}
				
			}
			return null;
		}
			
	//a classe interna MeuCursor não precisa ser genérica. Ela simplesmente usa o tipo T que já foi definido pela classe externa que a contém.		
	protected class MeuCursor implements ICursor<T> {	
		//elemento que faz referência ao elemento da lista encadeada no qual o	item determinado está armazenado.
		ListaEncadeadaGenerica<T>.Element element;
	
		public T getDado() {
			return element.getData();
		}
		public MeuCursor(ListaEncadeadaGenerica<T>.Element element) {
			this.element=element;
		
		}
		
		@Override
		public void inserirDepois(T object) {
			element.inserirDepois(object);
			
		}

		@Override
		public void inserirAntes(T object) {
			element.inserirAntes(object);
			
		}

		
		public void remover () throws ObjetoNaoEncontradoException {
			lista.extrair(element.getData());
			count--;
		}

		
		
		
		
	}

	
	
	
}
