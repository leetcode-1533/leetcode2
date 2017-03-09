public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums == null || nums.length <= 1) 
    		return 0;
   		
   		int cur = 0;
   		int bestl = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; j < nums.length; j++) {
            cur += nums[j];
            while (cur >= s) {
                bestl = Math.min(bestl, j - i + 1);
                cur -= nums[i++];
            }
        }
        
   		return bestl > nums.length ? 0 : bestl;
    }
}