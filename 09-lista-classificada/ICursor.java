package atv_9ListaClassificada;

public interface ICursor <T> {
	T getDado();
	void inserirDepois(T object);
	void inserirAntes(T object);
	void remover() throws ObjetoNaoEncontradoException;
	

}
