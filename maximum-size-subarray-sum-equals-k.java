public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
    	if (nums == null || nums.length == 0)
    		return 0;

 		HashMap<Integer, Integer> map_acc_sum = new HashMap<>(nums.length);
 		int[] acc = new int[nums.length + 1];
 		for (int i = 1; i < acc.length; i++) {
 			acc[i] = acc[i - 1] + nums[i - 1];
 		}
 		for (int i = 1; i < acc.length; i++) {
 			map_acc_sum.put(acc[i], i);
 		}

 		int re = 0;
 		for (int i = 0; i < acc.length; i++) {
 			Integer ind = map_acc_sum.get(k + acc[i]);
 			if (ind != null && ind >= i) {
 				re = Math.max(re, ind - i);
 			}
 		}
 		return re;
    }
}