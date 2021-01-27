package leetcode;

public class tribonacci_1137 {
    private int[] ans = new int[38];
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;
        else if(ans[n] == 0)
            ans[n] = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
        return ans[n];
    }
}
