package leetcode;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses_093_1 {
    public class Solution {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            ArrayList<String> res = new ArrayList<>();
            for(int a=1; a<=3 && a<=len-3; a++){
                if(isValid(s.substring(0, a))){
                    for(int b=a+1; b<=a+3 && b<=len-2; b++){
                        if(isValid(s.substring(a, b))){
                            for(int c=b+1; c<= b+3 && c<=len-1; c++){
                                if(isValid(s.substring(b, c)) && isValid(s.substring(c))){
                                    res.add(s.substring(0, a) + "." + s.substring(a, b) + "." + s.substring(b, c) +  "." + s.substring(c));
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }

        private boolean isValid(String s){
            if(s.length()>3 || Integer.parseInt(s) > 255 || s.length()>1 && s.charAt(0) == '0')
                return false;
            else
                return true;
        }
    }
}
