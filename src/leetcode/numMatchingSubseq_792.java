package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class numMatchingSubseq_792 {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> remainingWords = new HashMap<>();

        for(char c = 'a'; c<='z'; c++) {
            remainingWords.put(c, new LinkedList<>());
        }
        for(String word: words) {
            remainingWords.get(word.charAt(0)).add(word);
        }

        int count = 0;
        for(char c: S.toCharArray()) {
            int size = remainingWords.get(c).size();
            for(int i=0; i<size; i++) {
                String word = remainingWords.get(c).poll();
                if(word.length() == 1)
                    count++;
                else
                    remainingWords.get(word.charAt(1)).offer(word.substring(1));
            }
        }

        return count;
    }
}
