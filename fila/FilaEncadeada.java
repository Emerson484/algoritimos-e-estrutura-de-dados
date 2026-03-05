package atv6_FilaComListaEncadeada;

public class FilaEncadeada<T> implements IFila<T>{
	private ListaEncadeadaGenerica <T> lista;
	private int count;
	
	public FilaEncadeada () {
		lista = new ListaEncadeadaGenerica<T>();
		count =0;
		
	}
	
	public void fazVazia() {
		lista.fazVazia();
		count=0;
	}
	
	public boolean estaVazia() {
		return (count==0);
	}
	
    public T getPrimeiro () throws ContainerVazioException, ListaVaziaException {
    	if(count==0) {
    		throw new ContainerVazioException();
    	}
    	return lista.getPrimeiro();
    	
    }
    public void enfileirar (T objeto){
    	lista.inserirFim(objeto);
    	count++;
    }
    
    public T desinfileirar () throws ContainerVazioException, ObjetoNaoEncontradoException, ListaVaziaException {
    	if(count==0) {
    		throw new ContainerVazioException();
    	}
    	T result = lista.getPrimeiro(); 
    	lista.extrair(result);
    	--count;
    	return result;
    }
 
}
