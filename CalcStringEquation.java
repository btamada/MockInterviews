import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a string like "8 + 2 - -3" give the answer
 *
 */
public class CalcStringEquation {

    static final String OPERATORS = "+-*/";

    public static void main(String[] args) {
        String eq = "8 + 2 - -3";
        System.out.println(calcStringEquation(eq));
    }

    // match a number with optional -
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+");
    }

    static int calcStringEquation(String eq) {
        if(eq == null || eq.length() == 0) throw new IllegalArgumentException("Invalid input");
        String[] sa = eq.split("\\s");
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();

        // O(N)
        for(int i = 0; i < sa.length; i++) {
            if(OPERATORS.indexOf(sa[i]) != -1) queue.add(sa[i]);
            else if(isNumeric(sa[i])) {
                int num = Integer.parseInt(sa[i]);

                // negative
                if(num < 0) {
                    nums.add(num);
                } else { // non-negative
                    nums.add(num);
                }
            }
        }

        int result = nums.poll();

        // get the operator
        while (!nums.isEmpty()) {
            int tmp;
            switch (queue.poll()) {
                case "+":
                    tmp = nums.poll();
                    result += tmp;
                    break;
                case "-":
                    tmp = nums.poll();
                    result -= tmp;
                    break;
                case "*":
                    tmp = nums.poll();
                    result *= tmp;
                    break;
                case "/":
                    tmp = nums.poll();
                    result /= tmp;
                    break;
            }
        }

        return result;
    }

}
