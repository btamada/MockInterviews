import java.util.*;

/**
 * Trie Tree Data Structure
 */
public class TrieTree {
    TrieNode root;

    public TrieTree() {
        this.root = new TrieNode('-');
        this.root.children = new HashMap<>();
    }

    protected void insert(String word) {
        if(word == null || word.length() == 0) return;
        char[] wordChar = word.toCharArray();
        TrieNode curr = root;
        for(int i = 0; i < wordChar.length; i++) {

            // not in the hash map
            if(curr.children.get(wordChar[i]) == null) {

                // create a new TrieNode and put it into the hash map
                curr.children.put(wordChar[i], new TrieNode(wordChar[i]));

                // if we reached the last character of the word
                if(i == wordChar.length - 1)
                    curr.children.get(wordChar[i]).isEnd = true;
            }
            curr = curr.children.get(wordChar[i]);
        }
    }

    protected boolean lookup(String word) {
        if(word == null || word.length() == 0) return false;

        char[] wordChar = word.toCharArray();

        TrieNode curr = root;

        for(int i = 0; i < wordChar.length; i++) {

            // reached the last character in the word
            if (i == wordChar.length - 1) {

                // check if the last character is in the hashmap
                if (curr.children.containsKey(wordChar[i]))

                    // check if the trie node is NOT marked as end, then return false
                    if (curr.children.get(wordChar[i]).isEnd) return true;

            }

            if (curr.children.containsKey(wordChar[i]))
                curr = curr.children.get(wordChar[i]);

        }

        return false;
    }

    private class TrieNode {
        char c;
        Map<Character,TrieNode> children;
        boolean isEnd;

        protected TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        TrieTree tt = new TrieTree();
        tt.insert("bryan");
        tt.insert("bryanna");
        tt.insert("bryannette");
        System.out.println(tt.lookup("brian"));
    }

}
