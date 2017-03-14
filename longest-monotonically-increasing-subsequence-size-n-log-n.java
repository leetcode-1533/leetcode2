public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
            
		List<Integer> re = new ArrayList<Integer>(0);
		for (int i = 0; i < nums.length; i++) {
			if (re.size() == 0) {
				re.add(nums[i]);
			} else {
			    update(re, nums[i]);
			}
		}        
		return re.size();
    }

    private void update(List<Integer> re, int num) {
    	int loc = binary_search(re, num);
    	if (loc == re.size()) {
    		re.add(num);
    	} else {
    		re.set(loc, num);
    	}
    }

    private int binary_search(List<Integer> re, int num) {
		int li = 0;
		int hi = re.size() - 1;
		while (hi >= li) {
			int mid = li + (hi - li) / 2;
			if (re.get(mid) >= num) 
				hi = mid - 1;
			else 
				li = mid + 1;
		}
		return li;
	}
}