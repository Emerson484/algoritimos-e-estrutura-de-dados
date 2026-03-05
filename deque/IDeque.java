package atv7_Deque;

//import atv6_filaComArray.ContainerCheioException;
//import atv6_filaComArray.ContainerVazioException;

public interface IDeque <T>{
	void fazVazia();
	boolean estaVazia();
	T getPrimeiro()throws ContainerVazioException;
	T getUltimo()throws ContainerVazioException;
	void enfileirarInicio(T object)throws ContainerCheioException;
	void enfileirarFim(T object)throws ContainerCheioException;
	T desinfileirarInicio() throws ContainerVazioException;
	T desinfileirarFim()throws ContainerVazioException ;

	

}
