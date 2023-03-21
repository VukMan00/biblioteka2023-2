package biblioteka;

import java.util.Objects;

/**
 * Predstavlja autora knjige.
 * 
 * Autor ima samo ime i prezime, nema identifikator.
 * 
 * @author Bojan Tomic
 * @since 0.1.0
 *
 */
public class Autor {
	
	/**
	 * Ime autora kao String.
	 */
	private String ime;
	
	/**
	 * Prezime autora kao String
	 */
	private String prezime;

	/**
	 * Vraca ime autora.
	 * 
	 * @return ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja vrednost atributa ime.
	 * 
	 * Ime ne sme biti null niti prazan String.
	 * 
	 * @param ime nova vrednost za ime autora
	 * 
	 * @throws NullPointerException ako se unese null vrednost za ime
	 * @throws IllegalArgumentException ako se unese prazan String kao ime
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazno");
		
		this.ime = ime;
	}

	/**
	 * Vraca prezime autora.
	 * 
	 * @return prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja vrednost atributa prezime.
	 * 
	 * Prezime ne sme biti null niti prazan String.
	 * 
	 * @param prezime nova vrednost za prezime autora
	 * 
	 * @throws NullPointerException ako se unese null vrednost za prezime
	 * @throws IllegalArgumentException ako se unese prazan String kao prezime
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazno");

		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	/**
	 * Racuna hash code na osnovu imena i prezimena autora
	 * 
	 * @return hash code izracunat na osnovu imena i prezimena
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	/**
	 * Poredi dva autora prema imenu i prezimenu.
	 * 
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su ime i prezime isti </li>
	 * 		<li> false - ako je unet null objekat ili ako nije klase Autor </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	
}
