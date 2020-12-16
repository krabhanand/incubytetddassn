package incubyte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void addNewLineAsSeparator()
    {
        assertEquals(25,stringCalculator.add("2,12\n4\n1,6"));
    }

    @Test
    public void addCustomDelimiter()
    {
        assertEquals(100,stringCalculator.add("//;\n1;2;57;40"));
    }

    @Test(expected = Exception.class)
    public void addNegativeNumberException()
    {
        try {
            stringCalculator.add("//;\n1;-2;32;-5;41;-59");
            
        } catch (Exception e) {
            
        //message expected from exception
        String expectedMessage = "negatives not allowed";

        //number expected from exception message
        int numExcep = -2;

        //verify if returned exception has above message and -ve number

        //get exception message
        String actualMessage = e.getMessage();

        //now verify for both
        assertTrue(actualMessage.contains(expectedMessage));
        assertTrue(actualMessage.contains(""+numExcep));
        }
        
        
    }



    
}
