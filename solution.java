import java.util.*;
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};

public class solution {


    private HashMap<Integer, Integer> container = new HashMap<>();
    private HashSet<Integer> rootset = new HashSet<>();

    public int findRoot(int a) {
        if (container.get(a) == a) {
            return a;
        }
        container.put(a, findRoot(container.get(a)));
        return container.get(a);
    }

    public void union(int a, int b) {
        int roota = findRoot(a);
        int rootb = findRoot(b);
        
        if (roota != rootb) {
            container.put(roota, rootb);
            rootset.remove(roota);
        }
    }

    private void reg_node(int label) {
        container.put(label, label);
        rootset.add(label);
    }

    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        for (DirectedGraphNode node : nodes) {
            if (!container.containsKey(node)) {
                reg_node(node.label);
            }
            for (DirectedGraphNode nei_node : node.neighbors) {
                if (!container.containsKey(nei_node))
                    reg_node(nei_node.label);
                union(nei_node.label, node.label);
            }
        }

        HashMap<Integer, List<Integer>> re_set = new HashMap<>();
        for (int item : rootset) {
            re_set.put(item, new ArrayList<Integer>());
        }

        for (int item : container.keySet()) {
            int root = findRoot(item);
            re_set.get(root).add(item);
        }

        ArrayList<List<Integer>> re = new ArrayList<>();
        for (int item : rootset) {
            List<Integer> temp = re_set.get(item);
            Collections.sort(temp);
            re.add(temp);
        }

        return re;
    }

    public static void main(String[] args) {
        solution sol = new solution();
        ArrayList<DirectedGraphNode> test = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            test.add(new DirectedGraphNode(i));
        }
        test.get(0).neighbors.add(test.get(1));
        test.get(0).neighbors.add(test.get(2));
        test.get(0).neighbors.add(test.get(3));

        List<List<Integer>> re = sol.connectedSet2(test);


        System.out.println(re.size());

    }
}