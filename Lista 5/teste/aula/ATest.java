package aula;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ATest {

	@Mock
	private A a = null;
	private Object Exception;
	private String d;
	private Object NullPointerException;
	//private double z;

	private double z() {
		return 0;
	}

	@Before
	public void setUp() throws Exception {

		a = mock(A.class);
		when(a.calc(2, 2)).thenReturn(4);
		when(a.calc("x", "y")).thenReturn("xy");
		when(a.calc(a, "y" )).thenReturn(NullPointerException);
		when(a.calc("2", 2 )).thenReturn(Exception);
	}

	@Test
	public void test1() throws NullPointerException, Exception {
		assertEquals(4, a.calc(2, 2));
	}

	@Test
	public void test2() throws NullPointerException, Exception{
		assertEquals("xy", a.calc("x", "y"));
	}
	@Test
	public void test3() throws NullPointerException, Exception{
		assertEquals(Exception, a.calc("2", 2));
	}
	@Test
	public void test4() throws NullPointerException, Exception{
		assertEquals(NullPointerException, a.calc(null, "y"));
	}

	@Test(expected = Exception.class)
	public void test5(){
		doThrow(new Exception("Teste")).when(a).msg(d);
	}

	@Test
	public void test6() {
		when(a.area(z())).thenCallRealMethod();

		verify(a, times(0)).pi();
		assertEquals(a.area(z()), 0.0, 0.0);
		verify(a, times(1)).pi();
	}


	@Test
	public void test7() {
		when(a.pow()).thenCallRealMethod();

		verify(a, times(0)).pi();
		assertEquals(a.pow(), 0.0, 0.0);
		verify(a, times(2)).pi();
	}
	@Test
	public void incTest() {
		when(a.inc()).thenReturn(1,2,3,4).thenThrow(new NullPointerException("Além do Limite"));
		while( true ) {
			System.out.println(a.inc() );
		}
	}


}
