package pacote;

import static org.junit.Assert.*;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import aula.Operacao;

@RunWith(Parameterized.class)
public class isNumberTest {
	private Object obj, ob;
	private Operacao op;

	@Before
	public void setUp() throws Exception {
		op = new Operacao();
	}
	
	public isNumberTest(Object obj, Object ob) {
		this.obj = obj;
		this.ob = ob;
	}
	
	 @Parameterized.Parameters
	    public static Collection<Object[]> parametros() {
	        return Arrays.asList(new Object[][] {                      
	        	{12, true},                      
	        	{12.0, true},                      
	        	{(char)12.0, false},                      
	        	{"12", false},                      
	        	{new Object(), false},                     
	        	{null, false}   }); 
	        }


	@Test
	public void testA() throws Exception {
		assertEquals(op.isNumber(obj), ob);
	}

}
