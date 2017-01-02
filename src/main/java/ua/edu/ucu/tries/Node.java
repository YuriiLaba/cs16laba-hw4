package ua.edu.ucu.tries;

import java.util.Arrays;

/**
 * Created by jlaba on 01.01.2017.
 */
public class Node {
    public static int R = 256;
    public Integer val;
    public Node[] next = new Node[R];





    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + Arrays.toString(next) +
                '}';
    }
}
