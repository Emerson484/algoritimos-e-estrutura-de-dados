/* Depois de implementado totalmente a arvore binária de busca, crie uma classe teste com um método que gera aleatoriamente, em um laço de 100 mil elementos, numeros para serem inseridos de forma ordenada na 
arvore binaria de busca. Execute buscas na arvore binaria de busca, veja os tempos da busca, se ele varia muito de acordo com o numero de elementos na arvore. Por exemplo, insira 1000 eleementos e faça uma busca 
coletando o tempo. Depois, insera 10 mil e 100 mil e repita o processo de busca com a coleta de tempo. Armazene os mesmos números em um vetor ordenado (com o mesmo numero de elementos da arvore). Faça a busca 
no vetor de forma sequencial ordenada e colete o tempo. Avalie a diferença de tempo entre a busca na arvore e no vetor.*/
package atv11_ArvoreBinariaDeBusca;

import java.util.Arrays;
import java.util.Random;

public class TesteDesempenho {

	public static void main(String[] args) {
		executarTeste (1000);
		executarTeste (10000);
		executarTeste (100000);

	}
	public static void executarTeste(int qtdElementos) {
		int numeros [] = new int [qtdElementos]; //vetor com os elementos
		Random aleatorio = new Random(); // numero aleatorio
		
		//preencher o vetor numeros com valores aleatorios
		for(int i=0;i<numeros.length;i++) {
			numeros[i] = aleatorio.nextInt(qtdElementos*10); // aleatorio vai gerar um numero inteiro aleatorio entre 0 e a quantidade de elementos
			//vezes 10
		}
		
		//inserir elementos na arvore
		ArvoreBinariaDeBusca <Integer> arvore = new ArvoreBinariaDeBusca <>();
		for(int numero:numeros) {
			arvore.inserirNo(numero);
		}
		
		//criar vetor ordenado
		int [] vetorOrdenado = Arrays.copyOf(numeros, qtdElementos);//a classe Arrays usa o metodo estatico copyOf pra criar uma copia do vetor
		// numeros(primeiro argumento) com com tamanho definido no segundo parametro
		Arrays.sort(vetorOrdenado); //ordena o vetor	
		
		//gerar um valor aleatorio pra posicao do vetor que vai de 0 ate a quantidade de elementos,assim o numero pertencera ao vetor e sera aleatorio
		int valorProcurar = numeros[aleatorio.nextInt(qtdElementos)]; 
				
		//calcular tempo de busca na arvore
		long tempoInicial = System.nanoTime();//medir o tempo inicial ao chamar o metodo de procura
		Node<Integer> noEncontrado = arvore.procurarValor(valorProcurar); 
		long tempoFinal =System.nanoTime(); //medir o tempo ao encontrar o valor
		
		// como um nanosegundo vale 1 bilonesimo de segundo 1/1*10^9,pra converter pra milisegundos (1/1*10^3) dividimos por 1*10^6
		double tempoTotal = (tempoFinal-tempoInicial)/1000000.0;
		
		if(noEncontrado!=null) {
			System.out.println("busca na arvore executado em:"+tempoTotal);
		}else {
			System.out.println("valor nao encontrado");
		}
		
		//calcular tempo de busca no vetor
		long tempoInicial2 = System.nanoTime();//medir o tempo inicial ao chamar o metodo de procura
		boolean encontrouVetor = buscarValorVetorOrdenado(vetorOrdenado,valorProcurar);
		long tempoFinal2 = System.nanoTime();//medir o tempo ao encontrar o valor
		double tempoTotal2 = (tempoFinal2-tempoInicial2 )/1000000.0;
		
		if(encontrouVetor) {
			System.out.println("busca de vetor ordenado executado em:"+tempoTotal2);
		}else {
			System.out.println("valor nao encontrado");
		}	
		
	}
	// encontrar valor de um vetor ordenado
	public static boolean buscarValorVetorOrdenado (int[] vetor,int valor) {
		for(int i=0;i<vetor.length;i++) {
			if(vetor[i]==valor) {
				return true;
			}
		}
		return false;
	}
	// resultados obtidos :
	
	//com 1000 elementos
	//busca na arvore executado em:0.109
	//busca de vetor ordenado executado em:0.03
	
	//com 10000 elementos
	//busca na arvore executado em:0.225
	//busca de vetor ordenado executado em:0.568
	
	//com 100000 elementos
	//busca na arvore executado em:0.155
	//busca de vetor ordenado executado em:3.162
    
	/*conclusao:
	 * para valores pequenos o vetor se sai melhor do que a arvore,mas pra valores maiores o tempo de excecucao do vetor aumenta drasticamente,
	 * enquanto a arvore continua baixo e quase constante.isso se deve a complexidade dos algoritimos,o vetor tem complexidade linear entao ao 
	 * aumentar a quantidade de elementos o tempo de execucao aumentara de forma proporcinal(comportamento de uma funcao do primeiro grau )
	 * enquanto a arvore tem complexidade logaritimica,entao mesmo aumentado muito a quantidade de elementos o  tempo de excecucao vai aumentar
	 *  pouquissimo,o que descreve o comportamento do grafico da funcao logaritimica,x tem que aumentar muito pra y aumentar so um pouco
	 */
}
