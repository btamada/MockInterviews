import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of tuples find the K nearest points to the given point, P.
 */
public class KNearNeighbor {

    public static void main(String[] args) {
        List<String> points = new ArrayList<>();
        points.add("(2,2)");
        points.add("(2,0)");
        points.add("(3,5)");
        points.add("(0,0)");
        points.add("(1,4)");
        for(String s : kNearestNeighbors(points, "(1,1)", 2)) {
            System.out.println(s);
        }
    }

    /**
     *
     * Time: O(n log n)
     * Space: O(K)
     *
     * @param points - list of tuples containing points (x,y) on a graph
     * @param origin - the original point to find the K nearest neighbors from
     * @param K - the numbers of neighbors to obtain from the origin
     * @return - the K nearest points
     */
    static List<String> kNearestNeighbors(List<String> points, String origin, int K) {
        if(points == null || points.size() == 0) return null;

        // O(K) space, where K is the number of neighbors
        List<String> result = new ArrayList<>();

        String x = String.valueOf((origin.charAt(1)));
        String y = String.valueOf((origin.charAt(3)));

        // Add the origin to the list of points
        // O(nlogn) time to sort
        points.add(origin);
        Collections.sort(points);

        for(String s : points) {

            // when we find the origin
            if(s.equals(origin)) {

                int orgIndex = points.indexOf(origin);
                int left = orgIndex - 1; // left pointer
                int right = orgIndex + 1; // right pointer

                // get the K nearest neighbors
                while(K > 0) {

                    if(left >= 0) {
                        result.add(points.get(left));
                        --left;
                    } else if(right < points.size()) {
                        result.add(points.get(right));
                        ++right;
                    }

                    --K;
                }
            }
        }

        return result;
    }

}
