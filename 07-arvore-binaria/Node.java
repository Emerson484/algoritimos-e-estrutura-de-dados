package atv11_ArvoreBinaria;

public class Node<T> {
	private T valor;
	private Node<T> filhoEsquerda;
	private Node<T> filhoDireita;
	
	//fornecer subArvores no construtor
	public Node(T valor, Node<T> filhoEsquerda, Node<T> filhoDireita) {
		this.valor = valor;
		this.filhoEsquerda = filhoEsquerda ;
		this.filhoDireita = filhoDireita;
	}
	//construtor para arvores sem subArvores
	public Node(T valor) {
		this.valor = valor;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	public Node() {
		
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Node<T> getFilhoEsquerda() {
		return filhoEsquerda;
	}

	public void setFilhoEsquerda(Node<T> filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}

	public Node<T> getFilhoDireita() {
		return filhoDireita;
	}

	public void setFilhoDireita(Node<T> filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
	
	

}
