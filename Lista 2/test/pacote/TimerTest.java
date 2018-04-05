package pacote;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import aula.Operacao;

@RunWith(Parameterized.class)
public class TimerTest {
	private int cont, time;
	private Operacao op;

	@Before
	public void setUp() throws Exception {
		op = new Operacao();
	}
	
	public TimerTest(int cont, int time) {
		this.time = time;
		this.cont = cont;
	}
	
	@Parameters 
	public static Collection<Object[]>collect(){
		Object[][] n = new Object[][]{
			{1, 1100},
			{3, 3100}
		};
		return Arrays.asList(n);
	}
	
	@Test
	public void testZ() throws Exception {
		assertEquals(op.timer(cont), op.timer(cont));;
	}

}
