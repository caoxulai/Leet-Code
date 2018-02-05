/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Arrays;

/**
 *
 * @author Bryce
 */
public class maximalRectangle_085 {
    
    public static void main(String [] args)    {
        char[][] matrix = {
            {'1', '0', '0'}, 
            {'1', '1', '1'}, 
            {'0', '1', '1'}};
        
        System.out.println(maximalRectangle(matrix));
    }
    
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] h = new int[n];
        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(left, 0);
        
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1')    h[j]++;
                else    h[j] = 0;
            }
            
            int curLeft=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1')    left[j] = Math.max(left[j], curLeft);
                else{
                    curLeft = j+1;
                    left[j] = 0;    // set left[i] -> 0 for the reference of next row
                }
            }
            
            int curRight=n;
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j] == '1')    right[j] = Math.min(right[j], curRight);
                else{
                    curRight = j;
                    right[j] = n;    // set right[i] -> n for the reference of next row
                }
            }
            
            for(int j=0; j<n; j++){
                max = Math.max(max, h[j] * (right[j] - left[j]));
                
                System.out.println("i " + i + " j " + j + " max " + max);
            }
        }
        return max;
    }
}
