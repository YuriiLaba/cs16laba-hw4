import ua.edu.ucu.autocomplete.PrefixMatches;
import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Tuple;

/**
 * Created by jlaba on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {

        RWayTrie arr = new RWayTrie();
        Tuple tuple = new Tuple("DDD", 3);
        Tuple tuple1 = new Tuple("Drown", 5);
        Tuple tuple2 = new Tuple("Adolf", 5);
        arr.add(tuple);
        arr.add(tuple1);
        arr.add(tuple2);
        //System.out.println(arr.get("DDD"));

        //System.out.println(arr.contains("DDD"));
        //System.out.println(arr.wordsWithPrefix("D"));
        PrefixMatches prefixMatches = new PrefixMatches(arr);
        System.out.println(prefixMatches.load("ddd", "fff"));


        //System.out.println(arr.words());
        //System.out.println(arr.size());
    }
}
