/**
 *
 * Find the substring and reverse
 *
 * Input:
 * String == "This is a test iss it working?";
 * Substring == "is";
 *
 * Output:
 * "Thsi si a test ssi it working?"
 *
 */
public class ReverseSubstring {

    static final String revSub = "si";

    public static void main(String[] args) {
        String str = "This is a test iss it working?";
        String sub = "is";
        System.out.println(reverseSubstring(str,sub));
    }

    public static String reverseSubstring(String str, String sub) {
        if(str == null || sub == null || str.length() == 0 || sub.length() == 0) return null;

        StringBuilder sb = new StringBuilder();

        // perform a linear scan to find the substring
        for(int i = 0; i < str.length(); i++) {

            // if we find the first character of our substring...
            if(str.charAt(i) == sub.charAt(0)) {
                int ctr = 0;
                boolean isValidSub = false;

                // make sure we found a valid substring
                for(int k = i; k < sub.length() + i; k++) {
                    if(str.charAt(k) == sub.charAt(ctr) && ctr < sub.length()) {
                        ++ctr;
                        isValidSub = true;
                    } else {
                        isValidSub = false;
                        break;
                    }
                }

                // if we found a valid substring, reverse it
                if(isValidSub) {
                    ++i;
                    sb.append(revSub);
                    continue;
                }
            }

            sb.append(str.charAt(i));

        }

        return sb.toString();
    }

    static String reverseSubstring(String str, int startIndex, int endIndex) {
        char[] subCA = str.toCharArray();
        for(int i = startIndex; i < (endIndex - startIndex) / 2 + startIndex; i++) {
            swap(subCA, i, ((endIndex - startIndex) / 2) + startIndex - i);
        }
        return new String(subCA);
    }

    static void swap(char[] ca, int a, int b) {
        char tmp = ca[a];
        ca[a] = ca[b];
        ca[b] = tmp;
    }

}
