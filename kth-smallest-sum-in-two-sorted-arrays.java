public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    private int[] A;
    private int[] B;

    private class node implements Comparable<node> {
    	final int row; // for a
    	final int col; // for b

    	public node(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}

    	public int val() {
    		return A[row] + b[col];
    	}

    	public int CompareTo(node that) {
    		return this.val() - that.val();
    	}
    }
    public int kthSmallestSum(int[] A, int[] B, int k) {
        this.A = A;
        this.B = B;
        // Write your code here
    	Queue<node> pq = new PriorityQueue<>(A.length);
    	for (int i = 0; i < A.length; i++) {
    		pq.offer(new node(i, 0));
    	}

    	node re = null;
    	for (int i = 0; i < k; i++) {
    		re = pq.poll();
    		if (re.col + 1 < B.length) {
    			pq.offer(new node(re.row, re.col + 1));
    		} 
    	}
    	return re.val();
    }
}