/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class countAndSay_038 {
    class Solution {
        public String countAndSay(int n) {
            if(n<=0)    return "";
            String res = "1";
            for(int i=2; i<=n; i++){
                StringBuilder sb = new StringBuilder();
                int cnt = 1;
                char pre = res.charAt(0);
                for(int j=1; j<res.length(); j++){
                    char c = res.charAt(j);
                    if(c == pre)    cnt++;
                    else{
                        sb.append(cnt).append(pre);
                        pre = c;
                        cnt=1;
                    }
                }
                sb.append(cnt).append(pre);
                res = sb.toString();
            }
            return res;
        }
    }
}
