package atv11_ArvoreBinariaDeBusca;

public class ArvoreBinariaDeBusca <T extends Comparable<T>>{
	Node <T> raiz;
	
	public ArvoreBinariaDeBusca() {
		this.raiz=null;
	}
	public void AuxiliarAdicionarNo(Node<T> novoNo,Node<T> noAtual) {
	
		
		if(raiz==null) { // se a arvore tiver vazia
			this.raiz=novoNo;
		}else {// se a arvore nao tiver vazia
			
				if( novoNo.getValor().compareTo(noAtual.getValor())<0 ){ //se novo elemento for menor que o no adiciona a esquerda
					if(noAtual.getFilhoEsquerda()!=null) {
						 //se ja tiver filho a esquerda atualiza a variavel pra apontar pro filho a esquerda e percorrer
						AuxiliarAdicionarNo (novoNo,noAtual.getFilhoEsquerda());//denovo
					}else { //se nao tiver filho a esquerda o novo elemento vira o filho a esquerda
						noAtual.setFilhoEsquerda(novoNo);
						
					}
				}else {//se novo elemento for maior que o no adiciona a direita
					if(noAtual.getFilhoDireita()!=null) {
						AuxiliarAdicionarNo(novoNo,noAtual.getFilhoDireita()); //se ja tiver filho a direita atualiza a variavel pra apontar pro filho a direita e percorrer
						//denovo
					}else {//se nao tiver filho a direita o novo elemento vira o filho a direita
						noAtual.setFilhoDireita(novoNo);
						
					}
				}
			
			
		}
		
	}
	public void inserirNo(T valor){
		Node<T> no = new Node<>(valor);
		AuxiliarAdicionarNo(no,raiz);
		
	}
	public void imprimirPreOrdem(Node<T> atual) {
		if(atual!=null) {
			System.out.print(atual.getValor()+" ");
			imprimirPreOrdem(atual.getFilhoEsquerda());
			imprimirPreOrdem(atual.getFilhoDireita());
		}
		
	}
	
	public void imprimirPosOrdem(Node<T> atual) {
		if(atual!=null) {
			imprimirPosOrdem (atual.getFilhoEsquerda());
			imprimirPosOrdem (atual.getFilhoDireita());
			System.out.print(atual.getValor()+" ");
		}
		
	}
	public void imprimirOrdemSimetrica(Node<T> atual) {
		if(atual!=null) {
			imprimirOrdemSimetrica(atual.getFilhoEsquerda());
			System.out.print(atual.getValor()+" ");
			imprimirOrdemSimetrica(atual.getFilhoDireita());
		}
		
	}
	
	public void imprimirEmLargura() throws ContainerVazioException,ListaVaziaException,ObjetoNaoEncontradoException  {
		if(raiz==null) {
			System.out.println("arvore vazia");
		}
		
		FilaEncadeada<Node<T>> fila = new FilaEncadeada<>();
		fila.enfileirar(raiz); // this vai ser a raiz da arvore que usar o metodo
		Node<T> no;
		
		while(!fila.estaVazia()) {
			no =(Node<T>) fila.desinfileirar();
			
			if(no.getFilhoEsquerda()!=null) {
				fila.enfileirar( no.getFilhoEsquerda() ); //o metodo enfileirar so recebe tipo T e nao
				// Node <T> por isso a conversao pra T
			}
			
			if(no.getFilhoDireita()!=null) {
				fila.enfileirar( no.getFilhoDireita());
			}
			
			System.out.print(no.getValor()+" ");
		}
	}
	// funcao auxiliar pra nao ter que criar fila na classe teste
	public void ImprimeEmLarguraRecursivo()throws ContainerVazioException,ListaVaziaException,ObjetoNaoEncontradoException  {
		FilaEncadeada<Node<T>> filaAuxiliar = new FilaEncadeada<>();
		filaAuxiliar.enfileirar(raiz);
		ImprimeEmLarguraRecursivo(filaAuxiliar);
		
	}
	public void ImprimeEmLarguraRecursivo(FilaEncadeada<Node<T>> fila)throws ContainerVazioException,ListaVaziaException,ObjetoNaoEncontradoException  {
		if(fila.estaVazia()) { // caso base pra parar a recursao
			return;
		}
		
		Node<T> no;
		
		if(raiz==null) {
			System.out.println("arvore vazia");
		}
				
		no = fila.desinfileirar();
		
		if(no.getFilhoEsquerda()!=null) {
			fila.enfileirar(no.getFilhoEsquerda());
		}
		if(no.getFilhoDireita()!=null) {
			fila.enfileirar(no.getFilhoDireita());
		}
		System.out.print(no.getValor()+" ");
	    
		ImprimeEmLarguraRecursivo(fila);
	}
	
