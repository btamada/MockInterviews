import java.util.LinkedHashSet;
import java.util.Set;

/**

 Given an array with unique characters arr and a string str, find the smallest
 substring of str containing all characters of arr.

 Example:
 arr: [x,y,z], str: xyyzyzyx
 result: zyx

 Implement your solution and analyze the runtime complexity

 */
public class SmallestSubstringAllChars {

    public static void main(String[] args) {
        char[] chars = {'x','y','z'};
        System.out.println(smallestSubstring(chars,"xyyzyzyx"));
    }

    private static String smallestSubstring(char[] chars, String str) {
        if(chars == null || chars.length == 0 || str == null || str.length() == 0) return "";
        Set<Character> set = new LinkedHashSet<>();
        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            for (int k = i + 1; k < str.length(); k++) {
                if (set.contains(str.charAt(k))) {
                    set.clear();
                    break;
                } else {
                    set.add(str.charAt(k));
                }
            }
            if (set.size() == chars.length) break;
        }

        String uniqueSubstring = "";

        for(Character c : set) {
            uniqueSubstring += c;
        }

        return uniqueSubstring;
    }

}
