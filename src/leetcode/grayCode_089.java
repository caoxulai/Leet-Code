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
public class grayCode_089 {
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            for(int i=0, base=1; i<n; i++){
                int size = res.size();
                for(int j=size-1; j>=0; j--){
                    res.add(res.get(j) + base);
                }
                base <<= 1;
            }
            return res;
        }
    }
}
