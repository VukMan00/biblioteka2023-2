package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import biblioteka.Autor;
import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {

	protected BibliotekaInterfejs biblioteka;

	@Test
	void testDodajKnjiguNull() {
		assertThrows(NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}

	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		
		biblioteka.dodajKnjigu(k);
		
		assertThrows(IllegalArgumentException.class,
				() -> biblioteka.dodajKnjigu(k) );
	}
	
	@Test
	void testDodajKnjiguSveOk() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue( knjige.contains(k) );
	}
	
	@Test
	void testDodajKnjiguSveOk2() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		
		biblioteka.dodajKnjigu(k2);

		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k) );
		assertTrue( knjige.contains(k2) );
	}

	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		
		biblioteka.dodajKnjigu(k2);

		biblioteka.obrisiKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue( knjige.contains(k2) );
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		
		k3.setIsbn(999);
	

		biblioteka.obrisiKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue( knjige.contains(k) );
		assertTrue( knjige.contains(k2) );
	}

	@Test
	void testPronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class ,
				() -> biblioteka.pronadjiKnjigu(null, -1, null, null));
	}
	
	@Test
	void testPronadjiKnjiguNaslovNull() {
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, 0, null, "Laguna");
		
		assertTrue( rezultat.isEmpty() );
	}
	
	
	@Test
	@Timeout(value = 3, unit = TimeUnit.MILLISECONDS)
	void testPronadjiKnjiguNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		k.setNaslov("Prohujalo sa vihorom");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		k2.setNaslov("Gospodar prstenova");
		
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, -1, "PRST", null);
		
		assertEquals(1, rezultat.size());
		assertTrue( rezultat.contains(k2) );
	}
	
	@Test
	@Timeout(3)
	void testPronadjiViseKnjigaNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		k.setNaslov("Prohujalo sa vihorom");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		k2.setNaslov("Gospodar prstenova");
		
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, -1, "PR", null);
		
		assertEquals(2, rezultat.size());
		assertTrue( rezultat.contains(k) );
		assertTrue( rezultat.contains(k2) );
	}
	
	@Test
	void testUpisKnjigeUFajl() {
		Autor autor = new Autor();
		autor.setIme("Milos");
		autor.setPrezime("Manojlovic");
		
		Autor autor1 = new Autor();
		autor1.setIme("Milenko");
		autor1.setPrezime("Milenkovic");
		
		List<Autor> autori = new ArrayList<>();
		autori.add(autor);
		autori.add(autor1);
		
		Knjiga knjiga1 = new Knjiga();
		knjiga1.setIsbn(123);
		knjiga1.setNaslov("Karamazov");
		knjiga1.setIzdavac("Vuk");
		knjiga1.setIzdanje(1);
		knjiga1.setAutori(autori);
		
		Knjiga knjiga2 = new Knjiga();
		knjiga2.setAutori(autori);
		knjiga2.setIsbn(234);
		knjiga2.setIzdanje(2);
		knjiga2.setIzdavac("Marivoje");
		knjiga2.setNaslov("Ana Karenjina");
		
		biblioteka.dodajKnjigu(knjiga1);
		biblioteka.dodajKnjigu(knjiga2);
		
		biblioteka.upisKnjigaUFajl("knjige.json");
		assertEquals(2, biblioteka.vratiSveKnjige().size());
	}

	@Test
	void testUpisKnjigeUFajlSaNull() {
		assertThrows(NullPointerException.class, ()->biblioteka.upisKnjigaUFajl(null));
	}
	
	@Test
	void testUpisKnjigeUFajlPrazanString() {
		assertThrows(IllegalArgumentException.class, ()->biblioteka.upisKnjigaUFajl(""));
	}
	
	@Test
	void testCitanjeIzFajla() {
		Autor autor = new Autor();
		autor.setIme("Milos");
		autor.setPrezime("Manojlovic");
		
		Autor autor1 = new Autor();
		autor1.setIme("Milenko");
		autor1.setPrezime("Milenkovic");
		
		List<Autor> autori = new ArrayList<>();
		autori.add(autor);
		autori.add(autor1);
		
		Knjiga knjiga1 = new Knjiga();
		knjiga1.setIsbn(543);
		knjiga1.setNaslov("Proces");
		knjiga1.setIzdavac("Franc Kafka");
		knjiga1.setIzdanje(3);
		knjiga1.setAutori(autori);
		
		Knjiga knjiga2 = new Knjiga();
		knjiga2.setAutori(autori);
		knjiga2.setIsbn(234);
		knjiga2.setIzdanje(2);
		knjiga2.setIzdavac("Marivoje");
		knjiga2.setNaslov("Ana Karenjina");
		
		biblioteka.dodajKnjigu(knjiga1);
		biblioteka.dodajKnjigu(knjiga2);
		
		biblioteka.citanjeIzFajla("knjige.json");
		assertEquals(3, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	void testCitanjeIzFajlaSaNull() {
		assertThrows(NullPointerException.class, ()->biblioteka.citanjeIzFajla(null));
	}
	
	@Test
	void testCitanjeIzFajlaPrazanString() {
		assertThrows(IllegalArgumentException.class, ()->biblioteka.citanjeIzFajla(""));
	}
}
