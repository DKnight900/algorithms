/**
 *
 * @author DKnight900
 */
public class RabinKarp {
    
    private static final int prime = 101;
    
    public static void main(String[] args) {
        System.out.println(patternSearch("abeda", "eda"));
        System.out.println(patternSearch("eda", "eda"));
        System.out.println(patternSearch("abdefghta", "ght"));
    }
    
    public static int patternSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        long textHash = H1(text, m - 1);
        long patternHash = H1(pattern, m - 1); // Hash of first m characters of text
        for (int i = 1; i <= n - m + 1; i++) {            
            if (patternHash == textHash && text.substring(i - 1, i + m - 1).equals(pattern)) {
                return i - 1;
            }
            if (i < n - m + 1) {
                textHash = H2(text, i - 1, i + m - 1, textHash, m);
            }
        }
        return -1;
    }    
    
    private static long H1(String str, int end) {
        long hash = 0;
        for (int i = 0; i <= end; i++) {
            hash += str.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }
    
    private static long H2(String str, int oldIndex, int newIndex, long oldHash, int patternLen) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= prime;
        newHash += str.charAt(newIndex) * Math.pow(prime, patternLen - 1);
        return newHash;
    }    
}
