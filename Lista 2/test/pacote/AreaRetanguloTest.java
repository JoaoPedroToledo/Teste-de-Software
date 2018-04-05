package pacote;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import aula.Operacao;

@RunWith(Parameterized.class)
public class AreaRetanguloTest {
	private double a, b, c;
	private Operacao op;

	@Before
	public void setUp() {
		op = new Operacao();
	}
	public AreaRetanguloTest(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Parameters 
	public static Collection<Object[]>get(){
		Object[][] x = new Object[][]{
			{0, 0, 0},
			{1, 1, 1},
			{2, 0, 0},
			{0, 2, 0}
		};
		return Arrays.asList(x);
	}


	@Test
	public void test() throws Exception {
		assertEquals(op.areaRetangulo(b, a), b, b);
	}

}
