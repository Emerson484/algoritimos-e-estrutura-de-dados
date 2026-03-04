package atv5_transformacaoDeExpressoes;

public class PilhaEncadeada <T> implements IPilha <T> {
	private ListaEncadeadaGenerica<T> lista;
	private int count;
	
	//construtor
	public PilhaEncadeada(){
		lista = new ListaEncadeadaGenerica<T>();
		count = 0;
	}
	
	/*O método fazVazia de PilhaEncadeada chama o método fazVazia da classe ListaEncadeada e faz count receber
	zero.*/
	public void fazVazia() {
		lista.fazVazia();
		count=0;
	}
	//O método estaVazia
	public boolean estaVazia() {
		return count==0;
	}
	/*O método push recebe como parâmetro o objeto a ser inserido na pilha e o coloca no início da lista
	encadeada lista. Depois adiciona um ao contador.*/
	public void push (T object) {
		lista.inserirInicio(object);
		count++;
	}
	/* O método pop() utiliza dois métodos de ListaEncadeada: getPrimeiro() e extrair().*/
	public T pop () throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException{
			if(count==0) {
				throw new ContainerVazioException();
			}
			T primeiro =lista.getPrimeiro();
			lista.extrair(primeiro);
			count--;

		return primeiro;
		
	}
	/*Retorna o topo da pilha (primeiro elemento da lista encadeada). Caso a pilha esteja vazia o método 
	 * lança um exceção.*/
	public T getTop() throws ContainerVazioException,ListaVaziaException{
		if(count==0) {
			throw new  ContainerVazioException();
		}
		return lista.getPrimeiro();
	}


}
