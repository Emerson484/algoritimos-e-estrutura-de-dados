package atv11_ArvoreBinaria;

public class ClasseTeste {

	public static void main(String[] args) {
		ArvoreBinariaDeBusca <Integer> arvore1 = new ArvoreBinariaDeBusca <>();
		FilaEncadeada<Node<Integer>> fila = new FilaEncadeada<>();
		arvore1.inserirNo(6);
		arvore1.inserirNo(2);
		arvore1.inserirNo(1);
		arvore1.inserirNo(4);
		arvore1.inserirNo(3);
		arvore1.inserirNo(5);
		arvore1.inserirNo(7);
		arvore1.inserirNo(9);
		
		try {
		    System.out.println("testes de impressao:"+"\n");
			System.out.println("imprimindo em pre ordem:");
			arvore1.imprimirPreOrdem(arvore1.raiz);
			
			System.out.println("\n"+"imprimindo em pos ordem:");
			arvore1.imprimirPosOrdem(arvore1.raiz);
			
			System.out.println("\n"+"imprimindo em ordem:");
			arvore1.imprimirOrdemSimetrica(arvore1.raiz);
			
			System.out.println("\n"+"imprimindo em largura:");
	        arvore1.imprimirEmLargura();
	        
	        System.out.println("\n"+ "imprimindo em largura com recursao:");
	        arvore1.ImprimeEmLarguraRecursivo();
	        
	        System.out.println("\n"+ "imprimindo em largura invertido:");
	        arvore1.imprimeEmLarguraInvertido();
	        
	        System.out.println("\n"+ "testes de calculo  e busca");
	        System.out.println("\n"+ "calcular altura:");
	        System.out.println (arvore1.CalcularAltura());
	        
	        System.out.println("\n"+ "calcular altura em largura:");
	        System.out.println(arvore1.calcularAlturaEmLargura());
	        
	        System.out.println("\n"+ "calcular total de nos da arvore:"+arvore1.calcularTotalNodes());
	        
	        System.out.println("\n"+ "calcular total de folhas da arvore:"+arvore1.calcularTotalNodesFolhas());
	        
	        //testando a busca
	        System.out.println("\n"+ "verificando se o 4 (existe )"+arvore1.procurarValor(4).getValor());
	        System.out.println("\n"+ "verificando se o 8 (nao existe )"+arvore1.procurarValor(8));
	        
	        //testando menor e maior valor
	        System.out.println("\n"+ "menor valor(1):" +arvore1.NoComMenorValor(arvore1.raiz).getValor());
	        System.out.println("\n"+ "maior valor(9):" +arvore1.NoComMaiorValor(arvore1.raiz).getValor());
	        
	        System.out.println("\n"+"teste de remocao :");
	        System.out.println("\n"+ "arvore em ordem antes de remover o elemento:");
	        arvore1.imprimirOrdemSimetrica(arvore1.raiz);
	        System.out.println();
	        
	        System.out.println("\n"+"remover no sem filhos(folhas)");
	        arvore1.removerNode(5);
	        System.out.println("arvore em ordem apos remover o 5");
	        arvore1.imprimirOrdemSimetrica(arvore1.raiz);
	        System.out.println();
	        
	        System.out.println("\n"+"remover o 7 (no com filho a direita)");
	        arvore1.removerNode(7);
	        System.out.println("arvore em ordem  apos remover o 7");
	        arvore1.imprimirOrdemSimetrica(arvore1.raiz);
	        System.out.println();
	        
	        System.out.println("\n"+"remover o no 2 (tem 2 filhos 1 e 4)");
	        arvore1.removerNode(2);
	        System.out.println("arvore em ordem  apos remover o 2");
	        arvore1.imprimirOrdemSimetrica(arvore1.raiz);
	        System.out.println();
	        
	        System.out.println("\n"+"remover o no 6 que eh no raiz com 2 filhos");
	        arvore1.removerNode(6);
	        System.out.println("arvore em ordem  apos remover o 6");
	        arvore1.imprimirOrdemSimetrica(arvore1.raiz);
	        System.out.println();
	        
	        System.out.println("\n"+"nova raiz da arvore :"+arvore1.raiz.getValor());
	        
	        
		}catch (ContainerVazioException ex1) {
			System.out.println(ex1.getMessage());
		
		}catch (ListaVaziaException ex2) {
			System.out.println(ex2.getMessage());
		}catch (ObjetoNaoEncontradoException ex3) {
			System.out.println(ex3.getMessage());
		}
		
		
	}

}
