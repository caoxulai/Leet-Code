/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class letterCombinations_017 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)  return res;
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        res.add("");
        for(char digit: digits.toCharArray()){
            List<String> temp = new ArrayList<>();
            for(String pre: res){
                for(char c: map[digit-'0'].toCharArray()){
                    String s = pre + c;
                    temp.add(s);
                }
            }
            res = temp;
        }
        return res;
    }
}
