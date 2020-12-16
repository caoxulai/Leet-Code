package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class asteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> left = new ArrayList<>();
        Stack<Integer> right = new Stack<>();
        for(int asteroid: asteroids) {
            if(asteroid > 0)
                right.push(asteroid);
            else {
                boolean addToLeft = true;
                while(!right.isEmpty()){
                    if(right.peek() > -asteroid) {
                        addToLeft = false;
                        break;
                    }else if(right.peek() == -asteroid) {
                        addToLeft = false;
                        right.pop();
                        break;
                    }else {
                        right.pop();
                    }
                }
                if(addToLeft)
                    left.add(asteroid);
            }
        }

        int totalSize = left.size() + right.size();
        int[] ans = new int[totalSize];
        for(int i=0; i<left.size(); i++) {
            ans[i] = left.get(i);
        }

        int rightSize = right.size();
        for(int i=1; i<=rightSize; i++) {
            ans[totalSize - i] = right.pop();
        }
        return ans;
    }
}
