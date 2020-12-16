package incubyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator{
    
    private Pattern pattern;
    private Matcher matcher;
    
    StringCalculator(){

    }
    public int add(String numbers){
        if(numbers.equals(""))
            return 0;
        pattern = Pattern.compile("//");
        matcher = pattern.matcher(numbers);
        String delimiter = "";
        if(matcher.find())
        {
            //separate delimiter line and array of numbers by \n as point of separation
            String[] sepdelim = numbers.split("\n");
            //get delimiter from line
            delimiter = sepdelim[0].split("//")[1];
            //put array of numbers in numbers string
            numbers = sepdelim[1];
        }
        else{
            delimiter = ",|\n";
        }
        String[] nums = numbers.split(delimiter);
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
            sum += Integer.parseInt(nums[i]);
        return sum;
    
    }
}