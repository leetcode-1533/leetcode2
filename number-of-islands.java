public class Solution {
    private HashMap<Integer, Integer> container = new HashMap<>();
    private HashSet<Integer> rootset = new HashSet<>();

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            container.put(i, i);
        }

        for (int i = 0; i < n; i++) {
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
        int re = 0;
        for (int item : rootset) {
            int[] loc = index2ij(item);
            if (grid[loc[0]][loc[1]] == true) {
                re++;
            }
        }
        return re;
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
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        // Write your code here
        xsize = grid.length;
        ysize = grid[0].length;
        this.grid = grid;

        init(xsize * ysize);

       
        final int[] xdir = new int[]{0, 0, 1, -1};
        final int[] ydir = new int[]{1, -1, 0, 0};
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                for (int k = 0; k < 4; k++) {
                    int xi = i + xdir[k]; // bfs its neighbors
                    int yi = j + ydir[k];
                    if (xi < xsize && xi >= 0 && yi < ysize && yi >= 0) {
                        if (grid[xi][yi] == grid[i][j]) {
                            int loc_ij = ij2index(i, j);
                            int loc_neigh = ij2index(xi, yi);
                            // System.out.printf("%d %d", loc_ij, loc_neigh);
                            union(loc_ij, loc_neigh);
                        }
                    }
                }
            }
        }
        return setCount();
    }
}