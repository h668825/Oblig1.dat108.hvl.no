import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Oppg1a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		// Oppgåve: skrive ut liste på skjermen sortert etter tallverdi
		// skal bruke Collections.sort()
		// lambda-uttrykk for Comparator som sort() nyttar
		System.out.println(listen.stream()
			.sorted((a, b) -> Integer.parseInt(a) - Integer.parseInt(b))
			.collect(Collectors.toList()));
	}
}
