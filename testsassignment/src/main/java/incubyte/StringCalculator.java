package incubyte;

public class StringCalculator{
    public int add(String numbers){
        if(numbers.equals(""))
            return 0;
        String[] nums = numbers.split(",");
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
            sum += Integer.parseInt(nums[i]);
        return sum;
    }
}