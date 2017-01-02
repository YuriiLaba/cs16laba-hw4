package ua.edu.ucu.tries;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class RWayTrie  implements Trie {

    private Node root;      // root of trie
    private int n;

    public RWayTrie() {
    }

    @Override
    public void add(Tuple t) {
        /**
         * Public method which call real method add from the root.
         */
        root = add(root, t.term, t.weight, 0);
    }
    private Node add(Node x, String key, int val, int d) {
        /**
         * If we do not have node which corresponds to the element we create new instance of class Node.
         * When length of key is equal to the d (which means that we iterate as many times as number of value),
         * it means that we put all word, so we increase value and mark them corresponding node.
         * Also we increase. We need it to define a size.
         * When length of key isn't equal to the d we take letter of key which corresponds to d (for example
         * if we have word 'Drown' and d = 1, we take letter r) and recursively call method add with this letter.
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
        //System.out.println("FFF");
        return get(word) != null;
    }

    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }
    private Node get(Node x, String key, int d) {
        /**
         * Created by jlaba on 01.01.2017.
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

        ArrayList<String> wordsList = new ArrayList<String>();
        collect(root, "", wordsList);
        return wordsList;
    }


    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        ArrayList<String> wordsList = new ArrayList<String>();

        collect(get(root, s, 0), s, wordsList);
        return wordsList;
    }
    private void collect(Node x, String tmpWord, ArrayList<String> resList) {
        if (x != null) {
            for (int i = 0; i < Node.R; i++) {
                collect(x.next[i], tmpWord + (char)i, resList);
                if (x.val != null && x.val > 0){
                    resList.add(tmpWord);
                    break;
                }
            }
        }
    }


    @Override
    public int size() {
        return n;
    }



}
