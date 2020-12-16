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

    @Test
    public void addMultipleNumberString(){
        assertEquals(6,stringCalculator.add("1,2,3"));
        assertEquals(20,stringCalculator.add("2,5,6,3,4"));
        assertEquals(55,stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));

        StringBuilder temp = new StringBuilder("");
        for(int i = 1;i <= 22;i++)
        {
            temp.append((2*i-1)+",");
        }
        assertEquals(484,stringCalculator.add(temp.toString()));
    }


    
}
