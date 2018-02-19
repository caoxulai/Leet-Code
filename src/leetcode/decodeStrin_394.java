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
public class decodeStrin_394 {
    // 73.54%
    // My first implementation after reading the solution, lots of redundencies
    public static void main(String [] args){
        System.out.println(decodeString("3[a2[c]]3[a]2[bc]"));
        
    }
    
    static int i=0;
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(; i<s.length(); i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9')
                sb.append(s.charAt(i));
            else{
                int n = 0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    n = n*10 + s.charAt(i)-'0';
                    i++;
                }
                
                i++;
                String next = getBlock(s);
                for(int x=0; x<n; x++){
                    sb.append(next);
                }
            }
        }
        return sb.toString();
    }
    
    public static String getBlock(String s) {
        StringBuilder sb = new StringBuilder();
        for(; i<s.length(); i++){
            if(s.charAt(i) == ']'){
                break;
            }
            else if(s.charAt(i)<'0' || s.charAt(i)>'9')  sb.append(s.charAt(i));
            else{
                int n = 0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    n = n*10 + s.charAt(i)-'0';
                    i++;
                }
                
                i++;
                String next = getBlock(s);
                for(int x=0; x<n; x++){
                    sb.append(next);
                }
            }
        }
        return sb.toString();
    }
}

