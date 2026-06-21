/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void solve(Node oldNode, HashMap<Node, Node> cloneMap) {
        for (Node neighbor : oldNode.neighbors) {
            if (!cloneMap.containsKey(neighbor)) {
                cloneMap.put(neighbor, new Node(neighbor.val));
                solve(neighbor, cloneMap);
            }
        }
    }

    

    public Node cloneGraph(Node node) {

        // If the given graph is empty.
        if (node == null) {
            return null;
        }

        // Need to clone the first element to get started
        Node clone = new Node(node.val);

        // Create a Hashmap to store the clones of Original Nodes
        HashMap<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, clone);

        // Now Process every node and make a clone of it 
        solve(node, cloneMap);
        
        // As the clones ready now assign them the neighbors
        for (Node key: cloneMap.keySet()) {
            List<Node> cloneNeighbors = new ArrayList<>();
            Node value = cloneMap.get(key);
            for (Node neighbor: key.neighbors) {
                cloneNeighbors.add(cloneMap.get(neighbor));
            }
            value.neighbors = cloneNeighbors;
        }

        return clone;

    }
}