package leetcode;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class generate_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List>();
        if(numRows == 0)    return ans;
        ans.add(new ArrayList<>(List.of(1)));
        for(int i=1; i<numRows; i++) {
            List<Integer> currentLevel = ans.get(i-1);
            List<Integer> nextLevel = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                int num = getNum(currentLevel, j-1) + getNum(currentLevel, j);
                nextLevel.add(num);
            }
            ans.add(nextLevel);
        }
        return ans;
    }

    private int getNum(List<Integer> list, int pos) {
        if(pos < 0 || pos > list.size()-1)
            return 0;
        return list.get(pos);
    }
}
