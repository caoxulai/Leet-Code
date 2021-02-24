package leetcode;

public class sortArrayByParityII_922 {
    public int[] sortArrayByParityII(int[] A) {
        int even=0, odd = 1;
        for(int i=A.length-1; i>=0; i--) {
            if(i%2 != A[i] %2){
                if(A[i] % 2 == 0){
                    int t = A[even];
                    A[even] = A[i];
                    A[i] = t;
                    even += 2;
                }
                else{
                    int t = A[odd];
                    A[odd] = A[i];
                    A[i] = t;
                    odd += 2;
                }
                i++;
            }
        }
        return A;
    }
}
