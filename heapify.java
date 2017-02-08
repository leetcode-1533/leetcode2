public class Solution {
	private int[] A;
	private void exch(int i, int j) {
		i--;
		j--;

		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
    
    private int val(int i) {
        i--;
        return A[i];
    }
    
    private void sink(int k) {
        int N = A.length;
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && (val(j) > val(j+1))) j++;
            if (!(val(k) > val(j))) break;
            exch(k, j);
            k = j;
        }
    }
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
    	this.A = A;
        // write your code here
        for (int i = A.length / 2; i > 0; i--) {
        	sink(i);
        }
    }
}