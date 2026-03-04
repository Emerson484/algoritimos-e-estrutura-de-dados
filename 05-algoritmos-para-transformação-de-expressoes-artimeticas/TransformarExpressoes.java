//Usar pilha para transfomrar as expressoes de Infixa para Posfixa e Infixa para Prefixa além de PosFixa para Infixa
package atv5_transformacaoDeExpressoes;

public class TransformarExpressoes {
	PilhaEncadeada <String> Pilha = new PilhaEncadeada<>();
	ListaEncadeadaGenerica <String> PosFixa = new ListaEncadeadaGenerica<>();
	
	//metodo para transformar expressao infixa para posfixa
	public String infixaPosfixa(String infixa) throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException{ 
		for(String caractere : infixa.split(""))/*pega a expressao e divide em pedacos e coloca num array(usa
	    ndo espacos como delimitador*/
		if(ehOperador(caractere)) { // se o elemento lido for operador ira cair nessa condicao
			while( !Pilha.estaVazia() && temMenorPrioridade(caractere ,Pilha.getTop() ) ){
				PosFixa.inserirFim(Pilha.pop());
				/* se a pilha nao  tiver vazia e nao tiver operador com menor prioridade removemos o operador 
				 * que ta na pilha(maior prioridade) e adicionamos a lista posfixa,a pilha fica vazia e sai do
				 *loop,assim o operador com menor prececedencia e adicionado a pilha 
				 */
			}
			Pilha.push(caractere); /* se a pilha tiver vazia e nao tiver operador com menor prioridade
			adicionamos o operador a pilha*/
		}else {
			PosFixa.inserirFim(caractere);
		}
		
		//por fim remover operadores com menor precedencia e adicionar a lista posfixa
		while(!Pilha.estaVazia()) {
			PosFixa.inserirFim(Pilha.pop());
		}
		
		//conveter elementos da lista pra string
		return PosFixa.toString();
		
		
	}
	/*
	 * a primeira inversao ocorre pq na prefixa lemos da direita pra esquerda e a seguna inversao e pq a 
	 * posfixa e o  inverso	 da prefixa,tudo isso usando o algoritimo de infixa pra posfixa com nodificacoes
	 */
	public String infixaPrefixa(String infixa) throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException{ 
		StringBuilder invertida = new StringBuilder(infixa).reverse(); //inverte a infixa pra ser lida da direita pra esquerda
		String[] caracteres = invertida.toString().split(""); //tranforma em string  e divide em pedacos e coloca num array
		for(String caractere : caracteres)
	  
		if(ehOperador(caractere)) { // se o elemento lido for operador ira cair nessa condicao
			while( !Pilha.estaVazia() && temMenorPrioridade(caractere ,Pilha.getTop() ) ){
				PosFixa.inserirFim(Pilha.pop());
				/* se a pilha nao  tiver vazia e nao tiver operador com menor prioridade removemos o operador 
				 * que ta na pilha(maior prioridade) e adicionamos a lista posfixa,a pilha fica vazia e sai do
				 *loop,assim o operador com menor prececedencia e adicionado a pilha 
				 */
			}
			Pilha.push(caractere); /* se a pilha tiver vazia e nao tiver operador com menor prioridade
			adicionamos o operador a pilha*/
		}else {
			PosFixa.inserirFim(caractere);
		}
		
		//por fim remover operadores com menor precedencia e adicionar a lista posfixa
		while(!Pilha.estaVazia()) {
			PosFixa.inserirFim(Pilha.pop());
		}
	    //como a prefixa e espelho de posfixa ,pegamos o resultado em posfixo e invertemos
		
		StringBuilder prefixa = new StringBuilder(PosFixa.toString().toString());
		//o to string vai juntar os elementos de posfixa numa string e sera guardadado em prefixa
		
		prefixa.reverse();
 
		
		return prefixa.toString();//criamos o objeto do tipo StringBuilder para podermos inverter 
		// e uasamos to string para transformar em string
		
	}
	
	public String posfixaInfixa(String posfixa) throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
		for(String caractere: posfixa.split(" ")) { // dividir a expressaso em caracteres e verificar eles
			//individualmente
			if( !ehOperador(caractere)) {
				Pilha.push(caractere);//se nao for operador guarda o operando na pilha
			}else { //se for operador desimpilha dois ultimos operando e coloca entre o operador e guarda 
				//na pilha
				String a = Pilha.pop();//o primeiro removido fica a direita
				String b = Pilha.pop();
				String elemComParenteses ="("+b + caractere +a +")";
				Pilha.push(elemComParenteses);
				//ao final a pilha vai ter a expressao completa
			}
			
			
			
			
		}
		//o metodo pop remove e retorna o ultimo elemento,que e a expressao toda
		return Pilha.pop();
		
		
	}
    
	//verifica se e um operador
	public static boolean ehOperador(String operador) {
		switch(operador){
			case "/":{
				return true;
			}
			case "*":{
				return true;
			}
			case "+":{
				return true;
			}
			case "-":{
				return true;
			}
			default :{
				return false;
			}
	    }
		
	}
	//retorna o valor de prioridade a depender do operador
	public static int valorPrioridade(String operador) {
		switch(operador){
			case "/":{
				return 2;
			}
			case "*":{
				return 2;
			}
			case "+":{
				return 1;
			}
			case "-":{
				return 1;
			}
			default :{
				return 0;
			}
      }
	}
	//verifica a prioridade entre 2 operadores
	public static boolean temMenorPrioridade (String operador1,String operador2) {
		if(valorPrioridade(operador1) < valorPrioridade(operador2)) {
			return true;
		}else {
			return false;
		}
	}
}
