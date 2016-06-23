import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrays {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        addArrays(list1,list2).stream().forEach((num) -> {
            System.out.print(num + " ");
        });
    }

    /*
        - Add the numbers from the small list to the big list
            1  1  1  1
            9, 9, 9, 9, 9
            +     1, 2, 3
            -------------
         1  0  0  1  2  2
    */
    private static List<Integer> addArrays(List<Integer> list1, List<Integer> list2) {
        if(list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0)
            throw new IllegalArgumentException("invalid input");

        List<Integer> result = new ArrayList<>();

        int bigIndex = list1.size() - 1;
        int smallIndex = list2.size() - 1;
        int carryDigit = 0;

        while(smallIndex >= 0) {
            int sum = list1.get(bigIndex) + list2.get(smallIndex) + carryDigit;
            if(sum >= 10) {
                int rem = sum % 10;
                carryDigit = sum / 10;
                result.add(rem);
            } else {
                result.add(sum);
            }
            --smallIndex;
            --bigIndex;
        }

        while(bigIndex >= 0) {
            if(carryDigit > 0) {
                int sum = list1.get(bigIndex) + carryDigit;
                if(sum >= 10) {
                    int rem = sum % 10;
                    carryDigit = sum / 10;
                    result.add(rem);
                } else {
                    result.add(sum);
                }
            } else {
                result.add(list1.get(bigIndex));
            }
            --bigIndex;
        }

        if(carryDigit > 0) result.add(carryDigit);

        Collections.reverse(result);

        return result;
    }

}
