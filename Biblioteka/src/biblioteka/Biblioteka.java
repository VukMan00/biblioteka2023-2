package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

/**
 * Implementira biblioteku, pri cemu je
 * lista sa knjigama implementirana preko ArrayList klase
 * 
 * @author Bojan Tomic
 * @since 0.9.0
 */
public class Biblioteka implements BibliotekaInterfejs {

	/**
	 * Lista sa knjigama iz biblioteke - ArrayList implementacija
	 */
	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	
	
	//Pravi komentar, pravi kod
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga je duplikat");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn < 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();
		
		if (naslov!=null)
		  for (Knjiga k: knjige)
			if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase().trim()))
				rezultati.add(k);		
		
		return rezultati;
	}

}
