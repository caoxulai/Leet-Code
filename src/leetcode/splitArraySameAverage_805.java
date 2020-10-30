package leetcode;

import java.util.Arrays;

public class splitArraySameAverage_805 {
    public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {
        if (leftNum == 0) return leftSum == 0;
        if ((A[startIndex]) > leftSum / leftNum) return false;
        for (int i = startIndex; i < A.length - leftNum + 1; i ++) {
            if (i > startIndex && A[i] == A[i - 1]) continue;
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) return true;
        }
        return false;
    }

    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;
        int sumA = 0;
        for (int a: A) sumA += a;
        Arrays.sort(A);
        for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB ++) {
            if ((sumA * lenOfB) % A.length == 0) {
                if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0)) return true;
            }
        }
        return false;

    }
}
