import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

public class RobGraph {
  public List<Node> nodes;

  RobGraph(List<Node> nodes) {
    this.nodes = nodes;
  }

  public static HashMap<Node, Node> dijkstras(RobGraph graph, Node start) {
    PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
    HashMap<Node, Node> pred = new HashMap<Node, Node>();
    for(Node n : graph.nodes) {
      if(n.equals(start)) {
        n.val = 0;
      } else {
        n.val = Integer.MAX_VALUE;
      }
      pQueue.add(n);
    }
    while(!pQueue.isEmpty()) {
      Node minNode = pQueue.poll();
      for(Edge e : minNode.edges) {
        Node currentNode = e.to;
        if(e.weight == -1000) {
          int i = 0;
        }
        pQueue.remove(currentNode);
        if(currentNode.val > minNode.val + e.weight) {
          currentNode.val = minNode.val + e.weight;
          pred.put(currentNode, minNode);
        }
        pQueue.add(currentNode);
      }
    }
    return pred;
  }

}