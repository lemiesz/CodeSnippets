import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class MainClass {
    public static void main(String[] args) {
        // RobGraph graph = generateGraph();
        // Node start = graph.nodes.get(0);
        // Node s2 = graph.nodes.get(1);
        // HashMap<Node,Node> pred = RobGraph.dijkstras(graph, start);
        // printPath(graph.nodes.get(4), pred);
        int[][] array = new int[10][10];
        System.out.println(array.length);
        System.out.println(array[0].length);
    }
    
    public static void printPath(Node lastNode, HashMap<Node,Node> pred) {
        List<Node> path = new ArrayList<>();
        Node currentNode = lastNode;
        path.add(lastNode);
        while(currentNode != null) {
            currentNode = pred.get(currentNode);
            path.add(currentNode);
        }
        
        System.out.println(path);
    }

    public static RobGraph generateGraph() {
        Node s = new Node(0, "s");
        Node n1 = new Node(Integer.MAX_VALUE, "n1");
        Node n2 = new Node(Integer.MAX_VALUE, "n2");
        Node n3 = new Node(Integer.MAX_VALUE, "n3");
        Node n4 = new Node(Integer.MAX_VALUE, "n4");

        Edge s_n1 = new Edge(2, s, n1);
        Edge n1_n2 = new Edge(5, n1, n2);
        Edge n2_n3 = new Edge(5, n2, n3);
        Edge n3_n4 = new Edge(-1000, n3, n4);
        Edge n2_n4 = new Edge(6, n2, n4);

        s.edges = Arrays.asList(s_n1);
        n1.edges = Arrays.asList(n1_n2);
        n2.edges = Arrays.asList(n2_n3, n2_n4);
        n3.edges = Arrays.asList(n3_n4);

        RobGraph graph = new RobGraph(Arrays.asList(s,n1,n2,n3,n4));
        return graph;
    }

    public static TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        TreeNode rootLL = new TreeNode(4);
        TreeNode rootLR = new TreeNode(5);
        TreeNode rootRL = new TreeNode(6);
        TreeNode rootRR = new TreeNode(7);
        root.setLeft(rootL);
        root.setRight(rootR);
        rootL.setLeft(rootLL);
        rootL.setRight(rootLR);
        rootR.setRight(rootRR);
        rootR.setLeft(rootRL);
        return root;
    }
}