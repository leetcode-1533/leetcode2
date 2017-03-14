public class Solution {
    public int lengthOfLIS(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
    	int[] lis = new int[nums.length];
    	lis[0] = 1;
    	for (int i = 1; i < nums.length; i++) {
    		int temp = 1;
    		for (int j = i - 1; j >= 0; j--) {
    			if (nums[j] < nums[i])
    				temp = Math.max(temp, lis[j] + 1);
    		}
    		lis[i] = temp;
    	}
    	int re = 0;
    	for (int i = 0; i < nums.length; i++) {
    	    re = Math.max(re, lis[i]);
    	}
    	return re;
    }	
}
