package incubyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator{
    
    private int callCount;

    StringCalculator(){
        this.callCount = 0;
    }

    public int add(String numbers) throws NumberFormatException{
        // set call count, increase by 1 on each call
        setCallCount(getCallCount()+1);

        //if string empty return 0
        if(numbers.equals(""))
            return 0;

        //prepare pattern matcher variables to split, match and get delimiters    
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("//");
        matcher = pattern.matcher(numbers);
        String delimiter = "";

        //find if custom delimiters exist
        if(matcher.find())
        {
            //separate numbers list and line of delimiters
            String[] sepdelim = numbers.split("\n");
            
            //get group of delimiters
            String delimitergrp = sepdelim[0].split("//")[1];

            //find if multiple custom delimiters exist or single of length > 1
            pattern = Pattern.compile("\\[");
            matcher = pattern.matcher(delimitergrp);

            //find the delimiter
            delimiter = findDelimiter(delimitergrp,matcher);
            
            
            //put array of numbers in numbers string
            numbers = sepdelim[1];
        }
        else{
            delimiter = ",|\n";
        }
        String[] nums = numbers.split(delimiter);

        //find the sum from list and return it
        return findSumFromNumbers(nums);
        
    }


    private String findDelimiter(String delimitergrp, Matcher matcher) {
        String delimiter = "";

        //find if custom delimiters exist
        if(matcher.find())
            {
                String[] delimiters = delimitergrp.split("(\\[)");
                StringBuilder makeDelimiter = new StringBuilder("");
                for(int j = 0; j<delimiters.length; j++) {
                    String delim = delimiters[j].split("(\\])")[0];
                    if(!(delim.equals("")))
                        {
                            makeDelimiter.append("[\\\\"+delim.charAt(0)+"]+");
                            if(j != delimiters.length-1)
                                makeDelimiter.append("|");
                        }
               }
               delimiter = makeDelimiter.toString();
            }
            else{
                //if custom delimiters do not exist, delimitergrp will have the only delimiter 
                delimiter = delimitergrp;
            }
        return delimiter;
    }

    private int findSumFromNumbers(String[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            int temp = Integer.parseInt(nums[i]);
            if(temp < 0) {
                StringBuilder numExepList = new StringBuilder("");
                for(int j = i;j< nums.length; j++){
                    if(Integer.parseInt(nums[j]) < 0)
                        numExepList.append(nums[j]+" ");
                }
                throw new NumberFormatException("negatives not allowed : "+numExepList.toString());
            }
            if(temp <= 1000)
                sum += temp;
        }
        return sum;
    }

    public void setCallCount(int count) {
        this.callCount = count;
    }

    public int getCallCount()
    {
        return callCount;
    }
}