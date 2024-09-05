import java.util.Arrays;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		// liste skal sorterast og skrivast ut? 
		//Skriv ned oppgåveteksten her så det er lettare å skjønne.
		listen.stream()
			.mapToInt(x -> Integer.parseInt(x))
			.sorted()
			.forEach( s -> System.out.print(s + ","));
			
			// TODO konkatenere som streng, fjerne komma til slutt	
			// TODO lag eit predikat som skal sorterast med
	}
}
