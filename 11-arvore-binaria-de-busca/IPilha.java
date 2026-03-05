package atv11_ArvoreBinariaDeBusca;

public interface IPilha<T> {
	void fazVazia();
	boolean estaVazia();
	T getTop () throws ContainerVazioException,ListaVaziaException;
	void push(T object);
	T pop() throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException;

}
