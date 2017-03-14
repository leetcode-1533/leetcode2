public class Solution {
    public void moveZeroes(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return;

    	int i = 0, j = 0;
    	// i search for non-zero
    	// j search for zero
    	while (true) {
    		while (nums[i] == 0 || i <= j) {
    			i++;
    			if (i >= nums.length)
    				break;
    		}
    		while (nums[j] != 0) {
    			j++;
    			if (j >= nums.length)
    				break;
    		}
    		if (i >= nums.length || j >= nums.length)
    		    return;
    		exch(nums, i, j);
    	}
    }

    private void exch(int[] nums, int i, int j) {
        if (i > j) {
    	    int temp = nums[i];
    	    nums[i] = nums[j];
    	    nums[j] = temp;
        }
    }
}