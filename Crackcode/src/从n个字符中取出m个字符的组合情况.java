import java.util.*;

public class Solution{

    public static List<String> conbinations(String str, int n) {
        ArrayList<String> result = new ArrayList();
        if (str == null || n < 1 || str.length() < n) {
            return result;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        TreeSet<String> resultSet = new TreeSet<>();
        conbinations(chars, new char[n], 0, 0, resultSet);
        result.addAll(resultSet);
        return result;
    }

    private static void conbinations(char[] chars, char[] oneResult, int begin, int index, TreeSet resultSet) {
        // begin 为当前指向 chars数组中的起始处的指针， 而 index 则表示当前oneResult中的元素充填到哪了 
        int len = chars.length;
        if (index == oneResult.length) {
            resultSet.add(String.valueOf(oneResult));
            return;
        }
        if (len - begin < oneResult.length - index) {
            return;
        } // 代表所有， C(n, m) 其中 m > n 的情况
        oneResult[index] = chars[begin];
        conbinations(chars, oneResult, begin + 1, index + 1, resultSet);  // 代表C（n-1, m -1）
        conbinations(chars, oneResult, begin + 1, index, resultSet);   // 代表 C （n-1, m）
    }
    
    public static void main(String[] args) {
        List<String> result = conbinations("abcdefghijk", 1);
        for (String s : result) {
            System.out.println(s);
        }
    }
}