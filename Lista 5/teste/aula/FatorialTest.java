package aula;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;



@RunWith(Parameterized.class)
public class FatorialTest {
	
	@Mock
    private A a;

    private long entrada;
    private long esperado;
	
	public FatorialTest(long entrada, long esperado){
		this.entrada = entrada;
		this.esperado = esperado;
	}
	
	@Before
    public void setUp(){
        a = mock(A.class);
        when(a.fatorial(0)).thenReturn((long) 0);
        when(a.fatorial(1)).thenReturn((long) 1);
        when(a.fatorial(2)).thenReturn((long) 2);
        when(a.fatorial(5)).thenReturn((long) 120);

    }
	
	@Parameterized.Parameters
	public static Collection<Object[]> p(){
		return Arrays.asList(new Object[][]{
			{0, 0},
			{1, 1},
			{2, 2},
			{5, 120},
		});
		
	}
	@Test
	public void test(){
		assertEquals(esperado, a.fatorial(entrada), 0);
	}

}
