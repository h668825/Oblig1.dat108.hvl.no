
public class Oppg1b {
	
	public static void main(String[] args) {
		
		int svar;
		
		//tips - Bifunction / binary operator
		
		// i)
		Beregner sum = (a, b) -> a + b;
		svar = beregn(12, 13, sum );
		System.out.println("summen av 12 og 13 er lik " + svar);
		
		// ii)
		Beregner storst = (a, b) -> Math.max(a, b);
		svar = beregn(-5, 3, storst );
		System.out.println(svar + " er størst av -5 og 3");
		
		// iii)
		Beregner avstand = (a, b) -> Math.abs(a - b);
		svar = beregn(54, 45, avstand);
		System.out.println("avstanden mellom 54 og 45 er " + svar);
	}
	
	public static int beregn(int a, int b, Beregner r) {
		return r.run(a, b);
	}
}

@FunctionalInterface
interface Beregner {
	public int run(int a, int b);
}

