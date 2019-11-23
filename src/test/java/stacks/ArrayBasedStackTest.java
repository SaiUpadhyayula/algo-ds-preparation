package stacks;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArrayBasedStackTest {

    private ArrayBasedStack<String> arrayBasedStack;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        arrayBasedStack = new ArrayBasedStack<String>(1);
    }

    @Test
    public void testCreation() {
        assertNotNull(arrayBasedStack);
    }

    @Test
    public void testWhetherStackIsEmptyOrNot() {
        assertTrue(arrayBasedStack.isEmpty());

        arrayBasedStack.push("Sai");
        assertFalse(arrayBasedStack.isEmpty());
    }

    @Test
    public void testOnePushAndOnePop() {
        arrayBasedStack.push("Sai");
        assertThat(arrayBasedStack.size(), is(1));
        assertThat(arrayBasedStack.pop(), is("Sai"));
        assertTrue(arrayBasedStack.isEmpty());
    }

    @Test
    public void testExceptionThrown_If_Element_Pushed_When_Stack_Is_Full() {
        arrayBasedStack.push("Sai");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Stack is full");
        arrayBasedStack.push("Subramanyam");
    }

    @Test
    public void testExceptionThrown_If_Element_Pop_When_Stack_Is_Empty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Stack is Empty");
        arrayBasedStack.pop();
    }

    @Test
    public void testPeekOperation(){
        arrayBasedStack.push("Sai");
        assertThat(arrayBasedStack.peek(), is("Sai"));
    }


}