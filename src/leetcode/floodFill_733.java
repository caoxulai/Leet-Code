package leetcode;

public class floodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if(originColor == newColor) return image;
        return floodFill(image, sr, sc, originColor, newColor);
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int originColor, int newColor) {
        //this is a dfs algorithm.
        if(image[sr][sc] == originColor){
            image[sr][sc] = newColor;
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            for(int i=0; i<4; i++){
                int nr = sr + dr[i];
                int nc = sc + dc[i];
                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length){
                    image = floodFill(image, nr, nc, originColor, newColor);
                }
            }
        }
        return image;
    }
}
