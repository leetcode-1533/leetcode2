/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	private HashMap<Integer, Integer> container = new HashMap<>();
    private HashSet<Integer> rootset = new HashSet<>();

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            container.put(i, i);
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
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
       	List<Integer> re = new ArrayList<>();
       	if (operators == null || operators.length == 0 || n == 0 || m == 0) 
       	    return re;

        // Write your code here
        this.grid = new boolean[n][m];
        xsize = n;
        ysize = m;
        init(xsize * ysize);

       	final int[] idir = new int[]{0, 0, -1, 1};
       	final int[] jdir = new int[]{-1, 1, 0, 0};


        for (Point item : operators) {
        	grid[item.x][item.y] = true;
        	rootset.add(ij2index(item.x, item.y));
        	for (int i = 0; i < 4; i++) {
        		int nei_i = item.x + idir[i];
        		int nei_j = item.y + jdir[i];
        		if (nei_i >= 0 && nei_i < xsize && nei_j >= 0 && nei_j < ysize) {
        			if (grid[nei_i][nei_j] == true) {
        				int ij_loc = ij2index(item.x, item.y);
        				int nei_loc = ij2index(nei_i, nei_j);
        				union(ij_loc, nei_loc);
        			}
        		}
        	}
        	re.add(setCount());
        }
        return re;
    }
}