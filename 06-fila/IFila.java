package atv6_FilaComListaEncadeada;

public interface IFila <T>{
	void fazVazia();
	boolean estaVazia();
	T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
	void enfileirar(T objeto);
	T desinfileirar() throws ContainerVazioException, ObjetoNaoEncontradoException, ListaVaziaException;
	

}
