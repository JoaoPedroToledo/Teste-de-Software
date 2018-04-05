package aula;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SenaTest {

	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}
	@Rule
	public ExpectedException excEsp = ExpectedException.none();
	
	@After
	public void tearDown() {
		s = null;
	}
	@Test
	public void a() throws Exception {

		System.out.println();

		Integer[] listaInt = new Integer[5];
		for (int i = 0; i < listaInt.length; i++) {
			listaInt[i] = (int) (Math.random() * 2);
		}

		Float[] listaFloat = new Float[5];
		for (int i = 0; i < listaInt.length; i++) {
			listaFloat[i] = (float) (Math.random() * 1.115);
		}

		System.out.println("Lista FLOAT");
		for (float k : listaInt) {
			System.out.println(k);
		}

		System.out.println("Lista INT");
		for (int k : listaInt) {
			System.out.println(k);
		}

	}

	@Test
	public void b() throws Exception {

		for (int k : s.getSena(10)) {
			System.out.println(k);
		}
		
		assertThat(s.getSena(10), everyItem(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(60))));

	}
	
	@Test 
	public void c() throws Exception{
		assertThat(s.getSena(10), o());
		
	}
	@Test 
	public void d() throws Exception{
		assertThat(s.getSena(10), dup());
		
	}
	
	private TypeSafeMatcher<List<Integer>> o(){
		return new TypeSafeMatcher<List<Integer>>() {
			boolean matchesSafety(List<Integer> str) {
				int t = 0;
				while(t < str.size()) {
					for (int i = t+1; i < str.size(); i++) {
						if(str.get(t) > str.get(i)) {
							return false;
						}
						
					}
					t++;
				}
				return true;
				}
			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
			@Override
			protected boolean matchesSafely(List<Integer> item) {
				return false;
			}
		};
	}
	
	private TypeSafeMatcher<List<Integer>> dup(){
		return new TypeSafeMatcher<List<Integer>>() {
			boolean matchesSafety(List<Integer> str) {
				int t = 0;
				while(t < str.size()) {
					for (int i = t+1; i < str.size(); i++) {
						if(str.get(t) > str.get(i)) {
							return false;
						}
						
					}
					t++;
				}
				return true;
				}
			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
			@Override
			protected boolean matchesSafely(List<Integer> item) {
				return false;
			}
		};
	}
	
	
	@Test
	public void e() throws Exception {
		excEsp.expect(NullPointerException.class);
		s.getSena(null);
	}

	@Test
	public void f() throws Exception {
		excEsp.expectMessage("Minimo 6");
		s.getSena(5);
	}
	@Test
	public void g() throws Exception {
		excEsp.expectMessage("Maximo 12");
		s.getSena(13);
	}
	
}