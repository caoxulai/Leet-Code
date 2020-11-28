package leetcode;

public class canPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n <= 0)  return true;
        for(int i=0; i<flowerbed.length; i++) {
            if(getFlowers(flowerbed, i) == 0) {
                if(--n <= 0)
                    return true;
                flowerbed[i] = 1;
            }
        }
        return false;
    }

    private int getFlowers(int[] flowerbed, int i) {
        int flowers = flowerbed[i];
        if(i > 0) flowers += flowerbed[i-1];
        if(i < flowerbed.length-1) flowers += flowerbed[i+1];
        return flowers;
    }
}
