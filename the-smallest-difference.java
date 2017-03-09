public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
    	if (A == null || B == null || A.length == 0 || B.length == 0) {
    		return -1;
    	}
        // write your code here
        int[] a_c = A.clone();
        int[] b_c = B.clone();
        Arrays.sort(a_c);
        Arrays.sort(b_c);
        int i = 0, j = 0;
        int minimum = Integer.MAX_VALUE;
        while (i < a_c.length && j < b_c.length) {
        	minimum = Math.min(minimum, Math.abs(a_c[i] - b_c[j]));
        	if (a_c[i] < b_c[j]) 
        		i++;
        	else if (a_c[i] > b_c[j])
        		j++;
        	else 
        		return 0;
        }
        return minimum;
    }
}
