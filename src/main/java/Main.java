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
        arr.add(tuple);
        arr.add(tuple1);
        System.out.println(arr.get("DDD"));

        System.out.println(arr.contains("DDD"));



        System.out.println(arr.words());
    }
}
