package atv2_listaDuplamenteEncadeada;

import atv3ListaSimplesmenteEncadeadaGenerica.ObjetoNaoEncontradoException;

public class ListaDuplamenteEncadeada <T>{
	private Element head;
	private Element tail;
	
	//classe element
	public final class Element{
		private T data;
		private Element next;
		private Element prev;
		
		Element(T d,Element n,Element p){
			this.data=d;
			this.next=n;
			this.prev=p;
		}
	}
	
	//metodos get set
	public void setHead (Element head) {
		this.head = head;
	}
	public Element getHead() {
		return head;
	}
	
	public Element getTail() {
		return tail;
	}
	public void setTail(Element tail) {
		this.tail = tail;
	}
    
	//inserir no inicio
	public void inserirInicio(T item) {
		Element temp =new Element(item,head,null);
		if(head !=null) {
			head.prev=temp;
		}else {
			tail = temp;
		}
		head=temp; //independente de ser ou nao vazai head apntonta pro novo no
	}
	
	//inserir no fim
	public void inserirFim(T item) {
		Element temp = new Element (item,null,tail); //com a lista vazia tail e null,entao prev do temp e null tmb
		
		if(tail!=null) {
			tail.next=temp;
		}else {
			head = temp;
		}
		tail= temp;		
	}
	
	//remover
	public void remover(T item) throws ObjetoNaoEncontradoException {
		Element ptr =head;
		
		while(ptr != null && !ptr.data.equals(item)){
			ptr = ptr.next;
		}
		
		if(ptr == null) {
			throw new ObjetoNaoEncontradoException();
		}
		
		if(ptr == head && ptr == tail) {
			head = null;
			tail = null;
		}
		else if(ptr == head) {
			head = ptr.next;
			head.prev = null;
		}
		else if(ptr == tail) {
			tail = ptr.prev;
			tail.next = null;
		}
		else {
			ptr.prev.next = ptr.next;
			ptr.next.prev = ptr.prev;
		}
	}
	
}
