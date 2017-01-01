import java.util.Arrays;

/**
 * Created by jlaba on 08.12.2016.
 */
public class Test<T> {

    private T t;

    public void set(T t1){
        System.out.println(t1);
    }
    public void load(String... strings) {
        System.out.println(Arrays.toString(strings));

    }}
