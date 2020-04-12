package dsf19Exam2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProblemStack3WrapperTest {
	
	ProblemStack3Wrapper.Stack<String> S, R;

	@Before
	public void setUp() throws Exception {
		S = new ProblemStack3Wrapper.SingleLinkedStack<>();
		// S = {Joe, Ned, Jil, Ned, Apu}
		S.push("Apu");
		S.push("Ned");
		S.push("Jil");
		S.push("Ned");
		S.push("Joe");

	}

	@Test
	public void test1() {
		S.clear();
		R = ProblemStack3Wrapper.stackTop(S, 2);
		assertEquals("On empty stack S = {}, stackTop(S, 2) fails to return empty stack.", true, 
				R.isEmpty());
	}

	@Test
	public void test2() {
		R = ProblemStack3Wrapper.stackTop(S, 1);
		assertEquals("On stack S = {Joe, Ned, Jil, Ned, Apu}, stackTop(S, 1) fails to return "
				+ "stack {Joe} and leave S as it was.", true, 
				R.size() == 1 && R.pop().equals("Joe") && S.size() == 5 && S.top().equals("Joe"));
	}
	
	@Test
	public void test5() {
		R = ProblemStack3Wrapper.stackTop(S, 4);
		assertEquals("On stack S = {Joe, Ned, Jil, Ned, Apu}, stackTop(S, 4) fails to return "
				+ "stack {Joe, Ned, Jil, Ned} and leave S as it was.", true, 
				R.size() == 4 && R.pop().equals("Joe") && R.pop().equals("Ned") 
				&& R.pop().equals("Jil") && R.pop().equals("Ned") &&  S.size() == 5
				&& S.top().equals("Joe"));
	}

}