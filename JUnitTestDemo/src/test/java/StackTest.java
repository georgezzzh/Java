import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
    private Stack<String> stack;
    //each time test setting
    @Before
    public void setUp(){
        stack = new Stack<>();
        stack.push("dog");
        stack.push("moon");
    }

    /**
     *  stack.empty() return true
     */
    @Test public void test_C1T(){
        stack.clear();
        Assert.assertTrue(stack.empty());
    }
    /**
     *  stack.empty() return false
     */
    @Test public void test_F(){
        Assert.assertFalse(stack.empty());
    }
    /**
     * stack isn't empty & stack.pop() return not null
     */
    @Test public void test_FT(){
        Assert.assertNotNull(stack.pop());
    }
    /**
     * stack isn't empty & stack.pop() throw a EmptyStackException
     */
    @Test(expected = EmptyStackException.class)
    public void test_FF(){
        stack.clear();
        stack.pop();
    }
    /**
     * stack isn't empty & stack.pop() return not null & stack.search() return actual index
     */
    @Test public void test_FTT(){
        Assert.assertFalse(stack.empty());
        Assert.assertNotNull(stack.pop());
        //return actual index
        Assert.assertEquals(stack.search("dog"),1);
    }
    /**
     * stack isn't empty & stack.pop() return null & stack.search("dog") return -1
     */
    @Test(expected = EmptyStackException.class)
    public void test_FFF(){
        Assert.assertFalse(stack.empty());
        stack.clear();
        //stack.search() return -1 when stack can't contain "dog"
        Assert.assertEquals(stack.search("dog"),-1);
        //C2 throw a Exception
        stack.pop();
    }
    /**
     * stack isn't empty & stack.pop() return null & stack.search() return actual index
     */
    @Test public void test_FFT(){
        Assert.assertFalse(stack.empty());
        stack.push(null);
        Assert.assertNull(stack.pop());
        Assert.assertEquals(stack.search("moon"),1);
    }
    /**
     * stack isn't empty & stack.pop() return not null & stack.search() return -1
     */
    @Test public void test_FTF(){
        Assert.assertFalse(stack.empty());
        Assert.assertNotNull(stack.pop());
        Assert.assertEquals(stack.search("chicken"),-1);
    }
}
