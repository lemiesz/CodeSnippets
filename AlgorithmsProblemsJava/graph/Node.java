import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    int val;
    String name;
    List<Edge> edges;

    public Node(int val) {
        this.val = val;
        this.edges = new ArrayList<Edge>();
    }

    public Node(int val, String name) {
        this.val = val;
        this.name = name;
        this.edges = new ArrayList<Edge>();
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Node other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        return other.val - this.val;
    }
}