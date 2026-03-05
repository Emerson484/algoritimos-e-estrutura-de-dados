package atv7_Deque;

/*import atv6_filaComArray.ContainerCheioException;
import atv6_filaComArray.ContainerVazioException;
import atv6_filaComArray.FilaArray;*/

public class DequeArray<T> extends FilaArray<T> implements IDeque<T> {

	//construtor
	public DequeArray(int tamanho) {
		super(tamanho);
		
	}
	//operações que acessam o início da fila,
	
	//O método getPrimiero() é herdado da classe FilaArray.
	public T getPrimeiro() throws ContainerVazioException{
		if(super.count==0) {
			throw new ContainerVazioException();			
		}
		return super.getPrimeiro();
	}

	//O método desenfileirarInicio() simplesmente chama o método desenfileirar() herdado da classe FilaArray.
	public T desinfileirarInicio()throws ContainerVazioException {
		return desinfileirar();
		
	}
	
	public void enfileirarInicio(T object) throws ContainerCheioException  {
		if(super.count==super.array.length) {
			throw new  ContainerCheioException();
		}
		--head;
		
		if(head==-1) {
			head=super.array.length-1;
		}
		
		super.array[head] =object;
		++count;
	}
	
	//O método getUltimo()
	
	public T getUltimo() throws ContainerVazioException {
		if(super.count==0) {
			throw new ContainerVazioException();
			
		}
		return (T) super.array[tail];
	}
	public T desinfileirarFim() throws ContainerVazioException {
		if(super.count==0) {
			throw new ContainerVazioException();
		}
		T result =(T) super.array[tail];
		
		super.array[tail] =null; //boa pratica ´pra limpar a memoria
		
		--tail;
		
		if(tail==-1) {
			tail =super.array.length-1;
		}
		-- count;
		return result;
		
	}
	public void enfileirarFim(T object) throws ContainerCheioException {
	
			enfileirar(object);
		

	}

}
