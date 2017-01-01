import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Tuple;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jlaba on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) {

        RWayTrie arr = new RWayTrie();
        Tuple tuple = new Tuple("DDD", 0);
        arr.add(tuple);
        System.out.println(arr.contains("DDDD"));
    }
}
