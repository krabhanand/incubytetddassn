package incubyte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static StringCalculator stringCalculator;

    @BeforeClass
    public static void initialize ()
    {
        stringCalculator = new StringCalculator();
    }

    //give empty string as parameter to add function
    @Test
    public void addEmptyString()
    {
        assertEquals(0,stringCalculator.add(""));
    }

    @Test
    public void addOneBumberString()
    {
        assertEquals(4,stringCalculator.add("4"));
    }

    @Test
    public void addTwoNumberString(){
        assertEquals(5,stringCalculator.add("2,3"));
        assertNotEquals(4,stringCalculator.add("2,3"));
    }
    
}