	public void imprimeEmLarguraInvertido()throws ContainerVazioException,ListaVaziaException,ObjetoNaoEncontradoException {
		PilhaEncadeada<Node<T>> pilha = new PilhaEncadeada<>();
		FilaEncadeada <Node<T>> fila = new FilaEncadeada <>();
		
		Node <T> no;
		fila.enfileirar(raiz);
		
		while(!fila.estaVazia()) {
			no = (Node<T>)fila.desinfileirar();
			
			if(no.getFilhoEsquerda()!=null) {
				fila.enfileirar(no.getFilhoEsquerda());
			}
			if(no.getFilhoDireita()!=null) {
				fila.enfileirar(no.getFilhoDireita());
			}
			pilha.push((Node<T>)no);
		}
		imprimePilha(pilha);
		
		
	}
	public void imprimePilha(PilhaEncadeada<Node<T>> pilha)throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
		while(!pilha.estaVazia()) {
			Node<T> no = new Node <>();
			no = pilha.pop();
			System.out.print(no.getValor()+" ");
		}
	}
	
	public int CalcularAltura() throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
		return auxiliarCalcularAltura(raiz);
	}
	public int auxiliarCalcularAltura(Node<T> no) throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
		
		if(no==null) {
			return 0;
		}
		int alturaEsquerda=0;
		int alturaDireita=0;
		FilaEncadeada<Node<T>> fila = new FilaEncadeada<>();
		
		
		if(no.getFilhoEsquerda()!=null) {
			alturaEsquerda = auxiliarCalcularAltura(no.getFilhoEsquerda())+1;
		}
		if(no.getFilhoDireita()!=null) {
			alturaDireita = auxiliarCalcularAltura(no.getFilhoDireita())+1;
		}
		
		if(alturaEsquerda>alturaDireita) {
			return alturaEsquerda;
			
		}else {
			return alturaDireita; // caso dos 2 iguais
		}
	}
	
	public int calcularAlturaEmLargura() throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
		FilaEncadeada <Node<T>> fila = new FilaEncadeada <>();
		FilaEncadeada <Integer> distancia = new FilaEncadeada <>();
		
		fila.enfileirar(raiz);
		distancia.enfileirar(0);
		Node<T> no;
		int nivel=0;
		
		int alturaMax=0;
		
		while(!fila.estaVazia()) {
			no = fila.desinfileirar();
			nivel=distancia.desinfileirar();
			
			if(no.getFilhoEsquerda()!=null) {
				fila.enfileirar(no.getFilhoEsquerda());		
				distancia.enfileirar(nivel+1);	
			}
			if(no.getFilhoDireita()!=null) {
				fila.enfileirar(no.getFilhoDireita());
				distancia.enfileirar(nivel+1);
			}
			
			if(nivel>alturaMax) {
				alturaMax=nivel;
			}
		}
		return alturaMax;
		
	}
	
	public Node<T> procurarValor(T valor){
		Node<T> no =procurarValor(raiz,valor);
		return no;
	}
	public Node<T> procurarValor(Node<T> atual, T valor){
		int comparacao =valor.compareTo(atual.getValor());
		if(comparacao<0) {
			if(atual.getFilhoEsquerda()!=null) {
				return procurarValor(atual.getFilhoEsquerda(),valor);
			}else {
				return null;
			}
			
		}else if(valor.compareTo(atual.getValor())>0) {
			if(atual.getFilhoDireita()!=null) {
				return procurarValor(atual.getFilhoDireita(),valor);
			}else {
				return null;
			}
		}
		else {
			return atual;
		}
	}
	
	public boolean removerNode (T valor) {
		boolean resultado =false;
		resultado = AuxiliarRemoverNode(raiz,valor,null);
		return resultado;
	}
	
    public boolean AuxiliarRemoverNode (Node<T> atual,T valor,Node<T> noPai) {
		boolean resultado =false;
		int comparacao =valor.compareTo(atual.getValor()); //guarda o valor da comparacao
		
		if(comparacao<0) { // se o valor do no a ser removido for menor que o no atual
			if(atual.getFilhoEsquerda()!=null) { //se no atual tiver filho esquerda faz a recursao pra percor
				//rer a arvore
				return AuxiliarRemoverNode (atual.getFilhoEsquerda(),valor,atual);
			}else { // senao tiver filho a esquerda significa que no que contem o valor nao aqui,entao retorna
				//falso
				return false;
			}
		}
		if(comparacao>0) { // se o valor do no a ser removido for maior que o no atual
			if(atual.getFilhoDireita()!=null) { //se no atual tiver filho esquerda faz a recursao pra percor
				//rer a arvore
				return AuxiliarRemoverNode(atual.getFilhoDireita(),valor,atual);
			}else{// senao tiver filho a esquerda significa que no que contem o valor nao aqui,entao retorna
				//falso				
				return false;
			}
		}
		else { // se nao for os casos acima significa que comparacao=0,entao chegamos no no que tem o valor
			//no a ser removido nao tem filhos
			if(atual.getFilhoEsquerda()==null && atual.getFilhoDireita()==null) { 
				trocarFilho(atual,noPai,null);
				return true;
			}
			//no a ser removido tem filho a esquerda
			if(atual.getFilhoEsquerda()!=null && atual.getFilhoDireita()==null) {
				trocarFilho(atual,noPai,atual.getFilhoEsquerda());
				return true;
			}
			//no a ser removido tem filho a direita
			if(atual.getFilhoEsquerda()==null && atual.getFilhoDireita()!=null) {
				trocarFilho(atual,noPai,atual.getFilhoDireita());
				return true;
			}
			//no a ser removido tem filho a esquerda e direita
			if(atual.getFilhoEsquerda()!=null && atual.getFilhoDireita()!=null) {
				Node<T> menorDosMaiores =NoComMenorValor(atual.getFilhoDireita());// menor valor a direita
				Node<T> noPaiMenorDosMaiores = new Node<>();// pai do menor valor a direita
				
				// se o menorDosMaiores for filho a direita do no a ser removido
				if(atual.getFilhoDireita()==menorDosMaiores) {
					noPaiMenorDosMaiores=atual;
				}else {// se o filho a direita do no a ser removido tiver filho a esquerda
					noPaiMenorDosMaiores = acharPai (atual.getFilhoDireita(),menorDosMaiores);
				}
				
				//troca o valor do no a ser removido pelo menor a direita
				atual.setValor(menorDosMaiores.getValor());
				/*seta o filho do pai do menor a direita como sendo o filho a direita do menor a direita pois
				como a arvore esta ordenada isso garante que o menor a direita nao tera filho a esquerda e
				isso cobre o caso dele ter filho ou nao*/
				trocarFilho(menorDosMaiores,noPaiMenorDosMaiores,menorDosMaiores.getFilhoDireita());
				
				return true;
			}
			
		}
		return resultado; 
	}
    
    public void trocarFilho(Node<T> noAtual,Node<T> noPai,Node<T> novoFilho) {
    	if(noPai!=null) {
    		if(noPai.getFilhoEsquerda()==noAtual) { // verifica se o filho ta a esquerda do pai
    			noPai.setFilhoEsquerda(novoFilho);
    		}
    		if(noPai.getFilhoDireita()==noAtual) {// verifica se o filho ta a direita do pai
    			noPai.setFilhoDireita(novoFilho);
    		}
    	}else {//se o no a ser removido for a raiz(pai nulo)
    		raiz=novoFilho;
    	}
    }
    public Node<T> NoComMenorValor(Node<T> outroAtual){
    	if(outroAtual.getFilhoEsquerda()!=null) {
    		return NoComMenorValor(outroAtual.getFilhoEsquerda());
    	
    	}else {
    		return outroAtual;
    	}
    }
    
    public Node<T> NoComMaiorValor(Node<T> outroAtual){
    	if(outroAtual.getFilhoDireita()!=null) {
    		return NoComMaiorValor(outroAtual.getFilhoDireita());
    	
    	}else {
    		return outroAtual;
    	}
    }
    public Node<T> acharPai(Node<T> atual,Node<T> filhoPerdido){
    	//verificar se atual eh pai do filho,senao for percorremos a arvore pela esquerda ou direita
    	if(atual.getFilhoEsquerda()==filhoPerdido || atual.getFilhoDireita()==filhoPerdido) {
    		return atual;
    	}else { 
    		//se o filho perdido tiver valor menor que o atual,percorremos a arvore pela esquerda
    		if(filhoPerdido.getValor().compareTo(atual.getValor())<0) {
    			if(atual.getFilhoEsquerda()!=null) {
    				return acharPai (atual.getFilhoEsquerda(),filhoPerdido);
    			}else {
    				return null; //o filho nao esta na arvore
    			}
    		}else { //se o filho perdido tiver valor maior que o atual,percorremos a arvore pela direita
    			if(atual.getFilhoDireita()!=null) {
    				return acharPai (atual.getFilhoDireita(),filhoPerdido);
    			}else {
    				return null; //o filho nao esta na arvore
    			}
    		}   		  		
    	}
    }
    public int calcularTotalNodes() {
    	int total = calcularTotalNodes(raiz);
    	return total;
    }
    public int calcularTotalNodes(Node<T> atual) {
    	int totalNosEsquerda=0;
        int totalNosDireita=0;
			if(atual.getFilhoEsquerda()!=null) {
				totalNosEsquerda = calcularTotalNodes(atual.getFilhoEsquerda());
			}
			if(atual.getFilhoDireita()!=null) {
				totalNosDireita = calcularTotalNodes(atual.getFilhoDireita());			
		    }
			return totalNosEsquerda + totalNosDireita +1;
    }
    
    public int calcularTotalNodesFolhas() {
    	int total = calcularTotalNodesFolhas(raiz);
    	return total;
    }
    public int calcularTotalNodesFolhas(Node<T> atual) {
    	int totalNosEsquerda=0;
        int totalNosDireita=0;
        boolean ehFolha=true;
        
        if(atual.getFilhoEsquerda()!=null) {
        	totalNosEsquerda = calcularTotalNodesFolhas(atual.getFilhoEsquerda());
			ehFolha=false;
		}
		if(atual.getFilhoDireita()!=null) {
			totalNosDireita = calcularTotalNodesFolhas(atual.getFilhoDireita());
			ehFolha=false;	
	    }
		
		if(ehFolha) {
			return 1;
		}
		return totalNosEsquerda + totalNosDireita;
        
    }
    public int calcularTotalNodesEmLargura()throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
    	int total = calcularTotalNodesEmLargura(raiz);
    	return total;
    }
    public int calcularTotalNodesEmLargura(Node<T> atual)throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException{
    	FilaEncadeada<Node<T>> fila = new FilaEncadeada<>();
    	Node<T> noAuxiliar;
    	int total=0;
    	 
    	fila.enfileirar(atual);
    	total++;
    	while(!fila.estaVazia()) {
    		noAuxiliar=fila.desinfileirar();
  	      
            if(noAuxiliar.getFilhoEsquerda()!=null) {
            	fila.enfileirar(noAuxiliar.getFilhoEsquerda());
            	total++;
            }
            if(noAuxiliar.getFilhoDireita()!=null) {
            	fila.enfileirar(noAuxiliar.getFilhoDireita());
            	total++;
            }
    	}
    	
        return total;
    }
    
    public int calcularTotalNodesFolhasEmLargura()throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException{
    	int total = calcularTotalNodesFolhasEmLargura(raiz);
    	return total;
    }
    public int calcularTotalNodesFolhasEmLargura(Node<T> atual)throws ContainerVazioException,ObjetoNaoEncontradoException,ListaVaziaException {
    	FilaEncadeada <Node<T>> fila = new FilaEncadeada<>();
    	int total = 0;
    	Node<T> noAuxiliar;
    	
    	fila.enfileirar(atual);
    	
    	while(!fila.estaVazia()) {
    		boolean ehFolha = true;
    		noAuxiliar = fila.desinfileirar();
    		
    		if(noAuxiliar.getFilhoEsquerda()!=null) {
    			fila.enfileirar(noAuxiliar.getFilhoEsquerda());
    			ehFolha = false;
    		}
    		if(noAuxiliar.getFilhoDireita()!=null) {
    			fila.enfileirar(noAuxiliar.getFilhoDireita());
    			ehFolha = false;
    		}
    		if(ehFolha) {
    			total++;
    		}
    	}
    	
    	return total;
    }

}
