public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
    	int li = 0;
    	int hi = heights.length - 1;
    	int re = 0;
    	int cur_bar = 0;
        // write your code here
        while (li < hi) {
        	if (heights[li] < heights[hi]) {
        		cur_bar = Math.max(heights[li], cur_bar);
        	    re += cur_bar - heights[li];

        		li++;
        	} else {
        		cur_bar = Math.max(heights[hi], cur_bar);
        		re += cur_bar - heights[hi];

        		hi--;
        	}
        }
        return re;
    }
}