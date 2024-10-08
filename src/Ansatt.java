
public class Ansatt {
	
	private String fornavn, 
				etternavn, 
				stilling;
	private Kjonn kjonn;
	private int aarslonn;
	
	Ansatt(String fornavn, 
			String etternavn, 
			String stilling,
			Kjonn kjonn,
			int aarslonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.stilling = stilling;
		this.kjonn = kjonn;
		this.aarslonn = aarslonn;
		
	}
	
	public String getfornavn() {
		return fornavn;
	}

	@Override
	public String toString() {
		return "navn: " + fornavn + " " + etternavn + ", stilling: " + stilling + ", kjonn: " + kjonn
				+ ", aarslonn: " + aarslonn;
	}

	public void setfornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public Kjonn getKjonn() {
		return kjonn;
	}

	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}

	public int getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}

}
