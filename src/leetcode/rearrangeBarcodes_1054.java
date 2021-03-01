package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rearrangeBarcodes_1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0) return barcodes;
        Map<Integer, Integer> counter = new HashMap<>();
        int max_fre = 0;
        for (int num : barcodes) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            if (counter.get(num) > max_fre) {
                max_fre = counter.get(num);
            }
        }
        List<Integer>[] buckets = new ArrayList[max_fre + 1];
        for (int num : counter.keySet()) {
            int c = counter.get(num);
            if (buckets[c] == null) {
                buckets[c] = new ArrayList<>();
            }
            buckets[c].add(num);
        }

        int index = 0;
        int[] res = new int[barcodes.length];
        for (int i = max_fre; i >= 1; i--) {
            List<Integer> b = buckets[i];
            if (b == null) continue;
            for (int num : b) {
                int j = i;
                while (j > 0) {
                    res[index] = num;
                    index = index + 2 < barcodes.length ? index + 2 : 1;
                    j--;
                }
            }
        }
        return res;
    }
}
