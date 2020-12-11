package leetcode;

public class numFriendRequests_825 {
    public int numFriendRequests(int[] ages) {
        int[] numInAge = new int[121];
        int[] sumInAge = new int[121];

        for(int age : ages) {
            numInAge[age]++;
        }

        for(int age=1; age<=120; age++) {
            sumInAge[age] = sumInAge[age-1] + numInAge[age];
        }

        int count = 0;
        for(int age=15; age<=120; age++) {
            int qualifiedB = sumInAge[age] - sumInAge[age/2 + 7];
            count += numInAge[age] * qualifiedB - numInAge[age];
        }

        return count;
    }
}
