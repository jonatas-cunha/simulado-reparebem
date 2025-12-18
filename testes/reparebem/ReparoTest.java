package reparebem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ReparoTest {
	private Reparo r;
	
	@BeforeEach
	void setUp(){
		this.r = new Reparo("btn", "Costura simples de botão", 15.00);
	}
	
	
	@Test
	void testReajustarPreco() {
		r.reajustarPreco(1.1);
		assertEquals(r, 16.50);
	}

}
