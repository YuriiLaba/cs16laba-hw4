package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;

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
        for (String list: strings) {

            for (String string: list.split(" ")) {

                if (string.length() > 2) {
                    trie.add(new Tuple(string, string.length()));
                    count++;
                }
            }
        }
        return count;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
            return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        Iterable<String> stringIterable = trie.wordsWithPrefix(pref);
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String list: stringIterable) {
            if(k > list.length() - pref.length()){
                stringArrayList.add(list);
            }
        }return stringArrayList;
    }



    public int size() {
        return trie.size();
    }
}
