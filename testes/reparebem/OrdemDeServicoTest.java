package reparebem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdemDeServicoTest {
	private OrdemDeServico os;

	@BeforeEach
	void setUp(){
		this.os = new OrdemDeServico("Maria", "(83) 98765-4321", "Vestido");
	}
	
	@Test
	void testAlterarStatus() {
		this.os.alterarStatus("Em andamento");
		assertEquals(
				os.getStatus(),
				"Em andamento"
		);
	}
	
}
