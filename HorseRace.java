import java.util.*;

/**
 *
 * Given a list of tuples return the ranking of the horses at the end of the race
 *
 * Input:
 * (3, 1) - horse 3 beat horse 1
 * (2, 3) - horse 2 beat horse 3
 * (4, 3) - horse 4 beat horse 2
 *
 *  Output:
 *  4 > 2 > 3 > 1
 *
 *  Time: O(wl)
 *  Space: O(w * len(l))
 *
 */
public class HorseRace {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        results.add("(3,1)");
        results.add("(2,3)");
        results.add("(4,3)");
        System.out.println(horseRace(results));
    }

    public static List<Integer> horseRace(List<String> results) {
        if(results == null || results.size() == 0) return null;

        List<Integer> ranking = new ArrayList<>();

        int[][] am = new int[results.size() + 2][results.size() + 2];

        for(int[] r : am)
            Arrays.fill(r, 0);

        // fill out the adjacency matrix
        for(String r : results) {
            int horseWon = Character.getNumericValue(r.charAt(1));
            int horseLost = Character.getNumericValue(r.charAt(3));
            am[horseWon][horseLost] = 1;
        }

        for(int i = 0; i < am.length; i++) {

            for(int k = 0; k < am[0].length; k++) {

                if(am[i][k] == 1) {

                    System.out.println("i: " + i);
                    System.out.println("k: " + k);

                    if(ranking.contains(i)) {

                        if (ranking.indexOf(i) == 0) {

                            ranking.add(0, k);

                        } else {

                            ranking.add(ranking.indexOf(i) + 1, k);

                        }

                    } else if(ranking.contains(k)) {

                        if (ranking.indexOf(k) == 0) {

                            ranking.add(0, i);

                        } else {

                            ranking.add(ranking.indexOf(k) - 1, i);

                        }

                    } else {

                        ranking.add(i);
                        ranking.add(k);

                    }

                }

            }

        }

        return ranking;
    }

}
