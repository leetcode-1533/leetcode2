public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        Queue<Integer> pq = new PriorityQueue<>(arrays.length, new Comparator<Integer>() {
        	int compare(Integer lhs, Integer rhs) {
        		if (lhs > rhs) return 1;
        		if (lhs.equals(rhs)) return 0;
        		return -1;
        	}
        });
        for (int[] array : arrays) {
        	for (int item : array) {
        		pq.offer(item);
        	}
        }

        int re = 0;
        while (k > 0 && !pq.isEmpty()) {
        	re = pq.poll();
        	k--;
        }
        return re;
    }
}