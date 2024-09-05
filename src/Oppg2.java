import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Oppg2 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Anne", "Kverner", "Landmåler", Kjonn.Kvinne, 800000),
				new Ansatt("Jan", "Meling", "Byggingeniør", Kjonn.Mann, 700000),
				new Ansatt("Rikke", "Kverner", "Lærling", Kjonn.Kvinne, 300000),
				new Ansatt("Jarl", "Varg", "Lærling", Kjonn.Mann, 350000),
				new Ansatt("Claus", "Ementhaler", "Røyrleggar", Kjonn.Mann, 500000)
		);
		
		
		// i) fast kronetillegg
		Function<Ansatt, Integer> kroneTillegg = a -> a.getAarslonn() + 10000;
		
		lonnsoppgjor(ansatte, kroneTillegg);
		
		System.out.println("med kronetillegg på 10000");
		skrivUtAlle(ansatte);
		
		
		// ii) fast prosenttillegg
		Function<Ansatt, Integer> prosentTillegg = a -> (int)(a.getAarslonn() * 1.10);
		
		lonnsoppgjor(ansatte, prosentTillegg);
		
		System.out.println("med prosenttillegg på 10%");
		skrivUtAlle(ansatte);
		
		
		// i) fast kronetillegg
		Function<Ansatt, Integer> lavLonnTillegg = a -> 
			a.getAarslonn() < 400000 
				? kroneTillegg.apply(a) 
				: a.getAarslonn();
		
		lonnsoppgjor(ansatte, lavLonnTillegg);
		
		System.out.println("med kronetillegg på 10000 for alle med løn under 400 000");
		skrivUtAlle(ansatte);
		
		
		// i) fast kronetillegg
		Function<Ansatt, Integer> mannProsentTillegg = a ->
			a.getKjonn() == Kjonn.Mann 
				? prosentTillegg.apply(a) 
				: a.getAarslonn();
		
		lonnsoppgjor(ansatte, mannProsentTillegg);
			
		System.out.println("med prosenttillegg på 10% for alle menn");
		skrivUtAlle(ansatte);
	}

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> r) {
		for (Ansatt ansatt : ansatte) {
			ansatt.setAarslonn(r.apply(ansatt));
		}
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
		System.out.print("\n\n");
	}
}
