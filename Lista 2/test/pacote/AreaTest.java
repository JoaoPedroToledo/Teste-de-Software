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
public class AreaTest {

	private double a, b, c;
	private Operacao op;

	@Before
	public void setUp() {
		op = new Operacao();
	}
	public AreaTest(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Parameters 
	public static Collection<Object[]>parametros(){
		Object[][] x = new Object[][]{
			{-1, 0, -1},
			{0, -1, -1},
			{-1, -1, 1},
		};
		return Arrays.asList(x);
	}


	@Test(expected = Exception.class)
	public void test() throws Exception {
		assertEquals(op.areaRetangulo(a, b), b, b);
	}

}
