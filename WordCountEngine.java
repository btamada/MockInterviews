import java.util.*;

/**

 Word Count Engine

 Implement a document scanning engine that receives a text document doc and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in descending order.

 Example:
 for doc: "practice makes perfect. get perfect by practice. just practice!"
 the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.

 The engine should ignore punctuation and white-spaces.
 Find the minimal runtime complexity and analyze it.

 */
public class WordCountEngine {

    public static void main(String[] args) {
        for (Word w : wordCountEngine("practice makes perfect. get perfect by practice. just practice!")) {
            System.out.print(w.word + " " + w.count);
            System.out.println();
        }
    }

    private static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String w, int c) {
            this.word = w;
            this.count = c;
        }

        @Override
        public int compareTo(Word other) {
            if (this.count < other.count) return -1;
            else if (this.count > other.count) return 1;
            return 0;
        }
    }

    private static List<Word> wordCountEngine(String doc) {
        if(doc == null || doc.length() == 0) throw new IllegalArgumentException("invalid input");

        List<Word> wordCountList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        // iterate through doc string to find letters
        for(int i = 0; i < doc.length(); i++) {
            if(Character.isLetter(doc.charAt(i))) {
                sb.append(doc.charAt(i));
            } else if (doc.charAt(i) == ' ') {
                sb.append(' ');
            }
        }

        // splits words into a string array
        String[] docStringArr = sb.toString().split(" ");

        Map<String, Integer> map = new HashMap<>();

        // place words into map and number of occurrences of each word
        for(int i = 0; i < docStringArr.length; i++) {
            if(map.containsKey(docStringArr[i])) {
                int freq = map.get(docStringArr[i]);
                map.put(docStringArr[i],++freq);
            } else {
                map.put(docStringArr[i],1);
            }
        }

        // dynamically create new word objects and set their properties to the word and frequency
        for(String w : map.keySet()) {
            wordCountList.add(new Word(w, map.get(w)));
        }

        Collections.sort(wordCountList);
        Collections.reverse(wordCountList);

        return wordCountList;
    }

}
