package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber_179 {
    public String largestNumber(int[] nums) {

        String[] numStrings = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrings, new Comparator<String>(){
            @Override
            public int compare(String num1, String num2) {
                String num1num2 = num1 + num2;
                String num2num1 = num2 + num1;
                return num2num1.compareTo(num1num2);
            }
        });

        if(numStrings[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String num : numStrings) {
            sb.append(num);
        }
        return sb.toString();
    }
}
