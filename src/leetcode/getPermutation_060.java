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
public class getPermutation_060 {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(getPermutation(5, 34));
    }
    
    
    public static String getPermutation(int n, int k) {
        int[] factorial  = new int[n+1];
        factorial [0] = 1;
        for(int i=1; i<=n; i++){
            factorial [i] = factorial [i-1] * i;
        }
        StringBuilder dict = new StringBuilder();
        for(int j=1; j<=n; j++){
            dict.append(j);
        }
        
        StringBuilder sb = new StringBuilder();
        k = k-1;
        for(int x=n-1; x>=0; x--){
            int bucket = k/factorial[x];
            sb.append(dict.charAt(bucket));
            dict.deleteCharAt(bucket);
            k %= factorial [x];
        }
        return sb.toString();
    }
}