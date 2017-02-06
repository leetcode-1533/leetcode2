import java.util.*;

public class ConnectingGraph3 {
    unionfind container;

    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        container = new unionfind(n);
    }

    public void connect(int a, int b) {
        // Write your code here
        container.union(a, b);
    }

    public int query() {
        // return the number of connected component
        return container.setCount();
    }

    public static void main(String[] args) {
        ConnectingGraph3 sol = new ConnectingGraph3(5);
        sol.query();
        sol.connect(1, 2);
        sol.query();

        sol.connect(2, 4);
        sol.query();

        sol.connect(1, 4);
        sol.query();

    }

    private class unionfind {
        private HashMap<Integer, Integer> container = new HashMap<>();
        private HashSet<Integer> rootset = new HashSet<>();

        public unionfind(int n) {
            for (int i = 1; i <= n; i++) {
                container.put(i, i);
            }

            for (int i = 1; i <= n; i++) {
                rootset.add(i);
            }
        }

        private int findRoot(int a) {
            if (container.get(a) == a)
                return a;
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

        public int setCount() {
            System.out.println(rootset.size());
            return rootset.size();
        }
    }
}