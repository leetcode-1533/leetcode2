public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        	return 0;
        int xsize = grid.length;
        int ysize = grid[0].length;
        int[][] re = new int[xsize][ysize];
        re[0][0] = grid[0][0];
        for (int i = 1; i < xsize; i++) 
        	re[i][0] = grid[i][0] + re[i - 1][0];
        for (int j = 1; j < ysize; j++) 
        	re[0][j] = grid[0][j] + re[0][j - 1];

        for (int i = 1; i < xsize; i++) {
        	for (int j = 1; j < ysize; j++) {
        		re[i][j] = Math.min(re[i - 1][j], re[i][j - 1]) + grid[i][j];
        	}
        }
        return re[xsize - 1][ysize - 1];
    }
}