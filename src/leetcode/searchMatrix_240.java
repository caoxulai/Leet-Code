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
public class searchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0)  return false;
        int col = matrix[0].length;
        
        int i=0, j=col-1;
        while(i<row && j>=0){
            if(matrix[i][j] == target)  return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
