import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get, set and search.
 *
 * get(name) - Using the name of the person return the LRU SSN stored in the linked list.
 *
 * set(name, ssn) - Insert the new SSN into the linked list.  If the linked thread has met its
 * limit (10) then it should invalidate the LRU SSN and insert the new SSN into the list.
 *
 * search(name, ssn) - Search for the SSN of the person in the LRU cache and return the latest
 * one in the linked hash map.
 *
 * */
public class LRUCache {

    private static Map<String,LinkedList<String>> names = new HashMap<>();

    static String lookup(String name) {
        if(name == null || name.length() == 0) return null;
        String entry = new String();
        if(!names.containsKey(name)) {
            return null;
        } else {
            entry = names.get(name).poll();
        }
        return entry;
    }

    static void insert(String name, String ssn) {
        if(name == null || ssn == null || name.length() == 0 || ssn.length() == 0) return;
        if(names.containsKey(name)) {
            names.get(name).add(ssn);
        }
    }

    static boolean delete(String name, String ssn) {
        if(name == null || ssn == null || name.length() == 0 || ssn.length() == 0) return false;
        if(!names.containsKey(name)) return false;
        names.get(name).pollFirst();
        return true;
    }

}
