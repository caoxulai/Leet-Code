package leetcode;

public class addStrings_415_1 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int max = Math.max(m, n), c = 0;
        for(int i = 0; i<=max; i++) {
            int a = m>=0 ? num1.charAt(m--) - '0' : 0;
            int b = n>=0 ? num2.charAt(n--) - '0' : 0;
            int sum = a + b + c;
            sb.insert(0, sum % 10);
            c /= 10;
        }

        if(c != 0)
            sb.insert(0, c);

        return sb.toString();

    }
}
