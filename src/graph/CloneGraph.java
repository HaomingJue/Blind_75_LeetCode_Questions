package graph;

import utils.Node;

import java.util.HashMap;

public class CloneGraph {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cur;
        if (map.containsKey(node)) {
            cur = map.get(node);
            return cur;
        }
        else {
            cur = new Node();
            cur.val = node.val;
            map.put(node, cur);
        }
        for (Node neighbor : node.neighbors) {
            cur.neighbors.add(cloneGraph(neighbor));
        }
        return cur;
    }
}
