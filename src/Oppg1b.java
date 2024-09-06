import java.util.function.BinaryOperator;

public class Oppg1b {
	
	public static void main(String[] args) {
		
		int svar;		
		
		// i)
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		svar = beregn(12, 13, sum );
		System.out.println("summen av 12 og 13 er lik " + svar);
		
		// ii)
		BinaryOperator<Integer> storst = (a, b) -> Math.max(a, b);
		svar = beregn(-5, 3, storst );
		System.out.println(svar + " er størst av -5 og 3");
		
		// iii)
		BinaryOperator<Integer> avstand = (a, b) -> Math.abs(a - b);
		svar = beregn(54, 45, avstand);
		System.out.println("avstanden mellom 54 og 45 er " + svar);
	}
	
	public static int beregn(int a, int b, BinaryOperator<Integer> r) {
		return r.apply(a, b);
	}
}