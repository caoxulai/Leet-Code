package leetcode;

public class minOperations_1598 {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(String log : logs) {
            if(log.equals("../")) {
                ans = ans==0 ? 0 : ans - 1;
            }else if(!log.equals("./")) {
                ans++;
            }
        }
        return ans;
    }
}
