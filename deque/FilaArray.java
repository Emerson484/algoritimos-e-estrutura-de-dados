package atv6_filaComArray;

public class FilaArray <T> implements IFila<T> {
	protected T[] array;
	protected int head,tail,count;
	
	public FilaArray(int tamanho){
		array=(T[]) new Object [tamanho]; // da erro sem o casting pois ao compilar o java apaga o tipo generico
		head=0;//dai em tempo de execucao  o vetor precisa saber o tipo  e como o java apagou ele
		tail=tamanho-1;//nao pode ser criado
		count=0;
		
	}
	//pra classe deque
	
	public void setHead(int head) {
		this.head=head;
	}
	public int getHead() {
		return head;
	}
	
	public void setTail(int tail) {
		this.tail=tail;
	}
	public int getTail() {
		return tail;
	}
	
	public void fazVazia() {
		while(count>0) {
			array[head]=null;
			++head;
			
			if(head==array.length) {
				head=0;
			}
			-- count;
			
		}
	}
	//Este método verifica se a fila está ou não vazia comparando o valor de count.
	public boolean estaVazia() {
		return count==0;
	}
	
	//O método getPrimeiro() retorna o	elemento encontrado no início da fila.
	public T getPrimeiro() throws ContainerVazioException {
		if(count==0) {
			throw new ContainerVazioException();
		}
		return (T) array[head];
		
	}
	//O método enfileira recebe como parâmetro o objeto a ser inserido na fila.
	public void enfileirar (T object) throws ContainerCheioException {
		if(count==array.length) {
			throw new ContainerCheioException();
		}
		++tail;
		if(tail==array.length) {
			tail=0;
		}
		array[tail]=object;
		++count;
	}
	
	//O método desenfileirar() retira o	elemento do início da fila e o retorna.
	public T desinfileirar() throws ContainerVazioException {
		if(count==0) {
			throw new ContainerVazioException();
		}
		T result =(T) array[head]; 
		array[head]=null;
		
	    ++head;
	    
	    if(head==array.length) {
	    	head=0;
	    }
	    
	    --count;
		
	    return result;
	}
	
	

}
