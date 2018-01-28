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
public class setZeroes_073 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            if(matrix == null || matrix.length==0 || matrix[0].length==0)
                return;
            int row = matrix.length;
            int col = matrix[0].length;
            
            boolean firstRow = false;
            for(int j=0; j<col; j++){
                if(matrix[0][j]==0){
                    firstRow = true;
                    break;
                }
            }
            
            boolean firstCol = false;
            for(int i=0; i<row; i++){
                if(matrix[i][0]==0){
                    firstCol = true;
                    break;
                }
            }
            
            for(int i=1; i<row; i++){
                for(int j=1; j<col; j++){
                    if(matrix[i][j]==0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            
            for(int i=1; i<row; i++){
                for(int j=1; j<col; j++){
                    if(matrix[i][0]==0 && matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
            
            
            if(firstRow){
                for(int j=0; j<col; j++){
                    matrix[0][j]=0;
                }
            }
            
            if(firstCol){
                for(int i=0; i<row; i++){
                    matrix[i][0]=0;
                }
            }
        }
    }
}
