/**
 * Remove duplicate characters from a string
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("hhelllowwwworrllldd"));
    }

    static String removeDuplicates(String s) {
        if(s == null || s.length() == 0) return null;

        // result string to return
        String result = "";

        // holder for prev char in the string
        char prev = s.charAt(0);

        // iterate through the string
        for(int i = 1; i < s.length(); i++) {

            // check if prev char is not same as current char
            if(prev != s.charAt(i)) {
                result += prev;
                prev = s.charAt(i);
            }
        }

        // add the last character to the result
        result += s.charAt(s.length() - 1);

        return result;
    }

}
