package leetcode;

public class maxDistToClosest_849 {
    public int maxDistToClosest(int[] seats) {
        int empty = 0;
        int first = -1, last = -1;
        int max = 0;

        for(int i=0; i<seats.length; i++) {
            if(seats[i] == 0)
                empty ++;
            else {
                if(first == -1)
                    first = i;
                last = i;

                max = Math.max(max, (empty+1)/2);
                empty = 0;
            }
        }


        max = Math.max(max, first);
        max = Math.max(max, seats.length - 1 - last);

        return max;
    }
}
