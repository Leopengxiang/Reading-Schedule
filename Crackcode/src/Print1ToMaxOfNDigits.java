import java.math.BigInteger;
import java.util.Arrays;

public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print1ToMaxOfNDigits_1(1);
    }



    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');
        int count = 0;

        while (!increment(number)) {
            count++;
            print(number);
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static boolean increment(char[] number) {
        int nLength = number.length;
        int takeOver = 0;
        boolean isOverflow = false;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + takeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum == 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum = nSum -10;
                    takeOver = 1;
                    number[i] = (char)(nSum + '0');
                }
            } else {
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public static void print(char[] number) {
        boolean isStartZero = true;
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            if (isStartZero && number[i] != '0') {
                isStartZero = false;
            }
            if(!isStartZero) {
                System.out.print(number[i]);
            }
        }
        System.out.print("\t");
    }

    public static void print1ToMaxOfNDigits_1(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i + '0');
            print1ToMaxOfNDigitsRcursively(number,0);
        }
    }

    private static void print1ToMaxOfNDigitsRcursively(char[] number, int index) {
        if (index == number.length - 1) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)(i + '0');
            print1ToMaxOfNDigitsRcursively(number, index+1);
        }
    }
}
