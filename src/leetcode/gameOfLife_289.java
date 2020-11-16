package leetcode;

public class gameOfLife_289 {
    public void gameOfLife(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int liveCount = -get(board, i, j);;
                for(int a=i-1; a<=i+1; a++){
                    for(int b=j-1; b<=j+1; b++){
                        liveCount += get(board, a, b);
                    }
                }
                if( (board[i][j] & 1) == 0 && liveCount == 3
                        || (board[i][j] & 1) == 1 && liveCount == 2
                        || (board[i][j] & 1) == 1 && liveCount == 3)
                    board[i][j] += 2;
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] >>= 1;
            }
        }
    }

    private int get(int[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length)
            return 0;
        else
            return board[i][j] & 1;
    }
}
