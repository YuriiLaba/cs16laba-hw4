package ua.edu.ucu.tries;

public class RWayTrie <Value> implements Trie {
    private static final int R = 256;
    private Node root;      // root of trie
    private int n;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public RWayTrie() {
    }

    @Override
    public void add(Tuple t) {
        root = add(root, t.term, t.weight, 0);
    }
    private Node add(Node x, String key, int val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null) n++;
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, val, d+1);
        return x;
    }

    @Override
    public boolean contains(String word) {
        System.out.println("FFF");
        return get(word) != null;
    }
    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }
    private Node get(Node x, String key, int d) {
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
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    @Override
    public Iterable<String> words() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


}
