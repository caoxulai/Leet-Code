package leetcode;

public class characterReplacement_424 {

    public static void main(String [] args) {
        System.out.println(characterReplacement("BABB", 0));
    }

    public static int characterReplacement(String s, int k) {
        int ans = 0;
        int first = 0, last= 0;
        int[] charCount = new int[26];
        while(first < s.length()) {
            while(last < s.length()) {
                charCount[s.charAt(last) - 'A'] += 1;
                last++;
                if(replacementCount(charCount, last - first) <= k) {
                    ans = Math.max(ans, last-first);
                } else
                    break;
            }
            charCount[s.charAt(first) - 'A'] -= 1;
            first++;
        }
        return ans;
    }

    private static int replacementCount(int[] charCount, int subStringLen) {
        return subStringLen - getMax(charCount);
    }

    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
