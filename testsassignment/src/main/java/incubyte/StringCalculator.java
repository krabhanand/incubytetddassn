package incubyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator{
    
    private int callCount;

    StringCalculator(){
        this.callCount = 0;
    }

    public int add(String numbers) throws Exception{
        // set call count, increase by 1 on each call
        setCallCount(getCallCount()+1);
        if(numbers.equals(""))
            return 0;
        Pattern pattern;
        Matcher matcher;
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
        for(int i = 0;i<nums.length;i++){
            int temp = Integer.parseInt(nums[i]);
            if(temp < 0) {
                StringBuilder numExepList = new StringBuilder("");
                for(;i< nums.length; i++){
                    if(Integer.parseInt(nums[i]) < 0)
                        numExepList.append(nums[i]+" ");
                }
                throw new NumberFormatException("negatives not allowed : "+numExepList.toString());
            }
            if(temp <= 1000)
                sum += temp;
        }
        return sum;
    
    }

    public void setCallCount(int count){
        this.callCount = count;
    }

    public int getCallCount()
    {
        return callCount;
    }
}