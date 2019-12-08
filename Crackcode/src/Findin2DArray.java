public class Findin2DArray {
    public static boolean find(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if (matrix[i][j] == num) {
                return true;
            } else if (num > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] twoDArr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(twoDArr.length);
        int[] testNums = {1, 7, 9, 12, 15, 8, 6};
        for (int i : testNums) {
            System.out.println(find(twoDArr, i));
        }
        System.out.println(find(twoDArr,3));
    }
}
