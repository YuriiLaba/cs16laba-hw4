package ua.edu.ucu.tries;
import ua.edu.ucu.autocomplete.Queue;

import java.util.ArrayList;



public class RWayTrie  implements Trie {

    /**
     * This is an implementation of RW-Trie
     */

    private Node root;
    private int n;

    public RWayTrie() {
    }

    @Override
    public void add(Tuple t) {
        /**
         * Public method which call overridden method add from the root.
         */
        root = add(root, t.term, t.weight, 0);
    }
    private Node add(Node x, String key, int val, int d) {
        /**
          If we do not have node which corresponds to the element we create new instance of class Node.
          When length of key is equal to the d (which means that we iterate as many times as number of value),
          it means that we put all word, so we increase value and mark them corresponding node.
          Also we increase. We need it to define a size.
          When length of key isn't equal to the d we take letter of key which corresponds to d (for example
          if we have word 'Drown' and d = 1, we take letter r) and recursively call method add with this letter.
         */
        //System.out.println(x);
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null){
                n ++;
                val ++;
                x.val = val;
                return x;
            }
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, val, d+1);
        //System.out.println(Arrays.toString(x.next));
        return x;
    }


    @Override
    public boolean contains(String word) {
        /**
         * This method calls method get and if get isn't equal to none it returns true, otherwise
         * it returns false.
        */
        return get(word) != null;
    }

    public Object get(String key) {
        /**
         * Public method which call overridden method get and return value of x.
         */
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }
    private Node get(Node x, String key, int d) {
        /**
         * When length of key is equal to the d (which means that we iterate as many times as number of value),
         * we return x (node). As it follows, we found key. When length of key isn't equal to the d we take letter of
         * key which corresponds to d (for example if we have word 'Drown' and d = 1, we take letter r) and
         * recursively call method get with this letter.
         */
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    @Override
    public boolean delete(String word) {
        root = delete(root, word, 0);
        return true;
    }
    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) n--;
            x.val = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.val != null) return x;
        for (int c = 0; c < Node.R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    @Override
    public Iterable<String> words() {

        Queue<String> queueResult = new Queue<String>();
        collect(root, "", queueResult);
        return queueResult;
    }


    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Queue<String> queueResult = new Queue<String>();

        collect(get(root, s, 0), s, queueResult);
        return queueResult;
    }
    private void collect(Node x, String word, Queue<String> queueResult) {
        if (x != null) {
            if (x.val != null && x.val > 0){
                queueResult.enqueue(word);
            }
            for (int i = 0; i < Node.R; i++) {
                collect(x.next[i], word + (char) (i), queueResult);
            }
        }
    }

    @Override
    public int size() {
        return n;
    }



}
