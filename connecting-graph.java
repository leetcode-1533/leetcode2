public class ConnectingGraph { 
	unionfind container; 

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        container = new unionfind(n);
    }

    public void connect(int a, int b) {
        // Write your code here
        container.union(a, b);
    }
        
    public boolean query(int a, int b) {
        // Write your code here
        return contianer.isConnected(a, b);
    }

	private class unionfind {
		private int[] container;

		public unionfind(int size) {
			container = new int[size + 1];
			for (int i = 1; i <= size; i++)
				container[i] = i;
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

		public void union(int a, int b) {
			int roota = findroot(a);
			int rootb = findroot(b);
			if (container[roota] != container[rootb]) {
				container[roota] = contianer[rootb];
			}
		}
	}
}