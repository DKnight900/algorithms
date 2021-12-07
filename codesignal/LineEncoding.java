package codesignal;

public class LineEncoding {
    public static void main(String[] args) {
        System.out.println(lineEncoding("aabbbc"));
        System.out.println(lineEncoding("abc"));
        System.out.println(lineEncoding("zz"));
        System.out.println(lineEncoding("zzzz"));
        System.out.println(lineEncoding("abbcabb"));
    }

    static String lineEncoding(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i == s.length() - 1 || currentChar != s.charAt(i + 1)) {
                sb.append(currentChar);
            }
            else {
                int j = i;
                while (j != s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                }
                int subLength = s.substring(i, j + 1).length();
                sb.append(subLength + "" + s.charAt(i));
                i += subLength - 1;
            }
        }
        return sb.toString();
    }
}
