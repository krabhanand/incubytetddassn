package incubyte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
    public void addEmptyString() throws Exception {
        assertEquals(0,stringCalculator.add(""));
    }

    @Test
    public void addOneBumberString() throws Exception
    {
        assertEquals(4,stringCalculator.add("4"));
    }

    @Test
    public void addTwoNumberString() throws Exception{
        assertEquals(5,stringCalculator.add("2,3"));
        assertNotEquals(4,stringCalculator.add("2,3"));
    }

    @Test
    public void addMultipleNumberString() throws Exception{
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
    public void addNewLineAsSeparator() throws Exception
    {
        assertEquals(25,stringCalculator.add("2,12\n4\n1,6"));
    }





    @Test
    public void addCustomDelimiter() throws Exception
    {
        assertEquals(100,stringCalculator.add("//;\n1;2;57;40"));
    }




    @Test
    public void addNegativeNumberException()throws Exception
    {
        Exception e = assertThrows(NumberFormatException.class,() -> {stringCalculator.add("//;\n1;-2;32;-5;41;-59");});
            
            
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

    @Test
    public void showAllNegativesInException() throws Exception{
        Exception e = assertThrows(NumberFormatException.class,() -> {stringCalculator.add("//;\n1;-2;32;-5;41;-59");});
            
            
        //message expected from exception
        String expectedMessage = "negatives not allowed";

        //number expected from exception message
        int[] numExcepArr = {-2,-5,-59};

        //verify if returned exception has above message and -ve number

        //get exception message
        String actualMessage = e.getMessage();

        //now verify for both
        assertTrue(actualMessage.contains(expectedMessage));
        for(int numExcep:numExcepArr)
        assertTrue(actualMessage.contains(""+numExcep));
    }


    @Test
    public void testCallCount() throws Exception{
        stringCalculator.setCallCount(0);
        stringCalculator.add("2,1,6,4");
        stringCalculator.add("2,1,6,8");
        stringCalculator.add("2,1,6,7");
        stringCalculator.add("2,1,6,6");
        stringCalculator.add("2,1,6,2");
        assertEquals(5,stringCalculator.getCallCount());
    }


    @Test
    public void ignoreGreaterThanThousand() throws Exception
    {
        assertEquals(90,stringCalculator.add("2,56,32,4443"));
    }

    
}
