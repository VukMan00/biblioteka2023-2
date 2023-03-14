package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {
	
	Knjiga k;

	@BeforeEach
	void setUp() throws Exception {
		k = new Knjiga();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	@Test
	void testSetNaslovNull() {
		assertThrows(NullPointerException.class,
				() -> k.setNaslov(null));
	}

	@Test
	void testSetNaslovPrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> k.setNaslov(""));
	}
	
	@Test
	void testSetNaslov() {
		k.setNaslov("Tihi don");
		
		assertEquals("Tihi don", k.getNaslov());
	}
	
	@Test
	void testSetIzdavacNull() {
		assertThrows(NullPointerException.class,
				() -> k.setIzdavac(null));
	}

	@Test
	void testSetIzdavacPrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> k.setIzdavac(""));
	}
	
	@Test
	void testSetIzdavac() {
		k.setIzdavac("Vulkan");
		
		assertEquals("Vulkan", k.getIzdavac());
	}

	@Test
	void testSetIzdanje() {
		k.setIzdanje(1);
		
		assertEquals(1, k.getIzdanje());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIzdanjeNedozvoljeno(int izdanje) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setIzdanje(izdanje));
	}

	
	@Test
	void testSetISBN() {
		k.setIsbn(1);
		
		assertEquals(1, k.getIsbn());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIsbnNedozvoljeno(int isbn) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setIsbn(isbn));
	}

	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		k.setNaslov("Tihi don");
		k.setIzdavac("Vulkan");
		k.setIzdanje(3);
		k.setIsbn(999);
		
		Autor a = new Autor();
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		List<Autor> autori = new ArrayList<Autor>();
		autori.add(a);
		
		k.setAutori(autori);
		
		String s = k.toString();

		assertTrue( s.contains("999") );
		assertTrue( s.contains("Tihi don") );
		assertTrue( s.contains("3") );
		assertTrue( s.contains("Vulkan") );
		assertTrue( s.contains("Pera") );
		assertTrue( s.contains("Peric") );
	}
	
	@ParameterizedTest
	@CsvSource ({
		"999, 999, true",
		"5656, 7766, false"
	})
	void testEquals(long isbn1,long isbn2, boolean isti) {
		k.setIsbn(isbn1);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(isbn2);
		
		assertEquals(isti, k.equals(k2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(k.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(k.equals(k));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(k.equals(new Exception()));
	}
	
}
