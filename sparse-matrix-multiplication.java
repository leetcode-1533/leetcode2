public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
    	if (A == null || A.length == 0 || A[0] == null || A[0].length == 0 ||
    		B == null || B.length == 0 || B[0] == null || B[0].length == 0)
    		return null;

    	int k = B.length;
    	int R_row = A.length;
    	int R_cow = B[0].length;

    	boolean[] A_index = new boolean[R_row];
    	for (int i = 0; i < R_row; i++) {
    		for (int j = 0; j < k; j++) {
    			if (A[i][j] != 0) {
    				A_index[i] = true;
    				break;
    			}
    		}
    	}

    	boolean[] B_index = new boolean[R_cow];
    	for (int i = 0; i < R_cow; i++) {
    		for (int j = 0; j < k; j++) {
    			if (B[j][i] != 0) {
    				B_index[i] = true;
    				break;
    			}
    		}
    	}

    	int[][] re = new int[R_row][R_cow];
    	for (int i = 0; i < R_row; i++) {
    		for (int j = 0; j < R_cow; j++) {
    			if (A_index[i] && B_index[j]) {
    				int temp = 0;
    				for (int n = 0; n < k; n++) {
    					temp += A[i][n] * B[n][j];
    				}
    				re[i][j] = temp;
    			}
    		}
    	}
    	return re;
    }
}