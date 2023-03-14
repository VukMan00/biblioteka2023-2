package biblioteka;

import java.util.List;
import java.util.Objects;

public class Knjiga {
	
	private String naslov;
	
	private long isbn;
	
	private List<Autor> autori;
	
	private String izdavac;

	private int izdanje;

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		if (naslov == null)
			throw new NullPointerException("Naslov ne sme biti null");
		
		if (naslov.isEmpty())
			throw new IllegalArgumentException("Naslov ne sme biti prazan");
		
		this.naslov = naslov;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN ne sme biti nula niti manji");
		
		this.isbn = isbn;
	}

	public List<Autor> getAutori() {
		return autori;
	}

	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Izdavac ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");		
		
		this.izdavac = izdavac;
	}

	public int getIzdanje() {
		return izdanje;
	}

	public void setIzdanje(int izdanje) {
		if (izdanje < 1)
			throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
		
		this.izdanje = izdanje;
	}

	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return isbn == other.isbn;
	}
	
	
}
