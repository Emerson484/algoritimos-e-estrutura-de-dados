package atv5_transformacaoDeExpressoes;

public class ClasseTeste {
	public static void main(String []args)   {
		try {
			TransformarExpressoes te = new TransformarExpressoes();
			
			System.out.println("tranformando expressao infixa 10-6/2  em posfixa ");
		    System.out.println(te.infixaPosfixa("10-6/2"));
		   // em pofixa 1062/-
		    
	        TransformarExpressoes t2 = new TransformarExpressoes();
			
	        System.out.println("tranformando expressao infixa 2+3*4  em posfixa ");
		    System.out.println(t2.infixaPosfixa("2+3*4"));
		   // em posfixa  234*+
		    
	       TransformarExpressoes t3 = new TransformarExpressoes();
			
	        System.out.println("tranformando expressao infixa 2+3*4  em prefixa ");
		    System.out.println(t3.infixaPrefixa("2+3*4"));
		    //em pref +2*34
		    
	        TransformarExpressoes t4 = new TransformarExpressoes();
			
	        System.out.println("tranformando expressao infixa a+b*c  em prefixa ");
		    System.out.println(t4.infixaPrefixa("a+b*c"));
		   //em pref +a*bc
		    
	       TransformarExpressoes t5 = new TransformarExpressoes();
			
	       System.out.println("tranformando expressao posfixa 10 6 2 / - em infixa");
		    System.out.println(t5.posfixaInfixa("10 6 2 / -"));
		    
	        TransformarExpressoes t6 = new TransformarExpressoes();
			
	        System.out.println("tranformando expressao posfixa 2 3 4 * +  em infixa");
		    System.out.println(t6.posfixaInfixa("2 3 4 * +" ));
			
		} catch (ContainerVazioException e) {
			 System.out.println(e.getMessage());
		} catch (ObjetoNaoEncontradoException e) {
			 System.out.println(e.getMessage());
		} catch (ListaVaziaException e) {
			 System.out.println(e.getMessage());
		}
		
	}
	
	

}
