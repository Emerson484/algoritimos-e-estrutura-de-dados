package atv11_ArvoreBinariaDeBusca;

public interface IFila <T>{
	void fazVazia();
	boolean estaVazia();
	T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
	void enfileirar(T objeto);
	T desinfileirar() throws ContainerVazioException, ObjetoNaoEncontradoException, ListaVaziaException;
	

}
