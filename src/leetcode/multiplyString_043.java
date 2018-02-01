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
public class multiplyString_043 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(multiply("1200", "62176"));
    }
    
    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        for(int p=0; p<len1; p++){
            int n1 = num1.charAt(len1-1-p) - '0';
            int c = 0;
            for(int q=0; q<len2; q++){
                int n2 = num2.charAt(len2-1-q) - '0';
                c += n1*n2;
                if(p+q >= sb.length())  sb.append(c%10);
                else{
                    c += sb.charAt(p+q) -'0';
                    sb.setCharAt(p+q, (char)(c%10 + '0'));
                }
                c /= 10;
            }
            while(c!=0){
                int index = p + len2;
                if(index >= sb.length())  sb.append(c%10);
                else{
                    c += sb.charAt(index) - '0';
                    sb.setCharAt(index, (char)(c%10 + '0'));
                }
                c /= 10;
                index++;
            }
        }
        
        while(sb.length()>1){
            if(sb.charAt(sb.length()-1) == '0')
                sb.setLength(sb.length()-1);
            else
                break;
        }
        return sb.reverse().toString();
    }
}