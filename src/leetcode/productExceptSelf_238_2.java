package leetcode;

public class productExceptSelf_238_2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n ; i++) {
            left[i] = i>0 ? left[i-1] : 1;
            left[i] *= i>0 ? nums[i-1] : 1;

            right[n-1-i] = i>0 ? right[n-i] : 1;
            right[n-1-i] *= i>0 ? nums[n-i] : 1;
        }

        int[] result = new int[n];
        for(int j=0; j<n; j++) {
            int leftProduct = left[j];
            int rightProduct = right[j];
            result[j] = leftProduct * rightProduct;

        }
        return result;
    }
}
