/*
 * hint - bruk stream(), map(), filter(), reduce(), osv.
 * alle svar lagrast i variablar og skrivast deretter ut til skjermen
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Anne", "Kverner", "sjef", Kjonn.Kvinne, 700000),
				new Ansatt("Jan", "Meling", "Byggingeniør", Kjonn.Mann, 700000),
				new Ansatt("Rikke", "Kverner", "Lærling", Kjonn.Kvinne, 300000),
				new Ansatt("Jarl", "Varg", "Lærling", Kjonn.Mann, 350000),
				new Ansatt("Claus", "Ementhaler", "Røyrleggar", Kjonn.Mann, 500000)
		);

		
		// a) Lag ei ny liste som kun inneheld etternamna til dei tilsette
		List<String> etternamnAnsatt = ansatte.stream()
			.map(a -> a.getEtternavn())
			.toList();
		etternamnAnsatt.stream().forEach(System.out::println);
		
		System.out.println();
		
		
		// b) Finn ut antal kvinner blant dei tilsette
		long kvinnerAnsatt = ansatte.stream()
				.filter(a -> (a.getKjonn() == Kjonn.Kvinne))
				.count();
		System.out.println("mengd tilsette kvinner: " + kvinnerAnsatt);		
		
		System.out.println();
		
		// c) Rekn ut gjennomsnittslønna til kvinnene
		OptionalDouble kvinnerLonnSnitt = ansatte.stream()
				.filter(a -> (a.getKjonn() == Kjonn.Kvinne))
				.mapToInt(a -> a.getAarslonn())
				.average();

		System.out.println(kvinnerLonnSnitt.isPresent()
			? "Snittløn for kvinner: " + kvinnerLonnSnitt.getAsDouble()
			: "Finner ingen tilsette kvinner");
		
		System.out.println();
		
		
		// d) Gi alle sjefar (stilling inneheld noko med "sjef") ei lønnsauke på 7% ved å bruke
		// streams direkte i staden for metoden du laga i Oppg2. Skriv ut lista av tilsette etter
		// lønnsauken
		
		//TODO contains er case sensitive, dvs. den skiller mellom "Sjef" og "sjef".
		//	implementer på ein måte som ikkje skiller mellom desse.
		ansatte.stream()
			.filter(a -> a.getStilling().contains("sjef"))
			.forEach(a -> a.setAarslonn((int)(a.getAarslonn() * 1.07)));
		ansatte.stream().forEach(System.out::println);
		
		System.out.println();
		
		
		// e) Finn ut (true|false) om det er nokon tilsette som tenar meir enn 800.000,-
		boolean finnastHogLonn = ansatte.stream()
			.anyMatch(a -> a.getAarslonn() > 800000);
		
		System.out.println(finnastHogLonn 
			? "det finnast ein tilsett med løn over 800 000" 
			: "det finnast ikkje ein tilsett med løn over 800 000");
		
		System.out.println();
			
		
		// f) Skriv ut alle dei tilsette med System.out.println() utan å nytte løkke
		ansatte.stream().forEach(System.out::println);
		
		System.out.println();
		
		
		// Finn den/dei tilsette som har lågast løn
		Optional<Ansatt> laagastLon = ansatte.stream()
			.min((a, b) -> a.getAarslonn() - b.getAarslonn());
		
		System.out.println(laagastLon.isPresent() 
				? "den tilsette med lågast løn heiter " + 
					laagastLon.get().getfornavn() + " " + 
					laagastLon.get().getEtternavn() + 
					" og har løna: " +
					laagastLon.get().getAarslonn()
				: "fann ingen tilsette med gyldig løn");
		
		System.out.println();
		
		
		// Finn ut summen av alle heiltal i [i, 1000> som er deleleg med 3 eller 5
		int sumIntDeleleg = IntStream.range(1, 1000)
			.filter(n -> n % 5 == 0 || n % 3 == 0)
			.sum();
		System.out.println(sumIntDeleleg);
		
		System.out.println();
	}
}
