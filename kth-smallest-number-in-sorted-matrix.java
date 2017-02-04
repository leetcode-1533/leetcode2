public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    private int[][] matrix = null;
    private class node implements Comparable<node> {
    	final int row;
    	final int col;
    	public node(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}

    	public int val() {
    		return matrix[row][col];
    	}

    	public int compareTo(node that) {
    		return (this.val() - that.val());
    	}

    }
    public int kthSmallest(int[][] matrix, int k) {
    	this.matrix = matrix;
        // write your code here
        if (matrix == null || matrix[0] == null || k > ((matrix.length + 1) * (matrix[0].length + 1))) {
        	return -1;
        }

        Queue<node> container = new PriorityQueue<>(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
        	container.offer(new node(i, 0));
        }

        node re = null;
        for (int i = 0; i < k; i++) {
        	re = container.poll();
        	if ((re.col + 1) < matrix[0].length) {
        		container.offer(new node(re.row, re.col + 1));
        	}
        }
        return re.val();
    }
}