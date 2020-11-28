package leetcode;

public class countArrangement_526 {
    private boolean[] visited;
    private int count = 0;
    public int countArrangement(int N) {
        visited = new boolean[N + 1];
        tryPosition(N, 1);
        return count;
    }

    private void tryPosition(int N, int pos) {
        if(pos > N)
            count++;
        for(int i=1; i<=N; i++) {
            if(!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                tryPosition(N, pos + 1);
                visited[i] = false;
            }
        }
    }
}
