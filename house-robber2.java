public class Solution {
    private int array_rob(int[] nums, int i, int j) {
    	int length = j - i + 1;

    	if (nums == null || length <= 0)
    		return 0;
    	if (length == 1) 
    		return nums[i];

 		int[] opt = new int[length];
        opt[0] = nums[i];
        opt[1] = Math.max(nums[i], nums[i + 1]);

 		for (int t = 2; t < length; t++) {
 			opt[t] = Math.max(nums[i + t] + opt[t - 2], opt[t - 1]);
 		}
 		return opt[opt.length - 1];
    }

    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	return Math.max(array_rob(nums, 1, nums.length - 1), nums[0] + array_rob(nums, 2, nums.length - 2));
    }
}