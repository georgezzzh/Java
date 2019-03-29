import static org.junit.Assert.*;
import org.junit.Test;
public class TriangleTest {
    @Test
    public void test(){
        assertEquals(true,new RegularTriangle().isLegal(1,1,3));
    }
}
