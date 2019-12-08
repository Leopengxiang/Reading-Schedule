public class ReplaceBlank {
    public static String replace(String orignalString) {
        if (orignalString == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < orignalString.length(); i++) {
            if (orignalString.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(orignalString.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy";
        s = null;
        s = replace(s);
        System.out.println(s);
    }
}
