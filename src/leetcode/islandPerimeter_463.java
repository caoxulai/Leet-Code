package leetcode;

public class islandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(i==0 || grid[i-1][j] == 0)
                        res += 2;
                    if(j==0 || grid[i][j-1] == 0)
                        res += 2;
                }
            }
        }
        return res;
    }
}
