public class Solution {
    public int maximalSquare(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
    		return 0;
    	int xsize = matrix.length;
    	int ysize = matrix[0].length;
        int[][] Mat = new int[xsize][ysize];
        for (int i = 0; i < xsize; i++) {
        	int j = 0;
        	Mat[i][j] = matrix[i][j] - '0';
        }

        for (int j = 0; j < ysize; j++) {
        	int i = 0;
        	Mat[i][j] = matrix[i][j] - '0';
        }

        for (int i = 1; i < xsize; i++) {
        	for (int j = 1; j < ysize; j++) {
        		if (matrix[i][j] == '1') {
        			Mat[i][j] = 1 + Math.min(Mat[i - 1][j - 1], Math.min(Mat[i - 1][j], Mat[i][j - 1]));
        			        		   // System.out.printf("%d, %d, %d\n", i, j, Mat[i][j]);

        		} else {
        			Mat[i][j] = 0;
        		}
        	}
        }
        int re = 0;
        for (int i = 0; i < xsize; i++) {
        	for (int j = 0; j < ysize; j++) {
        		re = Math.max(re, Mat[i][j]);
        	}
        }
        return re * re;
    }
}