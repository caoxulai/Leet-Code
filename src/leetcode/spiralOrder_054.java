package leetcode;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0)    return res;
        int n = matrix[0].length;

        for(int i=0; 2*i<Math.min(m,n); i++){
            for(int y=i; y<n-i; y++)
                res.add(matrix[i][y]);

            for(int x=i+1; x<m-i; x++)
                res.add(matrix[x][n-i-1]);

            if(i*2>=m-1)
                break;

            for(int y=n-i-2; y>=i; y--)
                res.add(matrix[m-i-1][y]);

            if(i*2>=n-1)
                break;

            for(int x=m-i-2; x>=i+1; x--)
                res.add(matrix[x][i]);
        }

        return res;
    }
}
