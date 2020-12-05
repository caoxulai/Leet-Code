package leetcode;

public class maxChunksToSorted_769 {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(arr[i], max);
            if(max <= i)
                chunks++;
        }
        return chunks;
    }
}
