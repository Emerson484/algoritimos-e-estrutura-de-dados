package atv8_filaMercado;

import java.util.Scanner;

public class Supermercado {
	public static void main (String []args) {
		FilaEncadeada <Cliente> fila = new FilaEncadeada <>(); // fila de clientes
		
		Scanner scan = new Scanner (System.in);
		
		int numeroC =5; // numero de clientes
		
		Cliente[] clientes = new Cliente[numeroC]; // criar um vetor de clientes e colocar info
		
		clientes[0] = new Cliente("Aline", 0, 5);
		clientes[1] = new Cliente("Bruno", 3, 4);
		clientes[2] = new Cliente("Camila", 9, 5);
		clientes[3] = new Cliente("Daniel", 13, 6);
		clientes[4] = new Cliente("Fernanda", 16, 5);


        
		int tempoAtual = 0;
	    int somaEspera = 0;
	    int tempoOcupado = 0;
		int tamMax=0;
		
		int inicioAtendimento = 0;
		int fim=0;
	    
	    try {
	    	//percorrer os clientes que tao no vetor
			for(int i=0;i<numeroC;i++) {
				Cliente cliente=clientes[i];
				int espera = 0;
				
				//tempo atual vai ser o momento que um ciente terminou de ser atendido
				// 
				if(cliente.getHoraChegou()<tempoAtual || !fila.estaVazia()) { // se a hora que o cliente chegou eh menor que a hora atual isso significa que alguem estava
					//sendo atendido ate o tempo atual,por isso o cliente vai pra fila
					
					fila.enfileirar(cliente);
					tamMax = Math.max(tamMax, fila.getCount());
				}else {//  se o caixa estiver livre e não tiver fila, atende direto
					
					if(cliente.getHoraChegou()>tempoAtual) {// se o cliente chegou com o caixa livre e nao tem ninguem na fila,eh necessario 
						//atualizar o relogio
						tempoAtual= cliente.getHoraChegou();
					}

					 inicioAtendimento=tempoAtual;
					espera = inicioAtendimento - cliente.getHoraChegou();
					 fim = tempoAtual + cliente.getTempoServico();
					
					somaEspera += espera;
					tempoOcupado+= cliente.getTempoServico();
					
					tempoAtual=fim; // atualizar tempo com base no tempo de servico do primeiro cliente que foi atendido
				}
				
				// se o caixa tiver livre mas tiver fila
				while(!fila.estaVazia()) { 
					
					tamMax = Math.max(tamMax, fila.getCount());
					
					Cliente clienteAtendendo =fila.desinfileirar();
					
					inicioAtendimento=tempoAtual;
					espera = inicioAtendimento - clienteAtendendo.getHoraChegou();
					fim = tempoAtual + clienteAtendendo.getTempoServico();
					
					somaEspera += espera;
					tempoOcupado+= clienteAtendendo.getTempoServico();
					
					
					
					tempoAtual=fim;
					
					
				}
				
				
				System.out.println("atendendo "+cliente.getNome()+": inicio="+inicioAtendimento+",fim="+fim+",espera="+espera);
		
				
			}
			System.out.println("tempo medio de espera:"+ somaEspera/(double)numeroC);
			System.out.println("ultilizacao do caixa "+ tempoOcupado);
			System.out.println("tamanho maximo da fila:"+tamMax);
	    	
	    }catch(ObjetoNaoEncontradoException e) {
	    	System.out.println(e.getMessage());
	    }catch(ListaVaziaException e) {
	    	System.out.println(e.getMessage());
	    }catch(ContainerVazioException e) {
	    	System.out.println(e.getMessage());
	    }
	    
	    
		
		scan.close();
	}
	
			
	

}
