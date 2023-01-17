package leetcode;

public class countStudents_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int count[] = {0, 0}, n = students.length;
        for (int student: students)
            count[student]++;
        int k;
        for (k = 0; k < n && count[sandwiches[k]] > 0; ++k)
            count[sandwiches[k]]--;
        return n - k;
    }
}
