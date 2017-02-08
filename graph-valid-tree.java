public class Solution {
	private HashMap<Integer, Integer> container = new HashMap<>();
    private HashSet<Integer> rootset = new HashSet<>();

  	private int findRoot(int a) {
	    if (container.get(a) == a)
	        return a;
	    container.put(a, findRoot(container.get(a)));
	    return container.get(a);
    }

    public boolean union(int a, int b) {
        int roota = findRoot(a);
        int rootb = findRoot(b);

        if (roota == rootb) 
        	return false;
        else {
            container.put(roota, rootb);
            rootset.remove(roota);
            return true;
        }
    }

    public int setCount() {
		return rootset.size();
    }

    public int ij2index(int i, int j) {
        return i * ysize + j;
    }

    public int[] index2ij(int index) {
        int i = index / ysize;
        int j = index - ysize * i;
        return new int[]{i, j};
    }

    private int xsize = 0;
    private int ysize = 0;
    private boolean[][] grid = null;


    public boolean validTree(int n, int[][] edges) {
    	if (edges.length == 0 && n == 1)
    		return true;
    	for (int[] edge : edges) {
    		for (int point : edge) {
    			if (!container.containsKey(point)) {
    				container.put(point, point);
    				rootset.add(point);
    			}
    		}
    		if (!union(edge[0], edge[1]))
    			return false;
    	}
    	return (setCount() == 1 && container.size() == n);
    }
}