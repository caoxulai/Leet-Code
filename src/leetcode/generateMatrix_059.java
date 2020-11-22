package leetcode;

public class generateMatrix_059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;

        for(int i=0; 2*i<n; i++){
            for(int y=i; y<n-i; y++)
                matrix[i][y] = count++;

            for(int x=i+1; x<n-i; x++)
                matrix[x][n-i-1] = count++;

            if(i*2>=n-1)
                break;

            for(int y=n-i-2; y>=i; y--)
                matrix[n-i-1][y] = count++;

            for(int x=n-i-2; x>=i+1; x--)
                matrix[x][i] = count++;
        }
        return matrix;
    }
}
