package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;
    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        int count = 0;
        for (String line: strings) {
            System.out.println(line);
            for (String word: line.split(" ")) {
                System.out.println(word);
                if (word.length() > 2) {
                    trie.add(new Tuple(word, word.length()));
                    count++;
                }
            }
        }
        return count;
    }

    public boolean contains(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
