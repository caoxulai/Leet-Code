package leetcode;

public class constructArray_667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        for (int i = 0, lo = 1, hi = n; lo <= hi; i++)
            ans[i] = k > i ? ( (k-i) % 2 != 0 ? lo++ : hi--) : lo++;
        return ans;
    }
}
