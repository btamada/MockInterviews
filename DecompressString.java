/**
 *
 * Change the uncompressed string to the decompressed string below:
 *
 * Uncompressed: 2(2u2lt4d)3(rb)pa
 * Decompressed: uulltdddduulltddddrbrbrbpa
 *
 */
public class DecompressString {

    public static void main(String[] args) {
        System.out.println(decompress("2(2u2lt4d)3(rb)pa"));
    }

    public static String decompress(String uncomp) {
        if(uncomp == null || uncomp.length() == 0) return new String();

        StringBuilder decomp = new StringBuilder();

        char[] caStr = uncomp.toCharArray();

        for(int i = 0; i < caStr.length; i++) {

            // we found a number
            if(Character.isDigit(caStr[i])) {
                StringBuilder parenStr = new StringBuilder();
                int outerNum = Character.getNumericValue(caStr[i]);
                if(caStr[++i] == '(') {

                    // create the string within the parenthesis
                    while(caStr[++i] != ')') {
                        int num = 0;

                        // number before letter
                        if(Character.isDigit(caStr[i])) {
                            num = Character.getNumericValue(caStr[i]);

                            // add n letters to decompress the stringbuilder
                            ++i;
                            while(num > 0) {
                                parenStr.append(caStr[i]);
                                --num;
                            }
                        // no number before letter
                        } else {
                            parenStr.append(caStr[i]);
                        }

                    }

                    // add the string in parenthesis n number of times
                    while(outerNum > 0) {
                        decomp.append(parenStr.toString());
                        --outerNum;
                    }

                }
            } else {
                // we found a letter
                decomp.append(caStr[i]);
            }

        }

        return decomp.toString();
    }

}
