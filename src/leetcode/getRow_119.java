package leetcode;

import java.util.ArrayList;
import java.util.List;

public class getRow_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> currentLevel = new ArrayList<>();
        currentLevel.add(1);
        for(int i=0; i<=rowIndex; i++) {
            List<Integer> nextLevel = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                int num = getNum(currentLevel, j-1) + getNum(currentLevel, j);
                nextLevel.add(num);
            }
            currentLevel = nextLevel;
        }
        return currentLevel;
    }

    private int getNum(List<Integer> list, int pos) {
        if(pos < 0 || pos > list.size()-1)
            return 0;
        return list.get(pos);
    }
}
