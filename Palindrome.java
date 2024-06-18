
/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class Palindrome {
    public static void main(String[] args) {
        Util.print("isPalindromeV1", () -> isPalindromeV1("Marge, let's \"[went].\" I await {news} telegram."));
        Util.print("isPalindromeV2", () -> isPalindromeV2("Marge, let's \"[went].\" I await {news} telegram."));
        Util.print("isPalindromeV3", () -> isPalindromeV3("Marge, let's \"[went].\" I await {news} telegram."));
    }

    public static boolean isPalindromeV1(String s) {
        int len = s.length();
        if (len == 1 || len == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        len = s.length();
        if (len == 1 || len == 0) return true;
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(String s) {
        int len = s.length();
        if (len <= 1) return true;
        StringBuilder filtered = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        len = filtered.length();
        if (len <= 1) return true;
        for (int i = 0; i <= len / 2; i++) {
            if (filtered.charAt(i) != filtered.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV3(String s) {
        int len = s.length();
        if (len <= 1) return true;
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        len = filtered.length();
        if (len <= 1) return true;
        for (int i = 0; i <= len / 2; i++) {
            if (filtered.charAt(i) != filtered.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
