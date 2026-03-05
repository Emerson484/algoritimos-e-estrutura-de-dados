package atv_9ListaClassificada;

public interface IListaClassificada <T> {
	T getDado (int i);
	ICursor<T> procurarPosicao(T object);
	void inserir(T object);
	void remover(T object) throws ContainerVazioException,ObjetoNaoEncontradoException;
	ICursor<T> procurar(T object);
	boolean ehMembro (T object);

}
