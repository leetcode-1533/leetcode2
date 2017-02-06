public class ConnectingGraph2 { 
	unionfind container; 

    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        container = new unionfind(n);
    }

    public void connect(int a, int b) {
        // Write your code here
        container.union(a, b);
    }
        
    public int query(int a) { 
    // returns the number of connected component nodes which include node a
    	return container.connected_count(a);
    }

	private class unionfind {
		private int[] container;
		private int[] connected_count;

		public unionfind(int size) {
			container = new int[size + 1];
			connected_count = new int[size + 1];

			for (int i = 1; i <= size; i++)
				container[i] = i;

			for (int i = 1; i <= size; i++)
				connected_count[i] = 1;
		}

		public boolean isConnected(int a, int b) {
			return (findroot(a) == findroot(b));
		}

		public int findroot(int a) {
			if (container[a] == a)
				return a;

			container[a] = findroot(container[a]);
			return container[a];
		}

		public int connected_count(int a) {
			int root = findroot(a);
			return connected_count[root];
		}

		public void union(int a, int b) {
			int roota = findroot(a);
			int rootb = findroot(b);
			if (container[roota] != container[rootb]) {
				container[roota] = container[rootb];
				connected_count[rootb] += connected_count[roota];
			}
		}
	}
}