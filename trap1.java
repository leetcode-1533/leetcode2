class Solution {
    public int trap(int[] height) {
    	if (height == null || height.length <= 2) {
    		return 0;
    	}

    	int lp = 0;
    	int rp = height.length - 1;

    	int l_max = height[lp];
    	int r_max = height[rp];

    	int re = 0;
    	while (lp < rp) {
    		if (height[lp] < height[rp]) {
    			lp++;
    			if (height[lp] <= l_max) {
    				re += (l_max - height[lp]);
    			} else {
    				l_max = height[lp];
    			}
    		} else {
    			rp--;
    			if (height[rp] <= r_max) {
    				re += (r_max - height[rp]);
    			} else {
    				r_max = height[rp];
    			}
    		}
    	}
    	return re;
    }

    public static void main(String[] args) {
    	int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	Solution sol = new Solution();
    	sol.trap(test);
    }
}