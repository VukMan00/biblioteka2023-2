package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

/**
 * Predstavlja biblioteku u koju se mogu dodati knjige, brisati i pretrazivati.
 * 
 * Nacin implementacije linijske strukture sa knjigama zavisi
 * od implementacione klase.
 * 
 * @author Bojan Tomic
 * @since 0.9.0
 *
 */
public interface BibliotekaInterfejs {
	
	/**
	 * Dodaje knjigu u biblioteku.
	 * 
	 * Knjiga ne sme biti null niti duplikat - ne sme postojati ista knjiga.
	 * 
	 * @param knjiga nova knjiga koju treba dodati u biblioteku
	 * 
	 * @throws NullPointerException ako je uneta knjiga null
	 * @throws IllegalArgumentException ako ista knjiga vec postoji u biblioteci
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	
	/**
	 * Brise knjigu iz biblioteke.
	 * 
	 * Ako je unet knjiga null ili ne postoji u biblioteci, ne desava se nista.
	 * 
	 * @param knjiga knjiga koju treba obrisati iz biblioteke
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	
	/**
	 * Vraca sve knjige iz biblioteke
	 * 
	 * @return lista sa svim knjigama iz biblioteke
	 */
	public List<Knjiga> vratiSveKnjige();
	
	
	/**
	 * Pretrazuje biblioteku i vraca sve knjige koje odgovaraju 
	 * kriterijumima pretrage.
	 * 
	 * Pretraga se moze vrsiti preko autora, isbn broja, dela naslova i dela naziva izdavaca.
	 * Pretraga preko autora i isbn broja je tacno kako je uneto,
	 * dok se pretrazuje prema delu naslova ili delu naziva izdavaca.
	 * 
	 * Ako se umesto parametra unese null ili -1 (isbn), taj kriterijum se ne koristi
	 * u pretrazi.
	 * 
	 * @param autor Autor knjige ili null ako se ne pretrazuje po autoru
	 * @param isbn isbn broj ili -1 ako se ne pretrazuje po isbn broju
	 * @param naslov deo naslova ili null ako se ne pretrazuje po naslovu
	 * @param izdavac deo naziva izdavaca ili null ako se ne pretrazuje po izdavacu
	 * 
	 * @return lista sa knjigama koje odgovaraju kriterijumima pretrage
	 * 
	 * @throws IllegalArgumentException ako nije unet nijedan kriterijum za pretragu
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor, 
			long isbn, String naslov, String izdavac);

}
