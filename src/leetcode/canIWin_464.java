package leetcode;

import java.util.HashMap;
import java.util.Map;

public class canIWin_464 {

    public static void main(String [] args)    {
        System.out.println(canIWin(10, 40));
    }

    // O(n^2) time, O(n^2) space
    private static Map<Integer, Boolean> numSetToWinMap;
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if(desiredTotal > sum)  return false;
        if(desiredTotal <= 0)   return true;

        // for ith bit, '0' - i used, '1' - i not used.
        int mask = (int) (Math.pow(2, maxChoosableInteger) - 1);
        numSetToWinMap = new HashMap<>();
        return canIWin(mask, maxChoosableInteger, desiredTotal);
    }

    private static boolean canIWin(int mask, int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0) return false;
        if(!numSetToWinMap.containsKey(mask)){
            int newMask = mask;
            for(int i=maxChoosableInteger; i>0; i--) {
                if((newMask & (1 << (i-1))) > 0) {
                    newMask ^= 1 << (i-1);
                    if(!canIWin(newMask, maxChoosableInteger, desiredTotal-i)){
                        numSetToWinMap.put(mask, true);
                        return true;
                    }
                    // reset the mask
                    newMask ^= 1 << (i-1);
                }
                numSetToWinMap.put(mask, false);
            }
        }
        return numSetToWinMap.get(mask);
    }
}
